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
import pl.marcinos.expfor2.Archer.Menu.ArcherWyborPoziomuActivity;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherMnich;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherMoskit;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherOrc;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherStroz;
import pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika.MagWyborDwa;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynKot;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynSzkielet;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynWilkor;
import pl.marcinos.expfor2.Paladyn.superWalka.Walka.PaladynZombie;
import pl.marcinos.expfor2.Potwory.Mnich;
import pl.marcinos.expfor2.Potwory.Moskit;
import pl.marcinos.expfor2.Potwory.Orc;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Potwory.Stroz;
import pl.marcinos.expfor2.R;

public class ArcherWyborDwa extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_wybor_dwa);


        list = (ListView)findViewById(R.id.myList510);

        List<Potwory> potworyList=new ArrayList<>();

        potworyList.add(new Moskit());
        potworyList.add(new Mnich());
        potworyList.add(new Orc());
        potworyList.add(new Stroz());

        MyAdapter510 myAdapter510 = new MyAdapter510(this,potworyList);


        //      int[] Images = {R.drawable.kot,R.drawable.wilkor,R.drawable.szkielet};
        //    ImageView imageView=(ImageView)view.findViewById(R.id.imageView2);
        //  imageView.setImageResource(Images[position]);



        list.setAdapter(myAdapter510);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0) {
                    Intent intent = new Intent(ArcherWyborDwa.this, ArcherMoskit.class);
                    ArcherWyborDwa.this.finish();
                    startActivity(intent);
                }
                else if(position==1) {
                    Intent intent = new Intent(ArcherWyborDwa.this, ArcherMnich.class);
                    ArcherWyborDwa.this.finish();
                    startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(ArcherWyborDwa.this, ArcherOrc.class);
                    ArcherWyborDwa.this.finish();
                    startActivity(intent);
                }
                else if(position==3)
                {
                    Intent intent = new Intent(ArcherWyborDwa.this, ArcherStroz.class);
                    ArcherWyborDwa.this.finish();
                    startActivity(intent);
                }


            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ArcherWyborDwa.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherWyborDwa.this.finish();
    }
}
