package com.example.rewirebluetoothforcesensor;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

abstract class DataViewFragment extends Fragment {
    String name = "";
    protected FlagViewModel flagViewModel;

    public DataViewFragment(){
        super();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        flagViewModel = new ViewModelProvider(requireActivity()).get(FlagViewModel.class);
    }

    public DataViewFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

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