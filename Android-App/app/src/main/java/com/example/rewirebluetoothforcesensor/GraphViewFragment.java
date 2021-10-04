package com.example.rewirebluetoothforcesensor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;

public class GraphViewFragment extends DataViewFragment {
    double[] sensorDataArr;
    int totalCycles;

    DoubleSupplier leftSupplier;
    DoubleSupplier rightSupplier;

    LineChart chart;
    float yMax = 10f;
    float yMin = -10f;

    int contentLayoutId;

    public GraphViewFragment(int contentLayoutId, float yMin, float yMax){
        super(contentLayoutId);
        this.contentLayoutId = contentLayoutId;

        this.yMin = yMin;
        this.yMax = yMax;
    }

    public GraphViewFragment(int contentLayoutId){
        super(R.layout.prosup_fragment);
        this.contentLayoutId = contentLayoutId;
    }

    public void setSuppliers(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier){
        this.leftSupplier = leftSupplier;
        this.rightSupplier = rightSupplier;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                contentLayoutId, container, false);

        chart = (LineChart) rootView.findViewById(R.id.chart);
        chart.getDescription().setText("");

        List<Entry> entries = new ArrayList<Entry>();
        LineDataSet leftDataSet = createLSet();
        LineDataSet rightDataSet = createRSet();

        LineData data = new LineData(leftDataSet, rightDataSet);

        chart.setData(data);
        chart.invalidate();

        return rootView;
    }

    public void putSensorData(Bundle args){
        for(int i=0; i<6; i++) {
            sensorDataArr = args.getDoubleArray("sensorData");
            totalCycles = args.getInt("totalCycles");
        }
    }

    public void update(){
        LineData data = chart.getData();

        if (data != null) {

            ILineDataSet dataLSet = data.getDataSetByIndex(0);
            ILineDataSet dataRSet = data.getDataSetByIndex(1);
            // set.addEntry(...); // can be called as well

            if (dataLSet == null) {
                dataLSet = createLSet();
                data.addDataSet(dataLSet);
            }

            if(dataRSet == null){
                dataRSet = createRSet();
                data.addDataSet(dataRSet);
            }

            data.addEntry(new Entry(totalCycles, (float)(leftSupplier.getAsDouble())), 0); // Left side
            data.addEntry(new Entry(totalCycles, (float)(rightSupplier.getAsDouble())), 1); // Right side
            //dataSet.getEntryCount();
            data.notifyDataChanged();

            // let the chart know it's data has changed
            chart.notifyDataSetChanged();

            chart.setVisibleXRangeMaximum(120);
            chart.getAxisLeft().setAxisMaximum(yMax);
            chart.getAxisLeft().setAxisMinimum(yMin);
            chart.getAxisRight().setEnabled(false);

            //chart.setVisibleYRangeMaximum(50f, YAxis.AxisDependency.LEFT);

            chart.moveViewToX(data.getEntryCount());

        }
    }


    private LineDataSet createLSet() {

        LineDataSet dataSet = new LineDataSet(null, "Left Foot");
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setColor(Color.rgb(195, 19, 19));
        //dataSet.setCircleColor(Color.BLACK);
        dataSet.setLineWidth(3f);
        //dataSet.setCircleRadius(4f);
        dataSet.setDrawCircles(false);
        dataSet.setFillAlpha(65);
        dataSet.setFillColor(ColorTemplate.getHoloBlue());
        //dataSet.setHighLightColor(Color.rgb(244, 117, 117));
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(9f);
        dataSet.setDrawValues(false);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER); // Makes lines smooth
        return dataSet;
    }

    private LineDataSet createRSet() {

        LineDataSet dataSet = new LineDataSet(null, "Right Foot");
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setColor(Color.rgb(72, 195, 19));
        //dataSet.setCircleColor(Color.BLACK);
        dataSet.setLineWidth(3f);
        //dataSet.setCircleRadius(4f);
        dataSet.setDrawCircles(false);
        dataSet.setFillAlpha(65);
        dataSet.setFillColor(ColorTemplate.getHoloBlue());
        //dataSet.setHighLightColor(Color.rgb(244, 117, 117));
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(9f);
        dataSet.setDrawValues(false);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER); // Makes lines smooth
        return dataSet;
    }
}
