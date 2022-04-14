package com.example.rewirebluetoothforcesensor;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;

abstract class DataViewFragment extends Fragment {
    String name = "";
    ViewGroup rootView;

    public DataViewFragment(){
        super();
    }

    public DataViewFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    abstract void refreshView();

    abstract void putSensorData(Bundle sensorData);

    abstract void update();

    abstract void clear();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}