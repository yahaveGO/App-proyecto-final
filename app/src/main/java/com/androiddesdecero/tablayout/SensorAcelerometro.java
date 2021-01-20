package com.androiddesdecero.tablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class SensorAcelerometro extends AppCompatActivity implements SensorEventListener {
    private long last_update =0, last_moment = 0;
    private float prevX = 0, prevY = 0, prevZ = 0;
    private float curX = 0, curY = 0, curZ = 0;

    public int contador  = 0;
    public boolean condicion = true;

    private TextToSpeech tts;
    private TextToSpeech.OnInitListener ttsLintener =
            new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS){
                        //Locale locale = new Locale("spa", "MEX");// Español mexico
                        tts.setLanguage(Locale.US);
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_acelerometro);
        tts = new TextToSpeech(this,ttsLintener);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        synchronized (this){
            long current_time = event.timestamp;
            String salida="";

            curX = event.values[0];
            curY = event.values[1];
            curZ = event.values[2];

            if (prevX == 0 && prevY == 0 && prevZ == 0){
                last_update = current_time;
                last_moment = current_time;
                prevX = curX;
                prevY = curY;
                prevZ = curX;
            }

            long time_difference = current_time - last_update;
            if (time_difference > 0){
                float movement = Math.abs((curX + curY + curZ) - (prevX - prevY - prevZ)) / time_difference;
                int limit = 1500;
                float min_movement = 1E-6f;
                if(movement > min_movement){
                    if (current_time - last_moment >= limit){
                        if (prevX<curX) salida="Derecha";
                        if (curX<prevX) salida="Izquierda";
                        //tts.speak(salida, TextToSpeech.QUEUE_FLUSH, null);
                        //Toast.makeText(getApplicationContext(), "Hay movimiento de " + movement, Toast.LENGTH_SHORT).show();
                        TextView orientacion=findViewById(R.id.tvOrientacion);
                        orientacion.setText(salida);
                        //Toast.makeText(getApplicationContext(), "Hay movimiento de " + movement, Toast.LENGTH_SHORT).show();
                        if (condicion){
                            contador = 0;
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            tts.speak("", TextToSpeech.QUEUE_FLUSH, null);
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            condicion = false;
                        }else
                            tts.speak("Phone", TextToSpeech.QUEUE_FLUSH, null);

                        contador++;
                        Toast.makeText(getApplicationContext(), "c: "+contador, Toast.LENGTH_SHORT).show();
                        if (contador > 300 && contador < 400){
                            condicion = true;
                        }
                    }
                    last_moment = current_time;
                }
                prevX = curX;
                prevY = curY;
                prevZ = curZ;
                last_update = current_time;
            }
            ((TextView) findViewById(R.id.tvX)).setText("Acelerometro X: " + curX);
            ((TextView) findViewById(R.id.tvY)).setText("Acelerometro Y: " + curY);
            ((TextView) findViewById(R.id.tvZ)).setText("Acelerometro Z: " + curZ);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensor = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensor.size() >0){
            sm.registerListener(this,sensor.get(0), SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onStop(){
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.unregisterListener(this);
        super.onStop();
    }
}