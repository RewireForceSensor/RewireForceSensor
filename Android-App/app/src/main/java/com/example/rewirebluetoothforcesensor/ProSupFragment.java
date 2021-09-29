package com.example.rewirebluetoothforcesensor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProSupFragment extends DataViewFragment {
    double[] sensorDataArr;
    int totalCycles;

    LineChart chart;


    public ProSupFragment(){
        super(R.layout.prosup_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.prosup_fragment, container, false);

        chart = (LineChart) rootView.findViewById(R.id.chart);

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

            data.addEntry(new Entry(dataLSet.getEntryCount(), (float)(sensorDataArr[1] - sensorDataArr[2])), 0); // Left side
            data.addEntry(new Entry(dataLSet.getEntryCount(), (float)(sensorDataArr[4] - sensorDataArr[5])), 1); // Right side
            //dataSet.getEntryCount();
            data.notifyDataChanged();

            // let the chart know it's data has changed
            chart.notifyDataSetChanged();

            chart.setVisibleXRangeMaximum(120);
            chart.getAxisLeft().setAxisMaximum(10f);
            chart.getAxisLeft().setAxisMinimum(-10f);
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
