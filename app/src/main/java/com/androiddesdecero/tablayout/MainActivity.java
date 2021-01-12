package com.androiddesdecero.tablayout;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();
        setUpViewPagerAdapter();

    }

    private void setUpView(){
        imageView = findViewById(R.id.imageView);
        tabLayout = findViewById(R.id.tabLayout);
        appBarLayout = findViewById(R.id.appBarLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    private void setUpViewPagerAdapter(){
        viewPagerAdapter.addFragment(new Option1Fragment(), "COLORS");
        viewPagerAdapter.addFragment(new Option2Fragment(), "NUMBERS");
        viewPagerAdapter.addFragment(new Option3Fragment(), "FIGURES");
        viewPagerAdapter.addFragment(new Option4Fragment(), "ANIMALS");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        imageView.setImageResource(R.drawable.color_black);
                        Log.d("TAG1", "Posicion: " + tabLayout.getSelectedTabPosition() + " Titulo: " + viewPagerAdapter.getPageTitle(tabLayout.getSelectedTabPosition()));
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.ic_baseline_exposure_zero_24);
                        Log.d("TAG1", "Posicion: " + tabLayout.getSelectedTabPosition() + " Titulo: " + viewPagerAdapter.getPageTitle(tabLayout.getSelectedTabPosition()));
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.figure_star);
                        Log.d("TAG1", "Posicion: " + tabLayout.getSelectedTabPosition() + " Titulo: " + viewPagerAdapter.getPageTitle(tabLayout.getSelectedTabPosition()));
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.ic_baseline_emoji_nature_24);
                        Log.d("TAG1", "Posicion: " + tabLayout.getSelectedTabPosition() + " Titulo: " + viewPagerAdapter.getPageTitle(tabLayout.getSelectedTabPosition()));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}


/*Aplicacion de ingles para niños en cuarentena implementando colores, numeros, figuras*/


/*
Orientada y dirigida para niños mayores de 5 años, la cual la problemática es de que los niños ya se desesperan estando en casa
estos niños podrían tener al tiempo problemas de ansiedad y estrés, y la aplicación será muy amigable enfocada para ellos,
y para aprovechar esos tiempos puedan usar la aplicación para aprender los colores, números y figuras, del cual podrán
visualizar la palabra de cada uno, al igual que se podrá utilizar el micrófono para practicar el hablar y verificar
si el niño o niña realiza una correcta pronunciación en ingles, lo escrito para leer, botones en cada una para escucharla
pronunciación ya sea para colores, números y figuras. Como es dirigida para niños utiliza un inglés básico.

*/
