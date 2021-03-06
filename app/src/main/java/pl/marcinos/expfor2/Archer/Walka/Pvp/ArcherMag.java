package pl.marcinos.expfor2.Archer.Walka.Pvp;

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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherGuard;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherHellgate;
import pl.marcinos.expfor2.Bohaterowie.Archer;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Metody.AtakPotwora;
import pl.marcinos.expfor2.Metody.ButtonPotkow;
import pl.marcinos.expfor2.Metody.Ograbienie;
import pl.marcinos.expfor2.Metody.RegeneracjaPotworow;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Walka;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Potwory.PvpPrzeciwnik;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;
import static pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPvpRanking.przeciwnikpvp;
import static pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPvpRanking.przeciwnikpvphp;
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

public class ArcherMag extends AppCompatActivity {
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
    ImageView imageDskill;
    ImageView imageDatak;
    ImageView imageBD;
    FirebaseDatabase database;
    DatabaseReference users;
    ImageView imageDpvp;
    ImageView imageDpvpatak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_mag);
        imageBcrit = (ImageView) findViewById(R.id.imageViewCrit);

        imageB = (ImageView) findViewById(R.id.imageB);

        imageBb = (ImageView) findViewById(R.id.imageB);
        imageBa = (ImageView) findViewById(R.id.imageA);
        imageBskill = (ImageView) findViewById(R.id.imageBskill);
        imageBs = (ImageView) findViewById(R.id.imageS);
        imageBatak = (ImageView) findViewById(R.id.imageBatak);
        imageAatak = (ImageView) findViewById(R.id.imageAatak);
        imageSatak = (ImageView) findViewById(R.id.imageSatak);
        imageTimer = (ImageView) findViewById(R.id.imageSkillTimer);
        imageStopPotek = (ImageView) findViewById(R.id.imagePotTimer);
        imageAtackTimer = (ImageView) findViewById(R.id.imageAtackTimer);
        imageSkillIkon = (ImageView) findViewById(R.id.imageSkill);
        buttonBack = (ImageButton) findViewById(R.id.ButtonBack);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


//
//        Bundle bundle = getIntent().getExtras();
//        final String b = bundle.getString("User");

        imageBpvp = (ImageView) findViewById(R.id.pvpb);
        imageBpvpatak = (ImageView) findViewById(R.id.pvpbatak);
        imageApvp = (ImageView) findViewById(R.id.pvpa);
        imageApvpatak = (ImageView) findViewById(R.id.pvpaatak);
        imageSpvp = (ImageView) findViewById(R.id.pvps);
        imageSpvpatak = (ImageView) findViewById(R.id.pvpsatak);
        imageP = (ImageView) findViewById(R.id.pvpb);
        imagePatakuj = (ImageView) findViewById(R.id.pvpbatak);


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
                Intent intent = new Intent(ArcherMag.this, ArcherMenuActivity.class);
                startActivity(intent);
                ArcherMag.this.finish();
            }
        });
        if (archer.sett == 1) {
            imageBatakuj = (ImageView) findViewById(R.id.imageBatak);
            imageBskill = (ImageView) findViewById(R.id.imageBskill);
            imageB = (ImageView) findViewById(R.id.imageB);

        } else if (archer.sett == 2) {
            imageBatakuj = (ImageView) findViewById(R.id.imageAatak);
            imageB = (ImageView) findViewById(R.id.imageA);
            imageBskill = (ImageView) findViewById(R.id.imageAskill);
        } else if (archer.sett == 3) {
            imageBatakuj = (ImageView) findViewById(R.id.imageSatak);
            imageB = (ImageView) findViewById(R.id.imageS);
            imageBskill = (ImageView) findViewById(R.id.imageSskill);
        }
        else if(archer.sett==4)
        {
            imageBatakuj=(ImageView)findViewById(R.id.imageDatak);
            imageB= (ImageView)findViewById(R.id.imageD);
            imageBskill=(ImageView)findViewById(R.id.imageDskill);
        }
        imageBD= (ImageView)findViewById(R.id.imageD);
        imageDskill= (ImageView)findViewById(R.id.imageDskill);
        imageDatak= (ImageView)findViewById(R.id.imageDatak);
        Set.zmianaSetuWalkaIntSetD(archer,imageBb,imageBa,imageBs,imageBD);


        textHpB = (TextView) findViewById(R.id.textHpB);
        textHpP = (TextView) findViewById(R.id.textHpP);


        anim = (ImageView) findViewById(R.id.imageView5);
        progresHpB = (ProgressBar) findViewById(R.id.progressHpB);
        progresHpP = (ProgressBar) findViewById(R.id.progressHpP);
        progresHpB.setMax(archerhp.hpbohater);
        progresHpP.setMax(przeciwnikpvphp.hp);
        progresHpB.setProgress(archer.hpbohater);
        progresHpP.setProgress(przeciwnikpvp.hp);
        View v = this.findViewById(android.R.id.content).getRootView();
        View vv = this.findViewById(android.R.id.content).getRootView();
