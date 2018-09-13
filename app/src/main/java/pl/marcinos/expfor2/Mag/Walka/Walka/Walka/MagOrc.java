package pl.marcinos.expfor2.Mag.Walka.Walka.Walka;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Mag.Menu.SetLevels;
import pl.marcinos.expfor2.Metody.AtakPotwora;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Metody.Skille;
import pl.marcinos.expfor2.Metody.Walka;
import pl.marcinos.expfor2.R;

import static android.view.View.VISIBLE;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.uzytyPotekHp;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.uzytyPotekMp;
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

public class MagOrc extends AppCompatActivity {

    ImageView buttonWalcz;
    ImageView buttonSkill;

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
    TextView textMana;
    ProgressBar progresMana;

    ImageView anim;
    ProgressBar progresHpB;
    ProgressBar progresHpP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_orc);





        imageBcrit = (ImageView)findViewById(R.id.imageViewCrit);

        imageB=(ImageView)findViewById(R.id.imageB);

        imageBb= (ImageView)findViewById(R.id.imageB);
        imageBa= (ImageView)findViewById(R.id.imageA);
        imageBskill= (ImageView)findViewById(R.id.imageBskill);
        imageBs= (ImageView)findViewById(R.id.imageS);





        imageBatak= (ImageView)findViewById(R.id.imageBatak);
        imageAatak= (ImageView)findViewById(R.id.imageAatak);
        imageSatak= (ImageView)findViewById(R.id.imageSatak);

        imageSkillIkon= (ImageView)findViewById(R.id.imageSkill);
        imageBatakuj=(ImageView)findViewById(R.id.imageBatak);
        imageBskill=(ImageView)findViewById(R.id.imageBskill);
        imageB= (ImageView)findViewById(R.id.imageB);
        SetLevels.SetCheck(mag,imageB,imageBatakuj,imageBskill);
        imageB.setVisibility(VISIBLE);
        buttonBack=(ImageButton) findViewById(R.id.ButtonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagOrc.this,MagMenuActivity.class);
                startActivity(intent);
                MagOrc.this.finish();
            }
        });

        imageBD= (ImageView)findViewById(R.id.imageD);
        imageDskill= (ImageView)findViewById(R.id.imageDskill);
        imageDatak= (ImageView)findViewById(R.id.imageDatak);
        imageP= (ImageView)findViewById(R.id.imageView4);
        anim = (ImageView)findViewById(R.id.imageView5);

        textHpB=(TextView)findViewById(R.id.textHpB);
        textHpP=(TextView)findViewById(R.id.textHpP);
        textMana=(TextView)findViewById(R.id.manaText);
        progresMana=(ProgressBar)findViewById(R.id.ManaBar);
        progresMana.setMax(mag.maxMana);
        progresMana.setProgress(mag.mana);
        textMana.setText("Mana: "+mag.mana);
        progresHpB=(ProgressBar)findViewById(R.id.progressHpB);
        progresHpP=(ProgressBar)findViewById(R.id.progressHpP);
        progresHpB.setMax(maghp.hpbohater);

        progresHpP.setMax(orchp.hp);
        progresHpB.setProgress(mag.hpbohater);
        progresHpP.setProgress(orc.hp);

        View v =this.findViewById(android.R.id.content).getRootView();
        hpPotion= (ImageView)findViewById(R.id.hpPotion);
        manaPotion=(ImageView)findViewById(R.id.manaPotion);
        hpPotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mag.hpbohater+=300;
                progresHpB.setProgress(mag.hpbohater);
                textHpB.setText("Hp: "+mag.hpbohater+" ");
                hpPotion.setVisibility(View.INVISIBLE);
                hpPotion.setEnabled(false);
            }
        });
        manaPotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mag.mana+=300;
                progresMana.setProgress(mag.mana);
                textMana.setText("Mana: "+mag.mana+" ");
                manaPotion.setVisibility(View.INVISIBLE);
                manaPotion.setEnabled(false);
            }
        });
        AtakPotwora.AtakPotworaPotkiTest(hpPotion,manaPotion,imageB,imageBatakuj,imageP,mag,orc,orchp,textHpB,textHpP,progresHpB,progresHpP,buttonWalcz,buttonSkill);



        textHpB.setText("Hp bohatera: "+mag.hpbohater);
        textHpP.setText("Hp Potwora: "+orc.hp);

        buttonWalcz=(ImageView)findViewById(R.id.buttonWalcz);
        buttonWalcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walczzPotworemTest(imageBcrit,anim,imageBatakuj,imageB,imageP,mag,maghp,orc,orchp,textHpB,textHpP,v,buttonWalcz);

                textMana.setText("Mana: "+mag.mana+" ");
                progresHpB.setProgress(mag.hpbohater);
                progresHpP.setProgress(orc.hp);
                if(mag.hpbohater<=0)
                {

                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(orc.hp<=0)
                {
                    nextFight(v);
                }
            }
        });
        buttonSkill=(ImageView)findViewById(R.id.buttonSkill);
        Skille.magDifferenceTest(buttonSkill);
        buttonSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walnijzeskillaTest(imageBcrit,imageSkillIkon,imageBskill,imageB,imageP,mag,maghp,orc,orchp,textHpB,textHpP,v,buttonSkill);


                progresHpB.setProgress(mag.hpbohater);
                progresHpP.setProgress(orc.hp);
                progresMana.setProgress(mag.mana);
                textMana.setText(mag.mana+" ");
                if(mag.hpbohater<=0)
                {

                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(orc.hp<=0)
                {
                    nextFight(v);
                    if(mag.quest1==1) {

                        mag.iloscZabitychPotworów += 1;
                    }
                }
            }
        });


        if(orc.hp<=0)
        {
            nextFight(v);
        }

    }      @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(MagOrc.this,MagMenuActivity.class);
        startActivity(intent);
        MagOrc.this.finish();
    }

    public void nextFight(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Potwór Pokonany !!!");
        alertDialogBuilder.setMessage("Czy chcesz kontynuować przygodę?");

        alertDialogBuilder.setPositiveButton(("Walcze dalej!"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(MagOrc.this,MagStroz.class);
                startActivity(intent);
                MagOrc.this.finish();
                RegeneracjaPotworow.Regenereuj(guard,guardhp,hellgate,hellgatehp,kot,kothp,mnich,mnichhp,moskit,moskithp,orc,orchp,rycerz,rycerzhp,stroz,strozhp,szkielet,szkielethp,wilkor,wilkorhp,zombie,zombiehp);

                uzytyPotekHp=0;
                uzytyPotekMp=0;


            }
        });
        alertDialogBuilder.setNegativeButton(("Wracam do Miasta"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onBackPressed();

                uzytyPotekHp=0;
                uzytyPotekMp=0;
            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.przygodawalka);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}
