package pl.marcinos.expfor2.Mag.Menu;

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

import pl.marcinos.expfor2.Archer.Menu.ArcherMapaPotworowActivity;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherBoss;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborCztery;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Mag.Walka.Walka.Questy.MagQuesty;
import pl.marcinos.expfor2.Mag.Walka.Walka.Walka.MagBoss;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborCzwarty;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborDwa;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborJeden;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborTrzy;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMapaPotworowActivity;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynBoss;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
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

public class MagMapaPotworowActivity extends AppCompatActivity {
    ImageButton button1_5;
    ImageButton button5_10;
    ImageButton button10_15;
    ImageButton button25;
    ImageButton buttonMiniGra;
    ImageButton buttonboss;
    ImageButton buttonQuesty;
    TextView klucz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_mapa_potworow);
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
                if (mag.hpbohater > 0) {

                    wejscieDoSmoka(mag);

                } else
                {
                    Toast.makeText(getApplicationContext(),"Najpierw się ulecz", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonQuesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(MagMapaPotworowActivity.this, MagQuesty.class);
                    startActivity(intent);


            }
        });
        button1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mag.hpbohater<=0)
                {
                    Snackbar.make(v,"Najpierw się ulecz!",Snackbar.LENGTH_LONG).show();
                }
                else  {
                    Intent intent = new Intent(MagMapaPotworowActivity.this, MagWyborJeden.class);
                    startActivity(intent);
                    MagMapaPotworowActivity.this.finish();
                }

            }
        });
        buttonMiniGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagMapaPotworowActivity.this,MiniGraMag.class);
                startActivity(intent);
                MagMapaPotworowActivity.this.finish();
            }
        });

        button5_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mag.lvl<5)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(mag.hpbohater>0&&mag.lvl>=5)
                {
                    Intent intent = new Intent(MagMapaPotworowActivity.this,MagWyborDwa.class);
                    startActivity(intent);
                    MagMapaPotworowActivity.this.finish();
                }

                else {
                    Snackbar.make(v,"Najpierw się ulecz!",Snackbar.LENGTH_LONG).show();
                }

            }
        });
        button10_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mag.lvl<15)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(mag.hpbohater>0&&mag.lvl>=15){
                    Intent intent = new Intent(MagMapaPotworowActivity.this, MagWyborTrzy.class);
                    startActivity(intent);
                    MagMapaPotworowActivity.this.finish();
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
                if(mag.lvl<25)
                {
                    Toast.makeText(getApplicationContext(),"Masz zbyt mały LVL podróżniku ", Toast.LENGTH_SHORT).show();
                }
                else if(mag.lvl>=25&&mag.hpbohater>0) {
                    Intent intent = new Intent(MagMapaPotworowActivity.this, MagWyborCzwarty.class);
                    startActivity(intent);
                    MagMapaPotworowActivity.this.finish();

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

        Intent intent = new Intent(MagMapaPotworowActivity.this,MagMenuActivity.class);
        startActivity(intent);
        MagMapaPotworowActivity.this.finish();
    }

    private void wejscieDoSmoka(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagMapaPotworowActivity.this,R.style.CustomDialogg);



        alertDialog.setTitle("Jaskinia Zła");
//        alertDialog.setMessage("oooo");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.wejscie_smok, null);



        klucz=(TextView)wejscie.findViewById(R.id.klucz);
        klucz.setText("Klucz: "+mag.iloscKluczy);

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
                if(mag.iloscKluczy>=1)
                {
                    Intent intent = new Intent(MagMapaPotworowActivity.this, MagBoss.class);
                    startActivity(intent);
                    MagMapaPotworowActivity.this.finish();
                    mag.iloscKluczy-=1;
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


