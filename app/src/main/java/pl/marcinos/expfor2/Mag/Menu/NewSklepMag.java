package pl.marcinos.expfor2.Mag.Menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;

public class NewSklepMag extends AppCompatActivity {
    Button buttonBandaz;
    Button buttonUlepsz;
    Button buttonEq;
    Button buttonWymien;
    Button buttonSprzedajMonu;
    TextView textGold;
    TextView textLvl;
    TextView textItem;
    TextView kosztEQ;
    TextView textMonument;
    TextView textKlucz;
    ImageView zbroja;



//    Bohaterowie x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sklep_mag);
        textGold = (TextView) findViewById(R.id.textGoldd);
        textItem = (TextView) findViewById(R.id.textItemm);
        textLvl=(TextView)findViewById(R.id.LVL);
        kosztEQ=(TextView)findViewById(R.id.kosztEQ);

        buttonSprzedajMonu = (Button) findViewById(R.id.buttonSprzedajMon);

        textMonument=(TextView)findViewById(R.id.textMonument);
        textKlucz=(TextView)findViewById(R.id.textKlucz);

        textKlucz.setText("Klucz: " + mag.klucz);

        textMonument.setText("Twoje monumenty: " + mag.odlamek);


        textGold.setText("Twoje złoto: " + mag.hajs);
        textItem.setText("Twoje itemy: " + mag.drop);
        buttonEq = (Button) findViewById(R.id.buttonEq);
        buttonBandaz=(Button)findViewById(R.id.buttonBandaz);


        zbroja= (ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuSklepWizard(mag,zbroja);

        buttonSprzedajMonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.sprzedajMonument(mag,v,textMonument,textGold);
            }
        });

        buttonBandaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kupZrodiwe(mag, maghp, v, textGold);

            }
        });
//        buttonUlepsz = (Button) findViewById(R.id.buttonUlepsz);
//
//        buttonUlepsz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Sklep.ulepsz(mag, maghp, v, textGold);
//            }
//        });
        buttonWymien = (Button) findViewById(R.id.buttonWymien);

        buttonWymien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kamien(mag, v, textItem);
            }
        });
        Sklep.sprawdzenieEQWymag(mag,textLvl,kosztEQ);
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mag.hajs >= 350) {
                    if (mag.lvl >= 10 && mag.sett == 1) {
                        Sklep.buyEqInt(mag, maghp, v, textGold,textMonument);
                        Snackbar.make(v, "Kupiłeś Nowy ekwipunek", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                    } else if (mag.lvl >= 20 && mag.sett == 2) {
                        Sklep.buyEqInt(mag, maghp, v, textGold,textMonument);
                        Snackbar.make(v, "Kupiłeś Nowy ekwipunek", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                    } else if (mag.sett == 3&&mag.lvl>=30&&mag.odlamek.equalsIgnoreCase("Antyczny fragment")) {
                        Sklep.buyEqInt(mag, maghp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();



                    } else if (mag.lvl < 10 && mag.sett == 1) {
                        Snackbar.make(v, "Potrzebujesz 10 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    } else if (mag.lvl < 20 && mag.sett == 2) {
                        Snackbar.make(v, "Potrzebujesz 20 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    }

                } else {
                    Snackbar.make(v, "Nie spełniasz warunków do posiadania tego EQ", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                }
                Set.zmianaGrafikiSetuSklepWizard(mag,zbroja);
                Sklep.sprawdzenieEQWymag(mag,textLvl,kosztEQ);
            }
        });
    }
}