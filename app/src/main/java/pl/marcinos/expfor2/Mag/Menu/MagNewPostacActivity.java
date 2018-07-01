package pl.marcinos.expfor2.Mag.Menu;

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
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;

public class MagNewPostacActivity extends AppCompatActivity {
    ImageView image1;
    ImageView image2;
    ImageView image5;
    TextView textKlasa;
    TextView textLvl;
    TextView texthp;
    TextView textAtk;
    TextView textExp;
    TextView textCrit;
    TextView textCritChance;

    ImageButton buttonAddCrit;
    ImageButton buttonAddHp;
    ImageButton buttonAddAtk;
    TextView textStaty;
    TextView textObrona;
    TextView textStatyhp;
    TextView textStatyCrit;
    TextView textStatyatk;
    TextView poziomUlepszeniaBroni;
    TextView poziomUlepszeniaZbroji;
    FirebaseDatabase database;
    DatabaseReference users;
    ImageView imageD;
    ImageView bron;
    ImageView zbroja;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mag_new_postac);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        image1 = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView1);
        image5 = (ImageView) findViewById(R.id.imageView2);
        imageD = (ImageView) findViewById(R.id.imageView3);

        Set.zmianaSetuWalkaIntSetD(mag,image1,image2,image5,imageD);

        poziomUlepszeniaBroni=(TextView)findViewById(R.id.poziomUlepzseniaBorni);
        poziomUlepszeniaBroni.setText("Różdka +"+mag.poziomUlepszenia);
        poziomUlepszeniaZbroji=(TextView)findViewById(R.id.poziomUlepszeniaZbroji);
        poziomUlepszeniaZbroji.setText("Zbroja +"+mag.poziomUlepszeniaZbroji);



        textObrona=(TextView)findViewById(R.id.textObrona);
        textObrona.setText("Twoja Obrona: "+mag.getObrona());

        bron=(ImageView)findViewById(R.id.bron);
        zbroja=(ImageView)findViewById(R.id.zbroja);
        Set.zmianaGrafikiSetuWizard(mag,bron,zbroja);

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);

                login.setHpbohater(mag.hpbohater);
                login.setAtkbohater(mag.atkbohater);
                login.setAtakcritical(mag.atakcritical);
                login.setDrop(mag.drop);
                login.setPoziomUlepszenia(mag.poziomUlepszenia);
                login.setExp(mag.exp);
                login.setLvl(mag.lvl);
                login.setHajs(mag.hajs);
                login.setOdlegloscKrytyczna(mag.odlegloscKrytyczna);
                login.setPunktyHonoru(mag.punktyHonoru);
                login.setKlucz(mag.klucz);
                login.setOdlamek(mag.odlamek);
                login.setObrona(mag.obrona);
                login.setQuest1(mag.quest1);
                login.setQuest2(mag.quest2);
                login.setQuest3(mag.quest3);
                login.setQuest4(mag.quest4);
                login.setQuest5(mag.quest5);
                login.setIloscZabitychPotworów(mag.iloscZabitychPotworów);
////                login.setNazwa(mag.nazwa);ob
//
//
                login.setSet(mag.set);
                login.setPoziomUlepszeniaZbroji(mag.poziomUlepszeniaZbroji);
