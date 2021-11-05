package com.example.rewirebluetoothforcesensor;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import java.util.function.DoubleSupplier;

public class SupProFragment extends GraphViewFragment {

    private int[] supProFlags = {0, 0}; // [L, R] 0 nothing, 1 supination, 2 pronation
    private int threshold = 3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public SupProFragment(){
        super(R.layout.suppro_fragment);
        this.setName("SUPINATION/PRONATION");
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void update(){
        super.update();
        supProFlags[0] = 1;
        supProFlags[1] = 1;
        flagViewModel.setSupProFlag(supProFlags);
//        if(currentLeftVal > threshold){
//            supProFlags[0] = 1;
//        }
//        else if(currentLeftVal < -threshold){
//            supProFlags[0] = 2;
//        }
//        else{
//            supProFlags[0] = 0;
//        }
//
//        if(currentRightVal > threshold){
//            supProFlags[1] = 1;
//        }
//        else if(currentRightVal < -threshold){
//            supProFlags[1] = 2;
//        }
//        else{
//            supProFlags[1] = 0;
//        }
        supProFlags[0] = 1;// Test
    }

}
