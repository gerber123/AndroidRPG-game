package pl.marcinos.expfor2.Archer.Menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.marcinos.expfor2.Archer.Karczma.ArcherEq;
import pl.marcinos.expfor2.Archer.Karczma.ArcherHonor;
import pl.marcinos.expfor2.Archer.Karczma.ArcherSkills;
import pl.marcinos.expfor2.Archer.Karczma.SklepArcher;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;

public class ArcherKarczma extends AppCompatActivity {

    Button buttonShop;
    Button buttonProf;
    Button buttonEq;
    Button buttonHonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_karczma);

        buttonShop= (Button)findViewById(R.id.buttonShop);
        buttonEq= (Button)findViewById(R.id.buttonEq);
        buttonProf= (Button)findViewById(R.id.buttonProf);

        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherKarczma.this,SklepArcher.class);
                startActivity(intent);
            }
        });

        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(archer.profesja.equalsIgnoreCase("lowca")||archer.profesja.equalsIgnoreCase("dagger"))
                {
                    Intent intent = new Intent(ArcherKarczma.this, ArcherSkills.class);
                    startActivity(intent);
                }
                else {
                    wejscieNaLowy(archer);
                }
            }
        });
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ArcherKarczma.this, ArcherEq.class);
                    startActivity(intent);


            }
        });
        buttonHonor= (Button)findViewById(R.id.buttonHonor);
        buttonHonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ArcherKarczma.this, ArcherHonor.class);
                    startActivity(intent);


            }
        });
    }
    private void wejscieNaLowy(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherKarczma.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Łowca");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.archer_wejscie_biblioteka, null);


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
                if(archer.lvl>=10)
                {
                    if(archer.profesja.equalsIgnoreCase("brak")) {
                        Intent intent = new Intent(ArcherKarczma.this, ArcherSkills.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Intent intent = new Intent(ArcherKarczma.this, ArcherSkills.class);
                        startActivity(intent);
                    }


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Niemasz wystarczającego poziommu aby porozmawiać z Voldem",Toast.LENGTH_LONG).show();
                }
            }
        });


        alertDialog.show();


    }

}
