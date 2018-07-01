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
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherGuard;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherHellgate;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherMnich;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherMoskit;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherOrc;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherRycerz;
import pl.marcinos.expfor2.Archer.Walka.Walka.ArcherStroz;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Potwory.Guard;
import pl.marcinos.expfor2.Potwory.Hellgate;
import pl.marcinos.expfor2.Potwory.Mnich;
import pl.marcinos.expfor2.Potwory.Moskit;
import pl.marcinos.expfor2.Potwory.Orc;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.Potwory.Rycerz;
import pl.marcinos.expfor2.Potwory.Stroz;
import pl.marcinos.expfor2.R;

public class ArcherWwyborTrzy extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer_wwybor_trzy);

        list = (ListView)findViewById(R.id.myList510);

        List<Potwory> potworyList=new ArrayList<>();

        potworyList.add(new Guard());
        potworyList.add(new Hellgate());
        potworyList.add(new Rycerz());


        MyAdapter1015 myAdapter1015 = new MyAdapter1015(this,potworyList);


        //      int[] Images = {R.drawable.kot,R.drawable.wilkor,R.drawable.szkielet};
        //    ImageView imageView=(ImageView)view.findViewById(R.id.imageView2);
        //  imageView.setImageResource(Images[position]);



        list.setAdapter(myAdapter1015);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0) {
                    Intent intent = new Intent(ArcherWwyborTrzy.this, ArcherGuard.class);
                    ArcherWwyborTrzy.this.finish();
                    startActivity(intent);
                }
                else if(position==1) {
                    Intent intent = new Intent(ArcherWwyborTrzy.this, ArcherHellgate.class);
                    ArcherWwyborTrzy.this.finish();
                    startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(ArcherWwyborTrzy.this, ArcherRycerz.class);
                    ArcherWwyborTrzy.this.finish();
                    startActivity(intent);
                }



            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ArcherWwyborTrzy.this,ArcherMenuActivity.class);
        startActivity(intent);
        ArcherWwyborTrzy.this.finish();
    }
}
