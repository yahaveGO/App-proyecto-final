package com.androiddesdecero.tablayout;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/*import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;*/

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class Figures extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    private TextView tvMensaje;
    private TextToSpeech textToSpeech;
//--------------------------------------------------------------------------------------------------
    private TextToSpeech mTTS;
    private EditText mEditText;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private Button mButtonSpeak;
//--------------------------------------------------------------------------------------------------
//ObjectAnimator -> Nos proporciona soporte parar animar nuestros objetos
    private ObjectAnimator animatorX;
    private ObjectAnimator animatorY;
    private ObjectAnimator animatorAlpha;
    private ObjectAnimator animatorRotation;
    private ObjectAnimator animatorAll;

    private long animationDuration = 1000;

    //AnimatorSet -> Reproduce un conjunto de ObjectAnimator en un orden especificado. Las animaciones pueden ser todas a la vez o secuenciadas
    private AnimatorSet animatorSet;
//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figures);
//--------------------------------------------------------------------------------------------------
        tvMensaje = findViewById(R.id.tvMensaje);
        textToSpeech = new TextToSpeech(this, this);
//--------------------------------------------------------------------------------------------------
        mButtonSpeak = findViewById(R.id.button_speak);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
        mEditText = findViewById(R.id.edit_text);
        mSeekBarPitch = findViewById(R.id.seek_bar_pitch);
        mSeekBarSpeed = findViewById(R.id.seek_bar_speed);
        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
        ImageButton colorwhite = (ImageButton) findViewById(R.id.colorwhite);
        ImageButton colorblack = (ImageButton) findViewById(R.id.colorblack);
        ImageButton colorgray = (ImageButton) findViewById(R.id.colorgray);
        ImageButton colorred = (ImageButton) findViewById(R.id.colorred);
        ImageButton colorblue = (ImageButton) findViewById(R.id.colorblue);
        ImageButton coloryellow = (ImageButton) findViewById(R.id.coloryellow);
        ImageButton colorgreen = (ImageButton) findViewById(R.id.colorgreen);
        ImageButton colororange = (ImageButton) findViewById(R.id.colororange);
        ImageButton colorbrown = (ImageButton) findViewById(R.id.colorbrown);
        ImageButton colorpink = (ImageButton) findViewById(R.id.colorpink);
        ImageButton colorviolet = (ImageButton) findViewById(R.id.colorviolet);
        ImageButton colorpurple = (ImageButton) findViewById(R.id.colorpurple);
        ImageButton coloruno = (ImageButton) findViewById(R.id.coloruno);
        ImageButton colordos = (ImageButton) findViewById(R.id.colordos);
        //ImageButton colortres = (ImageButton) findViewById(R.id.colortres);

        TextView txtwhite = (TextView) findViewById(R.id.txtwhite);
        TextView txtblack = (TextView) findViewById(R.id.txtblack);
        TextView txtgray = (TextView) findViewById(R.id.txtgray);
        TextView txtred = (TextView) findViewById(R.id.txtred);
        TextView txtblue = (TextView) findViewById(R.id.txtblue);
        TextView txtyellow = (TextView) findViewById(R.id.txtyellow);
        TextView txtgreen = (TextView) findViewById(R.id.txtgreen);
        TextView txtorange = (TextView) findViewById(R.id.txtorange);
        TextView txtbrown = (TextView) findViewById(R.id.txtbrown);
        TextView txtpink = (TextView) findViewById(R.id.txtpink);
        TextView txtviolet = (TextView) findViewById(R.id.txtviolet);
        TextView txtpurple = (TextView) findViewById(R.id.txtpurple);
        TextView txtuno = (TextView) findViewById(R.id.txtuno);
        TextView txtdos = (TextView) findViewById(R.id.txtdos);
        //TextView txttres = (TextView) findViewById(R.id.txttres);

        clickColor(colorwhite, txtwhite);
        clickColor(colorblack, txtblack);
        clickColor(colorgray, txtgray);
        clickColor(colorred, txtred);
        clickColor(colorblue, txtblue);
        clickColor(coloryellow, txtyellow);
        clickColor(colorgreen, txtgreen);
        clickColor(colororange, txtorange);
        clickColor(colorbrown, txtbrown);
        clickColor(colorpink, txtpink);
        clickColor(colorviolet, txtviolet);
        clickColor(colorpurple, txtpurple);
        clickColor(coloruno, txtuno);
        clickColor(colordos, txtdos);
        //clickColor(colortres, txttres);
//--------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------
    }
