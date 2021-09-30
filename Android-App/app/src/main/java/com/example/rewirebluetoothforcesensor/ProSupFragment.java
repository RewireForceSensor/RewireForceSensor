package com.example.rewirebluetoothforcesensor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
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
import java.util.Map;
import java.util.function.DoubleSupplier;

public class ProSupFragment extends GraphViewFragment {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ProSupFragment(){

        super(R.layout.prosup_fragment);
        this.setName("PRONATION/SUPINATION");
        setSuppliers(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return sensorDataArr[1] - sensorDataArr[2];
            }
        }, new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return sensorDataArr[4] - sensorDataArr[5];
            }
        });
    }

}
