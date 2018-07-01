package pl.marcinos.expfor2.Archer.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWwyborTrzy;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborDwa;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborJeden;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Paladyn.Menu.WyborPoziomuActivity;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
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
import static pl.marcinos.expfor2.Potwory.Potwory.stroz;
import static pl.marcinos.expfor2.Potwory.Potwory.strozhp;
import static pl.marcinos.expfor2.Potwory.Potwory.szkielet;
import static pl.marcinos.expfor2.Potwory.Potwory.szkielethp;
import static pl.marcinos.expfor2.Potwory.Potwory.wilkor;
import static pl.marcinos.expfor2.Potwory.Potwory.wilkorhp;
import static pl.marcinos.expfor2.Potwory.Potwory.zombie;
import static pl.marcinos.expfor2.Potwory.Potwory.zombiehp;

public class ArcherWyborPoziomuActivity extends AppCompatActivity {
Button button1_5;
Button button5_10;
Button button10_15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_wybor_poziomu);
        button1_5= (Button)findViewById(R.id.button1_5);
        button5_10= (Button)findViewById(R.id.button5_10);
        button10_15= (Button)findViewById(R.id.button10_15);
        RegeneracjaPotworow.Regenereuj(guard,guardhp,hellgate,hellgatehp,kot,kothp,mnich,mnichhp,moskit,moskithp,orc,orchp,rycerz,rycerzhp,stroz,strozhp,szkielet,szkielethp,wilkor,wilkorhp,zombie,zombiehp);

        button5_10.setEnabled(false);
        button10_15.setEnabled(false);

        //button10_15.setEnabled(false);

        if(archer.lvl>=5)
        {
            button5_10.setEnabled(true);
        }        if(archer.lvl>=10)
        {
            button10_15.setEnabled(true);
        }

        button1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherWyborPoziomuActivity.this,ArcherWyborJeden.class);
                startActivity(intent);
                ArcherWyborPoziomuActivity.this.finish();
            }
        });

        button5_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherWyborPoziomuActivity.this,ArcherWyborDwa.class);
                startActivity(intent);
                ArcherWyborPoziomuActivity.this.finish();
            }
        });

         button10_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherWyborPoziomuActivity.this,ArcherWwyborTrzy.class);
                startActivity(intent);
                ArcherWyborPoziomuActivity.this.finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ArcherWyborPoziomuActivity.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherWyborPoziomuActivity.this.finish();
    }
}
