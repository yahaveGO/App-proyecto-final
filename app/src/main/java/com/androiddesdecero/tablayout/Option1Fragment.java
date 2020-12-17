package com.androiddesdecero.tablayout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
/*
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
*/
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import android.speech.tts.TextToSpeech;

public class Option1Fragment extends Fragment {
    public Option1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_option1, container, false);
//--------------------------------------------------------------------------------------------------
        ImageButton colorwhite  = (ImageButton) view.findViewById(R.id.colorwhite);
        ImageButton colorblack  = (ImageButton) view.findViewById(R.id.colorblack);
        ImageButton colorgray   = (ImageButton) view.findViewById(R.id.colorgray);
        ImageButton colorred    = (ImageButton) view.findViewById(R.id.colorred);
        ImageButton colorblue   = (ImageButton) view.findViewById(R.id.colorblue);
        ImageButton coloryellow = (ImageButton) view.findViewById(R.id.coloryellow);
        ImageButton colorgreen  = (ImageButton) view.findViewById(R.id.colorgreen);
        ImageButton colororange = (ImageButton) view.findViewById(R.id.colororange);
        ImageButton colorbrown  = (ImageButton) view.findViewById(R.id.colorbrown);
        ImageButton colorpink   = (ImageButton) view.findViewById(R.id.colorpink);
        ImageButton colorviolet = (ImageButton) view.findViewById(R.id.colorviolet);
        ImageButton colorpurple = (ImageButton) view.findViewById(R.id.colorpurple);

        metodoClickColor(colorwhite,"white");
        metodoClickColor(colorblack,"black ");
        metodoClickColor(colorgray,"gray ");
        metodoClickColor(colorred,"red  ");
        metodoClickColor(colorblue,"blue");
        metodoClickColor(coloryellow,"yellow");
        metodoClickColor(colorgreen,"green");
        metodoClickColor(colororange,"orange");
        metodoClickColor(colorbrown,"brown");
        metodoClickColor(colorpink,"pink ");
        metodoClickColor(colorviolet,"violet");
        metodoClickColor(colorpurple,"purple");
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
        Button colores = (Button) view.findViewById(R.id.colores);
        colores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Colors.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
        return view;
    }
    public void metodoClickColor(ImageButton color, final String name){
        color.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show(); }
        });
    }

}
