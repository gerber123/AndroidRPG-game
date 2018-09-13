package pl.marcinos.expfor2.Metody;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.R;

/**
 * Created by marci on 09.03.2018.
 */

public class Drop
{
    public static Random rand = new Random();
    Bohaterowie x;
    Potwory y;

    public static int   dropexp=0;
    public static int  drophajsu=0;
    public static int droprare = 0;
    public static int droprareBest=0;
    public static int droprareKlucz=0;
    public static int droprareOdlamek=0;



    public static void drop(Bohaterowie x, Bohaterowie xhp, Potwory y,View v)
    {

        if(y.lvl<3)
        {
            drophajsu =  rand.nextInt(40)+35;
            dropexp = rand.nextInt(20)+20;
            droprare=rand.nextInt(13)+1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }
        if(y.lvl<=5&&y.lvl>=3)
        {
            drophajsu =  rand.nextInt(50)+50;
            dropexp = rand.nextInt(30)+25;
            droprare=rand.nextInt(9)+1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }
        if(y.lvl<=7&&y.lvl>5)
        {
            drophajsu =  rand.nextInt(60)+60;
            dropexp = rand.nextInt(30)+45;
            droprare=rand.nextInt(8)+1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }
        if(y.lvl>7&&y.lvl<=10)
        {
            drophajsu =  rand.nextInt(80)+80;
            dropexp = rand.nextInt(50)+55;
            droprare=rand.nextInt(6)+1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }
        if(y.lvl>10&&y.lvl<=13)
        {
            drophajsu =  rand.nextInt(100)+80;
            dropexp = rand.nextInt(70)+85;
            droprare=rand.nextInt(5)+1;
            droprareKlucz=rand.nextInt(35)+1;

            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }
        if(y.lvl>13&&y.lvl<20)
        {
            drophajsu =  rand.nextInt(120)+100;
            dropexp = rand.nextInt(90)+85;
            droprare=rand.nextInt(4)+1;
            droprareBest=rand.nextInt(12)+1;
            droprareKlucz=rand.nextInt(25)+1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }
        if(y.lvl>=20)
        {
            drophajsu =  rand.nextInt(199)+199;
            dropexp = rand.nextInt(120)+85;
            droprare=rand.nextInt(5)+1;
            droprareBest=rand.nextInt(10)+1;
            droprareKlucz=rand.nextInt(15)+1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();


        }
        if(y.lvl==99)
        {
            drophajsu =  rand.nextInt(250)+400;
            dropexp = rand.nextInt(350)+200;
//            droprare=rand.nextInt(2)+1;
//            droprareBest=rand.nextInt(4)+1;
            droprareKlucz=rand.nextInt(25)+1;

//            x.odlamek="Antyczny fragment";
//            x.drop="kamienPewny";
            x.iloscKamieniPewnych+=1;
            x.iloscKamieni+=1;
            x.iloscMonumentow+=1;


            Snackbar.make(v,"Zwycięstwo drop: " + +Drop.getDrophajsu()+"$, Exp:"+Drop.getDropexp(),Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();



        }

        x.hajs+=drophajsu;
        x.exp+=dropexp;
        if(droprare==2)
        {
//            x.drop="kamien";
            x.iloscKamieni+=1;
            Snackbar.make(v,"Udało Ci się zdobyć kamień, wymień go w sklepie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

         }
        if(droprareBest==4)
        {
//            x.drop="kamienPewny";
            x.iloscKamieniPewnych+=1;
            Snackbar.make(v,"Udało Ci się zdobyć Pewny kamień, Ulepsz broń lub Zbroje!",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

        }
        if(droprareKlucz==4)
        {
            x.iloscKluczy+=1;
//            x.klucz="Posiadany";
            Snackbar.make(v,"Udało Ci się zdobyć klucz do Komnaty Smoka",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();

        }



    }
    public static int getDropexp() {
        return dropexp;
    }

    public static int getDrophajsu() {
        return drophajsu;
    }

    public static int getDroprare() {
        return droprare;
    }
}
