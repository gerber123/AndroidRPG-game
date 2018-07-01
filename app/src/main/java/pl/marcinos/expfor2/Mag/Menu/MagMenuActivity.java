package pl.marcinos.expfor2.Mag.Menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Menu.ArcherRanking;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPvpRanking;
import pl.marcinos.expfor2.Bohaterowie.Mag;

import pl.marcinos.expfor2.Mag.Walka.Walka.Pvp.MagPvpRanking;
import pl.marcinos.expfor2.Metody.Dialog;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynKowal;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;


public class MagMenuActivity extends AppCompatActivity {



    public static Mag mag = new Mag();
    public static Mag maghp = new Mag();
    CardView postac;
    CardView ekwipunek;
    CardView sklep;
    CardView przygoda;
    CardView miniGra;
    CardView pvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_menu);

        postac=(CardView)findViewById(R.id.postac);

        ekwipunek=(CardView)findViewById(R.id.ekwipunek);
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

        sklep = (CardView) findViewById(R.id.sklep);
        sklep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MagMenuActivity.this,NewSklepMag.class);
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
