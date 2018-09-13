package pl.marcinos.expfor2.Paladyn.Menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Archer.Menu.ArcherMapaPotworowActivity;
import pl.marcinos.expfor2.Archer.Menu.MiniGraElf;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborCztery;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Mag.Menu.MagMapaPotworowActivity;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborDwa;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborJeden;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborTrzy;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Paladyn.superWalka.Questy.PaladynQuesty;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynBoss;
import pl.marcinos.expfor2.Paladyn.superWalka.WyborPrzeciwnika.PaladynWyborCzwarty;
import pl.marcinos.expfor2.Paladyn.superWalka.WyborPrzeciwnika.WyborDwaActivity;
import pl.marcinos.expfor2.Paladyn.superWalka.WyborPrzeciwnika.WyborJedenActivity;
import pl.marcinos.expfor2.Paladyn.superWalka.WyborPrzeciwnika.WyborTrzyActivity;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Questy.Questy;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
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

public class PaladynMapaPotworowActivity extends AppCompatActivity {
    ImageButton button1_5;
    ImageButton button5_10;
    ImageButton button10_15;
    ImageButton button25;
    ImageButton buttonboss;
    ImageButton buttonMiniGra;
    ImageButton buttonQuesty;
    TextView klucz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_mapa_potworow);
        button1_5= (ImageButton)findViewById(R.id.button1_55);
        button5_10= (ImageButton)findViewById(R.id.button5_100);
        button10_15= (ImageButton)findViewById(R.id.button10_155);
        buttonMiniGra= (ImageButton)findViewById(R.id.buttonMagicznKraina);
        button25= (ImageButton)findViewById(R.id.button25);
        buttonQuesty= (ImageButton)findViewById(R.id.buttonQuesty);

        RegeneracjaPotworow.Regenereuj(guard,guardhp,hellgate,hellgatehp,kot,kothp,mnich,mnichhp,moskit,moskithp,orc,orchp,rycerz,rycerzhp,stroz,strozhp,szkielet,szkielethp,wilkor,wilkorhp,zombie,zombiehp);

        RegeneracjaPotworow.RegenereujBossa(boss,bosshp);
        RegeneracjaPotworow.RegenereujBossa(fishman,fishmanhp);
        RegeneracjaPotworow.RegenereujBossa(soldier,soldierhp);
        RegeneracjaPotworow.RegenereujBossa(turtle,turtlehp);

        buttonboss= (ImageButton)findViewById(R.id.buttonboss);
        buttonboss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paladyn.hpbohater > 0) {

                    wejscieDoSmoka(paladyn);

                } else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz", Toast.LENGTH_SHORT).show();
                }

            }
        });







        buttonMiniGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PaladynMapaPotworowActivity.this,MiniGraPaladyn.class);
                startActivity(intent);
                PaladynMapaPotworowActivity.this.finish();
            }
        });

        buttonQuesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(PaladynMapaPotworowActivity.this, PaladynQuesty.class);
                    startActivity(intent);


            }
        });
        button1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(paladyn.hpbohater>0) {
                    Intent intent = new Intent(PaladynMapaPotworowActivity.this, WyborJedenActivity.class);
                    startActivity(intent);
                    PaladynMapaPotworowActivity.this.finish();
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
                if(paladyn.lvl<5)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(paladyn.lvl>=5&&paladyn.hpbohater>0){
                    Intent intent = new Intent(PaladynMapaPotworowActivity.this, WyborDwaActivity.class);
                    startActivity(intent);
                    PaladynMapaPotworowActivity.this.finish();
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
                if(paladyn.lvl<15)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(paladyn.lvl>=15&&paladyn.hpbohater>0){
                    Intent intent = new Intent(PaladynMapaPotworowActivity.this, WyborTrzyActivity.class);
                    startActivity(intent);
                    PaladynMapaPotworowActivity.this.finish();
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
                if(paladyn.lvl<25)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(paladyn.lvl>=25&&paladyn.hpbohater>0){
                    Intent intent = new Intent(PaladynMapaPotworowActivity.this, PaladynWyborCzwarty.class);
                    startActivity(intent);
                    PaladynMapaPotworowActivity.this.finish();
                }
                 else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(PaladynMapaPotworowActivity.this,PaladynMenuActivity.class);
        startActivity(intent);
        PaladynMapaPotworowActivity.this.finish();
    }


    private void wejscieDoSmoka(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynMapaPotworowActivity.this,R.style.CustomDialogg);



        alertDialog.setTitle("Jaskinia Zła");
        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.wejscie_smok, null);



        klucz=(TextView)wejscie.findViewById(R.id.klucz);
        klucz.setText("Klucz: "+x.getIloscKluczy());

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
                if(paladyn.getIloscKluczy()>=1&&paladyn.lvl>=30)
                {
                    Intent intent = new Intent(PaladynMapaPotworowActivity.this, PaladynBoss.class);
                    startActivity(intent);
                    PaladynMapaPotworowActivity.this.finish();
                    paladyn.iloscKluczy-=1;
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

