package pl.marcinos.expfor2.Paladyn.Karczma;

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

import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class PaladynSkills extends AppCompatActivity {


    ImageButton starterSkill;
    ImageButton PaladynSkill;
    ImageButton BerserkerSkill;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_skills);


        starterSkill = (ImageButton)findViewById(R.id.starterSkill);
        PaladynSkill = (ImageButton)findViewById(R.id.PaladynSkill);
        BerserkerSkill = (ImageButton)findViewById(R.id.berserkerSkill);

        starterSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
        if(paladyn.profesja.equalsIgnoreCase("berserker"))
        {
            BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
            PaladynSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        }
        if(paladyn.profesja.equalsIgnoreCase("paladyn"))
        {
            PaladynSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
            BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        }
        if(paladyn.profesja.equalsIgnoreCase(("brak")))
        {
            BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            PaladynSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            RozmowaToros(paladyn);

        }
        starterSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        PaladynSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        BerserkerSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });



    }
    private void RozmowaToros(Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Przywitanie Torosa");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.toros_talk, null);


        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Władca Toporów", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BerserkerWave(paladyn);
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("Obrońca nieba", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PaladynWave(paladyn);
                dialog.dismiss();

            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                 PaladynSkills.this.finish();
            }
        });



        alertDialog.show();


    }

    private void BerserkerWave(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.berserker_wave, null);


        alertDialog.setView(wejscie);
        alertDialog.setCancelable(false);
        alertDialog.setNegativeButton("Obieram tę ścieżkę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                x.profesja="berserker";
                x.atkbohater+=350;
                x.obrona+=200;
                x.atakcritical+=100;
                    BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
                PaladynSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                BerserkerWaveAccepted(paladyn);

            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                RozmowaToros(paladyn);
            }
        });


        alertDialog.show();


    }
    private void BerserkerWaveAccepted(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.toros_talk_berserker_select, null);
        TextView g =(TextView)wejscie.findViewById(R.id.textInfo);
        TextView profesja =(TextView)wejscie.findViewById(R.id.textProsfesja);
        profesja.setText("Od tej chwili zostałeś młodym Berserkerem, idź siać mord i cierpienie wśród wszystkich przeciwników!");
        g.setText("Atuty Berserkera: \n Atak wzrósł o 350, obrona o 200 i siła ciosu krytycznego o 100. Dodatkowo zyskałeś umiejętnósc pozwalającą zwiększyć swój atak na 2 sekundy o 350 i zadającą obrażenia");
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
    private void PaladinWaveAccepted(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");

        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.toros_talk_berserker_select, null);
        TextView g =(TextView)wejscie.findViewById(R.id.textInfo);
        TextView profesja =(TextView)wejscie.findViewById(R.id.textProsfesja);
        profesja.setText("Od tej chwili zostałeś młodym Paladynem, będziesz musiał bronić wszystkich pokrzywdzonych swoim Twardym Napierśnikiem!");
        g.setText("Atuty Paladyna: \n Atak wzrósł o 150, obrona o 300 i siła ciosu krytycznego o 50. Dodatkowo zyskałeś umiejętnósc pozwalającą zwiększyć swoją obrone na 2 sekundy o 350 i leczącą Cię znacznie");
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
    private void PaladynWave(final Bohaterowie x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PaladynSkills.this,R.style.CustomDialogg);



        alertDialog.setTitle("Spotkanie z Mentorem");
        alertDialog.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View wejscie = inflater.inflate(R.layout.paladyn_wave, null);


        alertDialog.setView(wejscie);

        alertDialog.setNegativeButton("Obieram tę ścieżkę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                x.profesja="paladyn";
                x.atkbohater+=150;
                x.obrona+=300;
                x.atakcritical+=50;
                PaladynSkill.setBackgroundColor(getResources().getColor(R.color.light_overlay));
                BerserkerSkill.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                PaladinWaveAccepted(paladyn);
            }
        });
        alertDialog.setPositiveButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                RozmowaToros(paladyn);
            }
        });


        alertDialog.show();


    }
}
