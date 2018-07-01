package pl.marcinos.expfor2.Metody;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;

/**
 * Created by marci on 07.03.2018.
 */

public class Staty
{
    Bohaterowie x;
    Bohaterowie xhp;
    View view;
    TextView text;
    TextView text2;

    public static void zwiekszHP(Bohaterowie x, Bohaterowie xhp, View view, TextView text, TextView text2,TextView text3)
    {
        if(x.staty>0)
        {
            x.staty-=1;
            x.statyhp+=1;
            x.hpbohater+=20;
            xhp.hpbohater+=20;
            text.setText(x.statyhp+"");
            text2.setText("Twoje życie : "+ x.hpbohater+"/"+xhp.hpbohater);
            text3.setText("Punkty statystyk : "+ x.staty);
            Toast toast = Toast.makeText(view.getContext(),"",Toast.LENGTH_SHORT);
            toast.show();
//            Snackbar.make(view,"Dodałeś jeden punkt do zdrowia",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
        else
        {
            Toast toast = Toast.makeText(view.getContext(),"Niemasz punktów aby to zrobić",Toast.LENGTH_SHORT);
            toast.show();
            Snackbar.make(view,"Niemasz punktów aby to zrobić",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
    }
    public static void zwiekszAtk(Bohaterowie x, Bohaterowie xhp, View view, TextView text, TextView text2,TextView text3)
    {
        if(x.staty>0)
        {
            x.staty-=1;
            x.statyatk+=1;
            x.atkbohater+=20;
            xhp.atkbohater+=20;
            text.setText(x.statyatk+"");
            text2.setText("Twój atk : "+ x.atkbohater);
            text3.setText("Punkty statystyk : "+ x.staty);
//            Snackbar.make(view,"Dodałeś jeden punkt do ataku",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
        else
        {
            Snackbar.make(view,"Niemasz punktów aby to zrobić",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
    } public static void zwiekszCrit(Bohaterowie x, Bohaterowie xhp, View view, TextView text, TextView text1, TextView text2,TextView text3)
    {
        if(x.staty>0)
        {
            if(x.odlegloscKrytyczna>1) {
                x.staty -= 1;
                x.statyCrit += 1;
                x.atakcritical += 10;
                x.odlegloscKrytyczna -= 1;
                xhp.odlegloscKrytyczna -= 1;
                x.szansaCrit -= 1;
                xhp.szansaCrit -= 1;
                xhp.atakcritical += 10;
                text.setText(x.statyCrit + "");
                text1.setText("Critical Chance: " + x.statyCrit/4 + "0 %");
                text2.setText("Critical Damage: " + x.atakcritical / 10 + "%");
                text3.setText("Punkty statystyk : " + x.staty);

//                Snackbar.make(view, "Dodałeś jeden punkt do krytyków", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
            }
            else
            {

                x.staty -= 1;
                x.statyCrit += 1;
                x.atakcritical += 20;
                xhp.atakcritical += 20;
                text.setText(x.statyCrit + "");
                text1.setText("Critical Chance: 100%");
                text2.setText("Critical Damage: " + x.atakcritical / 10 + "%");
                text3.setText("Punkty statystyk : " + x.staty);

//                Snackbar.make(view, "Dodałeś jeden punkt do krytyków", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
            }
        }
        else
        {
            Snackbar.make(view,"Niemasz punktów aby to zrobić",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
    }
}
