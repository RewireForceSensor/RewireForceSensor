package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.DoubleSupplier;

public class LeftRightFragment extends GraphViewFragment {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public LeftRightFragment(){

        super(R.layout.prosup_fragment, 0f, 10f);
        this.setName("OVERALL BALANCE");
        setSuppliers(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return (sensorDataArr[0] + sensorDataArr[1] + sensorDataArr[2])/3;
            }
        }, new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return (sensorDataArr[3] + sensorDataArr[4] + sensorDataArr[5])/3;
            }
        });
    }

}
