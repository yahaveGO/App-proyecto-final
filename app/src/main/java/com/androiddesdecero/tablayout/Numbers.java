package com.androiddesdecero.tablayout;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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


public class Numbers extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    private TextView tvMensaje;
    private TextToSpeech textToSpeech;

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
        setContentView(R.layout.activity_numbers);
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
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
    }

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
                    String nocolor = "@number/ not found";
                    /*System.out.println("CADENA: "+cadena+" -> "+cadena.length());//-------------->hablando*/
                    if (cadena.equalsIgnoreCase("one") ||
                            cadena.equalsIgnoreCase("two") ||
                            cadena.equalsIgnoreCase("three") ||
                            cadena.equalsIgnoreCase("four") ||
                            cadena.equalsIgnoreCase("five") ||
                            cadena.equalsIgnoreCase("six") ||
                            cadena.equalsIgnoreCase("seven") ||
                            cadena.equalsIgnoreCase("eight") ||
                            cadena.equalsIgnoreCase("nine") ||
                            cadena.equalsIgnoreCase("ten") ||
                            cadena.equalsIgnoreCase("eleven") ||
                            cadena.equalsIgnoreCase("twelve")
                    ) {
                        tvMensaje.setText(cadena);
                        System.out.println("CADENA: " + cadena + " -> " + cadena.length());//-------------->hablando
                        textToSpeech.setLanguage(new Locale("us", "EU"));
                        speak(cadena);
                    } else {
                        tvMensaje.setText(nocolor);
                    }
                    for (int i = 0; i <= 1000000; i++) {
                        if (cadena.equalsIgnoreCase("" + i + "")) {
                            tvMensaje.setText(cadena);
                            System.out.println("CADENA: " + cadena + " -> " + cadena.length());//-------------->hablando
                            textToSpeech.setLanguage(new Locale("us", "EU"));
                            speak(cadena);
                        }
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

                    try {
                        Thread.sleep(1000); //pause
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    if(cadena.equalsIgnoreCase("" + 1 + "")){
                        metodoAnimator(colorwhite);
                    } else if(cadena.equalsIgnoreCase("" + 2 + "")){
                        metodoAnimator(colorgray);
                    } else if(cadena.equalsIgnoreCase("" + 3 + "")){
                        metodoAnimator(colorblue);
                    } else if(cadena.equalsIgnoreCase("" + 4 + "")){
                        metodoAnimator(colorgreen);
                    } else if(cadena.equalsIgnoreCase("" + 5 + "")){
                        metodoAnimator(colorbrown);
                    } else if(cadena.equalsIgnoreCase("" + 6 + "")){
                        metodoAnimator(colorviolet);
                    } else if(cadena.equalsIgnoreCase("" + 7 + "")){
                        metodoAnimator(colorblack);
                    } else if(cadena.equalsIgnoreCase("" + 8 + "")){
                        metodoAnimator(colorred);
                    } else if(cadena.equalsIgnoreCase("" + 9 + "")){
                        metodoAnimator(coloryellow);
                    } else if(cadena.equalsIgnoreCase("" + 10 + "")){
                        metodoAnimator(colororange);
                    } else if(cadena.equalsIgnoreCase("" + 11 + "")){
                        metodoAnimator(colorpink);
                    } else if(cadena.equalsIgnoreCase("" + 12 + "")){
                        metodoAnimator(colorpurple);
                    }
//--------------------------------------------------------------------------------------------------

                }
        }
    }

    private void metodoAnimator(ImageButton color) {
        animatorX = ObjectAnimator.ofFloat(color, "x", 300f);
        animatorX.setDuration(animationDuration);
        AnimatorSet animatorSetX = new AnimatorSet();
        animatorSetX.playTogether(animatorX);
        animatorSetX.start();

        try {
            Thread.sleep(2000); //pause
        } catch (Exception e) {
            System.out.println(e);
        }

        animatorAlpha = ObjectAnimator.ofFloat(color, View.ALPHA,1.0f, 0.0f);
        animatorAlpha.setDuration(animationDuration);
        AnimatorSet animatorSetAlpha = new AnimatorSet();
        animatorSetAlpha.playTogether(animatorAlpha);
        animatorSetAlpha.start();
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
