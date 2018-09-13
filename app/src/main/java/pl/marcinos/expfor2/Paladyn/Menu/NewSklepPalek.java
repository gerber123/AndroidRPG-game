package pl.marcinos.expfor2.Paladyn.Menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Paladyn;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladynhp;

public class NewSklepPalek extends AppCompatActivity {
    Button buttonBandaz;
    Button buttonUlepsz;
    Button buttonEq;
    Button buttonWymien;
    Button buttonSprzedajMonu;
    TextView textLvl;
    TextView textGold;
    TextView kosztEQ;
    TextView textItem;
    TextView textMonument;
    TextView textKlucz;
    ImageView zbroja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sklep_palek);
        textGold = (TextView) findViewById(R.id.textGoldd);
        textItem = (TextView) findViewById(R.id.textItemm);
        textGold.setText("Twoje złoto: " + paladyn.hajs);
        buttonSprzedajMonu = (Button) findViewById(R.id.buttonSprzedajMon);

        textItem.setText("Twoje itemy: " + paladyn.drop);
        buttonEq = (Button) findViewById(R.id.buttonEq);
        textLvl=(TextView)findViewById(R.id.LVL);
        kosztEQ=(TextView)findViewById(R.id.kosztEQ);


        textMonument=(TextView)findViewById(R.id.textMonument);
        textKlucz=(TextView)findViewById(R.id.textKlucz);

        textKlucz.setText("Klucz: " + paladyn.klucz);

        textMonument.setText("Twoje monumenty: " + paladyn.odlamek);

        zbroja= (ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuSklepPaladyn(paladyn,zbroja);



        buttonSprzedajMonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.sprzedajMonument(paladyn,v,textMonument,textGold);
            }
        });

        buttonBandaz=(Button)findViewById(R.id.buttonBandaz);
        Sklep.sprawdzenieEQWymag(paladyn,textLvl,kosztEQ);
        buttonBandaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kupZrodiwe(paladyn, paladynhp, v, textGold);

            }
        });

        buttonWymien = (Button) findViewById(R.id.buttonWymien);

        buttonWymien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kamien(paladyn, v, textItem);
            }
        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paladyn.hajs >= 500) {
                    if (paladyn.lvl >= 10 && paladyn.sett == 1) {
                        Sklep.buyEqInt(paladyn, paladynhp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

                    } else if (paladyn.lvl >= 20 && paladyn.sett == 2) {
                        Sklep.buyEqInt(paladyn, paladynhp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

                    } else if (paladyn.sett == 3&&paladyn.lvl>=30&&paladyn.getIloscMonumentow()>=1) {
                        Sklep.buyEqInt(paladyn, paladynhp, v, textGold,textMonument);
                        Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();



                    } else if (paladyn.lvl < 10 && paladyn.sett == 1) {
                        Snackbar.make(v, "Potrzebujesz 10 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    } else if (paladyn.lvl < 20 && paladyn.sett == 2) {
                        Snackbar.make(v, "Potrzebujesz 20 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    }

                } else {
                    Snackbar.make(v, "Nie spełniasz warunków do posiadania tego EQ", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                }
                Set.zmianaGrafikiSetuSklepPaladyn(paladyn,zbroja);
                Sklep.sprawdzenieEQWymag(paladyn,textLvl,kosztEQ);
            }
        });
    }
}