//--------------------------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------------------------
    private void speak() {
        String text = mEditText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    //--------------------------------------------------------------------------------------------------
    public void clickColor(ImageButton imgcolor, final TextView txtcolor) {
        imgcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakColor(txtcolor);
            }
        });
    }

    //--------------------------------------------------------------------------------------------------
    private void speakColor(TextView color) {
        String text = color.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
//--------------------------------------------------------------------------------------------------

    public void hablar(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        startActivityForResult(intent, RECOGNIZE_SPEECH_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && data != null) {
                    List<String> coincidencias = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String cadena = coincidencias.get(0);
                    String nocolor = "@figure/ not found";
                    /*System.out.println("CADENA: "+cadena+" -> "+cadena.length());//-------------->hablando*/
                    if (cadena.equalsIgnoreCase("basquetbol") ||
                            cadena.equalsIgnoreCase("star") ||
                            cadena.equalsIgnoreCase("car") ||
                            cadena.equalsIgnoreCase("cake") ||
                            cadena.equalsIgnoreCase("headset") ||
                            cadena.equalsIgnoreCase("house") ||
                            cadena.equalsIgnoreCase("key") ||
                            cadena.equalsIgnoreCase("computer") ||
                            cadena.equalsIgnoreCase("cell phone") ||
                            cadena.equalsIgnoreCase("phone") ||
                            cadena.equalsIgnoreCase("watch") ||
                            cadena.equalsIgnoreCase("sun") ||
                            cadena.equalsIgnoreCase("soccer") ||
                            cadena.equalsIgnoreCase("cloud") ||
                            cadena.equalsIgnoreCase("pet")) {
                        tvMensaje.setText(cadena);
                        System.out.println("CADENA: " + cadena + " -> " + cadena.length());//-------------->hablando
                        textToSpeech.setLanguage(new Locale("us", "EU"));
                        speak(cadena);
                    }else {
                        tvMensaje.setText(nocolor);
                    }
                    if(cadena.equalsIgnoreCase("hand")){
                        Intent intent = new Intent(this, SensorHang.class);
                        startActivity(intent);
                    }if(cadena.equalsIgnoreCase("phone") || cadena.equalsIgnoreCase("cell phone") ){
                        Intent intent = new Intent(this, SensorAcelerometro.class);
                        startActivity(intent);
                    }
//--------------------------------------------------------------------------------------------------
                    ImageButton colorwhite = (ImageButton) findViewById(R.id.colorwhite);
                    ImageButton colorblack = (ImageButton) findViewById(R.id.colorblack);
                    ImageButton colorgray = (ImageButton) findViewById(R.id.colorgray);
                    ImageButton colorred = (ImageButton) findViewById(R.id.colorred);
                    ImageButton colorblue = (ImageButton) findViewById(R.id.colorblue);
                    ImageButton coloryellow = (ImageButton) findViewById(R.id.coloryellow);
                    ImageButton colorgreen = (ImageButton) findViewById(R.id.colorgreen);
                    ImageButton colororange = (ImageButton) findViewById(R.id.colororange);
                    ImageButton colorbrown = (ImageButton) findViewById(R.id.colorbrown);
                    ImageButton colorpink = (ImageButton) findViewById(R.id.colorpink);
                    ImageButton colorviolet = (ImageButton) findViewById(R.id.colorviolet);
                    ImageButton colorpurple = (ImageButton) findViewById(R.id.colorpurple);
                    ImageButton coloruno = (ImageButton) findViewById(R.id.coloruno);
                    ImageButton colordos = (ImageButton) findViewById(R.id.colordos);

                    try {
                        Thread.sleep(1000); //pause
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    if(cadena.equalsIgnoreCase("basquetbol")){
                        metodoAnimator(colorwhite);
                    } else if(cadena.equalsIgnoreCase("star")){
                        metodoAnimator(colorpurple);
                    } else if(cadena.equalsIgnoreCase("car")){
                        metodoAnimator(colorblue);
                    } else if(cadena.equalsIgnoreCase("cake")){
                        metodoAnimator(colorviolet);
                    } else if(cadena.equalsIgnoreCase("headset")){
                        metodoAnimator(colordos);
                    } else if(cadena.equalsIgnoreCase("house")){
                        metodoAnimator(colorbrown);
                    } else if(cadena.equalsIgnoreCase("key")){
                        metodoAnimator(coloryellow);
                    } else if(cadena.equalsIgnoreCase("computer")){
                        metodoAnimator(coloruno);
                    } else if(cadena.equalsIgnoreCase("watch")){
                        metodoAnimator(colororange);
                    } else if(cadena.equalsIgnoreCase("sun")){
                        metodoAnimator(colorgray);
                    } else if(cadena.equalsIgnoreCase("soccer")){
                        metodoAnimator(colorblack);
                    } else if(cadena.equalsIgnoreCase("cloud")){
                        metodoAnimator(colorred);
                    } else if(cadena.equalsIgnoreCase("pet")){
                        metodoAnimator(colorpink);
                    }
//--------------------------------------------------------------------------------------------------
                }
        }
    }

    private void metodoAnimator(ImageButton color) {
        animatorRotation = ObjectAnimator.ofFloat(color, "rotation",0f, 720);//360f
        animatorRotation.setDuration(animationDuration);
        AnimatorSet animatorSetRotator = new AnimatorSet();
        animatorSetRotator.playTogether(animatorRotation);
        animatorSetRotator.start();
    }


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(this, "Error por falta de datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void speak(String cadena) {
        textToSpeech.speak(cadena, TextToSpeech.QUEUE_FLUSH, null);
        textToSpeech.setSpeechRate(0.0f);
        textToSpeech.setPitch(0.0f);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }
//--------------------------------------------------------------------------------------------------
}
