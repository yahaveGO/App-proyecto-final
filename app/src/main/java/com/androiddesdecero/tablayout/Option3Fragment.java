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
public class Option3Fragment extends Fragment {


    public Option3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_option3, container, false);
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
        ImageButton coloruno   = (ImageButton) view.findViewById(R.id.coloruno);
        ImageButton colordos = (ImageButton) view.findViewById(R.id.colordos);
        ImageButton colortres = (ImageButton) view.findViewById(R.id.colortres);

        metodoClickColor(colorwhite,"basquetbol");
        metodoClickColor(colorblack,"star");
        metodoClickColor(colorgray,"car");
        metodoClickColor(colorred,"cloud");
        metodoClickColor(colorblue,"cake");
        metodoClickColor(coloryellow,"headset");
        metodoClickColor(colorgreen,"house");
        metodoClickColor(colororange,"key");
        metodoClickColor(colorbrown,"computer");
        metodoClickColor(colorpink,"hand");
        metodoClickColor(colorviolet,"phone");
        metodoClickColor(colorpurple,"watch");
        metodoClickColor(coloruno,"pet");
        metodoClickColor(colordos,"sun");
        metodoClickColor(colortres,"soccer");
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
        Button colores = (Button) view.findViewById(R.id.colores);
        colores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Figures.class);
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
