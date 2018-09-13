package pl.marcinos.expfor2.Paladyn.Menu;

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

import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladynhp;

public class PaladynPostacActivity extends AppCompatActivity {

    TextView textKlasa;
    TextView textLvl;
    TextView texthp;
    TextView textAtk;
    TextView textExp;
    TextView textStaty;
    TextView textStatyCrit;
    TextView textCrit;
    TextView textCritChance;
    ImageButton buttonAddCrit;
    TextView poziomUlepszeniaBroni;
    TextView poziomUlepszeniaZbroji;
    TextView textStatyhp;
    TextView textStatyatk;
    TextView textObrona;
    ImageButton buttonAddHp;
    ImageButton buttonAddAtk;
    ImageView image1;
    ImageView image2;
    ImageView image5;
    ImageView bron;
    ImageView zbroja;
    ImageView imageD;
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_postac);
        image1 = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView1);
        image5 = (ImageView) findViewById(R.id.imageView2);
        imageD = (ImageView) findViewById(R.id.imageView3);
        textObrona=(TextView)findViewById(R.id.textObrona);
        textObrona.setText("Twoja Obrona: "+paladyn.getObrona());

        Set.zmianaSetuWalkaIntSetD(paladyn,image1,image2,image5,imageD);


        poziomUlepszeniaBroni=(TextView)findViewById(R.id.poziomUlepzseniaBorni);
        poziomUlepszeniaBroni.setText("Miecze +"+paladyn.poziomUlepszenia);
        poziomUlepszeniaZbroji=(TextView)findViewById(R.id.poziomUlepszeniaZbroji);
        poziomUlepszeniaZbroji.setText("Zbroja +"+paladyn.poziomUlepszeniaZbroji);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


        bron=(ImageView)findViewById(R.id.bron);
        zbroja=(ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuPaladyn(paladyn,bron,zbroja);

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);
                login.setPoziomUlepszenia(paladyn.poziomUlepszenia);
                login.setHpbohater(paladyn.hpbohater);
                login.setAtkbohater(paladyn.atkbohater);
                login.setAtakcritical(paladyn.atakcritical);
                login.setDrop(paladyn.drop);
                login.setPoziomUlepszeniaZbroji(paladyn.poziomUlepszeniaZbroji);
                login.setPierscienVolda(paladyn.pierscienVolda);
                login.setNaszyjnikTorosa(paladyn.naszyjnikTorosa);
                login.setKolczykiLajamira(paladyn.kolczykiLajamira);
                login.setProfesja(paladyn.profesja);
                login.setObrona(paladyn.obrona);
                login.setExp(paladyn.exp);
                login.setLvl(paladyn.lvl);
                login.setHajs(paladyn.hajs);
                login.setOdlegloscKrytyczna(paladyn.odlegloscKrytyczna);
                login.setPunktyHonoru(paladyn.punktyHonoru);
                login.setQuest1(paladyn.quest1);
                login.setQuest2(paladyn.quest2);
                login.setQuest3(paladyn.quest3);
                login.setQuest4(paladyn.quest4);
                login.setQuest5(paladyn.quest5);
                login.setIloscZabitychPotworów(paladyn.iloscZabitychPotworów);

                login.setKlucz(paladyn.klucz);
                login.setOdlamek(paladyn.odlamek);
                login.setIloscKamieni(paladyn.getIloscKamieni());
                login.setIloscKamieniPewnych(paladyn.getIloscKamieni());
                login.setIloscMonumentow(paladyn.getIloscMonumentow());
                login.setIloscKluczy(paladyn.getIloscKluczy());
////                login.setNazwa(mag.nazwa);
//
//
                login.setSet(paladyn.set);
//
                login.setSett(paladyn.sett);

                login.setStaty(paladyn.staty);
                login.setStatyatk(paladyn.statyatk);
                login.setStatyhp(paladyn.statyhp);
                login.setStatyCrit(paladyn.statyCrit);
                login.setMaxhp(paladynhp.hpbohater);
                login.setMaxexp(paladynhp.exp);
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



        textKlasa.setText("Twoja Profesja: "+paladyn.getProfesja());
        texthp.setText("Twoje życie : "+ paladyn.hpbohater+"/"+PaladynMenuActivity.paladynhp.hpbohater);
        textAtk.setText("Twój atk : "+ paladyn.atkbohater);
        textLvl.setText("Twój lvl : "+ paladyn.lvl);
        textExp.setText("Twój exp : "+ paladyn.exp+"/"+ PaladynMenuActivity.paladynhp.exp);
        textStaty.setText("Punkty statystyk : "+ paladyn.staty);
        textStatyhp.setText(""+ paladyn.statyhp);
        textStatyatk.setText(""+ paladyn.statyatk);
        if(paladyn.szansaCrit >1) {
            textCritChance.setText("Critical Chance: " + paladyn.statyCrit / 2 + "0%");
        }
        else
        {
            textCritChance.setText("Critical Chance: 100%");
        }
        textCrit.setText("Critical Damage: "+paladyn.atakcritical/10+"%");
        textStaty.setText("Punkty statystyk : "+ paladyn.staty);
        textStatyCrit.setText(""+paladyn.statyCrit);

        buttonAddHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszHP(paladyn, PaladynMenuActivity.paladynhp,v,textStatyhp,texthp,textStaty);
            }
        });
        buttonAddAtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszAtk(paladyn, PaladynMenuActivity.paladynhp,v,textStatyatk,textAtk,textStaty);
            }
        });
        buttonAddCrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszCrit(paladyn, PaladynMenuActivity.paladynhp,v,textStatyCrit,textCritChance,textCrit,textStaty);
            }
        });

    }
}
