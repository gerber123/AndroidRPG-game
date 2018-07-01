package pl.marcinos.expfor2.Archer.Walka.Questy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Bohaterowie.Archer;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Model.Dorosle;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Questy.Questy;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Potwory.Potwory.kot;

public class ArcherQuesty extends AppCompatActivity {
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



    public static Questy questFaraon = new Questy(1, "Zaginiony Kot"," ", 150, 100, R.drawable.kot, 6,archer);
    public static Questy questWyspa = new Questy(5, "Oblężenie Orców"," ", 450, 650, R.drawable.orc, 15,archer);
    public static Questy questKatakumby = new Questy(10, "Szczątki Gwardii"," ", 900, 450, R.drawable.guard, 12,archer);
    public static Questy questKraniec = new Questy(5, "Zaginiony Rybak"," ", 3100, 490, R.drawable.turtle, 10,archer);
    public static Questy questLodowiec = new Questy(5, "Szalony Nożownik"," ", 999, 999, R.drawable.kosiarz, 99,archer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_questy);
        Questy.sprawdzQuesta(archer,questFaraon,questWyspa,questKatakumby,questKraniec,questLodowiec);


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
        Questy.stanQuesta(archer,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);

        buttonWzgorzaFaraona = (Button) findViewById(R.id.buttonWzgorzaFaraona);
        buttonWzgorzaFaraona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(archer, kot,questFaraon,WzgorzaFaraonaStan);

            }
        });


        buttonZatrutaWyspa = (Button) findViewById(R.id.buttonZatrutaWyspa);
        buttonZatrutaWyspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(archer, kot,questWyspa,ZatrutaWyspaStan);

            }
        });
        buttonLodowiecGeista = (Button) findViewById(R.id.buttonLodowiecGeista);
        buttonLodowiecGeista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(archer, kot,questLodowiec,KatakumbyStan);
            }
        });
        buttonKatakumby = (Button) findViewById(R.id.buttonKatakumby);
        buttonKatakumby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(archer, kot,questKatakumby,LodowiecGeistaStan);
            }
        });
        buttonKraniecSwiatow = (Button) findViewById(R.id.buttonKraniecSwiatow);
        buttonKraniecSwiatow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog(archer, kot,questKraniec, KraniecSwiatowStan);
            }
        });
    }


    private void showSignUpDialog(final Bohaterowie x, final Potwory y, final Questy quest, final TextView StanQuestaText) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ArcherQuesty.this,R.style.CustomDialogg);



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
                if(archer.quest1==1||archer.quest2==1||archer.quest3==1||archer.quest4==1||archer.quest5==1)
                {
                    Toast.makeText(getApplicationContext(),"Najpierw skończ jedno zadanie", Toast.LENGTH_SHORT).show();
                }
                else {
                    quest.zaczetoMisje(x, y, StanQuestaText);
                    Questy.stanQuesta(archer, WzgorzaFaraonaStan, ZatrutaWyspaStan, KatakumbyStan, LodowiecGeistaStan, KraniecSwiatowStan);
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
                        Questy.stanQuesta(archer,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);


                }
            });

        }
        else if(quest.stanQuesta==2)
        {
            Questy.stanQuesta(archer,WzgorzaFaraonaStan,ZatrutaWyspaStan,KatakumbyStan,LodowiecGeistaStan,KraniecSwiatowStan);
            textQuesta.setText("Ile już zabiłeś " + quest.getIleZabic()+ " / " + quest.getIleZabic());
            textQuesta.setTextColor(Color.GREEN);
        }


        alertDialog.show();


    }
}