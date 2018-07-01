package pl.marcinos.expfor2.Mag.Walka.Walka.Pvp;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherArcher;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Metody.AtakPotwora;
import pl.marcinos.expfor2.Metody.ButtonPotkow;
import pl.marcinos.expfor2.Metody.Ograbienie;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Walka;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;
import static pl.marcinos.expfor2.Mag.Walka.Walka.Pvp.MagPvpRanking.przeciwnikpvp;
import static pl.marcinos.expfor2.Mag.Walka.Walka.Pvp.MagPvpRanking.przeciwnikpvphp;


public class MagArcher extends AppCompatActivity {
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
    ImageView imageDskill;
    ImageView imageDatak;
    ImageView imageBD;
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
    ImageView imageBpvp;
    ImageView imageBpvpatak;
    ImageView imageApvp;
    ImageView imageApvpatak;
    ImageView imageSpvp;
    ImageView imageSpvpatak;
    ImageView imagePatakuj;

    ImageView imageSkillIkon;
    ImageView anim;
    ProgressBar progresHpB;
    ProgressBar progresHpP;
    ImageView imageDpvp;
    ImageView imageDpvpatak;

    DatabaseReference users;
    DatabaseReference uzytkownicy;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_archer);
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
        database=FirebaseDatabase.getInstance();
        users=database.getReference("Users");



        imageBpvp= (ImageView)findViewById(R.id.pvpb);
        imageBpvpatak= (ImageView)findViewById(R.id.pvpbatak);
        imageApvp= (ImageView)findViewById(R.id.pvpa);
        imageApvpatak= (ImageView)findViewById(R.id.pvpaatak);
        imageSpvp= (ImageView)findViewById(R.id.pvps);
        imageSpvpatak= (ImageView)findViewById(R.id.pvpsatak);
        imageP= (ImageView)findViewById(R.id.pvpb);
        imagePatakuj= (ImageView)findViewById(R.id.pvpbatak);



        imageDpvp= (ImageView)findViewById(R.id.pvpd);
        imageDpvpatak= (ImageView)findViewById(R.id.pvpdatak);


        if(przeciwnikpvp.sett==1)
        {
            imageP=(ImageView)findViewById(R.id.pvpb);
            imageP.setVisibility(View.VISIBLE);
            imagePatakuj=(ImageView)findViewById(R.id.pvpbatak);
//                    imagePatakuj.setVisibility(View.VISIBLE);


        }
        else if(przeciwnikpvp.sett==2)
        {
            imageP=(ImageView)findViewById(R.id.pvpa);
            imageP.setVisibility(View.VISIBLE);
            imagePatakuj=(ImageView)findViewById(R.id.pvpaatak);
//                    imagePatakuj.setVisibility(View.VISIBLE);
        }
        else if(przeciwnikpvp.sett==3)
        {
            imageP=(ImageView)findViewById(R.id.pvps);
            imageP.setVisibility(View.VISIBLE);
            imagePatakuj=(ImageView)findViewById(R.id.pvpsatak);
//                    imagePatakuj.setVisibility(View.VISIBLE);
        }
        else if(przeciwnikpvp.sett==4)
        {
            imageP=(ImageView)findViewById(R.id.pvpd);
            imageP.setVisibility(View.VISIBLE);
            imagePatakuj=(ImageView)findViewById(R.id.pvpdatak);
//                    imagePatakuj.setVisibility(View.VISIBLE);
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MagArcher.this,MagMenuActivity.class);
                startActivity(intent);
                MagArcher.this.finish();
            }
        });
        if(mag.sett==1)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageBatak);
            imageBskill=(ImageView)findViewById(R.id.imageBskill);
            imageB= (ImageView)findViewById(R.id.imageB);

        }
        else if(mag.sett==2)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageAatak);
            imageB= (ImageView)findViewById(R.id.imageA);
            imageBskill=(ImageView)findViewById(R.id.imageAskill);
        }
        else if(mag.sett==3)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageSatak);
            imageB= (ImageView)findViewById(R.id.imageS);
            imageBskill=(ImageView)findViewById(R.id.imageSskill);
        }
        else if(mag.sett==4)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageDatak);
            imageB= (ImageView)findViewById(R.id.imageD);
            imageBskill=(ImageView)findViewById(R.id.imageDskill);
        }

        imageBD= (ImageView)findViewById(R.id.imageD);
        imageDskill= (ImageView)findViewById(R.id.imageDskill);
        imageDatak= (ImageView)findViewById(R.id.imageDatak);
        Set.zmianaSetuWalkaIntSetD(mag,imageBb,imageBa,imageBs,imageBD);


        textHpB=(TextView)findViewById(R.id.textHpB);
        textHpP=(TextView)findViewById(R.id.textHpP);


        View v =this.findViewById(android.R.id.content).getRootView();
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Grabież!");
        alertDialogBuilder.setMessage("Udało Ci się wyciągnąc  "+(przeciwnikpvp.getHajs()*5)/100+" złota\n ...Lecz straciłeś na honorze...");

        alertDialogBuilder.setPositiveButton(("Wracam do Miasta"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                onBackPressed();

            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.grabiez);
        final AlertDialog.Builder alertDialogBuilderHonor = new AlertDialog.Builder(v.getContext());
        alertDialogBuilderHonor.setTitle("Honor!");
        alertDialogBuilderHonor.setMessage("Za uczciwą walke zdobyłeś 1 pkt Honoru");

        alertDialogBuilderHonor.setPositiveButton(("Wracam do Miasta"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                onBackPressed();

            }
        });
        alertDialogBuilderHonor.setCancelable(false);
        alertDialogBuilderHonor.setIcon(R.drawable.honorikon);

        anim = (ImageView)findViewById(R.id.imageView5);
        progresHpB=(ProgressBar)findViewById(R.id.progressHpB);
        progresHpP=(ProgressBar)findViewById(R.id.progressHpP);
        progresHpB.setMax(maghp.hpbohater);
        progresHpP.setMax(przeciwnikpvphp.hp);
        progresHpB.setProgress(mag.hpbohater);
        progresHpP.setProgress(przeciwnikpvp.hp);

        AtakPotwora.AtakPvpPrzeciwnik(imageB,imageBatakuj,imageP,imagePatakuj,mag,przeciwnikpvp,przeciwnikpvphp,textHpB,textHpP,progresHpB,progresHpP,buttonWalcz,buttonSkill,buttonPotek);



        textHpB.setText("Hp bohatera: "+mag.hpbohater);
        textHpP.setText("Hp Potwora: "+przeciwnikpvp.hp);
        buttonWalcz=(ImageButton)findViewById(R.id.buttonWalcz);
        buttonWalcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walczzPotworemPVP(imageAtackTimer,imageBcrit,anim,imageBatakuj,imageB,imageP,mag,maghp,przeciwnikpvp,przeciwnikpvphp,textHpB,textHpP,v,buttonWalcz);


                progresHpB.setProgress(mag.hpbohater);
                progresHpP.setProgress(przeciwnikpvp.hp);
                if(mag.hpbohater<=0)
                {

                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(przeciwnikpvp.hp<=0)
                {
                    Ograbienie.nextFightDialog(alertDialogBuilderHonor,alertDialogBuilder,v,przeciwnikpvp,mag,database,users);
                    if(mag.quest5==1) {

                        mag.iloscZabitychPotworów += 5;
                    }
                }

            }
        });
        buttonSkill=(ImageButton)findViewById(R.id.buttonSkill);
        buttonSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walnijzeskillaPVP(imageTimer,imageBcrit,imageSkillIkon,imageBskill,imageB,imageP,mag,maghp,przeciwnikpvp,przeciwnikpvphp,textHpB,textHpP,v,buttonSkill);


                progresHpB.setProgress(mag.hpbohater);
                progresHpP.setProgress(przeciwnikpvp.hp);
                if(mag.hpbohater<=0)
                {

                    Snackbar.make(v,"Zginąłeś, wróć do menu",Snackbar.LENGTH_SHORT);
                }
                if(przeciwnikpvp.hp<=0)
                {
                    Ograbienie.nextFightDialog(alertDialogBuilderHonor,alertDialogBuilder,v,przeciwnikpvp,mag,database,users);
                    if(mag.quest5==1) {

                        mag.iloscZabitychPotworów += 5;
                    }
                }

            }
        });
        buttonPotek=(ImageButton)findViewById(R.id.buttonPotek);

        buttonPotek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ButtonPotkow.uzyjPota(mag,maghp,imageStopPotek,buttonPotek,textHpB,progresHpB);

            }
        });

    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(MagArcher.this,MagMenuActivity.class);
        startActivity(intent);
        MagArcher.this.finish();

    }


}
