package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.DoubleSupplier;

public class AntPosFragment extends GraphViewFragment {

    private int[] antPosFlags = {0, 0}; // [L, R] 0 nothing, 1 anterior, 2 posterior
    private int threshold = 3;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void update(){
        super.update();
        if(currentLeftVal > threshold){
            antPosFlags[0] = 1;
        }
        else if(currentLeftVal < -threshold){
            antPosFlags[0] = 2;
        }
        else{
            antPosFlags[0] = 0;
        }

        if(currentRightVal > threshold){
            antPosFlags[1] = 1;
        }
        else if(currentRightVal < -threshold){
            antPosFlags[1] = 2;
        }
        else{
            antPosFlags[1] = 0;
        }
        flagViewModel.setAntPosFlag(antPosFlags);
    }
}
