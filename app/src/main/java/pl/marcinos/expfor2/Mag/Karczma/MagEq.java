package pl.marcinos.expfor2.Mag.Karczma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Bohaterowie.Itemy;
import pl.marcinos.expfor2.Metody.EqAdapter;
import pl.marcinos.expfor2.Metody.EqGenerator;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamien;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;

public class MagEq extends AppCompatActivity {
    DatabaseReference uzytkownicy;
    FirebaseDatabase database;
    ListView listt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_eq);


        listt = (ListView)findViewById(R.id.myListtEq);
        List<Itemy> BohaterowieEq=new ArrayList<>();
        MagEqGenerator.sprawdzEq(mag,BohaterowieEq);
        EqAdapter myAdapter = new EqAdapter(this,BohaterowieEq);

        listt.setAdapter(myAdapter);





    }
}
