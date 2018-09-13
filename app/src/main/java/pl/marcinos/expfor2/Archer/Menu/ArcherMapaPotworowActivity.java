package pl.marcinos.expfor2.Archer.Menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Archer.Walka.Questy.ArcherQuesty;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherBoss;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWwyborTrzy;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborCztery;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborDwa;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborJeden;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMapaPotworowActivity;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynBoss;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Potwory.Potwory.boss;
import static pl.marcinos.expfor2.Potwory.Potwory.bosshp;
import static pl.marcinos.expfor2.Potwory.Potwory.fishman;
import static pl.marcinos.expfor2.Potwory.Potwory.fishmanhp;
import static pl.marcinos.expfor2.Potwory.Potwory.guard;
import static pl.marcinos.expfor2.Potwory.Potwory.guardhp;
import static pl.marcinos.expfor2.Potwory.Potwory.hellgate;
import static pl.marcinos.expfor2.Potwory.Potwory.hellgatehp;
import static pl.marcinos.expfor2.Potwory.Potwory.kot;
import static pl.marcinos.expfor2.Potwory.Potwory.kothp;
import static pl.marcinos.expfor2.Potwory.Potwory.mnich;
import static pl.marcinos.expfor2.Potwory.Potwory.mnichhp;
import static pl.marcinos.expfor2.Potwory.Potwory.moskit;
import static pl.marcinos.expfor2.Potwory.Potwory.moskithp;
import static pl.marcinos.expfor2.Potwory.Potwory.orc;
import static pl.marcinos.expfor2.Potwory.Potwory.orchp;
import static pl.marcinos.expfor2.Potwory.Potwory.rycerz;
import static pl.marcinos.expfor2.Potwory.Potwory.rycerzhp;
import static pl.marcinos.expfor2.Potwory.Potwory.soldier;
import static pl.marcinos.expfor2.Potwory.Potwory.soldierhp;
import static pl.marcinos.expfor2.Potwory.Potwory.stroz;
import static pl.marcinos.expfor2.Potwory.Potwory.strozhp;
import static pl.marcinos.expfor2.Potwory.Potwory.szkielet;
import static pl.marcinos.expfor2.Potwory.Potwory.szkielethp;
import static pl.marcinos.expfor2.Potwory.Potwory.turtle;
import static pl.marcinos.expfor2.Potwory.Potwory.turtlehp;
import static pl.marcinos.expfor2.Potwory.Potwory.wilkor;
import static pl.marcinos.expfor2.Potwory.Potwory.wilkorhp;
import static pl.marcinos.expfor2.Potwory.Potwory.zombie;
import static pl.marcinos.expfor2.Potwory.Potwory.zombiehp;

public class ArcherMapaPotworowActivity extends AppCompatActivity {
    ImageButton button1_5;
    ImageButton button5_10;
    ImageButton buttonboss;
    ImageButton button10_15;
    ImageButton button25;
    ImageButton buttonMiniGra;
    ImageButton buttonQuesty;
    TextView klucz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_mapa_potworow);
        button1_5= (ImageButton)findViewById(R.id.button1_55);
        button5_10= (ImageButton)findViewById(R.id.button5_100);
        button10_15= (ImageButton)findViewById(R.id.button10_155);
        button25= (ImageButton)findViewById(R.id.button25);
        buttonQuesty= (ImageButton)findViewById(R.id.buttonQuesty);
        buttonMiniGra= (ImageButton)findViewById(R.id.buttonMagicznKraina);
        RegeneracjaPotworow.Regenereuj(guard,guardhp,hellgate,hellgatehp,kot,kothp,mnich,mnichhp,moskit,moskithp,orc,orchp,rycerz,rycerzhp,stroz,strozhp,szkielet,szkielethp,wilkor,wilkorhp,zombie,zombiehp);
        RegeneracjaPotworow.RegenereujBossa(boss,bosshp);
        RegeneracjaPotworow.RegenereujBossa(fishman,fishmanhp);
        RegeneracjaPotworow.RegenereujBossa(soldier,soldierhp);
        RegeneracjaPotworow.RegenereujBossa(turtle,turtlehp);


        buttonboss= (ImageButton)findViewById(R.id.buttonboss);
        buttonboss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (archer.hpbohater > 0) {

                    wejscieDoSmoka(archer);

                } else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //button10_15.setEnabled(false);


        buttonQuesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, ArcherQuesty.class);
                    startActivity(intent);


            }
        });
        button1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.hpbohater>0) {
                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, ArcherWyborJeden.class);
                    startActivity(intent);
                    ArcherMapaPotworowActivity.this.finish();
                }
                   else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        button5_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.lvl<5)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }

                else if(archer.lvl>=5&&archer.hpbohater>0){
                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, ArcherWyborDwa.class);
                    startActivity(intent);
                    ArcherMapaPotworowActivity.this.finish();
                }
                   else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button10_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.lvl<15)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(archer.lvl>=15&&archer.hpbohater>0){
                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, ArcherWwyborTrzy.class);
                    startActivity(intent);
                    ArcherMapaPotworowActivity.this.finish();
                }
                   else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.lvl<25)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(archer.lvl>=25&&archer.hpbohater>0){
                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, ArcherWyborCztery.class);
                    startActivity(intent);
                    ArcherMapaPotworowActivity.this.finish();
                }
                   else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonMiniGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, MiniGraElf.class);
                    startActivity(intent);
                    ArcherMapaPotworowActivity.this.finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ArcherMapaPotworowActivity.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherMapaPotworowActivity.this.finish();
    }


    private void wejscieDoSmoka(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherMapaPotworowActivity.this,R.style.CustomDialogg);



        alertDialog.setTitle("Jaskinia Zła");
//        alertDialog.setMessage("oooo");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.wejscie_smok, null);



        klucz=(TextView)wejscie.findViewById(R.id.klucz);
        klucz.setText("Klucz: "+x.iloscKluczy);

        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("Wejdź", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(archer.iloscKluczy>=1)
                {
                    Intent intent = new Intent(ArcherMapaPotworowActivity.this, ArcherBoss.class);
                    startActivity(intent);
                    ArcherMapaPotworowActivity.this.finish();
                    archer.iloscKluczy-=1;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Niemasz klucza lub LVL",Toast.LENGTH_LONG).show();
                }
            }
        });


        alertDialog.show();


    }
}



