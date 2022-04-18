package com.example.rewirebluetoothforcesensor;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import static android.content.ContentValues.TAG;
import static com.example.rewirebluetoothforcesensor.Constants.*;

public class MainActivity extends AppCompatActivity {

    private String deviceName = null;
    private String deviceAddress;
    public static Handler handler;
    public static BluetoothSocket mmSocket;
    public static ConnectedThread connectedThread;
    public static CreateConnectThread createConnectThread;

    private final static int CONNECTING_STATUS = 1; // used in bluetooth handler to identify message status
    private final static int MESSAGE_READ = 2; // used in bluetooth handler to identify message update

    private static final int NUM_PAGES = 4;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    public int totalCycles = 1; //total num of cycles
    private static FileOutputStream csvOut;
    private static ParcelFileDescriptor pfd;
    private static Context context;

    private String validDouble = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    private static CalibrationStage calibrationStage = CalibrationStage.UNCALIBRATED;
    private static double[] offsets = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    private static double[] factors = {-10000.0, -10000.0, -10000.0, -10000.0, -10000.0, -10000.0, -10000.0, -10000.0};
    private static double calibrationLbs = 0;
    private static int offsetCycleStart = 0;
    private static int factorCycleStart = 0;

    ActivityResultLauncher<Intent> fileActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager2) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        final Button connect = findViewById(R.id.connect);
        final Button disconnect = findViewById(R.id.disconnect);
        final ToggleButton logging = findViewById(R.id.logging);
        final ImageButton next = findViewById(R.id.next);
        final ImageButton prev = findViewById(R.id.prev);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        final TextView connectStatus = findViewById(R.id.connectstatus);

        final TextView calibrationInfo = findViewById(R.id.calibrationInfo);
        final Button calibration = findViewById(R.id.calibration);
        final EditText calibrationLbsField = findViewById(R.id.calibrationLbs);

        final TextView title = findViewById(R.id.pagerTitle);

        connect.setVisibility(View.VISIBLE);
        connect.setEnabled(true);
        disconnect.setVisibility(View.GONE);
        disconnect.setEnabled(false);
        logging.setEnabled(false);
        calibration.setEnabled(false);

        calibrationInfo.setVisibility(View.VISIBLE);

        calibrationLbsField.setVisibility(View.GONE);
        calibrationLbsField.setEnabled(false);

        MainActivity.context = getApplicationContext();

        viewPager.setUserInputEnabled(false);
        viewPager.setOffscreenPageLimit(NUM_PAGES);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                title.setText(((DataViewFragment)getSupportFragmentManager().findFragmentByTag("f"+viewPager.getCurrentItem())).getName());
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem() < NUM_PAGES - 1)
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                else{
                    viewPager.setCurrentItem(0, true);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem() > 0)
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                else{
                    viewPager.setCurrentItem(NUM_PAGES-1, true);
                }
            }
        });

        calibration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                calibrationInfo.setVisibility(View.VISIBLE);
                if(calibrationStage != CalibrationStage.FINISHED){
                    calibrationStage = CalibrationStage.values()[calibrationStage.ordinal() + 1];
                    if(calibrationStage == CalibrationStage.FINISHED){
                        calibrationInfo.setVisibility(View.GONE);
                    }
                }
                else{
                    calibrationStage = CalibrationStage.OFFSET;
                    calibration.setText("Next Step");
                }

                switch(calibrationStage){
                    case UNCALIBRATED:
                        calibrationInfo.setText("Before connection, ensure the scale has no weight on it.");
                        break;
                    case OFFSET:
                        offsetCycleStart = totalCycles - 1;
                        for(int i=0; i<8; i++){
                            offsets[i] = 0;
                            factors[i] = -10000;
                        }
                        calibrationInfo.setText("Place no weight on the scale and wait until values are all approximately zero.");
                        connectStatus.setText("Connected to " + deviceName + ". Calibrating...");
                        break;
                    case WEIGHT:
                        calibrationInfo.setText("Place a known weight in the middle of both scales and type it in the field below. When finished, hit next step.");
                        calibrationLbsField.setVisibility(View.VISIBLE);
                        calibrationLbsField.setEnabled(true);
                        break;
                    case FACTOR:
                        try {
                            calibrationLbs = Double.parseDouble(calibrationLbsField.getText().toString()) / 4.0;
                        }
                        catch(NumberFormatException e){
                            Log.e("NumberFormatError", "No weight entered");
                            calibrationStage = CalibrationStage.WEIGHT;
                            break;
                        }
                        factorCycleStart = totalCycles - 1;
                        calibrationLbsField.setVisibility(View.GONE);
                        calibrationLbsField.setEnabled(false);
                        calibrationInfo.setText("Wait until the weight in the center of both scales resembles the known weight you placed.");
                        calibration.setText("Finish");
                        break;
                    case FINISHED:
                        totalCycles = 1;
                        for(Fragment f: getSupportFragmentManager().getFragments()){
                            ((DataViewFragment)f).clear();
                            ((DataViewFragment)f).refreshView();
                        }
                        calibration.setText("Recalibrate");
                        calibrationInfo.setText("");
                        calibrationInfo.setVisibility(View.GONE);
                        connectStatus.setText("Connected to " + deviceName);
                }
            }
        });

        disconnect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (createConnectThread != null){
                    createConnectThread.cancel();
                }

                connectStatus.setText("Disconnected");
                calibration.setEnabled(false);
                calibrationInfo.setVisibility(View.GONE);
                calibrationLbsField.setEnabled(false);
                calibrationLbsField.setVisibility(View.GONE);

                if(logging.isChecked()) {
                    if (csvOut != null && pfd != null) {
                        try {
                            csvOut.close();
                            pfd.close();
                            csvOut = null;
                            pfd = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "File Creation Error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    logging.setChecked(false);
                }

                for(Fragment f: getSupportFragmentManager().getFragments()){
                    ((DataViewFragment)f).clear();
                }

                disconnect.setEnabled(false);
                disconnect.setVisibility(View.GONE);
                logging.setEnabled(false);
                connect.setEnabled(true);
                connect.setVisibility(View.VISIBLE);

                if(calibrationStage != CalibrationStage.FINISHED){
                    for(int i=0; i<8; i++){
                        offsets[i] = 0;
                        factors[i] = -10000;
                    }
                    totalCycles = 1;
                    offsetCycleStart = 0;
                    factorCycleStart = 0;
                    calibrationStage = CalibrationStage.UNCALIBRATED;
                }
            }
        });

        //title.setText(((DataViewFragment)getSupportFragmentManager().getFragments().get(position)).getName());

        fileActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result){
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            Uri uri = data.getData();
                            try {
                                pfd = getContentResolver().
                                        openFileDescriptor(uri, "w");
                                csvOut =
                                        new FileOutputStream(pfd.getFileDescriptor());
                                csvOut.write("Timestamp, 1, 2, 3, 4, 5, 6, 7, 8, Cycle".getBytes());
                                csvOut.write(System.getProperty( "line.separator" ).getBytes());
                                csvOut.flush();
                                totalCycles = 0;
                            }
                            catch(FileNotFoundException e){
                                e.printStackTrace();
                            }
                            catch(IOException e){
                                e.printStackTrace();
                            }
                        }
                        else{
                            logging.setChecked(false);
                        }
                    }
                }
        );

        deviceName = getIntent().getStringExtra("deviceName");
        if(deviceName != null) {
            deviceAddress = getIntent().getStringExtra("deviceAddress");
            //toolbar.setSubtitle("Connecting to " + deviceName + "...");
            connectStatus.setText("Connecting to " + deviceName + "...");
            connect.setEnabled(false);

            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            createConnectThread = new CreateConnectThread(bluetoothAdapter, deviceAddress);
            createConnectThread.start();

        }

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg){
                switch(msg.what){
                    case CONNECTING_STATUS:
                        switch(msg.arg1){
                            case 1:
                                //toolbar.setSubtitle("Connected to " + deviceName);
                                if(calibrationStage != CalibrationStage.FINISHED) {
                                    for(int i=0; i<8; i++){
                                        offsets[i] = 0;
                                        factors[i] = -10000;
                                    }
                                    totalCycles = 1;
                                    offsetCycleStart = 0;
                                    factorCycleStart = 0;
                                    connectStatus.setText("Connected to " + deviceName + ". Calibrating...");
                                    calibrationStage = CalibrationStage.OFFSET;
                                    calibrationInfo.setText("Place no weight on the scale and wait until values are all approximately zero.");
                                    logging.setEnabled(false);
                                    calibration.setEnabled(true);
                                    calibration.setText("Next Step");
                                }
                                else{
                                    connectStatus.setText("Connected to " + deviceName);
                                    calibrationInfo.setText("");
                                    calibrationInfo.setVisibility(View.GONE);
                                    logging.setEnabled(true);
                                    calibration.setText("Recalibrate");
                                    calibration.setEnabled(true);
                                }
                                connect.setEnabled(false);
                                connect.setVisibility(View.GONE);
                                disconnect.setEnabled(true);
                                disconnect.setVisibility(View.VISIBLE);
                                break;
                            case -1:
                                //toolbar.setSubtitle("Device fails to connect");
                                connectStatus.setText("Device fails to connect");
                                connect.setEnabled(true);
                                connect.setVisibility(View.VISIBLE);
                                disconnect.setEnabled(false);
                                disconnect.setVisibility(View.GONE);
                                logging.setEnabled(false);
                                break;
                        }
                        break;
                    case MESSAGE_READ:
                        String arduinoMsg = msg.obj.toString(); // Read message from Arduino
                        String[] splitArr = arduinoMsg.split(","); // Split up message into strings
                        //Log.e("LEN", Integer.toString(splitArr.length));
                        double[] sensorDataArr;
                        boolean skipRead = false;
                        if(splitArr.length < 11){
                            break;
                        }

                        sensorDataArr = new double[10];

                        for(int i=0; i<sensorDataArr.length; i++){
                            //Log.e("VALUE", splitArr[i]);
                            try {
                                sensorDataArr[i] = Double.valueOf(splitArr[i]);
                            }
                            catch(NumberFormatException e){
                                Log.e("Number Format Error", "Failure in receive from Arduino");
                                skipRead = true;
                                break;
                            }
                        }

                        for(int i=0; i<8; i++){
                            if(calibrationStage == CalibrationStage.OFFSET){
                                // Add to average offset
                                offsets[i] *= (totalCycles-offsetCycleStart-1);
                                offsets[i] += sensorDataArr[i];
                                offsets[i] /= totalCycles-offsetCycleStart;
                            }

                            sensorDataArr[i] -= offsets[i];

                            if(calibrationStage == CalibrationStage.FACTOR){
                                factors[i] *= totalCycles-factorCycleStart-1;
                                factors[i] += sensorDataArr[i]/calibrationLbs;
                                factors[i] /= totalCycles-factorCycleStart;
                                if(factors[i] == 0){
                                    factors[i] = 1;
                                }
                            }

                            sensorDataArr[i] /= factors[i];
                            sensorDataArr[i] = Math.max(0, Math.floor(sensorDataArr[i] * 100)/100);

                        }

                        Log.i("factors", Arrays.toString(factors));

                        if(skipRead){
                            break;
                        }

                        //update total cycle count
                        totalCycles++;

                        if(calibrationStage == CalibrationStage.FINISHED) {
                            //Logging to CSV
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");

                            Date date = new Date();
                            Timestamp timestamp = new Timestamp(date.getTime());

                            //format timestamp
                            String timestampStr = sdf.format(timestamp);

                            String csvText = timestampStr + ", " + arduinoMsg + totalCycles;
                            csvText = csvText.replaceAll("\n", "").replaceAll("\r", "");

                            if (logging.isChecked() && csvOut != null && pfd != null) {
                                try {
                                    csvOut.write(csvText.getBytes());
                                    csvOut.write(System.getProperty("line.separator").getBytes());
                                    csvOut.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Toast.makeText(getApplicationContext(), "File Write Error, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        // Send data from main activity to fragment(s)
                        Bundle sensorData = new Bundle();
                        sensorData.putDoubleArray("sensorData", sensorDataArr);
                        sensorData.putInt("totalCycles", totalCycles);

                        // Only publish data to all fragments if calibrated
                        if(calibrationStage == CalibrationStage.FINISHED) {
                            for (Fragment f : getSupportFragmentManager().getFragments()) {
                                ((DataViewFragment) f).putSensorData(sensorData);
                                ((DataViewFragment) f).update();
                            }
                        }
                        else{
                            DataViewFragment f = (DataViewFragment)getSupportFragmentManager().getFragments().get(0);
                            f.putSensorData(sensorData);
                            f.update();
                        }

                        break;
                }
            }
        };

        // Select Bluetooth Device
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Move to adapter list
                Intent intent = new Intent(MainActivity.this, SelectDeviceActivity.class);
                startActivity(intent);
            }
        });

        logging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                // Move to adapter list
                if(logging.isChecked()){
                    //method 2 - via Date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");

                    Date date = new Date();
                    Timestamp timestamp = new Timestamp(date.getTime());

                    //format timestamp
                    String fileName = sdf.format(timestamp);

                    Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType(".csv -> text/plain");
                    intent.putExtra(Intent.EXTRA_TITLE, fileName+".csv");
                    fileActivityResultLauncher.launch(intent);

                }
                else{
                    if(csvOut != null && pfd != null) {
                        try {
                            csvOut.close();
                            pfd.close();
                            csvOut = null;
                            pfd = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "File Creation Error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch(position) {
                case 0:
                    return new LoadCellFragment();
                case 1:
                    return new ProSupFragment();
                case 2:
                    return new AntPosFragment();
                case 3:
                    return new LeftRightFragment();
                default:
                    throw new IllegalArgumentException();
            }
            //return new OverviewFragment();

        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }


    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThread extends Thread {

        public CreateConnectThread(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocket = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocket.connect();
                Log.e("Status", "Device connected");
                handler.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket.close();
                    Log.e("Status", "Cannot connect to device");
                    handler.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThread = new ConnectedThread(mmSocket);
            connectedThread.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n'){
                        readMessage = new String(buffer,0,bytes);
                        Log.e("Arduino Message",readMessage);
                        handler.obtainMessage(MESSAGE_READ,readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error","Unable to send message",e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) { }
        }
    }

    /* ============================ Terminate Connection at BackPress ====================== */
    @Override
    public void onBackPressed() {
        // Terminate Bluetooth Connection and close app
        if (createConnectThread != null){
            createConnectThread.cancel();
        }
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }



}