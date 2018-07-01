package pl.marcinos.expfor2.IntroActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Model.CurrentUser;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladynhp;

public class LoginActivity extends AppCompatActivity {
Button buttonWejdz;
Button buttonWyjdz;
Button buttonWczytaj;
Button wczytaj;



        static MaterialEditText edtNewUser;
        MaterialEditText edtNewPassword;
        MaterialEditText edtNewEmail;
        MaterialEditText edtNewBohater;

        MaterialEditText edtUser, edtPassword;

        Button btnSignUp, btnSignIn;
    public static CurrentUser user123 = new CurrentUser();

        FirebaseDatabase database;
        DatabaseReference users;
        ImageView czaszka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        czaszka=(ImageView)findViewById(R.id.czacha);
        startAnim(czaszka);

        //FireBase

            database=FirebaseDatabase.getInstance();
            users=database.getReference("Users");

            edtUser=(MaterialEditText)findViewById(R.id.edtUserName);
            edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);


            btnSignIn=(Button)findViewById(R.id.btn_sign_in);
            btnSignUp=(Button)findViewById(R.id.btn_sign_up);


            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    showSignUpDialog();
                    Intent intent = new Intent(LoginActivity.this,SignUp.class);
                    startActivity(intent);
                }
            });
            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signIn(edtUser.getText().toString(),edtPassword.getText().toString());
                }
            });

        }

    private void signIn(final String user, final String pwd)
    {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(user).exists())
                {
                    if(!user.isEmpty())
                    {
                        User login =dataSnapshot.child(user).getValue(User.class);

                        if(login.getPassword().equals(pwd)) {

                            Toast.makeText(LoginActivity.this, "Zalogowales sie !", Toast.LENGTH_SHORT).show();

                            user123.setUserName(user);
                            user123.setEmail(login.getEmail());
                            user123.setPassword(login.getPassword());
                            user123.setVoteScore(login.getVoteScore());



                            if(login.bohater.equalsIgnoreCase("mag")) {
                                mag.setHpbohater(login.hpbohater);
                                mag.setAtkbohater(login.atkbohater);
                                mag.setAtakcritical(login.atakcritical);
                                mag.setDrop(login.drop);
                                mag.setPunktyHonoru(login.getPunktyHonoru());
                                mag.setObrona(login.getObrona());
                                mag.setQuest1(login.getQuest1());
                                mag.setQuest2(login.getQuest2());
                                mag.setQuest3(login.getQuest3());
                                mag.setQuest4(login.getQuest4());
                                mag.setQuest5(login.getQuest5());
                                mag.setQuest6(login.getQuest6());


                                mag.setExp(login.exp);
                                mag.setLvl(login.lvl);
                                mag.setHajs(login.hajs);
                                mag.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                                mag.setNazwa(login.nazwa);
                                maghp.setNazwa(login.nazwa);

                                mag.setSet(login.set);
                                mag.setSzansaCrit(login.szansaCrit);
                                mag.setSkillDamage(login.skillDamage);
                                mag.setStaty(login.staty);
                                mag.setStatyatk(login.statyatk);
                                mag.setStatyhp(login.statyhp);
                                mag.setStatyCrit(login.statyCrit);


                                maghp.setAtakcritical(login.maxhp);
                                maghp.setDrop(login.drop);
                                mag.setSett(login.sett);
                                maghp.setExp(login.maxexp);
                                maghp.setLvl(login.lvl);
                                maghp.setHajs(login.hajs);
                                maghp.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                                mag.setKlucz(login.klucz);
                                maghp.setHpbohater(login.maxhp);
                                maghp.setExp(login.maxexp);
                                mag.setMaxexp(login.maxexp);
                                mag.setMaxhp(login.maxhp);
                                mag.setPoziomUlepszenia(login.getPoziomUlepszenia());
                                mag.setPoziomUlepszeniaZbroji(login.poziomUlepszeniaZbroji);
                                maghp.setSet(login.set);
                                maghp.setSkillDamage(login.skillDamage);
                                maghp.setStaty(login.staty);
                                maghp.setStatyatk(login.statyatk);
                                maghp.setStatyhp(login.statyhp);
                                maghp.setStatyCrit(login.statyCrit);
                                mag.setOdlamek(login.odlamek);
                                mag.setIloscZabitychPotworów(login.getIloscZabitychPotworów());

                                Intent intent = new Intent(LoginActivity.this, MagMenuActivity.class);
                                startActivity(intent);
                                LoginActivity.this.finish();

                            }
                            else if(login.bohater.equalsIgnoreCase("archer")) {
                                archer.setHpbohater(login.hpbohater);
                                archer.setAtkbohater(login.atkbohater);
                                archer.setAtakcritical(login.atakcritical);
                                archer.setDrop(login.drop);
                                archer.setSett(login.sett);
                                archer.setExp(login.exp);
                                archer.setLvl(login.lvl);
                                archer.setHajs(login.hajs);
                                archer.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                                archer.setNazwa(login.nazwa);
                                archerhp.setNazwa(login.nazwa);
                                archer.setPunktyHonoru(login.getPunktyHonoru());
//                                archer.setOnline(1);
                                archer.setObrona(login.getObrona());
                                archer.setSet(login.set);
                                archer.setKlucz(login.klucz);
                                archer.setSzansaCrit(login.szansaCrit);

                                archer.setSkillDamage(login.skillDamage);
                                archer.setStaty(login.staty);
                                archer.setStatyatk(login.statyatk);
                                archer.setStatyhp(login.statyhp);
                                archer.setStatyCrit(login.statyCrit);
                                archer.setPoziomUlepszeniaZbroji(login.poziomUlepszeniaZbroji);
//                            maghp.setHpbohater(login.hpbohater);
//                            maghp.setAtkbohater(login.atkbohater);
                                archerhp.setAtakcritical(login.maxhp);
                                archerhp.setDrop(login.drop);
                                archer.setPoziomUlepszenia(login.getPoziomUlepszenia());
                                archerhp.setHpbohater(login.maxhp);
                                archerhp.setExp(login.maxexp);
                                archerhp.setExp(login.maxexp);
                                archerhp.setLvl(login.lvl);
                                archerhp.setHajs(login.hajs);
                                archerhp.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                                archerhp.setHpbohater(login.maxhp);
                                archerhp.setExp(login.maxexp);
                                archer.setMaxexp(login.maxexp);
                                archer.setMaxhp(login.maxhp);
                                archerhp.setSet(login.set);
                                archerhp.setSkillDamage(login.skillDamage);
                                archerhp.setStaty(login.staty);
                                archerhp.setStatyatk(login.statyatk);
                                archerhp.setStatyhp(login.statyhp);
                                archerhp.setStatyCrit(login.statyCrit);
                                archer.setOdlamek(login.odlamek);
                                archer.setQuest1(login.getQuest1());
                                archer.setQuest2(login.getQuest2());
                                archer.setQuest3(login.getQuest3());
                                archer.setQuest4(login.getQuest4());
                                archer.setQuest5(login.getQuest5());
                                archer.setQuest6(login.getQuest6());
                                archer.setIloscZabitychPotworów(login.getIloscZabitychPotworów());
                                Intent intent = new Intent(LoginActivity.this, ArcherMenuActivity.class);
                                startActivity(intent);
                                LoginActivity.this.finish();

                            }
                            else if(login.bohater.equalsIgnoreCase("paladyn")) {
                                paladyn.setAtakcritical(login.atakcritical);
                                paladyn.setHpbohater(login.hpbohater);
                                paladyn.setAtkbohater(login.atkbohater);

                                paladyn.setSzansaCrit(login.szansaCrit);

                                paladyn.setDrop(login.drop);
                                paladyn.setPunktyHonoru(login.getPunktyHonoru());
                                paladyn.setPoziomUlepszenia(login.getPoziomUlepszenia());
                                paladyn.setMaxexp(login.maxexp);
                                paladyn.setMaxhp(login.maxhp);
                                paladyn.setExp(login.exp);
                                paladyn.setLvl(login.lvl);
                                paladyn.setHajs(login.hajs);
                                paladyn.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                                paladyn.setNazwa(login.nazwa);
                                paladynhp.setNazwa(login.nazwa);
                                paladyn.setObrona(login.getObrona());
                                paladyn.setSet(login.set);
                                paladyn.setSett(login.sett);
                                paladyn.setSkillDamage(login.skillDamage);
                                paladyn.setStaty(login.staty);
                                paladyn.setStatyatk(login.statyatk);
                                paladyn.setStatyhp(login.statyhp);
                                paladyn.setStatyCrit(login.statyCrit);
                                paladyn.setKlucz(login.klucz);
//                            maghp.setHpbohater(login.hpbohater);
//                            maghp.setAtkbohater(login.atkbohater);
                                paladynhp.setAtakcritical(login.maxhp);
                                paladynhp.setDrop(login.drop);
                                paladynhp.setHpbohater(login.maxhp);
                                paladynhp.setExp(login.maxexp);
                                paladyn.setQuest1(login.getQuest1());
                                paladyn.setQuest2(login.getQuest2());
                                paladyn.setQuest3(login.getQuest3());
                                paladyn.setQuest4(login.getQuest4());
                                paladyn.setQuest5(login.getQuest5());
                                paladyn.setQuest6(login.getQuest6());

                                paladyn.setIloscZabitychPotworów(login.getIloscZabitychPotworów());
                                paladynhp.setLvl(login.lvl);
                                paladynhp.setHajs(login.hajs);
                                paladynhp.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                                paladyn.setPoziomUlepszeniaZbroji(login.poziomUlepszeniaZbroji);
                                paladyn.setOdlamek(login.odlamek);
                                paladynhp.setSet(login.set);
                                paladynhp.setSkillDamage(login.skillDamage);
                                paladynhp.setStaty(login.staty);
                                paladynhp.setStatyatk(login.statyatk);
                                paladynhp.setStatyhp(login.statyhp);
                                paladynhp.setStatyCrit(login.statyCrit);

                                Intent intent = new Intent(LoginActivity.this, PaladynMenuActivity.class);
                                startActivity(intent);
                                LoginActivity.this.finish();

                            }
                            else
                            {

                            }




                        }

                        else
                            Toast.makeText(LoginActivity.this,"Złe hasło",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Proszę wypełnic wszystkie pola",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Niema takiego użytkownika",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showSignUpDialog()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Rejestracja");
        alertDialog.setMessage("Prosze wypełnić wszystkie pola");


        LayoutInflater inflater =this.getLayoutInflater();
        View sign_up_layout=inflater.inflate(R.layout.sign_up_layout,null);


        edtNewUser=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewUserName);
        edtNewPassword=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewPassword);
        edtNewEmail=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewEmail);
        edtNewBohater=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewBohater);

        alertDialog.setView(sign_up_layout);


        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.setPositiveButton("Stwórz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final User user=new User(edtNewUser.getText().toString(),edtNewPassword.getText().toString()
                        ,edtNewEmail.getText().toString(),edtNewBohater.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUserName()).exists())
                        {
                            Toast.makeText(LoginActivity.this,"Taki użytkownik już istnieje", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            users.child(user.getUserName())
                                    .setValue(user);
                            user123.setUserName(user.getUserName());
                            user123.setPassword(user.getPassword());
                            user123.setEmail(user.getEmail());
                            user123.setVoteScore(user.getVoteScore());

                            if(edtNewBohater.equals("archer"))
                            {
                                users.child(user123.getUserName()).setValue(archer);
                            }
                            else if(edtNewBohater.equals("paladyn"))
                            {
                                users.child(user123.getUserName()).setValue(paladyn);
                            }
                            else if(edtNewBohater.equals("mag"))
                            {
                                users.child(user123.getUserName()).setValue(mag);
                            }
//                            users.child(user.getUserName()).setValue(edtNewUser.getText().toString());
                            Toast.makeText(LoginActivity.this,"Utworzono Konto",Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                dialog.dismiss();
            }
        });

        alertDialog.show();

    }
    private void startAnim(final ImageView logo)
    {
        Animation scale = new ScaleAnimation(1f,1.2f,1f,1.2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


        scale.setDuration(2000);
        scale.setFillAfter(true);
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                startAnim2(logo);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo.startAnimation(scale);

    }
    private void startAnim2(final ImageView logo)
    {
        Animation scale = new ScaleAnimation(1.2f,1f,1.2f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


        scale.setDuration(2000);
        scale.setFillAfter(true);
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                startAnim(logo);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo.startAnimation(scale);
    }
}