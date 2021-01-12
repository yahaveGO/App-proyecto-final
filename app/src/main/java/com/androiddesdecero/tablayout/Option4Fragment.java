package com.androiddesdecero.tablayout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
/*
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
*/

public class Option4Fragment extends Fragment {
    public Option4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_option4, container, false);
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

        metodoClickColor(colorwhite,"antelope");
        metodoClickColor(colorblack,"bear");
        metodoClickColor(colorgray,"crocodile");
        metodoClickColor(colorred,"elephant");
        metodoClickColor(colorblue,"flemish");
        metodoClickColor(coloryellow,"giraffe");
        metodoClickColor(colorgreen,"lion");
        metodoClickColor(colororange,"panda");
        metodoClickColor(colorbrown,"penguins");
        metodoClickColor(colorpink,"rhino");
        metodoClickColor(colorviolet,"tortoise");
        metodoClickColor(colorpurple,"zebra");
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
        Button colores = (Button) view.findViewById(R.id.colores);
        colores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Animals.class);
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
