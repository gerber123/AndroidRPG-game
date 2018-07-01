package pl.marcinos.expfor2.Paladyn.superWalka.WyborPrzeciwnika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherFishman;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherSoldier;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherTurtle;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.ArcherWyborCztery;
import pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika.MyAdapter25;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynFishman;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynSoldier;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynTurtle;
import pl.marcinos.expfor2.Potwory.Fishman;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Potwory.Soldier;
import pl.marcinos.expfor2.Potwory.Turtle;
import pl.marcinos.expfor2.R;

public class PaladynWyborCzwarty extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paladyn_wybor_czwarty);   list = (ListView)findViewById(R.id.myList510);

        List<Potwory> potworyList=new ArrayList<>();


        potworyList.add(new Soldier());
        potworyList.add(new Fishman());
        potworyList.add(new Turtle());

        MyAdapter25 myAdapter25 = new MyAdapter25(this,potworyList);





        list.setAdapter(myAdapter25);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0) {
                    Intent intent = new Intent(PaladynWyborCzwarty.this, PaladynSoldier.class);
                    PaladynWyborCzwarty.this.finish();
                    startActivity(intent);
                }
                else if(position==1) {
                    Intent intent = new Intent(PaladynWyborCzwarty.this, PaladynFishman.class);
                    PaladynWyborCzwarty.this.finish();
                    startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(PaladynWyborCzwarty.this, PaladynTurtle.class);
                    PaladynWyborCzwarty.this.finish();
                    startActivity(intent);
                }



            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(PaladynWyborCzwarty.this,PaladynMenuActivity.class);
        startActivity(intent);
        PaladynWyborCzwarty.this.finish();
    }
}
