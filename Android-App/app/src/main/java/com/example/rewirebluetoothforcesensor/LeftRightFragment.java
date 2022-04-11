package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.DoubleSupplier;
import static com.example.rewirebluetoothforcesensor.Constants.*;

public class LeftRightFragment extends GraphViewFragment {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public LeftRightFragment(){

        super(R.layout.leftright_fragment, 0f, 80f);
        this.setName("OVERALL BALANCE");
        setSuppliers(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                if(isLoadCell)
                    return (sensorDataArr[0] + sensorDataArr[1] + sensorDataArr[2] + sensorDataArr[3])/4;
                return (sensorDataArr[0] + sensorDataArr[1] + sensorDataArr[2])/3;
            }
        }, new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                if(isLoadCell)
                    return (sensorDataArr[4] + sensorDataArr[5] + sensorDataArr[6] + sensorDataArr[7])/4;
                return (sensorDataArr[3] + sensorDataArr[4] + sensorDataArr[5])/3;
            }
        });
    }

}
