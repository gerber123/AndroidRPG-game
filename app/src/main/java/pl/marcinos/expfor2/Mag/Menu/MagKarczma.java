package pl.marcinos.expfor2.Mag.Menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Mag.Karczma.MagEq;
import pl.marcinos.expfor2.Mag.Karczma.MagHonor;
import pl.marcinos.expfor2.Mag.Karczma.MagSkills;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;

public class MagKarczma extends AppCompatActivity {

    Button buttonShop;
    Button buttonProf;
    Button buttonHonor;
    Button buttonEq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_karczma);

        buttonShop= (Button)findViewById(R.id.buttonShop);
        buttonEq= (Button)findViewById(R.id.buttonEq);
        buttonProf= (Button)findViewById(R.id.buttonProf);
        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagKarczma.this,NewSklepMag.class);
                startActivity(intent);
            }
        });

        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mag.profesja.equalsIgnoreCase("woda")||mag.profesja.equalsIgnoreCase("ogien"))
                {
                    Intent intent = new Intent(MagKarczma.this, MagSkills.class);
                    startActivity(intent);
                }
                else {
                    wejscieDoBiblioteki(mag);
                }
            }
        });
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MagKarczma.this, MagEq.class);
                    startActivity(intent);


            }
        });
        buttonHonor= (Button)findViewById(R.id.buttonHonor);
        buttonHonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MagKarczma.this, MagHonor.class);
                startActivity(intent);


            }
        });
    }
    private void wejscieDoBiblioteki(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagKarczma.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.mag_wejscie_biblioteka, null);


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
                if(mag.lvl>=10)
                {
                    if(mag.profesja.equalsIgnoreCase("brak")) {
                        Intent intent = new Intent(MagKarczma.this, MagSkills.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Intent intent = new Intent(MagKarczma.this, MagSkills.class);
                        startActivity(intent);
                    }


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Niemasz wystarczającego poziommu aby porozmawiać z Czarodziejem",Toast.LENGTH_LONG).show();
                }
            }
        });


        alertDialog.show();


    }

}
