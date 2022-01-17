package com.example.rewirebluetoothforcesensor;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.solver.widgets.Rectangle;

// Feet
public class LoadCellFragment extends DataViewFragment{
    TextView[] pads;
    double[] sensorDataArr;
    int totalCycles;

    public int LeftNoWeightTimeCount = 0;
    public int LeftNoWeightValue = 0;
    public int RightNoWeightTimeCount = 0;
    public int RightNoWeightValue = 0;

    double[][] movingAvgArr = new double[4][6];

    double leftTotal;
    double rightTotal;
    int progbarVal;

    TextView padLtotal;
    TextView padRtotal;
    ProgressBar progbar;

    LoadCellView loadCellView;

    public LoadCellFragment(){

        super(R.layout.load_cell_fragment);
        this.setName("OVERVIEW");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.load_cell_fragment, container, false);

        loadCellView = (LoadCellView) rootView.findViewById(R.id.loadCellView);

        /*pads = new TextView[]{rootView.findViewById(R.id.pad0),
                rootView.findViewById(R.id.pad1),
                rootView.findViewById(R.id.pad2),
                rootView.findViewById(R.id.pad3),
                rootView.findViewById(R.id.pad4),
                rootView.findViewById(R.id.pad5)};

        padLtotal = rootView.findViewById(R.id.padLtot);
        padRtotal = rootView.findViewById(R.id.padRtot);
        progbar = rootView.findViewById(R.id.progressBar);

        sensorDataArr = new double[6];
        totalCycles = 0;

        leftTotal = 0;
        rightTotal = 0;

        progbarVal = 0;
*/
        return rootView;
    }


    public void putSensorData(Bundle args){
        /*for(int i=0; i<6; i++) {
            sensorDataArr = args.getDoubleArray("sensorData");
            totalCycles = args.getInt("totalCycles");
        }*/
    }

    public void update(){
        /*for(int i=0; i<6; i++){
            pads[i].setText("" + sensorDataArr[i]);
        }

        //this is the spot where the 3 point moving average goes

        for(int i=0; i<movingAvgArr.length; i++){
            //time to call upon the aid of my trusty friend, calculatron
            movingAvgArr[i][2] = sensorDataArr[i]; //set new value to third spot in array
            movingAvgArr[i] = calculatron(movingAvgArr[i]); // shift stuff back a spot, will get [val, val, 0, avg]
            //since all the arrays start populated with 0s, calculatron should just work
            pads[i].setText(String.format("%.2f", movingAvgArr[i][3])); // print avg to textView, round it
        }

        leftTotal = sensorDataArr[0] + sensorDataArr[1] + sensorDataArr[2];
        rightTotal = sensorDataArr[3] + sensorDataArr[4] + sensorDataArr[5];

        if(leftTotal == 0 && rightTotal == 0){
            progbar.setProgress(50);
        }
        else{
            progbarVal = (int) Math.round(100 * (leftTotal / (leftTotal + rightTotal)));
            progbar.setProgress(progbarVal);
        }

        padLtotal.setText((String.format("%.2f", leftTotal)));
        padRtotal.setText((String.format("%.2f", rightTotal)));*/

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

        progbar.setProgress(50);
    }


}