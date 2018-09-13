package pl.marcinos.expfor2.Mag.Menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;


public class SklepMag extends AppCompatActivity {
    Button buttonBandaz;
    Button buttonUlepsz;
    Button buttonEq;
    Button buttonWymien;
    TextView textGold;
    TextView textItem;
    TextView textMonument;
    TextView textKlucz;
    TextView textLvl;
    Bohaterowie x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sklep_mag);
        buttonBandaz = (Button) findViewById(R.id.buttonBandaz);
        textLvl=(TextView)findViewById(R.id.LVL);
        textMonument=(TextView)findViewById(R.id.textMonument);
        textKlucz=(TextView)findViewById(R.id.textKlucz);

        textGold = (TextView) findViewById(R.id.textGold);
        textItem = (TextView) findViewById(R.id.textItem);
        textMonument.setText("Monument: "+mag.getIloscMonumentow());
        textMonument.setText("Klucze: "+mag.getIloscKluczy());
        textGold.setText("Twoje złoto: " + mag.hajs);
        textItem.setText("Ilość posiadanych kamieni: "+mag.iloscKamieni+", diamentów: "+mag.iloscKamieniPewnych);

        buttonEq = (Button) findViewById(R.id.buttonEq);
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

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mag.hajs >= 350) {
                    if (mag.lvl >= 5 && mag.sett == 1) {
                        Sklep.buyEqInt(mag, maghp, v, textGold,textGold);
                        Intent intent = new Intent(getApplicationContext(), MagMenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else if (mag.lvl >= 10 && mag.sett == 2) {
                        Sklep.buyEqInt(mag, maghp, v, textGold,textGold);
                        Intent intent = new Intent(getApplicationContext(), MagMenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else if (mag.sett == 3) {
                        Snackbar.make(v, "Osiągnałeś już najlepszy set", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                        ;

                    } else if (mag.lvl < 5 && mag.sett == 1) {
                        Snackbar.make(v, "Potrzebujesz 5 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    } else if (mag.lvl < 10 && mag.sett == 2) {
                        Snackbar.make(v, "Potrzebujesz 10 lvl", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
                    }

                } else {
                    Snackbar.make(v, "Brakuje Ci złota", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

                }


            }
        });
    }
}
