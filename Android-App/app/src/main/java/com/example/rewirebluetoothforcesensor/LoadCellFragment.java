package com.example.rewirebluetoothforcesensor;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

// Feet
public class LoadCellFragment extends DataViewFragment{
    TextView[] pads;
    double[] sensorDataArr;
    ImageView leftCop;
    ImageView rightCop;
    LoadCellView viewL;
    LoadCellView viewR;
    int totalCycles;

    public int LeftNoWeightTimeCount = 0;
    public int LeftNoWeightValue = 0;
    public int RightNoWeightTimeCount = 0;
    public int RightNoWeightValue = 0;

    double[][] movingAvgArr = new double[4][10];
    double[] xdist = {-1, 1, -1, 1, -1, 1, -1, 1};    // As percentages of width (1.3/1.3)
    double[] ydist = {1, 1, -1, -1, 1, 1, -1, -1};    // As percentages of height (2.85/2.85)

    double leftTotal;
    double rightTotal;

    float copXLeft = 0;
    float copYLeft = 0;
    float copXRight = 0;
    float copYRight = 0;

    int progbarVal;

    TextView padLtotal;
    TextView padRtotal;
    ProgressBar progbar;

    View indicator;

    public LoadCellFragment(){

        super(R.layout.load_cell_fragment);
        this.setName("OVERVIEW");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.load_cell_fragment, container, false);

        refreshView();
//        indicator = rootView.findViewById(R.id.imageView);
        //SpringAnimation springAnim = new SpringAnimation(img, DynamicAnimation.TRANSLATION_Y, 0);

        return rootView;
    }

    public void refreshView(){
        pads = new TextView[]{
                rootView.findViewById(R.id.loadPad0),
                rootView.findViewById(R.id.loadPad1),
                rootView.findViewById(R.id.loadPad2),
                rootView.findViewById(R.id.loadPad3),
                rootView.findViewById(R.id.loadPad4),
                rootView.findViewById(R.id.loadPad5),
                rootView.findViewById(R.id.loadPad6),
                rootView.findViewById(R.id.loadPad7)};

        padLtotal = rootView.findViewById(R.id.leftLoadTotal);
        padRtotal = rootView.findViewById(R.id.rightLoadTotal);
        progbar = rootView.findViewById(R.id.progressBarLoad);

        leftCop = rootView.findViewById(R.id.copLeft);
        rightCop = rootView.findViewById(R.id.copRight);

        viewL = rootView.findViewById(R.id.loadCellView);
        viewR = rootView.findViewById(R.id.loadCellView2);

        sensorDataArr = new double[8];
        totalCycles = 0;

        leftTotal = 0;
        rightTotal = 0;

        progbarVal = 0;
    }


    public void putSensorData(Bundle args){
        sensorDataArr = args.getDoubleArray("sensorData");
        totalCycles = args.getInt("totalCycles");
    }

    public void update(){
        for(int i=0; i<8; i++){
            pads[i].setText("" + sensorDataArr[i]);
            if(i < 4) {
                copXLeft += sensorDataArr[i] * xdist[i];
                copYLeft += sensorDataArr[i] * ydist[i];
            }
            else{
                copXRight += sensorDataArr[i] * xdist[i];
                copYRight += sensorDataArr[i] * ydist[i];
            }

        }

        copXLeft = (float) (Math.signum(copXLeft) * Math.min(Math.abs(copXLeft), 1.0));
        copYLeft = (float) (Math.signum(copYLeft) * Math.min(Math.abs(copYLeft), 1.0));

        copXRight = (float) (Math.signum(copXRight) * Math.min(Math.abs(copXRight), 1.0));
        copYRight = (float) (Math.signum(copYRight) * Math.min(Math.abs(copYRight), 1.0));

        //this is the spot where the 3 point moving average goes
        for(int i=0; i<movingAvgArr.length; i++){
            //time to call upon the aid of my trusty friend, calculatron
            movingAvgArr[i][2] = sensorDataArr[i]; //set new value to third spot in array
            movingAvgArr[i] = calculatron(movingAvgArr[i]); // shift stuff back a spot, will get [val, val, 0, avg]
            //since all the arrays start populated with 0s, calculatron should just work
            pads[i].setText(String.format("%.2f", movingAvgArr[i][3])); // print avg to textView, round it
        }

        leftTotal = sensorDataArr[0] + sensorDataArr[1] + sensorDataArr[2] + sensorDataArr[3];
        rightTotal = sensorDataArr[4] + sensorDataArr[5] + sensorDataArr[6] + sensorDataArr[7];

        if(leftTotal != 0) {
            copXLeft /= leftTotal;
            copYLeft /= leftTotal;
        }

        if(rightTotal != 0) {
            copXRight /= rightTotal;
            copYRight /= rightTotal;
        }

        if(leftTotal == 0 && rightTotal == 0){
            progbar.setProgress(50);
        }
        else{
            progbarVal = (int) Math.round(100 * (leftTotal / (leftTotal + rightTotal)));
            progbar.setProgress(progbarVal);
        }

        padLtotal.setText((String.format("%.2f", leftTotal)));
        padRtotal.setText((String.format("%.2f", rightTotal)));

        // Clamp to within bounds of footplate on screen
        float XL = copXLeft*viewL.getWidth()+viewL.getX()+viewL.getWidth()/2;
        float YL = (-copYLeft)*viewL.getHeight()+viewL.getY()+viewL.getHeight()/2;
        float XR = copXRight*viewR.getWidth()+viewR.getX()+viewR.getWidth()/2;
        float YR = (-copYRight)*viewR.getHeight()+viewR.getY()+viewR.getHeight()/2;

        XL = Math.max(XL, viewL.getX()+viewL.strokeWidth);
        YL = Math.max(YL, viewL.getY()+viewL.strokeWidth);
        XR = Math.max(XR, viewR.getX()+viewR.strokeWidth);
        YR = Math.max(YR, viewR.getY()+viewR.strokeWidth);

        XL = Math.min(XL, viewL.getX() + viewL.getWidth() - viewL.strokeWidth);
        YL = Math.min(YL, viewL.getY() + viewL.getHeight() - viewL.strokeWidth);
        XR = Math.min(XR, viewR.getX() + viewR.getWidth() - viewR.strokeWidth);
        YR = Math.min(YR, viewR.getY() + viewR.getHeight() - viewR.strokeWidth);

        leftCop.animate().x(XL)
                .y(YL)
                .setDuration(290)
                .start();
        rightCop.animate().x(XR)
                .y(YR)
                .setDuration(290)
                .start();

        Log.i("XY", XR + ", " + YR);

        copXLeft = 0;
        copYLeft = 0;
        copXRight = 0;
        copYRight = 0;
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

    @Override
    public void clear(){
        for(int i=0; i<pads.length; i++){
            pads[i].setText("");
        }

        padLtotal.setText("");
        padRtotal.setText("");

        //progbar.setProgress(50);
    }


}