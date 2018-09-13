package pl.marcinos.expfor2.Archer.Menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPvpRanking;
import pl.marcinos.expfor2.Bohaterowie.Archer;

import pl.marcinos.expfor2.Bohaterowie.Itemy;
import pl.marcinos.expfor2.R;

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
    public static Itemy kamien = new Itemy("Kamien","1500",archer.getIloscKamieni(),R.drawable.kamien,"Magiczny Kamień który umożliwa ulepszanie wyposażenia");
    public static Itemy kamienPewny = new Itemy("Diament","2300",archer.getIloscKamieniPewnych(),R.drawable.magicznykamien,"Antyczny kamień który umożliwia ulepszenie wyposażenia");
    public static Itemy antycznyFragment = new Itemy("Monument","1500",archer.getIloscMonumentow(),R.drawable.artefakt,"Artefakt umożliwiający uzyskać najlepsza zbroję");
    public static Itemy klucz = new Itemy("Klucz","1500",archer.getIloscKluczy(),R.drawable.key,"Klucz pozwalający wejśc do jamy Antharasa");
    public static Itemy zloto = new Itemy("Gold"," ",archer.getHajs(),R.drawable.redball," ");
    public static Itemy set = new Itemy("Set"," ",archer.getSett(),R.drawable.redball,"Zbroja pozwalająca Ci przetrwać na polu bitwy");
    public static Itemy bron = new Itemy("Wep"," ",archer.getSett(),R.drawable.redball,"Wyposażenie pozwalające Ci pokonywać potwory");
    public static Itemy kolczykLajamira = new Itemy("Kolczyk Lajamira"," ",archer.getKolczykiLajamira(),R.drawable.necklace,"Kolczyki Lajamira, dodają Twoim Umięjtnośćia o 200 mocy przy użyciu umięjtnośći oraz zwiększają Twoją szanse krytyczna ");
    public static Itemy pierscienVolda = new Itemy("Pierścień Volda"," ",archer.getPierscienVolda(),R.drawable.voldring,"Pierścień Volda, Vold Ofiaruję Ci Pierścień który powoduje że Twoje ciosy są precyzyjniesze a siła krytyczna zwiększa się o 200, oraz atak o 250");
    public static Itemy naszyjnikTorosa = new Itemy("Naszyjnik Torosa"," ",archer.getNaszyjnikTorosa(),R.drawable.voldearring,"Naszyjnik Torosa, który ofiaruje Ci za bycie honorowym walecznym przeciwnikiem. Dodaje Ci 300 Pancerza i 300 punktów Życia");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_menu);

        postac = (CardView) findViewById(R.id.postac);

        if(archer.getProfesja().equalsIgnoreCase("bow"))
        {
            archer.skillDamage=780;
        }
        if(archer.getProfesja().equalsIgnoreCase("dagger"))
        {
            archer.skillDamage=480;
        }
        if(archer.getProfesja().equalsIgnoreCase("brak"))
        {
            archer.skillDamage=50;
        }
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

        sklep = (CardView) findViewById(R.id.karczma);
        sklep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ArcherMenuActivity.this, ArcherKarczma.class);
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
