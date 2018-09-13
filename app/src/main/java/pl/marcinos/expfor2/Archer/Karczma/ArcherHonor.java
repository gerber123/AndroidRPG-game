package pl.marcinos.expfor2.Archer.Karczma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;

public class ArcherHonor extends AppCompatActivity {
    Button buttonPierscienVolda;
    Button buttonNaszyjnikTorosa;
    Button buttonKolczykiLajamira;
    TextView textHonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_honor);
        Button buttonPierscienVolda = (Button)findViewById(R.id.buttonPierscienVolda);
        Button buttonNaszyjnikTorosa = (Button)findViewById(R.id.buttonNaszyjnikTorosa);
        Button buttonKolczykiLajamira = (Button)findViewById(R.id.buttonKolczykiLajamira);
        final TextView textHonor = (TextView)findViewById(R.id.textHonor);
        textHonor.setText("Twój Honor: "+archer.getPunktyHonoru());

        buttonPierscienVolda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.getPierscienVolda()>=1)
                {
                    Toast.makeText(getApplicationContext(),"Posiadasz ten przedmiot", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Sklep.WymienPierscien(archer,v,textHonor);
                }
            }
        });
        buttonNaszyjnikTorosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.getNaszyjnikTorosa()>=1)
                {
                    Toast.makeText(getApplicationContext(),"Posiadasz ten przedmiot", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Sklep.WymienNaszyjnik(archer,v,textHonor);
                }
            }
        });
        buttonKolczykiLajamira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.getKolczykiLajamira()>=1)
                {
                    Toast.makeText(getApplicationContext(),"Posiadasz ten przedmiot", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Sklep.WymienKolczyki(archer,v,textHonor);
                }
            }
        });
    }
}
