package com.example.rewirebluetoothforcesensor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FlagViewModel extends ViewModel {
    private final MutableLiveData<int[]> supProFlag = new MutableLiveData<int[]>();
    private final MutableLiveData<int[]> antPosFlag = new MutableLiveData<int[]>();
    private final MutableLiveData<int[]> zeroWeightFlag = new MutableLiveData<int[]>();

    public void setSupProFlag(int[] flags) {
        supProFlag.setValue(flags);
    }

    public void setAntPosFlag(int[] flags){
        antPosFlag.setValue(flags);
    }

    public void setZeroWeightFlag(int[] flags){
        zeroWeightFlag.setValue(flags);
    }

    public LiveData<int[]> getSupProFlag() {
        return supProFlag;
    }

    public LiveData<int[]> getAntPosFlag() {
        return antPosFlag;
    }

    public LiveData<int[]> getZeroWeightFlag() {
        return zeroWeightFlag;
    }
}