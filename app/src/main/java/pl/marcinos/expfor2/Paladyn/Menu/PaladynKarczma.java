package pl.marcinos.expfor2.Paladyn.Menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Paladyn.Karczma.PaladynEq;
import pl.marcinos.expfor2.Paladyn.Karczma.PaladynHonor;
import pl.marcinos.expfor2.Paladyn.Karczma.PaladynSkills;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class PaladynKarczma extends AppCompatActivity {

    Button buttonShop;
    Button buttonProf;
    Button buttonEq;
    Button buttonHonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_karczma);

        buttonShop= (Button)findViewById(R.id.buttonShop);
        buttonEq= (Button)findViewById(R.id.buttonEq);
        buttonProf= (Button)findViewById(R.id.buttonProf);
        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaladynKarczma.this,NewSklepPalek.class);
                startActivity(intent);
            }
        });

        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paladyn.profesja.equalsIgnoreCase("berserker")||paladyn.profesja.equalsIgnoreCase("paladyn"))
                {
                    Intent intent = new Intent(PaladynKarczma.this, PaladynSkills.class);
                    startActivity(intent);
                }
                else {
                    wejscieNaLowy(paladyn);
                }
            }
        });
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(PaladynKarczma.this, PaladynEq.class);
                    startActivity(intent);


            }
        });
        buttonHonor= (Button)findViewById(R.id.buttonHonor);
        buttonHonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PaladynKarczma.this, PaladynHonor.class);
                startActivity(intent);


            }
        });
    }
    private void wejscieNaLowy(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynKarczma.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Łowca");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.paladyn_wejscie_biblioteka, null);


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
                if(paladyn.lvl>=10)
                {
                    if(paladyn.profesja.equalsIgnoreCase("brak")) {
                        Intent intent = new Intent(PaladynKarczma.this, PaladynSkills.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Intent intent = new Intent(PaladynKarczma.this, PaladynSkills.class);
                        startActivity(intent);
                    }


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Niemasz wystarczającego poziommu aby porozmawiać z Torosem",Toast.LENGTH_LONG).show();
                }
            }
        });


        alertDialog.show();


    }

}
