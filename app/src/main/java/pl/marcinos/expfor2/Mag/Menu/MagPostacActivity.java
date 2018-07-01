package pl.marcinos.expfor2.Mag.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Metody.Staty;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.maghp;

public class MagPostacActivity extends AppCompatActivity {


    TextView textKlasa;
    TextView textLvl;
    TextView texthp;
    TextView textAtk;
    TextView textExp;
    TextView textStatyCrit;
    TextView textCrit;
    TextView textCritChance;

    TextView textStaty;
    TextView textStatyhp;
    TextView textObrona;
    TextView textStatyatk;
    ImageButton buttonAddCrit;
    ImageButton buttonAddHp;
    ImageButton buttonAddAtk;
    FirebaseDatabase database;
     DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_postac);


        textObrona=(TextView)findViewById(R.id.textObrona);
        textObrona.setText("Twoja Obrona: "+mag.getObrona());

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User login =dataSnapshot.child(user123.getUserName()).getValue(User.class);

                login.setHpbohater(mag.hpbohater);
                login.setAtkbohater(mag.atkbohater);
                login.setAtakcritical(mag.atakcritical);
                login.setDrop(mag.drop);

                login.setObrona(mag.obrona);
                login.setExp(mag.exp);
                login.setLvl(mag.lvl);
                login.setHajs(mag.hajs);
              login.setOdlegloscKrytyczna(mag.odlegloscKrytyczna);
////                login.setNazwa(mag.nazwa);
//
//
               login.setSet(mag.set);
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


