package pl.marcinos.expfor2.Mag.Menu;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import pl.marcinos.expfor2.Archer.Menu.ArcherRanking;
import pl.marcinos.expfor2.Bohaterowie.Itemy;
import pl.marcinos.expfor2.Bohaterowie.Mag;

import pl.marcinos.expfor2.Mag.Walka.Walka.Pvp.MagPvpRanking;
import pl.marcinos.expfor2.R;


public class MagMenuActivity extends AppCompatActivity {



    public static Mag mag = new Mag();
    public static Mag maghp = new Mag();
    public static int uzytyPotekHp=0;
    public static int uzytyPotekMp=0;
    CardView postac;
    CardView ekwipunek;
    CardView sklep;
    CardView przygoda;
    CardView miniGra;
    CardView pvp;
    public static Itemy kamien = new Itemy("Kamien","1500",mag.getIloscKamieni(),R.drawable.kamien,"Magiczny Kamień który umożliwa ulepszanie wyposażenia");
    public static Itemy kamienPewny = new Itemy("Diament","2300",mag.getIloscKamieniPewnych(),R.drawable.magicznykamien,"Antyczny kamień który umożliwia ulepszenie wyposażenia");
    public static Itemy antycznyFragment = new Itemy("Monument","1500",mag.getIloscMonumentow(),R.drawable.artefakt,"Artefakt umożliwiający uzyskać najlepsza zbroję");
    public static Itemy klucz = new Itemy("Klucz","1500",mag.getIloscKluczy(),R.drawable.key,"Klucz pozwalający wejśc do jamy Antharasa");
    public static Itemy zloto = new Itemy("Gold"," ",mag.getHajs(),R.drawable.redball," ");
    public static Itemy set = new Itemy("Set"," ",mag.getSett(),R.drawable.redball,"Zbroja pozwalająca Ci przetrwać na polu bitwy");
    public static Itemy bron = new Itemy("Wep"," ",mag.getSett(),R.drawable.redball,"Wyposażenie pozwalające Ci pokonywać potwory");
    public static Itemy kolczykLajamira = new Itemy("Kolczyk Lajamira"," ",mag.getKolczykiLajamira(),R.drawable.necklace,"Kolczyki Lajamira, dodają Twoim Umięjtnośćia o 200 mocy przy użyciu umięjtnośći oraz zwiększają Twoją szanse krytyczna ");
    public static Itemy pierscienVolda = new Itemy("Pierścień Volda"," ",mag.getPierscienVolda(),R.drawable.voldring,"Pierścień Volda, Vold Ofiaruję Ci Pierścień który powoduje że Twoje ciosy są precyzyjniesze a siła krytyczna zwiększa się o 200, oraz atak o 250");
    public static Itemy naszyjnikTorosa = new Itemy("Naszyjnik Torosa"," ",mag.getNaszyjnikTorosa(),R.drawable.voldearring,"Naszyjnik Torosa, który ofiaruje Ci za bycie honorowym walecznym przeciwnikiem. Dodaje Ci 300 Pancerza i 300 punktów Życia");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_menu);

        postac=(CardView)findViewById(R.id.postac);

        ekwipunek=(CardView)findViewById(R.id.ekwipunek);

        if(mag.getProfesja().equalsIgnoreCase("ogien"))
        {
            mag.skillDamage=780;
        }
        if(mag.getProfesja().equalsIgnoreCase("woda"))
        {
            mag.skillDamage=320;
        }
        if(mag.getProfesja().equalsIgnoreCase("brak"))
        {
            mag.skillDamage=50;
        }

        postac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagMenuActivity.this,MagNewPostacActivity.class);
                startActivity(intent);
            }
        });

        ekwipunek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagMenuActivity.this,MagKowal.class);
                startActivity(intent);
            }
        });

        sklep = (CardView) findViewById(R.id.karczma);
        sklep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagMenuActivity.this,MagKarczma.class);
                startActivity(intent);




            }
        });
        przygoda = (CardView) findViewById(R.id.przygoda);
        przygoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MagMenuActivity.this, MagMapaPotworowActivity.class);
                    startActivity(intent);
                    MagMenuActivity.this.finish();

            }
        });
        pvp = (CardView) findViewById(R.id.pvp);
        pvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mag.hpbohater<=0)
                {
                    Snackbar.make(v,"Najpierw się ulecz!",Snackbar.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(MagMenuActivity.this, MagPvpRanking.class);
                    startActivity(intent);
                    MagMenuActivity.this.finish();
                }
            }
        });

        miniGra = (CardView) findViewById(R.id.achievement);
        miniGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagMenuActivity.this,ArcherRanking.class);
                startActivity(intent);

            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt("storedInt", mag.hpbohater); // value to store
//        editor.commit();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt("storedInt", mag.hpbohater); // value to store
//        editor.commit();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        int storedPreference = preferences.getInt("storedInt", 0);
//
//        if(storedPreference!=mag.hpbohater)
//        {
//            Toast.makeText(getApplicationContext(),"Ograbiono Cię",Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//
//        }
//    }

}
