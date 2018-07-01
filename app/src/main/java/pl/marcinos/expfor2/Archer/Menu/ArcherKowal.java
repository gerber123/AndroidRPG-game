package pl.marcinos.expfor2.Archer.Menu;

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

import pl.marcinos.expfor2.Metody.AnimacjaPrzeciwnika;
import pl.marcinos.expfor2.Metody.AnimacjaPrzegranej;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Sklep;
import pl.marcinos.expfor2.Metody.Walka;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

public class ArcherKowal extends AppCompatActivity {
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
ImageView imageUlepszenie;
ImageView set;
    FirebaseDatabase database;
    DatabaseReference users;
    public static int a=0;
    public static int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_kowal);
        textGold = (TextView) findViewById(R.id.textGoldd);
        textItemm = (TextView) findViewById(R.id.textItemm);
        textBron = (TextView) findViewById(R.id.textBron);
        succes = (ImageView) findViewById(R.id.success);
        fail = (ImageView) findViewById(R.id.fail);

        textGold.setText("Twoje złoto: " + archer.hajs);
        textItemm.setText("Twoje itemy: " + archer.drop);
//        textBron.setText("Łuk +" + archer.getPoziomUlepszenia());
        progressBar=(ProgressBar)findViewById(R.id.progressHpP);
//        progressBar=(ProgressBar)findViewById(R.id.progressHpP);
        View v =this.findViewById(android.R.id.content).getRootView();

        buttonUlepsz = (Button) findViewById(R.id.buttonUlepsz);
        buttonWymien = (Button) findViewById(R.id.buttonWymien);

        textZbroja = (TextView) findViewById(R.id.textZbroja);
        succesZbroja = (ImageView) findViewById(R.id.successzbroja);
        failZbroja = (ImageView) findViewById(R.id.failzbroja);
        set=(ImageView)findViewById(R.id.set);
        imageUlepszenie=(ImageView)findViewById(R.id.itemUlepszenie);
        Set.zmianaGrafikiSetuArcher(archer,imageUlepszenie,set);

//        textZbroja.setText("Zbroja +" + archer.getPoziomUlepszeniaZbroji());
        progressBarZbroja=(ProgressBar)findViewById(R.id.progressHpZbroja);

        buttonUlepszZbroje = (Button) findViewById(R.id.buttonUlepszZbroje);
        buttonWymienZbroje = (Button) findViewById(R.id.buttonWymienZbroje);
        Set.zmianaNazwSetu(archer,textBron,textZbroja);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


        if(archer.hajs<=0)
        {
            buttonUlepsz.setEnabled(false);
        }
        else
        {
            buttonUlepsz.setEnabled(true);
        }
        if(archer.drop.equalsIgnoreCase("kamien")||archer.drop.equalsIgnoreCase("kamienPewny"))
        {
            buttonWymien.setEnabled(true);
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
                        if(archer.hajs<=0)
                        {
                            buttonUlepsz.setEnabled(false);
                        }
                        else
                        {
                            buttonUlepsz.setEnabled(true);
                        }
                        Sklep.ulepsz(fail,succes,archer,archerhp,v,textGold);
//                        textBron.setText("Łuk +" + archer.getPoziomUlepszenia());
                        Set.zmianaNazwSetu(archer,textBron,textZbroja);
                        if(archer.drop.equalsIgnoreCase("kamien")||archer.drop.equalsIgnoreCase("kamienPewny"))
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


                            Sklep.ulepszzaKamien(fail,succes,archer,archerhp,v,textItemm);
//                            textBron.setText("Łuk +" + archer.getPoziomUlepszenia());
                            Set.zmianaNazwSetu(archer,textBron,textZbroja);
                            if(archer.hajs<=0)

                            {
                                buttonUlepsz.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepsz.setEnabled(true);
                            }
                            if(archer.drop.equalsIgnoreCase("kamien")||archer.drop.equalsIgnoreCase("kamienPewny"))
                            {
                                buttonWymien.setEnabled(true);
                            }
                            else
                            {
                                buttonWymien.setEnabled(false);
                            }
//                            users.addValueEventListener(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(DataSnapshot dataSnapshot)
//                                {
//                                    User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);
//                                    login.setPoziomUlepszenia(archer.poziomUlepszenia);
////                                    login.setHpbohater(archer.hpbohater);
//                                    login.setHajs(archer.hajs);
//                                    login.setAtkbohater(archer.atkbohater);
////                                    login.setSett(archer.sett);
//                                    login.setDrop(archer.drop);
////                                    login.setPoziomUlepszeniaZbroji(archer.poziomUlepszeniaZbroji);
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



        if(archer.hajs<=0)
        {
            buttonUlepszZbroje.setEnabled(false);
        }
        else
        {
            buttonUlepszZbroje.setEnabled(true);
        }
        if(archer.drop.equalsIgnoreCase("kamien")||archer.drop.equalsIgnoreCase("kamienPewny"))
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
//                        buttonWymien.setEnabled(true);
//                        buttonUlepsz.setEnabled(true);
                            if(archer.hajs<=0)
                            {
                                buttonUlepszZbroje.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepszZbroje.setEnabled(true);
                            }
                            Sklep.ulepszZbroje(failZbroja,succesZbroja,archer,archerhp,v,textGold);
//                            textZbroja.setText("Zbroja +" + archer.getPoziomUlepszeniaZbroji());
                            Set.zmianaNazwSetu(archer,textBron,textZbroja);
                            if(archer.drop.equalsIgnoreCase("kamien")||archer.drop.equalsIgnoreCase("kamienPewny"))
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

                            Sklep.ulepszzaKamienZbroje(failZbroja,succesZbroja,archer,archerhp,v,textItemm);
//                            textZbroja.setText("Zbroja +" + archer.getPoziomUlepszeniaZbroji());
                            Set.zmianaNazwSetu(archer,textBron,textZbroja);
                            if(archer.hajs<=0)
                            {
                                buttonUlepszZbroje.setEnabled(false);
                            }
                            else
                            {
                                buttonUlepszZbroje.setEnabled(true);
                            }
                            if(archer.drop.equalsIgnoreCase("kamien")||archer.drop.equalsIgnoreCase("kamienPewny"))
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
