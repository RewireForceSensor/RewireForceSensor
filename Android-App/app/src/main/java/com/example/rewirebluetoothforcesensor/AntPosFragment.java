package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.DoubleSupplier;
import static com.example.rewirebluetoothforcesensor.Constants.*;

public class AntPosFragment extends GraphViewFragment {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public AntPosFragment(){

        super(R.layout.antpos_fragment);
        this.setName("ANTERIOR/POSTERIOR");
        setSuppliers(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                if(isLoadCell)
                    return (sensorDataArr[0] + sensorDataArr[1])/2 - (sensorDataArr[2]+sensorDataArr[3])/2;
                return (sensorDataArr[1] + sensorDataArr[2])/2 - sensorDataArr[0];
            }
        }, new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                if(isLoadCell)
                    return (sensorDataArr[4] + sensorDataArr[5])/2 - (sensorDataArr[6]+sensorDataArr[7])/2;
                return (sensorDataArr[4] + sensorDataArr[5])/2 - sensorDataArr[3];
            }
        });
    }
}
