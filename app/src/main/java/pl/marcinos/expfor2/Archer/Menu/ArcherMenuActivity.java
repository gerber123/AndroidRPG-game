package pl.marcinos.expfor2.Archer.Menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherArcher;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPvpRanking;
import pl.marcinos.expfor2.Bohaterowie.Archer;

import pl.marcinos.expfor2.Bohaterowie.Mag;
import pl.marcinos.expfor2.IntroActivity.eeee;
import pl.marcinos.expfor2.Mag.Menu.MagMapaPotworowActivity;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Mag.Menu.MagNewPostacActivity;
import pl.marcinos.expfor2.Mag.Menu.MiniGraMag;
import pl.marcinos.expfor2.Mag.Menu.NewSklepMag;
import pl.marcinos.expfor2.Metody.Dialog;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.SoundPlayer;
import pl.marcinos.expfor2.Metody.onDestroyOffline;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Paladyn.Menu.SklepPaladyn;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

public class ArcherMenuActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image5;


    CardView postac;
    CardView ekwipunek;
    CardView sklep;
    CardView przygoda;
    CardView miniGra;
    CardView pvp;
    FirebaseDatabase database;
    DatabaseReference users;

    public static Archer archer = new Archer();
    public static Archer archerhp = new Archer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_menu);

        postac = (CardView) findViewById(R.id.postac);

//        database = FirebaseDatabase.getInstance();
//        users = database.getReference("Users");
//        users.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot)
//            {
//                User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);
//
//                login.setHpbohater(archer.hpbohater);
//                login.setAtkbohater(archer.atkbohater);
//                login.setAtakcritical(archer.atakcritical);
//                login.setDrop(archer.drop);
//                login.setPoziomUlepszenia(archer.poziomUlepszenia);
//                login.setExp(archer.exp);
//                login.setObrona(archer.obrona);
//                login.setLvl(archer.lvl);
//                login.setHajs(archer.hajs);
//                login.setOdlegloscKrytyczna(archer.odlegloscKrytyczna);
//                login.setSett(archer.sett);
//                login.setPunktyHonoru(archer.punktyHonoru);
//                login.setPoziomUlepszeniaZbroji(archer.poziomUlepszeniaZbroji);
////
////
//                login.setSet(archer.set);
////
//
//                login.setStaty(archer.staty);
//                login.setStatyatk(archer.statyatk);
//                login.setStatyhp(archer.statyhp);
//                login.setStatyCrit(archer.statyCrit);
//                login.setMaxhp(archerhp.hpbohater);
//                login.setMaxexp(archerhp.exp);
//
//
//
//                users.child(user123.getUserName()).setValue(login);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        postac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherMenuActivity.this, ArcherPostacActivity.class);
                startActivity(intent);
            }
        });

        ekwipunek = (CardView) findViewById(R.id.ekwipunek);
        ekwipunek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherMenuActivity.this, ArcherKowal.class);
                startActivity(intent);

            }
        });

        sklep = (CardView) findViewById(R.id.sklep);
        sklep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ArcherMenuActivity.this, SklepArcher.class);
                    startActivity(intent);



            }
        });
        przygoda = (CardView) findViewById(R.id.przygoda);
        przygoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ArcherMenuActivity.this, ArcherMapaPotworowActivity.class);
                    startActivity(intent);
                    ArcherMenuActivity.this.finish();

            }
        });
        pvp = (CardView) findViewById(R.id.pvp);
        pvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (archer.hpbohater <= 0) {
                    Snackbar.make(v, "Najpierw się ulecz!", Snackbar.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(ArcherMenuActivity.this, ArcherPvpRanking.class);
                    startActivity(intent);
                    ArcherMenuActivity.this.finish();
                }
//                Toast.makeText(getApplicationContext(),"PVP będzie dostępne wkrótce", Toast.LENGTH_LONG).show();

            }
        });

        miniGra = (CardView) findViewById(R.id.achievement);
        miniGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherMenuActivity.this, ArcherRanking.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed()
    {
        View v = this.findViewById(android.R.id.content).getRootView();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Exit ");
        alertDialogBuilder.setMessage("Czy Chcesz wyjść z gry? ");
        alertDialogBuilder.setIcon(R.drawable.sad);
        alertDialogBuilder.setPositiveButton(("Tak"),
                new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog,
                                        int id) {
//                        onDestroyOffline.onDestroyVoid(database,users);
//                        CountDownTimer t=    new CountDownTimer(3000, 100) {
//
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//
//
//
//                            }
//
//                            @Override
//                            public void onFinish()
//                            {
//                                System.exit(0);
//                                dialog.cancel();
//
//                            }
//                        }.start();
                        System.exit(0);
                                dialog.cancel();

                    }
                });
        alertDialogBuilder.setNegativeButton(("Nie"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }
}
