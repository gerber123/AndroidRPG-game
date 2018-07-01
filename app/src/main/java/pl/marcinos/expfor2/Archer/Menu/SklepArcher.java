package pl.marcinos.expfor2.Archer.Menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Bohaterowie.Archer;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Metody.Dialog;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;

public class SklepArcher extends AppCompatActivity {
    Button buttonBandaz;
    Button buttonUlepsz;
    Button buttonEq;
    Button buttonWymien;
    Button buttonSprzedajMonu;
    TextView textLvl;
    TextView textGold;
    TextView textMonument;
    TextView textKlucz;
    TextView kosztEQ;
    ImageView zbroja;
    TextView textItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sklep_archer);
        textGold = (TextView) findViewById(R.id.textGoldd);
        textItem = (TextView) findViewById(R.id.textItemm);
        buttonWymien = (Button) findViewById(R.id.buttonWymien);
        buttonEq = (Button) findViewById(R.id.buttonEq);
        buttonSprzedajMonu = (Button) findViewById(R.id.buttonSprzedajMon);
        textLvl=(TextView)findViewById(R.id.LVL);
        kosztEQ=(TextView)findViewById(R.id.kosztEQ);

        textMonument=(TextView)findViewById(R.id.textMonument);
        textKlucz=(TextView)findViewById(R.id.textKlucz);

        textKlucz.setText("Klucz: " + archer.klucz);

        textMonument.setText("Twoje monumenty: " + archer.odlamek);

        textGold.setText("Twoje złoto: " + archer.hajs);

        textItem.setText("Twoje itemy: " + archer.drop);

        zbroja= (ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuSklepArcher(archer,zbroja);

        buttonSprzedajMonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.sprzedajMonument(archer,v,textMonument,textGold);
            }
        });
        buttonBandaz=(Button)findViewById(R.id.buttonBandaz);
        buttonBandaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kupZrodiwe(archer, archerhp, v, textGold);

            }
        });



        buttonWymien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kamien(archer, v, textItem);
            }
        });

        Sklep.sprawdzenieEQWymag(archer,textLvl,kosztEQ);
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (archer.hajs >= 500) {
                    if (archer.lvl >= 10 && archer.sett == 1) {
                        Sklep.buyEqInt(archer, archerhp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

                    } else if (archer.lvl >= 20 && archer.sett == 2) {
                        Sklep.buyEqInt(archer, archerhp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

                    } else if (archer.sett == 3&&archer.lvl>=30&&archer.odlamek.equalsIgnoreCase("Antyczny fragment")) {
                        Sklep.buyEqInt(archer, archerhp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();


                    } else if (archer.lvl < 10 && archer.sett == 1) {
                        Snackbar.make(v, "Potrzebujesz 10 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    } else if (archer.lvl < 20 && archer.sett == 2) {
                        Snackbar.make(v, "Potrzebujesz 20 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    }
                    else if(archer.lvl>=30&&archer.sett==3&&archer.odlamek.equalsIgnoreCase("brak"))
                    {
                        Snackbar.make(v, "Nie spełniasz warunków do posiadania tego EQ", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
//                        Toast.makeText(getApplicationContext(),"chuj",Toast.LENGTH_LONG).show();
                    }

                } else
                    {
                    Snackbar.make(v, "Nie spełniasz warunków do posiadania tego EQ", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                }
                Set.zmianaGrafikiSetuSklepArcher(archer,zbroja);
                Sklep.sprawdzenieEQWymag(archer,textLvl,kosztEQ);
            }
        });
    }
}