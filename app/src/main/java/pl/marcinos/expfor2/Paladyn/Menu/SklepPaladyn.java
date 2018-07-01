package pl.marcinos.expfor2.Paladyn.Menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;


import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladynhp;

public class SklepPaladyn extends AppCompatActivity {
    Button buttonBandaz;
    Button buttonUlepsz;
    Button buttonWymien;
    Button buttonEq;
    TextView textGold;
    TextView textLvl;
    Bohaterowie x;
    TextView textItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sklep_paladyn);
        buttonBandaz = (Button) findViewById(R.id.buttonBandaz);

        textGold = (TextView) findViewById(R.id.textGold);
        textItem = (TextView) findViewById(R.id.textItem);
        textGold.setText("Twoje złoto: " + paladyn.hajs);
        textItem.setText("Twoje itemy: " + paladyn.drop);
        buttonEq = (Button) findViewById(R.id.buttonEq);
        buttonBandaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sklep.kupZrodiwe(paladyn, paladynhp, v, textGold);

            }
        });
//        buttonUlepsz = (Button) findViewById(R.id.buttonUlepsz);
//
//        buttonUlepsz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Sklep.ulepsz(paladyn, paladynhp, v, textGold);
//            }
//        });
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
                if (paladyn.hajs >= 350) {
                    if (paladyn.lvl >= 5 && paladyn.sett == 1) {
                        Sklep.buyEqInt(paladyn, paladynhp, v, textGold,textGold);
                        Snackbar.make(v, "Kupiłeś Nowy ekwipunek", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                    } else if (paladyn.lvl >= 10 && paladyn.sett == 2) {
                        Sklep.buyEqInt(paladyn, paladynhp, v, textGold,textGold);
                        Snackbar.make(v, "Kupiłeś Nowy ekwipunek", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                    } else if (paladyn.sett == 3) {
                        Snackbar.make(v, "Osiągnałeś już najlepszy set", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();


                    } else if (paladyn.lvl < 5 && paladyn.sett == 1) {
                        Snackbar.make(v, "Potrzebujesz 5 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    } else if (paladyn.lvl < 10 && paladyn.sett == 2) {
                        Snackbar.make(v, "Potrzebujesz 10 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    }

                } else {
                    Snackbar.make(v, "Brakuje Ci złota", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                }


            }
        });
    }
}
