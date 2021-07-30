/*
 * Copyright 2021 Punch Through Design LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rewire.forcesensor.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGattService
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rewire.forcesensor.R
import java.util.UUID

class SecondActivity :AppCompatActivity() {

    private lateinit var device: BluetoothDevice
    private val TAG = "SecondActivity"


    //private var weight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second);

        device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
            ?: error("Missing BluetoothDevice from MainActivity!")

        /*val bundle: Bundle? = intent.extras
        val sid = bundle!!.getString("sessionID")*/

        /*while(true){
            readWeightSensor()
        }*/

        //Log.d("value", weight.toString())

        readWeightSensor()


//        fun BluetoothGattCharacteristic.isReadable(): Boolean =
//            containsProperty(BluetoothGattCharacteristic.PROPERTY_READ)
//
//        fun BluetoothGattCharacteristic.isWritable(): Boolean =
//        containsProperty(BluetoothGattCharacteristic.PROPERTY_WRITE)
//
//        fun BluetoothGattCharacteristic.isWritableWithoutResponse(): Boolean =
//            containsProperty(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE)
//
//        fun BluetoothGattCharacteristic.containsProperty(property: Int): Boolean {
//            return properties and property != 0
//        }

        }

    private fun readWeightSensor(){
        val weightServiceUUID = UUID.fromString("0000181d-0000-1000-8000-00805f9b34fb")
        val weightCharUUID = UUID.fromString("00002a56-0000-1000-8000-00805f9b34fb")

        val weightService = BluetoothGattService(weightServiceUUID, 0)
        val weightCharacteristic = weightService.getCharacteristic(weightCharUUID)

        //val weightCharacteristic = BluetoothGattCharacteristic(weightServiceUUID)
        //return ConnectionManager.readCharacteristic(device, weightCharacteristic)

        val textView = findViewById<TextView>(R.id.txtOutput)
        /*if(weightCharacteristic.isReadable()){
            textView.text = "it's readable"
        }*/
        //textView.text = weightCharacteristic.toString()

        textView.text = ConnectionManager.readCharacteristic(device, weightCharacteristic).toString()

    }
    /*private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            if (newState == BluetoothGatt.STATE_CONNECTED) {
                Timber.i(TAG, "Connected to GATT server.")
                gatt?.requestMtu(256)
                gatt?.discoverServices()
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
            val weightServiceUUID = UUID.fromString("0000181d-0000-1000-8000-00805f9b34fb")
            val weightCharUUID = UUID.fromString("00002a56-0000-1000-8000-00805f9b34fb")
            val characteristic = gatt?.getService(weightServiceUUID) // Battery service
                ?.getCharacteristic(weightCharUUID) // Battery life
            gatt?.readCharacteristic(characteristic)
            gatt?.setCharacteristicNotification(characteristic, true)
            characteristic?.value = byteArrayOf(50)
            //gatt?.writeCharacteristic(characteristic)
        }

        override fun onCharacteristicRead(
            gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int
        ) { /* ... */ }

        override fun onCharacteristicWrite(
            gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int
        ) { /* ... */}

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?
        ) {
            characteristic?.let {
                val weight = characteristic.value[0].toInt()
                //Log.d("",weight.toString())
                textView.text = weight.toString()
                //Log.d("", "Battery life is: $batteryLife")
            }
        }
    }*/

    /*@Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status){
        BluetoothGattCharacteristic characteristic = gatt.getService(SERVICE_UUID).getCharacteristic(CHAR_UUID);
        gatt.setCharacteristicNotification(characteristic, enabled);
        BluetoothGattDescriptor descriptor =
        characteristic.getDescriptor(CHARACTERISTIC_CONFIG_UUID);

        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        gatt.writeDescriptor(descriptor);
    }*/

}




