package pl.marcinos.expfor2.Mag.Walka.Walka.Questy;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Archer.Walka.Questy.ArcherQuesty;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Mag.Menu.MagMapaPotworowActivity;
import pl.marcinos.expfor2.Mag.Walka.Walka.Walka.MagBoss;
import pl.marcinos.expfor2.Paladyn.superWalka.Questy.PaladynQuesty;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Questy.Questy;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Potwory.Potwory.kot;

public class MagQuesty extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textQuesta;
    TextView textTrescQuesta;
    TextView textNazwaQuesta;
    ImageView image;
    Button buttonZatrutaWyspa;
    Button buttonWzgorzaFaraona;
    Button buttonLodowiecGeista;
    Button buttonKatakumby;
    Button buttonKraniecSwiatow;
    TextView ZatrutaWyspaStan;
    TextView WzgorzaFaraonaStan;
    TextView LodowiecGeistaStan;
    TextView KatakumbyStan;
    TextView KraniecSwiatowStan;
    TextView klucz;



    public static Questy questFaraon = new Questy(1, "Zaginiony Kot"," ", 150, 100, R.drawable.kot, 6,mag);
    public static Questy questWyspa = new Questy(5, "Oblężenie Orców"," ", 450, 650, R.drawable.orc, 15,mag);
    public static Questy questKatakumby = new Questy(10, "Szczątki Gwardii"," ", 900, 450, R.drawable.guard, 12,mag);
    public static Questy questKraniec = new Questy(5, "Zaginiony Rybak"," ", 3100, 490, R.drawable.turtle, 10,mag);
    public static Questy questLodowiec = new Questy(5, "Szalony Nożownik"," ", 350, 250, R.drawable.kosiarz, 99,mag);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_questy);
        Questy.sprawdzQuesta(mag,questFaraon,questWyspa,questKatakumby,questKraniec,questLodowiec);
        String tekstFaraon = getString(R.string.Quest_wzgorza_Faraona);
        String tekstWyspa = getString(R.string.Quest_zatruta_wyspa);
        String tekstKatakumby = getString(R.string.Quest_katakumby);
        String tekstKraniec = getString(R.string.Quest_Kraniec_Światów);
        String tekstLodowiec = getString(R.string.Quest_Lodowiec_Geista);
        questFaraon.setTekstQuesta(tekstFaraon);
        questWyspa.setTekstQuesta(tekstWyspa);
        questKatakumby.setTekstQuesta(tekstKatakumby);
        questKraniec.setTekstQuesta(tekstKraniec);
        questLodowiec.setTekstQuesta(tekstLodowiec);
        ZatrutaWyspaStan=(TextView)findViewById(R.id.zatrutaWyspaStan);

        WzgorzaFaraonaStan=(TextView)findViewById(R.id.wzgorzaFaraonaStan);

        LodowiecGeistaStan=(TextView)findViewById(R.id.LodowiecGeistaStan);

        KatakumbyStan=(TextView)findViewById(R.id.KatakumbyStan);

        KraniecSwiatowStan=(TextView)findViewById(R.id.KraniecSwiatowStan);


        buttonWzgorzaFaraona = (Button) findViewById(R.id.buttonWzgorzaFaraona);

        buttonWzgorzaFaraona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showSignUpDialogggg(mag, kot,questFaraon,WzgorzaFaraonaStan);
                showSignUpDialog(mag, kot,questFaraon,WzgorzaFaraonaStan);

            }
        });


        buttonZatrutaWyspa = (Button) findViewById(R.id.buttonZatrutaWyspa);
        buttonZatrutaWyspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(mag, kot,questWyspa,ZatrutaWyspaStan);

            }
        });
        buttonLodowiecGeista = (Button) findViewById(R.id.buttonLodowiecGeista);
        buttonLodowiecGeista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(mag, kot,questLodowiec,KatakumbyStan);
            }
        });
        buttonKatakumby = (Button) findViewById(R.id.buttonKatakumby);
        buttonKatakumby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(mag, kot,questKatakumby,LodowiecGeistaStan);
            }
        });
        buttonKraniecSwiatow = (Button) findViewById(R.id.buttonKraniecSwiatow);
        buttonKraniecSwiatow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(mag, kot,questKraniec, KraniecSwiatowStan);
            }
        });
        Questy.stanQuesta(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);
        Questy.sprawdzMisje(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag);
    }


    private void showSignUpDialog(final Bohaterowie x, final Potwory y, final Questy quest, final TextView StanQuestaText) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagQuesty.this,R.style.AlertDialogTheme);



        alertDialog.setTitle(quest.getNazwaQuesta());
//        alertDialog.setMessage("oooo");

        LayoutInflater inflater = this.getLayoutInflater();
        final View pokazQuesta = inflater.inflate(R.layout.pokaz_quest, null);

        textNazwaQuesta = (TextView) pokazQuesta.findViewById(R.id.textImie);
        textTrescQuesta = (TextView) pokazQuesta.findViewById(R.id.textNazwisko);
        textQuesta=(TextView)pokazQuesta.findViewById(R.id.textOcena);


        image = (ImageView) pokazQuesta.findViewById(R.id.imageView3);
        image.setImageResource(quest.getImageResource());
        textNazwaQuesta.setText("Nagroda: "+quest.getNagroda()+"$, "+quest.getNagrodaExp()+" exp");
        textTrescQuesta.setText(quest.getTekstQuesta());
        textQuesta.setText("Ile już zabiłeś " + x.getIloscZabitychPotworów()+ " / " + quest.getIleZabic());
        alertDialog.setView(pokazQuesta);

        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        if (quest.stanQuesta == 0) {
            alertDialog.setPositiveButton("Zacznij Questa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                StanQuestaText.setText("Stan: Nie Wykonano");
                    if(mag.quest1==1||mag.quest2==1||mag.quest3==1||mag.quest4==1||mag.quest5==1)
                    {
                        Toast.makeText(getApplicationContext(),"Najpierw skończ jedno zadanie", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        quest.zaczetoMisje(x, y, StanQuestaText);
                        Questy.stanQuesta(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);
                        Questy.sprawdzMisje(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag);

                        Toast.makeText(getApplicationContext(), "Rozpocząłeś Zadanie", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if (quest.stanQuesta == 1) {
            alertDialog.setPositiveButton("Zakończ Questa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {



                    quest.wykonanoMisje(x, y,pokazQuesta, quest,StanQuestaText);
                    Questy.stanQuesta(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);
                    Questy.sprawdzMisje(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag);


                }
            });

        }
        else if(quest.stanQuesta==2)
        {
            Questy.stanQuesta(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);
            Questy.sprawdzMisje(buttonWzgorzaFaraona,buttonZatrutaWyspa,buttonKatakumby,buttonKraniecSwiatow,buttonLodowiecGeista,mag);

            textQuesta.setText("Ile już zabiłeś " + quest.getIleZabic()+ " / " + quest.getIleZabic());
            textQuesta.setTextColor(Color.GREEN);
        }

        AlertDialog a = alertDialog.create();
        a.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        a.show();

//        alertDialog.show();


    }


}