//        AtakPotwora.AtakPvpPrzeciwnik(imageB, imageBatakuj, imageP, imagePatakuj, archer, przeciwnikpvp, przeciwnikpvphp, textHpB, textHpP, progresHpB, progresHpP, buttonWalcz, buttonSkill, buttonPotek);

        AtakPotwora.AtakPvpPrzeciwnik(imageB,imageBatakuj,imageP,imagePatakuj,archer,przeciwnikpvp,przeciwnikpvphp,textHpB,textHpP,progresHpB,progresHpP,buttonWalcz,buttonSkill,buttonPotek);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(vv.getContext());
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


        textHpB.setText("Hp bohatera: " + archer.hpbohater);
        textHpP.setText("Hp Potwora: " + przeciwnikpvp.hp);
        buttonWalcz = (ImageButton) findViewById(R.id.buttonWalcz);
        buttonWalcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walczzPotworemPVP(imageAtackTimer, imageBcrit, anim, imageBatakuj, imageB, imageP, archer, archerhp, przeciwnikpvp, przeciwnikpvphp, textHpB, textHpP, v, buttonWalcz);


                progresHpB.setProgress(archer.hpbohater);
                progresHpP.setProgress(przeciwnikpvp.hp);
                if (archer.hpbohater <= 0) {

                    Snackbar.make(v, "Zginąłeś, wróć do menu", Snackbar.LENGTH_SHORT);
                }
                if(przeciwnikpvp.hp<=0)
                {
                    Ograbienie.nextFightDialog(alertDialogBuilderHonor,alertDialogBuilder,v,przeciwnikpvp,archer,database,users);
                    if(archer.quest5==1) {

                        archer.iloscZabitychPotworów += 5;
                    }
                }

            }
        });
        buttonSkill = (ImageButton) findViewById(R.id.buttonSkill);
        buttonSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Walka.walnijzeskillaPVP(imageTimer, imageBcrit, imageSkillIkon, imageBskill, imageB, imageP, archer, archerhp, przeciwnikpvp, przeciwnikpvphp, textHpB, textHpP, v, buttonSkill);


                progresHpB.setProgress(archer.hpbohater);
                progresHpP.setProgress(przeciwnikpvp.hp);
                if (archer.hpbohater <= 0) {

                    Snackbar.make(v, "Zginąłeś, wróć do menu", Snackbar.LENGTH_SHORT);
                }

                if(przeciwnikpvp.hp<=0)
                {
                    Ograbienie.nextFightDialog(alertDialogBuilderHonor,alertDialogBuilder,v,przeciwnikpvp,archer,database,users);
                    if(archer.quest5==1) {

                        archer.iloscZabitychPotworów += 5;
                    }
                }
            }
        });
        buttonPotek = (ImageButton) findViewById(R.id.buttonPotek);

        buttonPotek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                   textHpB.setText(archer.hpbohater);


                ButtonPotkow.uzyjPota(archer, archerhp, imageStopPotek, buttonPotek, textHpB, progresHpB);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ArcherMag.this, ArcherMenuActivity.class);
        startActivity(intent);
        ArcherMag.this.finish();

    }
}


