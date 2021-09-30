package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.DoubleSupplier;

public class AntPosFragment extends GraphViewFragment {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public AntPosFragment(){

        super(R.layout.antpos_fragment);
        this.setName("ANTERIOR/POSTERIOR");
        setSuppliers(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return (sensorDataArr[1] + sensorDataArr[2])/2 - sensorDataArr[0];
            }
        }, new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return (sensorDataArr[4] + sensorDataArr[5])/2 - sensorDataArr[3];
            }
        });
    }
}
