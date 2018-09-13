package pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherKot;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherSzkielet;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherWilkor;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherZombie;
import pl.marcinos.expfor2.Mag.Walka.Walka.Walka.MagKot;
import pl.marcinos.expfor2.Potwory.Kot;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Potwory.Szkielet;
import pl.marcinos.expfor2.Potwory.Wilkor;
import pl.marcinos.expfor2.Potwory.Zombie;
import pl.marcinos.expfor2.R;

public class ArcherWyborJeden extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_wybor_jeden);


        list = (ListView)findViewById(R.id.myList);

        List<Potwory> potworyList=new ArrayList<>();
        potworyList.add(new Kot());
        potworyList.add(new Wilkor());
        potworyList.add(new Szkielet());
        potworyList.add(new Zombie());


        MyAdapter myAdapter = new MyAdapter(this,potworyList);


        //      int[] Images = {R.drawable.kot,R.drawable.wilkor,R.drawable.szkielet};
        //    ImageView imageView=(ImageView)view.findViewById(R.id.imageView2);
        //  imageView.setImageResource(Images[position]);



        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(ArcherWyborJeden.this, ArcherKot.class);
                    ArcherWyborJeden.this.finish();
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(ArcherWyborJeden.this, ArcherWilkor.class);
                    ArcherWyborJeden.this.finish();

                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(ArcherWyborJeden.this, ArcherSzkielet.class);
                    ArcherWyborJeden.this.finish();

                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(ArcherWyborJeden.this, ArcherZombie.class);
                    ArcherWyborJeden.this.finish();

                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ArcherWyborJeden.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherWyborJeden.this.finish();
    }
}