//

                login.setStaty(mag.staty);
                login.setSett(mag.sett);
                login.setStatyatk(mag.statyatk);
                login.setStatyhp(mag.statyhp);
                login.setStatyCrit(mag.statyCrit);
                login.setMaxhp(maghp.hpbohater);
                login.setMaxexp(maghp.exp);
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
        textStatyhp = (TextView)findViewById(R.id.textStatHp);
        textStatyatk = (TextView)findViewById(R.id.textStatAtk);
        textKlasa = (TextView)findViewById(R.id.textKlasa);
        textLvl = (TextView)findViewById(R.id.textLvl);
        texthp = (TextView)findViewById(R.id.texthp);
        textAtk = (TextView)findViewById(R.id.textAtk);
        textExp = (TextView)findViewById(R.id.textExp);
        textStaty = (TextView)findViewById(R.id.textStaty);

        buttonAddHp = (ImageButton)findViewById(R.id.buttonAddHP);
        buttonAddAtk = (ImageButton)findViewById(R.id.buttonAddAtk);
        buttonAddCrit = (ImageButton)findViewById(R.id.buttonAddCrit);

        textKlasa.setText("Twoja klasa : Mag");
        texthp.setText("Twoje życie : "+ mag.hpbohater+"/"+ maghp.hpbohater);
        textAtk.setText("Twój atk : "+ mag.atkbohater);
        textLvl.setText("Twój lvl : "+ mag.lvl);
        textExp.setText("Twój exp : "+ mag.exp+"/"+ maghp.exp);
        textStaty.setText("Punkty statystyk : "+ mag.staty);
        textStatyhp.setText(""+ mag.statyhp);
        textStatyatk.setText(""+ mag.statyatk);
        textStatyCrit.setText(""+ mag.statyCrit);
        if(mag.szansaCrit >1) {
            textCritChance.setText("Critical Chance: " + mag.statyCrit / 2 + "0%");
        }
        else
        {
            textCritChance.setText("Critical Chance: 100%");
        }
        textCrit.setText("Critical Damage: "+mag.atakcritical/10+"%");
        textStaty.setText("Punkty statystyk : "+ mag.staty);

        textStatyCrit.setText(""+mag.statyCrit);


        buttonAddHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszHP(mag, MagMenuActivity.maghp,v,textStatyhp,texthp,textStaty);
            }
        });
        buttonAddAtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszAtk(mag, MagMenuActivity.maghp,v,textStatyatk,textAtk,textStaty);
            }
        });
        buttonAddCrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Staty.zwiekszCrit(mag, MagMenuActivity.maghp,v,textStatyCrit,textCritChance,textCrit,textStaty);
            }
        });

    }
}



//    private void showSignUpDialog()
//    {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MagNewPostacActivity.this);
//        alertDialog.setTitle("Głosowanie");
//        alertDialog.setMessage("Zaznacz swoja ocene");
//
//
//        LayoutInflater inflater =this.getLayoutInflater();
//        View rozdaj_staty=inflater.inflate(R.layout.activity_rozdaj_staty,null);
//
//        buttonAddHp = (ImageButton)rozdaj_staty.findViewById(R.id.buttonAddHP);
//        buttonAddAtk = (ImageButton)rozdaj_staty.findViewById(R.id.buttonAddAtk);
//        buttonAddCrit = (ImageButton)rozdaj_staty.findViewById(R.id.buttonAddCrit);
//        textStaty=(TextView)rozdaj_staty.findViewById(R.id.textStaty);
//        textStatyCrit = (TextView)rozdaj_staty.findViewById(R.id.textStatCrit);
//        textStatyhp = (TextView)rozdaj_staty.findViewById(R.id.textStatHp);
//        textStatyatk = (TextView)rozdaj_staty.findViewById(R.id.textStatAtk);
//
//
//        alertDialog.setView(rozdaj_staty);
//        buttonAddHp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Staty.zwiekszHP(mag, MagMenuActivity.maghp,v,textStatyhp,texthp,textStaty);
//            }
//        });
//        buttonAddAtk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Staty.zwiekszAtk(mag, MagMenuActivity.maghp,v,textStatyatk,textAtk,textStaty);
//            }
//        });
//        buttonAddCrit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Staty.zwiekszCrit(mag, MagMenuActivity.maghp,v,textStatyCrit,textCritChance,textCrit,textStaty);
//            }
//        });
//        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        alertDialog.setPositiveButton("Zatwierdź", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//            dialog.dismiss();
//
//
//
//
//
//                Toast.makeText(getApplicationContext(),"Dziękuje za głos",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alertDialog.show();
//
//    }
