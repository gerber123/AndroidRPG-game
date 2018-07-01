package pl.marcinos.expfor2.Paladyn.superWalka.Pvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.marcinos.expfor2.Archer.Menu.AdapterFinal;
import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherArcher;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherMag;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPaladyn;
import pl.marcinos.expfor2.Archer.Walka.Pvp.ArcherPvpRanking;
import pl.marcinos.expfor2.Bohaterowie.Paladyn;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Potwory.PvpPrzeciwnik;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

public class PaladynPvpRanking extends AppCompatActivity {
    DatabaseReference uzytkownicy;
    FirebaseDatabase database;
    DatabaseReference users;
    ListView listt;
    public static PvpPrzeciwnik przeciwnikpvp = new PvpPrzeciwnik();
    public static PvpPrzeciwnik przeciwnikpvphp = new PvpPrzeciwnik();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_pvp_ranking);

        listt = (ListView)findViewById(R.id.myListt);
        final List<User> UzytkownicyList=new ArrayList<>();
        database=FirebaseDatabase.getInstance();



        uzytkownicy=database.getReference("Users");

        uzytkownicy.orderByChild("lvl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                UzytkownicyList.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    User modeleczka = postSnapshot.getValue(User.class);

                    if(modeleczka.getUserName().equalsIgnoreCase(user123.getUserName()))
                    {

                    }
                    else if(modeleczka.getHpbohater()<=0)
                    {

                    }

                    else {
                        UzytkownicyList.add(modeleczka);
                    }


//                DorosleListFinal.add(modeleczka);
//               AdapterListyFinal myAdapterr = new AdapterListyFinal(ListaDorosleFinal.this,DorosleListFinal);
                    AdapterFinal myAdapterr = new AdapterFinal(PaladynPvpRanking.this,UzytkownicyList);
                    myAdapterr.notifyDataSetChanged();

                    listt.setAdapter(myAdapterr);
                }

                Collections.reverse(UzytkownicyList);



                Log.d("TAG", "" + dataSnapshot.getChildren());

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0;i<100;i++)
                {
                    if(position==i)
                    {

                        final User Ejzemberg = UzytkownicyList.get(position);
                        czyChceszWalczycMag(Ejzemberg,view);

                    }
                }

//
            }
        });
    }
    public void ustawPrzeciwnika(final User user)
    {
        database=FirebaseDatabase.getInstance();
        users=database.getReference("Users");
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                User login =dataSnapshot.child(user.getUserName()).getValue(User.class);

                przeciwnikpvp.setAtk(login.getAtkbohater());
                przeciwnikpvp.setHp(login.getHpbohater());
                przeciwnikpvphp.setHp(login.getMaxhp());
                przeciwnikpvp.setSett(login.getSett());
                przeciwnikpvp.setHajs(login.getHajs());
                przeciwnikpvp.setNazwaPrzeciwnika(login.getUserName());
                przeciwnikpvp.setPunktyHonoruPvp(login.getPunktyHonoru());
                przeciwnikpvp.setObrona(login.getObrona());

                przeciwnikpvp.setOdlegloscKrytyczna(login.odlegloscKrytyczna);
                przeciwnikpvp.setAtakcritical(login.atakcritical);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void onBackPressed()
    {
        Intent intent = new Intent(PaladynPvpRanking.this,PaladynMenuActivity.class);
        startActivity(intent);
        PaladynPvpRanking.this.finish();

    }

    public void czyChceszWalczycMag(final User user,View v)
    {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Wyzwij na Arene!");
        alertDialogBuilder.setMessage("\nCzy jesteś gotów do walki ?!\n");

        alertDialogBuilder.setPositiveButton(("Zaczynajmy!"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(user.getNazwa().equalsIgnoreCase("mag"))
                {
                    ustawPrzeciwnika(user);
                    Intent intent = new Intent(PaladynPvpRanking.this, PaladynMag.class);
//                intent.putExtra("User", user.getUserName());
                    startActivity(intent);
                    PaladynPvpRanking.this.finish();
                }
                else if(user.getNazwa().equalsIgnoreCase("paladyn"))
                {
                    ustawPrzeciwnika(user);
                    Intent intent = new Intent(PaladynPvpRanking.this,PaladynPaladyn.class);
//                    intent.putExtra("User",user.getUserName());
                    startActivity(intent);
                    PaladynPvpRanking.this.finish();

                }
                else  if( user.getNazwa().equalsIgnoreCase("archer"))
                {
                    ustawPrzeciwnika(user);
                    Intent intent = new Intent(PaladynPvpRanking.this,PaladynArcher.class);
//                    intent.putExtra("User",user.getUserName());
                    startActivity(intent);
                    PaladynPvpRanking.this.finish();

                }

            }
        });
        alertDialogBuilder.setNegativeButton(("Wracam do miasta"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onBackPressed();
            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.pvpikon);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }


}

