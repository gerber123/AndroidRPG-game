package pl.marcinos.expfor2.Paladyn.Menu;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Metody.Dialog;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladynhp;

public class PaladynKowal extends AppCompatActivity {
    Button buttonUlepsz;
    Button buttonWymien;
    Button buttonUlepszZbroje;
    Button buttonWymienZbroje;
    TextView textGold;
    TextView textItemm;
    TextView  textBron;
    ProgressBar progressBar;
    ImageView succes;
    ImageView fail;
    TextView  textZbroja;
    ProgressBar progressBarZbroja;
    ImageView succesZbroja;
    ImageView failZbroja;
    FirebaseDatabase database;
    DatabaseReference users;
    ImageView imageUlepszenie;
    ImageView set;
    public static int score=0;
    public static int a=0;
    public static int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_kowal);
        textGold = (TextView) findViewById(R.id.textGoldd);
        textItemm = (TextView) findViewById(R.id.textItemm);
        textBron = (TextView) findViewById(R.id.textBron);
        textGold.setText("Twoje złoto: " + paladyn.hajs);
        textItemm.setText("Kamienie: " + paladyn.iloscKamieni+" Diamenty: "+paladyn.getIloscKamieniPewnych());
//        textBron.setText("Różdzka +" + mag.getPoziomUlepszenia());
        progressBar=(ProgressBar)findViewById(R.id.progressHpP);
        progressBar=(ProgressBar)findViewById(R.id.progressHpP);
        succes = (ImageView) findViewById(R.id.success);
        fail = (ImageView) findViewById(R.id.fail);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        View v =this.findViewById(android.R.id.content).getRootView();

        buttonUlepsz = (Button) findViewById(R.id.buttonUlepsz);
        buttonWymien = (Button) findViewById(R.id.buttonWymien);

        textZbroja = (TextView) findViewById(R.id.textZbroja);
        succesZbroja = (ImageView) findViewById(R.id.successzbroja);
        failZbroja = (ImageView) findViewById(R.id.failzbroja);


        progressBarZbroja=(ProgressBar)findViewById(R.id.progressHpZbroja);



        imageUlepszenie=(ImageView)findViewById(R.id.bron);
        set=(ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuPaladyn(paladyn,imageUlepszenie,set);


        buttonUlepszZbroje = (Button) findViewById(R.id.buttonUlepszZbroje);
        buttonWymienZbroje = (Button) findViewById(R.id.buttonWymienZbroje);
//        textZbroja.setText("Zbroja +" + mag.getPoziomUlepszeniaZbroji());
        Set.zmianaNazwSetu(paladyn,textBron,textZbroja);

        if(paladyn.iloscKamieniPewnych>=1||paladyn.iloscKamieni>=1)
        {
            buttonWymien.setEnabled(true);
        }
        else
        {
            buttonWymien.setEnabled(false);
        }
        if(paladyn.hajs<=0)
        {
            buttonUlepsz.setEnabled(false);
        }
        else
        {
            buttonUlepsz.setEnabled(true);
        }
        progressBar.setMax(9);
//        progressBar.setProgress(a);
        buttonUlepsz.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {
                buttonUlepsz.setEnabled(false);
                buttonWymien.setEnabled(false);
                progressBar.setProgress(0);
                a=0;
                if(a!=10){
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(a==10)
                            {
                                this.cancel();
                            }
                            else {
                                a += 1;
                                progressBar.setProgress(a);
                            }


                        }

                        @Override
                        public void onFinish()
                        {
//                            buttonWymien.setEnabled(true);
//                            buttonUlepsz.setEnabled(true);
                            if(paladyn.hajs<=0)
                            {
                                buttonUlepsz.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepsz.setEnabled(true);
                            }
                            if(paladyn.iloscKamieniPewnych>=1||paladyn.iloscKamieni>=1)

                            {
                                buttonWymien.setEnabled(true);
                            }
                            else
                            {
                                buttonWymien.setEnabled(false);
                            }
                            Sklep.ulepsz(fail,succes,paladyn,paladynhp,v,textGold);
//                            textBron.setText("Różdzka +" + mag.getPoziomUlepszenia());
                            Set.zmianaNazwSetu(paladyn,textBron,textZbroja);

                        }

                    }.start();

                }}
        });

        buttonWymien.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {
                if(paladyn.getIloscKamieniPewnych()>=1&&paladyn.getIloscKamieni()>=1) {
                    kamienLubDiamnet(paladyn, v);
                }
                buttonWymien.setEnabled(false);
                buttonUlepsz.setEnabled(false);
                progressBar.setProgress(0);
                a=0;
                if(a!=10){
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(a==10&&(score==1||score==2))
                            {
                                this.cancel();
                            }
                            else {
                                a += 1;
                                progressBar.setProgress(a);
                            }


                        }

                        @Override
                        public void onFinish()
                        {

                            if(paladyn.getIloscKamieni()>=1&&paladyn.getIloscKamieniPewnych()>=1) {
                                Sklep.ulepszzaKamien(fail, succes, paladyn, paladynhp, v, textItemm, score);
                                Set.zmianaNazwSetu(paladyn, textBron, textZbroja);
                            }

                            if(paladyn.getIloscKamieni()>=1&&paladyn.getIloscKamieniPewnych()==0) {
                                Set.zmianaNazwSetu(paladyn, textBron, textZbroja);
                                Sklep.ulepszzaKamien(fail, succes, paladyn, paladynhp, v, textItemm, 1);
                            }
                            if(paladyn.getIloscKamieniPewnych()>=1&&paladyn.getIloscKamieni()==0) {
                                Sklep.ulepszzaKamien(fail, succes, paladyn, paladynhp, v, textItemm, 2);
//                            textBron.setText("Rózdzka +" + mag.getPoziomUlepszenia());
                                Set.zmianaNazwSetu(paladyn, textBron, textZbroja);
                            }
                            if(paladyn.hajs<=0)
                            {
                                buttonUlepsz.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepsz.setEnabled(true);
                            }

                            if(paladyn.iloscKamieniPewnych>=1||paladyn.iloscKamieni>=1)

                            {
                                buttonWymien.setEnabled(true);
                            }
                            else
                            {
                                buttonWymien.setEnabled(false);
                            }
                        }

                    }.start();

                }}
        });





        if(paladyn.hajs<=0)
        {
            buttonUlepszZbroje.setEnabled(false);
        }
        else
        {
            buttonUlepszZbroje.setEnabled(true);
        }
        if(paladyn.iloscKamieniPewnych>=1||paladyn.iloscKamieni>=1)

        {
            buttonWymienZbroje.setEnabled(true);
        }
        else
        {
            buttonWymienZbroje.setEnabled(false);
        }
        progressBarZbroja.setMax(9);
