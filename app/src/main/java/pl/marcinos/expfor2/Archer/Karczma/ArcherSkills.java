package pl.marcinos.expfor2.Archer.Karczma;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;

public class ArcherSkills extends AppCompatActivity {


    ImageButton starterSkill;
    ImageButton BowSkill;
    ImageButton DaggerSkill;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_skills);


        starterSkill = (ImageButton)findViewById(R.id.starterSkill);
        BowSkill = (ImageButton)findViewById(R.id.PaladynSkill);
        DaggerSkill = (ImageButton)findViewById(R.id.berserkerSkill);

        starterSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
        if(archer.profesja.equalsIgnoreCase("dagger"))
        {
            DaggerSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
            BowSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        }
        if(archer.profesja.equalsIgnoreCase("bow"))
        {
            BowSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
            DaggerSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        }
        if(archer.profesja.equalsIgnoreCase(("brak")))
        {
            DaggerSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            BowSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            RozmowaVold(archer);

        }
        starterSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        BowSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        DaggerSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });



    }
    private void RozmowaVold(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Kosiarzem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.vold_talk, null);


        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Mistrz Łuku", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BowWave(archer);
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("Skryty Sztylet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DaggerWave(archer);
                dialog.dismiss();

            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                 ArcherSkills.this.finish();
            }
        });



        alertDialog.show();


    }

    private void BowWave(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.bow_wave, null);


        alertDialog.setView(wejscie);
        alertDialog.setCancelable(false);
        alertDialog.setNegativeButton("Obieram tę ścieżkę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                x.profesja="bow";
                x.atkbohater+=200;
                x.obrona+=100;
                x.atakcritical+=200;
                    BowSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
                    DaggerSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                ArcherWaveAccepted(archer);

            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                RozmowaVold(archer);
            }
        });


        alertDialog.show();


    }
    private void DaggerWave(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");
        alertDialog.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.dagger_wave, null);


        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Obieram tę ścieżkę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                x.profesja="dagger";
                x.atakcritical+=400;
                x.obrona+=150;
                DaggerSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
                BowSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                DaggerWaveAccepted(archer);
            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                RozmowaVold(archer);
            }
        });


        alertDialog.show();


    }
    private void DaggerWaveAccepted(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.vold_talk_accepted_wave, null);
        TextView g =(TextView)wejscie.findViewById(R.id.textInfo);
        TextView profesja =(TextView)wejscie.findViewById(R.id.textProsfesja);
        profesja.setText("Twoim Narzędziem do zabijania od tej chwili jest Sztylet, a każdy kto wypowie Twoje imię musi zginąć! Czas Start!");
        g.setText("Atuty Assasyna: \n Atak krytyczny wzrósł o 400, obrona o 150. Dodatkowo zyskałeś umiejętnósc która pozwala Ci wykonać Cichy cios w potylice, który omija pancerz przecwinika i zadaje maksymalne obrażenia krytyczne");
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


    } private void ArcherWaveAccepted(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.vold_talk_accepted_wave, null);
        TextView g =(TextView)wejscie.findViewById(R.id.textInfo);
        TextView profesja =(TextView)wejscie.findViewById(R.id.textProsfesja);
        profesja.setText("Twoim Narzędziem do zabijania od tej chwili jest Łuk, Twoje sokole oko musi wypatrzeć wszystkich wrogów!");
        g.setText("Atuty Łowcy: \n Atak podstawowy wzrósł o 250, Atak krytyczny wzrósł o 200, obrona o 100. Dodatkowo zyskałeś umiejętnósc która pozwala Ci wykonać elektryczny strzał który zadaje potworne obrażenia");

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
