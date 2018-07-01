package pl.marcinos.expfor2.Paladyn.Menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import pl.marcinos.expfor2.Archer.Menu.ArcherMapaPotworowActivity;
import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Menu.ArcherPostacActivity;
import pl.marcinos.expfor2.Archer.Menu.ArcherRanking;
import pl.marcinos.expfor2.Archer.Menu.ArcherWyborPoziomuActivity;
import pl.marcinos.expfor2.Archer.Menu.MiniGraElf;
import pl.marcinos.expfor2.Archer.Menu.SklepArcher;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborJeden;
import pl.marcinos.expfor2.Bohaterowie.Mag;
import pl.marcinos.expfor2.Bohaterowie.Paladyn;
import pl.marcinos.expfor2.IntroActivity.WyborActivity;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Mag.Menu.MiniGraMag;
import pl.marcinos.expfor2.Metody.Dialog;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.SoundPlayer;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Paladyn.superWalka.Pvp.PaladynPvpRanking;
import pl.marcinos.expfor2.Paladyn.superWalka.WyborPrzeciwnika.WyborJedenActivity;
import pl.marcinos.expfor2.R;

import static android.support.v4.app.ActivityCompat.finishAffinity;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

public class PaladynMenuActivity extends AppCompatActivity {

    public static Paladyn paladyn = new Paladyn();
    public static Paladyn paladynhp = new Paladyn();


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

        sklep = (CardView) findViewById(R.id.sklep);
        sklep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(PaladynMenuActivity.this,NewSklepPalek.class);
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