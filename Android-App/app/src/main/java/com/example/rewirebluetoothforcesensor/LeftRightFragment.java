package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.DoubleSupplier;

public class LeftRightFragment extends GraphViewFragment {

    @RequiresApi(api = Build.VERSION_CODES.N)

    private int[] zeroWeightFlags = {0, 0}; // [L, R] 0 nothing, 1 zero weight
    private int threshold = 3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public LeftRightFragment(){

        super(R.layout.leftright_fragment, 0f, 10f);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void update(){
        super.update();
        if(currentLeftVal < threshold){
            zeroWeightFlags[0] = 1;
        }
        else{
            zeroWeightFlags[0] = 0;
        }

        if(currentRightVal < threshold){
            zeroWeightFlags[1] = 1;
        }
        else{
            zeroWeightFlags[1] = 0;
        }

        flagViewModel.setZeroWeightFlag(zeroWeightFlags);
    }

}
