package com.androiddesdecero.tablayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class SensorHang extends AppCompatActivity {
    private TextToSpeech mTTS;
    private EditText mEditText;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private Button mButtonSpeak;
//--------------------------------------------------------------------------------------------------
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_hang);
//--------------------------------------------------------------------------------------------------
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null)
            finish();
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < sensor.getMaximumRange())
                    getWindow().getDecorView().setBackgroundColor(Color.RED);

                else
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
//--------------------------------------------------------------------------------------------------
    }

//--------------------------------------------------------------------------------------------------
    public void start(){
        sensorManager.registerListener(sensorEventListener, sensor, 2000*1000);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
}