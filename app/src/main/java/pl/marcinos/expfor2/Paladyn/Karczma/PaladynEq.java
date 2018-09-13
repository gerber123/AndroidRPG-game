package pl.marcinos.expfor2.Paladyn.Karczma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.expfor2.Bohaterowie.Itemy;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class PaladynEq extends AppCompatActivity {
    DatabaseReference uzytkownicy;
    FirebaseDatabase database;
    ListView listt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_eq);


        listt = (ListView)findViewById(R.id.myListtEqArcher);
        List<Itemy> BohaterowieEq=new ArrayList<>();
        PaladynEqGenerator.sprawdzEq(paladyn,BohaterowieEq);
        PaladynEqAdapter myAdapter = new PaladynEqAdapter(this,BohaterowieEq);

        listt.setAdapter(myAdapter);





    }
}
