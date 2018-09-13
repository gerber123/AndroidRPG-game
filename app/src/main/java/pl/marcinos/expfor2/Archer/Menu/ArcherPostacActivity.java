package pl.marcinos.expfor2.Archer.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.Metody.Staty;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;


import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

public class ArcherPostacActivity extends AppCompatActivity {

    TextView textKlasa;
    TextView textLvl;
    TextView texthp;
    ImageView bron;
    TextView textAtk;
    TextView textExp;
    TextView textStaty;
    TextView textStatyhp;
    TextView textStatyatk;
    TextView poziomUlepszeniaZbroji;

    ImageButton buttonAddHp;
    ImageButton buttonAddAtk;
    TextView textStatyCrit;
    TextView textCrit;
    TextView textCritChance;
    TextView poziomUlepszeniaBroni;
    TextView textObrona;
    ImageButton buttonAddCrit;
    FirebaseDatabase database;
    DatabaseReference users;
    ImageView image1;
    ImageView image2;
    ImageView set;
    ImageView image5;
    ImageView imageD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_postac);

        image1 = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView1);
        image5 = (ImageView) findViewById(R.id.imageView2);
        imageD = (ImageView) findViewById(R.id.imageView3);




        poziomUlepszeniaBroni=(TextView)findViewById(R.id.poziomUlepzseniaBorni);
        poziomUlepszeniaBroni.setText("Łuk +"+archer.poziomUlepszenia);
        poziomUlepszeniaZbroji=(TextView)findViewById(R.id.poziomUlepszeniaZbroji);
        poziomUlepszeniaZbroji.setText("Zbroja +"+archer.poziomUlepszeniaZbroji);

        textObrona=(TextView)findViewById(R.id.textObrona);
        textObrona.setText("Twoja Obrona: "+archer.getObrona());

        bron=(ImageView)findViewById(R.id.bron);

        set=(ImageView)findViewById(R.id.set);

        Set.zmianaGrafikiSetuArcher(archer,bron,set);


        Set.zmianaSetuWalkaIntSetD(archer,image1,image2,image5,imageD);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");



        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);

                login.setHpbohater(archer.hpbohater);
                login.setAtkbohater(archer.atkbohater);
                login.setAtakcritical(archer.atakcritical);
                login.setDrop(archer.drop);
                login.setPoziomUlepszenia(archer.poziomUlepszenia);
                login.setExp(archer.exp);
                login.setMana(archer.mana);
                login.setMaxMana(archer.maxMana);
                login.setLvl(archer.lvl);
                login.setHajs(archer.hajs);
                login.setOdlegloscKrytyczna(archer.odlegloscKrytyczna);
                login.setSett(archer.sett);
                login.setPunktyHonoru(archer.punktyHonoru);
                login.setKlucz(archer.klucz);
                login.setOdlamek(archer.odlamek);
                login.setProfesja(archer.profesja);
                login.setQuest1(archer.quest1);
                login.setQuest2(archer.quest2);
                login.setQuest3(archer.quest3);
                login.setQuest4(archer.quest4);
                login.setQuest5(archer.quest5);
                login.setPierscienVolda(archer.pierscienVolda);
                login.setNaszyjnikTorosa(archer.naszyjnikTorosa);
                login.setKolczykiLajamira(archer.kolczykiLajamira);
                login.setIloscZabitychPotworów(archer.iloscZabitychPotworów);
                login.setIloscKamieni(archer.getIloscKamieni());
                login.setIloscKamieniPewnych(archer.getIloscKamieni());
                login.setIloscMonumentow(archer.getIloscMonumentow());
                login.setIloscKluczy(archer.getIloscKluczy());
//
                login.setObrona(archer.obrona);
                login.setPoziomUlepszeniaZbroji(archer.poziomUlepszeniaZbroji);
//
                login.setSet(archer.set);
//

                login.setStaty(archer.staty);
                login.setStatyatk(archer.statyatk);
                login.setStatyhp(archer.statyhp);
                login.setStatyCrit(archer.statyCrit);
                login.setMaxhp(archerhp.hpbohater);
                login.setMaxexp(archerhp.exp);
//                login.setSkillDamage(mag.skillDamage);
                users.child(user123.getUserName()).setValue(login);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        textCrit = (TextView)findViewById(R.id.textCrit);
            textCritChance = (TextView)findViewById(R.id.textCritChance);
        textStatyCrit = (TextView)findViewById(R.id.textStatCrit);
        buttonAddCrit = (ImageButton)findViewById(R.id.buttonAddCrit);
            textKlasa = (TextView)findViewById(R.id.textKlasa);
            textLvl = (TextView)findViewById(R.id.textLvl);
            texthp = (TextView)findViewById(R.id.texthp);
            textAtk = (TextView)findViewById(R.id.textAtk);
            textExp = (TextView)findViewById(R.id.textExp);
            textStaty = (TextView)findViewById(R.id.textStaty);
            textStatyhp = (TextView)findViewById(R.id.textStatHp);
            textStatyatk = (TextView)findViewById(R.id.textStatAtk);

            buttonAddHp = (ImageButton)findViewById(R.id.buttonAddHP);
            buttonAddAtk = (ImageButton)findViewById(R.id.buttonAddAtk);



        textKlasa.setText("Twoja Profesja: "+archer.getProfesja());
            texthp.setText("Twoje życie : "+ archer.hpbohater+"/"+ archerhp.hpbohater);
            textAtk.setText("Twój atk : "+ archer.atkbohater);
            textLvl.setText("Twój lvl : "+ archer.lvl);
            textExp.setText("Twój exp : "+ archer.exp+"/"+ archerhp.exp);

            textCrit.setText("Critical Damage: "+archer.atakcritical/10+"%");
            textStaty.setText("Punkty statystyk : "+ archer.staty);
            textStatyhp.setText(""+ archer.statyhp);
            textStatyatk.setText(""+ archer.statyatk);
            textStatyCrit.setText(""+archer.statyCrit);
            if(archer.szansaCrit >1) {
                textCritChance.setText("Critical Chance: " + archer.statyCrit / 2 + "0%");
            }
            else
            {
                textCritChance.setText("Critical Chance: 100%");
            }



        buttonAddHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszHP(archer, archerhp,v,textStatyhp,texthp,textStaty);
            }
        });
        buttonAddAtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszAtk(archer, archerhp,v,textStatyatk,textAtk,textStaty);
            }
        });
        buttonAddCrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszCrit(archer, archerhp,v,textStatyCrit,textCritChance,textCrit,textStaty);
            }
        });


        }



}

