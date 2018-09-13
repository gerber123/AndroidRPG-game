package pl.marcinos.expfor2.Archer.Walka.Walka;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Mag.Menu.SetLevels;
import pl.marcinos.expfor2.Mag.Walka.Walka.Walka.MagKot;
import pl.marcinos.expfor2.Metody.AtakPotwora;
import pl.marcinos.expfor2.Metody.ButtonPotkow;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Metody.Skille;
import pl.marcinos.expfor2.Metody.Walka;
import pl.marcinos.expfor2.R;

import static java.lang.Thread.sleep;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;
import static pl.marcinos.expfor2.Potwory.Potwory.guard;
import static pl.marcinos.expfor2.Potwory.Potwory.guardhp;
import static pl.marcinos.expfor2.Potwory.Potwory.hellgate;
import static pl.marcinos.expfor2.Potwory.Potwory.hellgatehp;
import static pl.marcinos.expfor2.Potwory.Potwory.kot;
import static pl.marcinos.expfor2.Potwory.Potwory.kothp;
import static pl.marcinos.expfor2.Potwory.Potwory.mnich;
import static pl.marcinos.expfor2.Potwory.Potwory.mnichhp;
import static pl.marcinos.expfor2.Potwory.Potwory.moskit;
import static pl.marcinos.expfor2.Potwory.Potwory.moskithp;
import static pl.marcinos.expfor2.Potwory.Potwory.orc;
import static pl.marcinos.expfor2.Potwory.Potwory.orchp;
import static pl.marcinos.expfor2.Potwory.Potwory.rycerz;
import static pl.marcinos.expfor2.Potwory.Potwory.rycerzhp;
import static pl.marcinos.expfor2.Potwory.Potwory.stroz;
import static pl.marcinos.expfor2.Potwory.Potwory.strozhp;
import static pl.marcinos.expfor2.Potwory.Potwory.szkielet;
import static pl.marcinos.expfor2.Potwory.Potwory.szkielethp;
import static pl.marcinos.expfor2.Potwory.Potwory.wilkor;
import static pl.marcinos.expfor2.Potwory.Potwory.wilkorhp;
import static pl.marcinos.expfor2.Potwory.Potwory.zombie;
import static pl.marcinos.expfor2.Potwory.Potwory.zombiehp;

public class ArcherKot extends AppCompatActivity {
    ImageView buttonWalcz;
    ImageView buttonSkill;
    ImageView imageTimer;
    ImageView imageStopPotek;
    ImageView imageAtackTimer;
    TextView textHpB;
    TextView textHpP;

    ImageView imageB;
    ImageButton buttonBack;
    ImageView imageBs;
    ImageView imageBa;
    ImageView imageBb;
    ImageView imageP;
    ImageView imageBatakuj;
    ImageView imageBskill;
    ImageView imageAskill;
    ImageView imageSskill;
    ImageView imageBatak;
    ImageView imageAatak;
    ImageView imageSatak;
    ImageView imageKrew;
    ImageView imageBcrit;
    ImageView imageDskill;
    ImageView imageDatak;
    ImageView imageBD;
    ImageView imageSkillIkon;
    ImageView hpPotion;
    ImageView manaPotion;
    ImageView imageSkillOgien;


