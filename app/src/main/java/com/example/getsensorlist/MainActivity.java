package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTextSensors;
    SensorManager sensorMgr;
    List<Sensor> sensorList;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSensors = findViewById(R.id.textSensors);
//        mTextSensors.setMovementMethod((new ScrollingMovementMethod()));
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new myOnClickListener());

    }
    private class myOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            sensorMgr = (SensorManager)getSystemService(SENSOR_SERVICE);

            sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);

            mTextSensors.append("(# Sensors: " + sensorList.size() +")\n\n");
            for(Sensor sensor : sensorList){
                mTextSensors.append("Sensor name: " +sensor.getName() +"\n");
                mTextSensors.append("Sensor type: " +sensor.getType() +"\n\n");
            }
        }
    };

}