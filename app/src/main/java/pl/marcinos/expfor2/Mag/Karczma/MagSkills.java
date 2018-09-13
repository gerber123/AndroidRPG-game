package pl.marcinos.expfor2.Mag.Karczma;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;

public class MagSkills extends AppCompatActivity {


    ImageButton starterSkill;
    ImageButton waterSkill;
    ImageButton fireSkill;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_skills);


        starterSkill = (ImageButton)findViewById(R.id.starterSkill);
        waterSkill = (ImageButton)findViewById(R.id.PaladynSkill);
        fireSkill = (ImageButton)findViewById(R.id.berserkerSkill);

        starterSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
        if(mag.profesja.equalsIgnoreCase("ogien"))
        {
            fireSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
            waterSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        }
        if(mag.profesja.equalsIgnoreCase("woda"))
        {
            waterSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
            fireSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        }
        if(mag.profesja.equalsIgnoreCase(("brak")))
        {
            fireSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            waterSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            RozmowaBiblioteki(mag);

        }
        starterSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        waterSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        fireSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });



    }
    private void RozmowaBiblioteki(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.lajamir_talk, null);


        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Ogień", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FireWave(mag);
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("Woda", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                WaterWave(mag);
                dialog.dismiss();

            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                 MagSkills.this.finish();
            }
        });



        alertDialog.show();


    }

    private void WaterWave(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.water_wave, null);


        alertDialog.setView(wejscie);
        alertDialog.setCancelable(false);
        alertDialog.setNegativeButton("Obieram tę ścieżkę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                x.profesja="woda";
                x.hpbohater+=200;
                x.atkbohater+=150;
              x.obrona+=200;
                    waterSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
                    fireSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                WaterWaveAccepted(mag);
            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                RozmowaBiblioteki(mag);
            }
        });


        alertDialog.show();


    }
    private void FireWave(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");
        alertDialog.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.fire_wave, null);


        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Obieram tę ścieżkę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                x.profesja="ogien";
                x.obrona+=100;
                x.atakcritical+=150;
                x.atkbohater+=400;
                fireSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
                waterSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                FireWaveAccepted(mag);
            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                RozmowaBiblioteki(mag);
            }
        });


        alertDialog.show();


    }
    private void WaterWaveAccepted(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.lajamir_talk_wave_accepted, null);
        TextView g =(TextView)wejscie.findViewById(R.id.textInfo);
        TextView profesja =(TextView)wejscie.findViewById(R.id.textProsfesja);
        profesja.setText("Od tej chwili jesteś magiem Wody, niech Posejdon będzie z Tobą");
        g.setText("Atuty Władcy Wody: \n Atak wzrósł o 150, obrona o 200 Oraz Twoje życie o 200. Dodatkowo zyskałeś umiejętnósc pozwalającą zadającą obrażenia i leczącą Cię");
        alertDialog.setView(wejscie);
        alertDialog.setCancelable(false);
        alertDialog.setNegativeButton("Zaczynajmy !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                x.profesja="berserker";
//                x.atkbohater+=350;
//                x.obrona+=200;
//                x.atakcritical+=100;
//                BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
//                PaladynSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));


            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                RozmowaToros(paladyn);
            }
        });


        alertDialog.show();


    } private void FireWaveAccepted(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.lajamir_talk_wave_accepted, null);
        TextView g =(TextView)wejscie.findViewById(R.id.textInfo);
        TextView profesja =(TextView)wejscie.findViewById(R.id.textProsfesja);
        profesja.setText("Od tej chwili jesteś magiem Ognia, Niech Płoną ! ");
        g.setText("Atuty Władcy Ognia: \n Atak wzrósł o 400, obrona o 1000 Oraz siła ciosu krytycznego o 150. Dodatkowo zyskałeś umiejętnósc pozwalającą zadającą okrutne obrażenia i podpalającą wroga");
        alertDialog.setView(wejscie);
        alertDialog.setCancelable(false);
        alertDialog.setNegativeButton("Zaczynajmy !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                x.profesja="berserker";
//                x.atkbohater+=350;
//                x.obrona+=200;
//                x.atakcritical+=100;
//                BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
//                PaladynSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));


            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                RozmowaToros(paladyn);
            }
        });


        alertDialog.show();


    }
}
