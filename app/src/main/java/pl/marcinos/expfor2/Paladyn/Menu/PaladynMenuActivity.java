package pl.marcinos.expfor2.Paladyn.Menu;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.marcinos.expfor2.Archer.Menu.ArcherRanking;
import pl.marcinos.expfor2.Bohaterowie.Itemy;
import pl.marcinos.expfor2.Bohaterowie.Paladyn;
import pl.marcinos.expfor2.Paladyn.superWalka.Pvp.PaladynPvpRanking;
import pl.marcinos.expfor2.R;

public class PaladynMenuActivity extends AppCompatActivity {

    public static Paladyn paladyn = new Paladyn();
    public static Paladyn paladynhp = new Paladyn();
    public static Itemy kamien = new Itemy("Kamien","1500",paladyn.getIloscKamieni(),R.drawable.kamien,"Magiczny Kamień który umożliwa ulepszanie wyposażenia");
    public static Itemy kamienPewny = new Itemy("Diament","2300",paladyn.getIloscKamieniPewnych(),R.drawable.magicznykamien,"Antyczny kamień który umożliwia ulepszenie wyposażenia");
    public static Itemy antycznyFragment = new Itemy("Monument","1500",paladyn.getIloscMonumentow(),R.drawable.artefakt,"Artefakt umożliwiający uzyskać najlepsza zbroję");
    public static Itemy klucz = new Itemy("Klucz","1500",paladyn.getIloscKluczy(),R.drawable.key,"Klucz pozwalający wejśc do jamy Antharasa");
    public static Itemy zloto = new Itemy("Gold"," ",paladyn.getHajs(),R.drawable.redball," ");
    public static Itemy set = new Itemy("Set"," ",paladyn.getSett(),R.drawable.redball,"Zbroja pozwalająca Ci przetrwać na polu bitwy");
    public static Itemy bron = new Itemy("Wep"," ",paladyn.getSett(),R.drawable.redball,"Wyposażenie pozwalające Ci pokonywać potwory");
    public static Itemy kolczykLajamira = new Itemy("Kolczyk Lajamira"," ",paladyn.getKolczykiLajamira(),R.drawable.necklace,"Kolczyki Lajamira, dodają Twoim Umięjtnośćia o 200 mocy przy użyciu umięjtnośći oraz zwiększają Twoją szanse krytyczna ");
    public static Itemy pierscienVolda = new Itemy("Pierścień Volda"," ",paladyn.getPierscienVolda(),R.drawable.voldring,"Pierścień Volda, Vold Ofiaruję Ci Pierścień który powoduje że Twoje ciosy są precyzyjniesze a siła krytyczna zwiększa się o 200, oraz atak o 250");
    public static Itemy naszyjnikTorosa = new Itemy("Naszyjnik Torosa"," ",paladyn.getNaszyjnikTorosa(),R.drawable.voldearring,"Naszyjnik Torosa, który ofiaruje Ci za bycie honorowym walecznym przeciwnikiem. Dodaje Ci 300 Pancerza i 300 punktów Życia");


    FirebaseDatabase database;
    DatabaseReference users;

    CardView postac;
    CardView ekwipunek;
    CardView sklep;
    CardView przygoda;
    CardView miniGra;
    CardView pvp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_menu);

        postac=(CardView)findViewById(R.id.postac);

        if(paladyn.getProfesja().equalsIgnoreCase("berserker"))
        {
            paladyn.skillDamage=650;
        }
        if(paladyn.getProfesja().equalsIgnoreCase("paladyn"))
        {
            paladyn.skillDamage=350;
        }
        if(paladyn.getProfesja().equalsIgnoreCase("brak"))
        {
            paladyn.skillDamage=50;
        }
        postac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaladynMenuActivity.this,PaladynPostacActivity.class);
                startActivity(intent);
            }
        });

        ekwipunek=(CardView)findViewById(R.id.ekwipunek);
        ekwipunek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaladynMenuActivity.this,PaladynKowal.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),"Ekwipunek będzie dostępne wkrótce", Toast.LENGTH_LONG).show();
            }
        });

        sklep = (CardView) findViewById(R.id.karczma);
        sklep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(PaladynMenuActivity.this,PaladynKarczma.class);
                    startActivity(intent);



            }
        });
        przygoda = (CardView) findViewById(R.id.przygoda);
        przygoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(PaladynMenuActivity.this, PaladynMapaPotworowActivity.class);
                    startActivity(intent);
                    PaladynMenuActivity.this.finish();

            }
        });
        pvp = (CardView) findViewById(R.id.pvp);
        pvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paladyn.hpbohater<=0)
                {
                    Snackbar.make(v,"Najpierw się ulecz!",Snackbar.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(PaladynMenuActivity.this, PaladynPvpRanking.class);
                    startActivity(intent);
                    PaladynMenuActivity.this.finish();
                }
            }
        });

        miniGra = (CardView) findViewById(R.id.achievement);
        miniGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaladynMenuActivity.this,ArcherRanking.class);
                startActivity(intent);

            }
        });
    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt("storedInt", paladyn.hpbohater); // value to store
//        editor.commit();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt("storedInt", paladyn.hpbohater); // value to store
//        editor.commit();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        int storedPreference = preferences.getInt("storedInt", 0);
//
//        if(storedPreference!=paladyn.hpbohater)
//        {
//            Toast.makeText(getApplicationContext(),"Ograbiono Cię",Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//
//        }
//    }
}