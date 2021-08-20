package com.example.rewirebluetoothforcesensor;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private String deviceName = null;
    private String deviceAddress;
    public static Handler handler;
    public static BluetoothSocket mmSocket;
    public static ConnectedThread connectedThread;
    public static CreateConnectThread createConnectThread;

    private final static int CONNECTING_STATUS = 1; // used in bluetooth handler to identify message status
    private final static int MESSAGE_READ = 2; // used in bluetooth handler to identify message update


    private static FileOutputStream csvOut;
    private static ParcelFileDescriptor pfd;
    private static Context context;

    ActivityResultLauncher<Intent> fileActivityResultLauncher;

    public int totalCycles = 0; //total num of cycles
    public int LeftNoWeightTimeCount = 0;
    public int LeftNoWeightValue = 0;
    public int RightNoWeightTimeCount = 0;
    public int RightNoWeightValue = 0;

    double[] lh_arr = new double[4];
    double[] lo_arr = new double[4];
    double[] li_arr = new double[4];
    double[] rh_arr = new double[4];
    double[] ro_arr = new double[4];
    double[] ri_arr = new double[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView[] pads = {findViewById(R.id.pad0),
                findViewById(R.id.pad1),
                findViewById(R.id.pad2),
                findViewById(R.id.pad3),
                findViewById(R.id.pad4),
                findViewById(R.id.pad5)};

        final Button connect = findViewById(R.id.connect);
        final ToggleButton logging = findViewById(R.id.logging);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        final TextView connectStatus = findViewById(R.id.connectstatus);
        final TextView padLtotal = findViewById(R.id.padLtot);
        final TextView padRtotal = findViewById(R.id.padRtot);
        final ProgressBar progbar = findViewById(R.id.progressBar);



        connect.setEnabled(true);
        logging.setEnabled(false);

        MainActivity.context = getApplicationContext();

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
                                csvOut.write("Timestamp, Lh, Lout, Lin, Rh, Rout, Rin, Cycle".getBytes());
                                csvOut.write(System.getProperty( "line.separator" ).getBytes());
                                csvOut.flush();
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
                                connectStatus.setText("Connected to " + deviceName);
                                connect.setEnabled(false);
                                logging.setEnabled(true);
                                break;
                            case -1:
                                //toolbar.setSubtitle("Device fails to connect");
                                connectStatus.setText("Device fails to connect");
                                connect.setEnabled(true);
                                logging.setEnabled(false);
                                break;
                        }
                        break;

                    case MESSAGE_READ:
                        String arduinoMsg = msg.obj.toString(); // Read message from Arduino
                        String[] splitArr = arduinoMsg.split(","); // Split up message into strings




                        double lh_val = Double.parseDouble(splitArr[0]);
                        double lo_val = Double.parseDouble(splitArr[1]);
                        double li_val = Double.parseDouble(splitArr[2]);
                        double rh_val = Double.parseDouble(splitArr[3]);
                        double ro_val = Double.parseDouble(splitArr[4]);
                        double ri_val = Double.parseDouble(splitArr[5]);

                        //this is the spot where the 3 point moving average goes

                        //time to call upon the aid of my trusty friend, calculatron
                        lh_arr[2]=lh_val; //set new value to third spot in array
                        lh_arr = calculatron(lh_arr); // shift stuff back a spot, will get [val, val, 0, avg]
                        //since all the arrays start populated with 0s, calculatron should just work
                        pads[0].setText(String.format("%.2f", lh_arr[3])); // print avg to left heel, round it

                        lo_arr[2] = lo_val;
                        lo_arr = calculatron(lo_arr);
                        pads[1].setText(String.format("%.2f", lo_arr[3]));

                        li_arr[2] = li_val;
                        li_arr = calculatron(li_arr);
                        pads[2].setText(String.format("%.2f", li_arr[3]));

                        rh_arr[2] = rh_val;
                        rh_arr = calculatron(rh_arr);
                        pads[3].setText(String.format("%.2f", rh_arr[3]));

                        ro_arr[2] = ro_val;
                        ro_arr = calculatron(ro_arr);
                        pads[4].setText(String.format("%.2f", ro_arr[3]));

                        ri_arr[2] = ri_val;
                        ri_arr = calculatron(ri_arr);
                        pads[5].setText(String.format("%.2f", ri_arr[3]));


                        //update total cycle count
                        totalCycles++;

                        double leftval = li_val+lo_val+lh_val;
                        double rightval = rh_val+ro_val+ri_val;



                        if (leftval == 0 && rightval == 0)
                        {progbar.setProgress(50);}
                        else {
                            int barVal = (int) Math.round(100 * (leftval / (leftval + rightval)));
                            progbar.setProgress(barVal);
                        }

                        padLtotal.setText((String.format("%.2f", leftval)));
                        padRtotal.setText((String.format("%.2f", rightval)));

                        // Logging to CSV
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");

                        Date date = new Date();
                        Timestamp timestamp = new Timestamp(date.getTime());

                        //format timestamp
                        String timestampStr = sdf.format(timestamp);

                        String csvText = timestampStr + ", " + arduinoMsg + ", " + totalCycles;

                        if(logging.isChecked() && csvOut!=null && pfd != null) {
                            try {
                                csvOut.write(csvText.getBytes());
                                csvOut.write(System.getProperty( "line.separator" ).getBytes());
                                csvOut.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(), "File Write Error, please try again", Toast.LENGTH_SHORT).show();
                            }
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



    public double[] calculatron(double[] values)
    {
        // the infinitely wise calculatron takes in an array, averages it,
        // and shifts some stuff around to make a new array
        double first = values[0];
        double second = values[1];
        double third = values[2];
        double placeholder = 0;
        double printout = ((first+second+third)/3);

            values[0] = second;
            values[1] = third;
            values[2] = placeholder;
            values[3] = printout;
            return values;


    }

}