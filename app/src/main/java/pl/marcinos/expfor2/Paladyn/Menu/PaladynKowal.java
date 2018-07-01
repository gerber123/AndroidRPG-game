package pl.marcinos.expfor2.Paladyn.Menu;

import android.os.CountDownTimer;
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
    ImageView bron;
    ImageView zbroja;
    public static int a=0;
    public static int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_kowal);
        textGold = (TextView) findViewById(R.id.textGoldd);
        textItemm = (TextView) findViewById(R.id.textItemm);
        textBron = (TextView) findViewById(R.id.textBron);
        succes = (ImageView) findViewById(R.id.success);
        fail = (ImageView) findViewById(R.id.fail);
        textGold.setText("Twoje złoto: " + paladyn.hajs);
        textItemm.setText("Twoje itemy: " + paladyn.drop);
//        textBron.setText("Miecze +" + paladyn.getPoziomUlepszenia());
        progressBar=(ProgressBar)findViewById(R.id.progressHpP);
//        progressBar=(ProgressBar)findViewById(R.id.progressHpP);
        View v =this.findViewById(android.R.id.content).getRootView();

        buttonUlepsz = (Button) findViewById(R.id.buttonUlepsz);
        buttonWymien = (Button) findViewById(R.id.buttonWymien);

        textZbroja = (TextView) findViewById(R.id.textZbroja);
        succesZbroja = (ImageView) findViewById(R.id.successzbroja);
        failZbroja = (ImageView) findViewById(R.id.failzbroja);


        progressBarZbroja=(ProgressBar)findViewById(R.id.progressHpZbroja);

        buttonUlepszZbroje = (Button) findViewById(R.id.buttonUlepszZbroje);
        buttonWymienZbroje = (Button) findViewById(R.id.buttonWymienZbroje);

        bron=(ImageView)findViewById(R.id.bron);
        zbroja=(ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuPaladyn(paladyn,bron,zbroja);

//        textZbroja.setText("Zbroja +" + paladyn.getPoziomUlepszeniaZbroji());
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        Set.zmianaNazwSetu(paladyn,textBron,textZbroja);

        if(paladyn.hajs<=0)
        {
            buttonUlepsz.setEnabled(false);
        }
        else
        {
            buttonUlepsz.setEnabled(true);
        }
        if(paladyn.drop.equalsIgnoreCase("kamien")||paladyn.drop.equalsIgnoreCase("kamienPewny"))
        {
            buttonWymien.setEnabled(true);
            buttonWymienZbroje.setEnabled(true);
        }
        else
        {
            buttonWymien.setEnabled(false);
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
//                        buttonWymien.setEnabled(true);
//                        buttonUlepsz.setEnabled(true);
                            if(paladyn.hajs<=0)
                            {
                                buttonUlepsz.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepsz.setEnabled(true);
                            }
                            Sklep.ulepsz(fail,succes,paladyn,paladynhp,v,textGold);
                            Set.zmianaNazwSetu(paladyn,textBron,textZbroja);
//                            textBron.setText("Miecze +" + paladyn.getPoziomUlepszenia());
                            if(paladyn.drop.equalsIgnoreCase("kamien")||paladyn.drop.equalsIgnoreCase("kamienPewny"))
                            {
                                buttonWymien.setEnabled(true);
                            }
                            else
                            {
                                buttonWymien.setEnabled(false);
                            }
//                        users.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot dataSnapshot)
//                            {
//                                User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);
//                                login.setPoziomUlepszenia(archer.poziomUlepszenia);
////                                login.setHpbohater(archer.hpbohater);
//                                login.setHajs(archer.hajs);
//                                login.setAtkbohater(archer.atkbohater);
////                                login.setSett(archer.sett);
//                                login.setDrop(archer.drop);
////                                login.setPoziomUlepszeniaZbroji(archer.poziomUlepszeniaZbroji);
//
//
//                                users.child(user123.getUserName()).setValue(login);
//                            }
//
//                            @Override
//                            public void onCancelled(DatabaseError databaseError) {
//
//                            }
//                        });
                        }

                    }.start();

                }}
        });

        buttonWymien.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {

                buttonWymien.setEnabled(false);
                buttonUlepsz.setEnabled(false);
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


                            Sklep.ulepszzaKamien(fail,succes,paladyn,paladynhp,v,textItemm);
//                            textBron.setText("Miecze +" + paladyn.getPoziomUlepszenia());
                            Set.zmianaNazwSetu(paladyn,textBron,textZbroja);
                            if(paladyn.hajs<=0)
                            {
                                buttonUlepsz.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepsz.setEnabled(true);
                            }
                            if(paladyn.drop.equalsIgnoreCase("kamien")||paladyn.drop.equalsIgnoreCase("kamienPewny"))
                            {
                                buttonWymien.setEnabled(true);
                                buttonWymienZbroje.setEnabled(true);
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
        if(paladyn.drop.equalsIgnoreCase("kamien")||paladyn.drop.equalsIgnoreCase("kamienPewny"))
        {

            buttonWymien.setEnabled(true);
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
                            Set.zmianaNazwSetu(paladyn,textBron,textZbroja);
//
//                            extZbroja.setText("Zbroja +" + paladyn.getPoziomUlepszeniaZbroji());
                            if(paladyn.drop.equalsIgnoreCase("kamien")||paladyn.drop.equalsIgnoreCase("kamienPewny"))
                            {
                                buttonWymienZbroje.setEnabled(true);
                            }
                            else
                            {
                                buttonWymienZbroje.setEnabled(false);
                            }
//                            users.addValueEventListener(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(DataSnapshot dataSnapshot)
//                                {
//                                    User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);
////                                    login.setPoziomUlepszenia(archer.poziomUlepszenia);
////                                    login.setHpbohater(archer.hpbohater);
//                                    login.setHajs(archer.hajs);
////                                    login.setAtkbohater(archer.atkbohater);
////                                    login.setSett(archer.sett);
//                                    login.setDrop(archer.drop);
//                                    login.setPoziomUlepszeniaZbroji(archer.poziomUlepszeniaZbroji);
//
//
//                                    users.child(user123.getUserName()).setValue(login);
//                                }
//
//                                @Override
//                                public void onCancelled(DatabaseError databaseError) {
//
//                                }
//                            });
                        }

                    }.start();

                }}
        });

        buttonWymienZbroje.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {

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
                            }
                            else {
                                b += 1;
                                progressBarZbroja.setProgress(b);
                            }


                        }

                        @Override
                        public void onFinish()
                        {
//                            buttonUlepsz.setEnabled(true);
//                            buttonWymien.setEnabled(true);

                            Sklep.ulepszzaKamienZbroje(failZbroja,succesZbroja,paladyn,paladynhp,v,textItemm);
//                            textZbroja.setText("Zbroja +" + paladyn.getPoziomUlepszeniaZbroji());
                            Set.zmianaNazwSetu(paladyn,textBron,textZbroja);
                            if(paladyn.hajs<=0)
                            {
                                buttonUlepszZbroje.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepszZbroje.setEnabled(true);
                            }
                            if(paladyn.drop.equalsIgnoreCase("kamien")||paladyn.drop.equalsIgnoreCase("kamienPewny"))
                            {
                                buttonWymienZbroje.setEnabled(true);
                            }
                            else
                            {
                                buttonWymienZbroje.setEnabled(false);
                            }
//                            users.addValueEventListener(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(DataSnapshot dataSnapshot)
//                                {
//                                    User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);
////                                    login.setPoziomUlepszenia(archer.poziomUlepszenia);
////                                    login.setHpbohater(archer.hpbohater);
//                                    login.setHajs(archer.hajs);
////                                    login.setAtkbohater(archer.atkbohater);
////                                    login.setSett(archer.sett);
//                                    login.setDrop(archer.drop);
//                                    login.setPoziomUlepszeniaZbroji(archer.poziomUlepszeniaZbroji);
//
//
//                                    users.child(user123.getUserName()).setValue(login);
//                                }
//
//                                @Override
//                                public void onCancelled(DatabaseError databaseError) {
//
//                                }
//                            });
                        }

                    }.start();

                }}
        });


    }
}
