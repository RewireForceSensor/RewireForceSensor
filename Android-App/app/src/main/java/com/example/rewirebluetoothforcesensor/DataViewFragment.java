package com.example.rewirebluetoothforcesensor;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;

abstract class DataViewFragment extends Fragment {
    String name = "";

    public DataViewFragment(){
        super();
    }

    public DataViewFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    abstract void putSensorData(Bundle sensorData);

    abstract void update();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}