    ImageView anim;
    ProgressBar progresHpB;
    ProgressBar progresHpP;
    TextView textMana;
    ProgressBar progresMana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_kot);
        imageBcrit = (ImageView)findViewById(R.id.imageViewCrit);

        imageB=(ImageView)findViewById(R.id.imageB);
        imageBskill= (ImageView)findViewById(R.id.imageBskill);

        buttonBack=(ImageButton) findViewById(R.id.ButtonBack);

        imageBatakuj=(ImageView)findViewById(R.id.imageBatak);
        imageBskill=(ImageView)findViewById(R.id.imageBskill);
        imageB= (ImageView)findViewById(R.id.imageB);
        SetLevels.ArcherSetCheck(archer,imageB,imageBatakuj,imageBskill);
        buttonSkill=(ImageView)findViewById(R.id.buttonSkill);
        buttonWalcz=(ImageView)findViewById(R.id.buttonWalcz);
        Skille.archerDifferenceTest(buttonSkill,buttonWalcz);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherKot.this,ArcherMenuActivity.class);
                startActivity(intent);
                ArcherKot.this.finish();
            }
        });
        imageBatakuj=(ImageView)findViewById(R.id.imageBatak);
        imageBskill=(ImageView)findViewById(R.id.imageBskill);
        imageB= (ImageView)findViewById(R.id.imageB);
        imageB.setVisibility(View.VISIBLE);
        SetLevels.ArcherSetCheck(archer,imageB,imageBatakuj,imageBskill);
        buttonSkill=(ImageView)findViewById(R.id.buttonSkill);
        Skille.archerDifferenceTest(buttonSkill,buttonWalcz);

        textHpB=(TextView)findViewById(R.id.textHpB);
        textHpP=(TextView)findViewById(R.id.textHpP);
        textMana=(TextView)findViewById(R.id.manaText);
        progresMana=(ProgressBar)findViewById(R.id.ManaBar);
        imageSkillIkon= (ImageView)findViewById(R.id.imageSkill);
        progresMana.setMax(archer.maxMana);
        progresMana.setProgress(archer.mana);
        textMana.setText("Chęć mordu: "+archer.mana);
        imageP= (ImageView)findViewById(R.id.imageView4);
        anim = (ImageView)findViewById(R.id.imageView5);
        progresHpB=(ProgressBar)findViewById(R.id.progressHpB);
        progresHpP=(ProgressBar)findViewById(R.id.progressHpP);
        progresHpB.setMax(archerhp.hpbohater);
        progresHpP.setMax(kothp.hp);
        progresHpB.setProgress(archer.hpbohater);
        progresHpP.setProgress(kot.hp);
        View v =this.findViewById(android.R.id.content).getRootView();
        hpPotion= (ImageView)findViewById(R.id.hpPotion);
        manaPotion=(ImageView)findViewById(R.id.manaPotion);
        hpPotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                archer.hpbohater+=300;
                progresHpB.setProgress(archer.hpbohater);
                textHpB.setText("Hp: "+archer.hpbohater+" ");
                hpPotion.setVisibility(View.INVISIBLE);
                hpPotion.setEnabled(false);
            }
        });
        manaPotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        AtakPotwora.AtakPotworaPotkiTest(hpPotion,manaPotion,imageB,imageBatakuj,imageP,archer,kot,kothp,textHpB,textHpP,progresHpB,progresHpP,buttonWalcz,buttonSkill);

        textHpB.setText("Hp bohatera: "+archer.hpbohater);
        textHpP.setText("Hp Potwora: "+kot.hp);
        buttonWalcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walczzPotworemTest(imageBcrit,anim,imageBatakuj,imageB,imageP,archer,archerhp,kot,kothp,textHpB,textHpP,v,buttonWalcz);
                progresMana.setProgress(archer.mana);
                textMana.setText("Chęć mordu: "+archer.mana);
                progresHpB.setProgress(archer.hpbohater);
                progresHpP.setProgress(kot.hp);
                if(archer.hpbohater<=0)
                {
                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(kot.hp<=0)
                {
                    nextFight(v);
                }
            }
        });

            buttonSkill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Walka.walnijzeskillaTest(imageBcrit,imageSkillIkon,imageBskill,imageB,imageP,archer,archerhp,kot,kothp,textHpB,textHpP,v,buttonSkill);
                    progresMana.setProgress(archer.mana);
                    textMana.setText("Chęć mordu: "+archer.mana);
                    progresHpB.setProgress(archer.hpbohater);
                    progresHpP.setProgress(kot.hp);
                    if(archer.hpbohater<=0)
                    {

                        Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                    }
                    if(kot.hp<=0)
                    {
                        nextFight(v);
                        if(archer.quest1==1) {

                            archer.iloscZabitychPotworów += 1;
                        }
                    }
                }
            });


    }
        @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ArcherKot.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherKot.this.finish();
    }
    public void nextFight(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Potwór Pokonany !!!");
        alertDialogBuilder.setMessage("Czy chcesz kontynuować przygodę?");

        alertDialogBuilder.setPositiveButton(("Walcze dalej!"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(ArcherKot.this,ArcherWilkor.class);
                startActivity(intent);
                ArcherKot.this.finish();
                RegeneracjaPotworow.Regenereuj(guard,guardhp,hellgate,hellgatehp,kot,kothp,mnich,mnichhp,moskit,moskithp,orc,orchp,rycerz,rycerzhp,stroz,strozhp,szkielet,szkielethp,wilkor,wilkorhp,zombie,zombiehp);




            }
        });
        alertDialogBuilder.setNegativeButton(("Wracam do Miasta"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onBackPressed();
            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.przygodawalka);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}