//        progressBar.setProgress(a);
        buttonUlepszZbroje.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {
                buttonUlepszZbroje.setEnabled(false);
                buttonWymienZbroje.setEnabled(false);
                progressBarZbroja.setProgress(0);
                b=0;
                if(b!=10){
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(b==10)
                            {
                                this.cancel();
                            }
                            else {
                                b += 1;
                                progressBarZbroja.setProgress(b);
                            }


                        }

                        @Override
                        public void onFinish()
                        {
                            if(paladyn.hajs<=0)
                            {
                                buttonUlepszZbroje.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepszZbroje.setEnabled(true);
                            }
                            Sklep.ulepszZbroje(failZbroja,succesZbroja,paladyn,paladynhp,v,textGold);
//                            textZbroja.setText("Zbroja +" + mag.getPoziomUlepszeniaZbroji());
                            Set.zmianaNazwSetu(paladyn,textBron,textZbroja);
                            if(paladyn.iloscKamieniPewnych>=1||paladyn.iloscKamieni>=1)

                            {
                                buttonWymienZbroje.setEnabled(true);
                            }
                            else
                            {
                                buttonWymienZbroje.setEnabled(false);
                            }

                        }

                    }.start();

                }}
        });

        buttonWymienZbroje.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {
                score=0;
                if(paladyn.getIloscKamieniPewnych()>=1&&paladyn.getIloscKamieni()>=1) {
                   kamienLubDiamnet(paladyn, v);
                }
                buttonWymienZbroje.setEnabled(false);
                buttonUlepszZbroje.setEnabled(false);
                progressBarZbroja.setProgress(0);
                b=0;

                if(b!=10){
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(b==10)
                            {
                                this.cancel();
                                score=0;
                            }
                            else if(b!=10) {

                                b += 1;
                                progressBarZbroja.setProgress(b);
                            }


                        }

                        @Override
                        public void onFinish()
                        {

                            if(score==0)
                            {
                                Snackbar.make(v,"Czas na decyzje minął, spróbuj jeszcze raz", Snackbar.LENGTH_LONG).show();
                            }

                            if(paladyn.getIloscKamieni()>=1&&paladyn.getIloscKamieniPewnych()>=1&&(score==1||score==2)) {

                                Sklep.ulepszzaKamienZbroje(failZbroja, succesZbroja, paladyn, paladynhp, v, textItemm, score);
                                Set.zmianaNazwSetu(paladyn, textBron, textZbroja);

                            }

                            if(paladyn.getIloscKamieni()>=1&&paladyn.getIloscKamieniPewnych()==0) {

                                Sklep.ulepszzaKamienZbroje(failZbroja, succesZbroja, paladyn, paladynhp, v, textItemm, 1);
                                Set.zmianaNazwSetu(paladyn, textBron, textZbroja);

                            }
                            if(paladyn.getIloscKamieniPewnych()>=1&&paladyn.getIloscKamieni()==0) {
                                Sklep.ulepszzaKamienZbroje(failZbroja, succesZbroja, paladyn, paladynhp, v, textItemm, 2);
//                            textBron.setText("Rózdzka +" + mag.getPoziomUlepszenia());
                                Set.zmianaNazwSetu(paladyn, textBron, textZbroja);

                            }
                            if(paladyn.iloscKamieniPewnych>=1||paladyn.iloscKamieni>=1)

                            {
                                buttonWymienZbroje.setEnabled(true);
                            }
                            else
                            {
                                buttonWymienZbroje.setEnabled(false);
                            }
                            if(paladyn.hajs>=150)
                            {
                                buttonUlepszZbroje.setEnabled(true);
                            }

                        }

                    }.start();

                }}
        });


    }
    public static void kamienLubDiamnet(Bohaterowie x, View v)
    {
        if(x.getIloscKamieni()>=1&&x.getIloscKamieniPewnych()>=1) {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
            alertDialogBuilder.setTitle("Dylemat");
            alertDialogBuilder.setMessage("Posiadasz Kamień i Diament, który z materiałów chcesz użyć do ulepszenia? ");

            alertDialogBuilder.setPositiveButton(("Kamień"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    score=1;
                }
            });
            alertDialogBuilder.setNegativeButton(("Diament"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    score=2;
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setIcon(R.drawable.ikonaograb);
            AlertDialog alertDialog = alertDialogBuilder.create();

            alertDialog.show();
        }
    }
}

