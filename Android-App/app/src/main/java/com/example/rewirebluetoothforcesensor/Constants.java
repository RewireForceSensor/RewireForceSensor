package com.example.rewirebluetoothforcesensor;

public class Constants {
    public static final boolean isLoadCell = true;
    public static enum CalibrationStage{
        UNCALIBRATED,   // Not calibrated
        OFFSET, // Calibrate offset
        WEIGHT, // Wait for weight placement
        FACTOR, // Calibrate factor
        FINISHED    // Finished
    }
}
