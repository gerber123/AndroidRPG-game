package pl.marcinos.expfor2.Archer.Walka.Walka;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Metody.AtakPotwora;
import pl.marcinos.expfor2.Metody.ButtonPotkow;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Walka;
import pl.marcinos.expfor2.R;

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

public class ArcherGuard extends AppCompatActivity {
    ImageButton buttonWalcz;
    ImageButton buttonSkill;
    ImageButton buttonPotek;
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
    ImageView anim;
    ProgressBar progresHpB;
    ProgressBar progresHpP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_guard);

        imageBcrit = (ImageView)findViewById(R.id.imageViewCrit);

        imageB=(ImageView)findViewById(R.id.imageB);

        imageBb= (ImageView)findViewById(R.id.imageB);
        imageBa= (ImageView)findViewById(R.id.imageA);
        imageBskill= (ImageView)findViewById(R.id.imageBskill);
        imageBs= (ImageView)findViewById(R.id.imageS);
        imageBatak= (ImageView)findViewById(R.id.imageBatak);
        imageAatak= (ImageView)findViewById(R.id.imageAatak);
        imageSatak= (ImageView)findViewById(R.id.imageSatak);
        imageTimer= (ImageView)findViewById(R.id.imageSkillTimer);
        imageStopPotek= (ImageView)findViewById(R.id.imagePotTimer);
        imageAtackTimer= (ImageView)findViewById(R.id.imageAtackTimer);
        imageSkillIkon= (ImageView)findViewById(R.id.imageSkill);
        buttonBack=(ImageButton) findViewById(R.id.ButtonBack);

        imageBD= (ImageView)findViewById(R.id.imageD);
        imageDskill= (ImageView)findViewById(R.id.imageDskill);
        imageDatak= (ImageView)findViewById(R.id.imageDatak);
        Set.zmianaSetuWalkaIntSetD(archer,imageBb,imageBa,imageBs,imageBD);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherGuard.this,ArcherMenuActivity.class);
                startActivity(intent);
                ArcherGuard.this.finish();
            }
        });
        if(archer.sett==1)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageBatak);
            imageBskill=(ImageView)findViewById(R.id.imageBskill);
            imageB= (ImageView)findViewById(R.id.imageB);

        }
        else if(archer.sett==2)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageAatak);
            imageB= (ImageView)findViewById(R.id.imageA);
            imageBskill=(ImageView)findViewById(R.id.imageAskill);
        }
        else if(archer.sett==3)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageSatak);
            imageB= (ImageView)findViewById(R.id.imageS);
            imageBskill=(ImageView)findViewById(R.id.imageSskill);
        }
        else if(archer.sett==4)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageDatak);
            imageB= (ImageView)findViewById(R.id.imageD);
            imageBskill=(ImageView)findViewById(R.id.imageDskill);
        }
//        Set.zmianaSetuWalkaInt(archer,imageBb,imageBa,imageBs);


        textHpB=(TextView)findViewById(R.id.textHpB);
        textHpP=(TextView)findViewById(R.id.textHpP);

        imageP= (ImageView)findViewById(R.id.imageView4);
        anim = (ImageView)findViewById(R.id.imageView5);
        progresHpB=(ProgressBar)findViewById(R.id.progressHpB);
        progresHpP=(ProgressBar)findViewById(R.id.progressHpP);
        progresHpB.setMax(archerhp.hpbohater);
        progresHpP.setMax(guardhp.hp);
        progresHpB.setProgress(archer.hpbohater);
        progresHpP.setProgress(guard.hp);
        View v =this.findViewById(android.R.id.content).getRootView();
        AtakPotwora.AtakPotwora(imageB,imageBatakuj,imageP,archer,guard,guardhp,textHpB,textHpP,progresHpB,progresHpP,buttonWalcz,buttonSkill,buttonPotek);



        textHpB.setText("Hp bohatera: "+archer.hpbohater);
        textHpP.setText("Hp Potwora: "+guard.hp);
        buttonWalcz=(ImageButton)findViewById(R.id.buttonWalcz);
        buttonWalcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walczzPotworem(imageAtackTimer,imageBcrit,anim,imageBatakuj,imageB,imageP,archer,archerhp,guard,guardhp,textHpB,textHpP,v,buttonWalcz);


                progresHpB.setProgress(archer.hpbohater);
                progresHpP.setProgress(guard.hp);
                if(archer.hpbohater<=0)
                {

                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(guard.hp<=0)
                {  if(archer.quest3==1) {

                    archer.iloscZabitychPotworów += 1;
                }
                    nextFight(v);
                }
            }
        });
        buttonSkill=(ImageButton)findViewById(R.id.buttonSkill);
        buttonSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walnijzeskilla(imageTimer,imageBcrit,imageSkillIkon,imageBskill,imageB,imageP,archer,archerhp,guard,guardhp,textHpB,textHpP,v,buttonSkill);


                progresHpB.setProgress(archer.hpbohater);
                progresHpP.setProgress(guard.hp);
                if(archer.hpbohater<=0)
                {

                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(guard.hp<=0)
                {  if(archer.quest3==1) {

                    archer.iloscZabitychPotworów += 1;
                }
                    if(archer.quest5==1)
                    {
                        archer.iloscZabitychPotworów+=1;
                    }
                    nextFight(v);
                }
            }
        });
        buttonPotek=(ImageButton)findViewById(R.id.buttonPotek);

        buttonPotek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                   textHpB.setText(archer.hpbohater);


                ButtonPotkow.uzyjPota(archer,archerhp,imageStopPotek,buttonPotek,textHpB,progresHpB);

            }
        });

    }
        @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ArcherGuard.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherGuard.this.finish();

    }
    public void nextFight(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Potwór Pokonany !!!");
        alertDialogBuilder.setMessage("Czy chcesz kontynuować przygodę?");

        alertDialogBuilder.setPositiveButton(("Walcze dalej!"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(ArcherGuard.this,ArcherHellgate.class);
                startActivity(intent);
                ArcherGuard.this.finish();
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



