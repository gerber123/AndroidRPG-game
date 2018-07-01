package pl.marcinos.expfor2.Archer.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherRycerz;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Model.Dorosle;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class ArcherRanking extends AppCompatActivity {
    DatabaseReference uzytkownicy;
    FirebaseDatabase database;
    Query queryRef;
    ListView listt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_ranking);


        listt = (ListView)findViewById(R.id.myListt);
        final List<User> UzytkownicyList=new ArrayList<>();
        database=FirebaseDatabase.getInstance();



        uzytkownicy=database.getReference("Users");

        uzytkownicy.orderByChild("lvl").limitToLast(10).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                UzytkownicyList.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    User modeleczka = postSnapshot.getValue(User.class);


                        UzytkownicyList.add(modeleczka);



//                DorosleListFinal.add(modeleczka);

//               AdapterListyFinal myAdapterr = new AdapterListyFinal(ListaDorosleFinal.this,DorosleListFinal);
                    AdapterFinal myAdapterr = new AdapterFinal(ArcherRanking.this,UzytkownicyList);
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

    }
}
