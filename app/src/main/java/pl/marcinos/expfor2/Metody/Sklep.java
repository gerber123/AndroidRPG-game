package pl.marcinos.expfor2.Metody;

import android.graphics.Color;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

/**
 * Created by marci on 07.03.2018.
 */

public class Sklep
{
    Bohaterowie x;
    Bohaterowie xhp;
    View v;

    public static void kupZrodiwe(Bohaterowie x, Bohaterowie xhp, View v, TextView text)
    {
        if(x.hajs>=50&&x.hpbohater!=xhp.hpbohater){
            x.hajs-=50;
            x.hpbohater=xhp.hpbohater;
            Snackbar.make(v,"Uleczyłeś swoją postać! ",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

            text.setText("Twoje złoto: "+x.hajs);


        }
        else if(x.hpbohater==xhp.hpbohater)
        {
            Snackbar.make(v,"Masz już pełne zdrowie",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
        else
        {
            Snackbar.make(v,"Niemasz wystarczającej ilośći Pieniędzy",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }
    public static void ulepsz(ImageView fail, ImageView success,Bohaterowie x, Bohaterowie xhp, View v,TextView text)
    {
        Random rand = new Random();
        int szansa=0;
        if(x.hajs>=150)
        {
            x.hajs-=150;
            if(x.poziomUlepszenia<4)
            {
                szansa = rand.nextInt(1) + 1;
            }
            if(x.poziomUlepszenia>=4&&x.poziomUlepszenia<6)
            {
                szansa=rand.nextInt(2)+1;
            }
            if(x.poziomUlepszenia>=6&&x.poziomUlepszenia<8)
            {
                szansa=rand.nextInt(3)+1;
            }
            if(x.poziomUlepszenia>=8)
            {
                szansa=rand.nextInt(5)+1;
            }
            if(szansa==1) {
                x.poziomUlepszenia += 1;
                Snackbar.make(v,"Udało Ci się ulepszyć Broń",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();
                Crit.startCrit(success);
                x.atkbohater+=40;
            }
            if(szansa!=1)
            {


                Crit.startCrit(fail);
                Snackbar.make(v,"Niestety, nie udało Ci się ulepszyć Broni",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();
                if(x.poziomUlepszenia>0)
                {
                    x.poziomUlepszenia-=1;

                    x.atkbohater-=40;
                }

            }
//            if(x.poziomUlepszenia==0)
//            {
//                x.atkbohater+=0;
//            }
//            if(x.poziomUlepszenia==1)
//            {
//                x.atkbohater+=20;
//            }
//
//            if(x.poziomUlepszenia==2)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==3)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==4)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==5)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==6)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==7)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==8)
//            {
//                x.atkbohater+=20;
//            }
//            if(x.poziomUlepszenia==9)
//            {
//                x.atkbohater+=20;
//            }
//            Snackbar.make(v,"Ulepszyłeś broń, atak rośnie o 20",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
            text.setText("Twoje złoto: "+x.hajs);


        }
        else
        {
            Snackbar.make(v,"Niemasz wystarczającej ilośći Pieniędzy",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }
    public static void ulepszzaKamien(ImageView fail, ImageView success, Bohaterowie x, Bohaterowie xhp, View v,TextView textt)
    {
        Random rand = new Random();
        int szansa=0;

        if(x.drop.equals("kamien"))
        {

            x.drop="brak";
            textt.setText("Twoje itemy:"+x.drop);


            if(x.poziomUlepszenia<4)
            {
                szansa = rand.nextInt(1) + 1;
            }
            if(x.poziomUlepszenia>=4&&x.poziomUlepszenia<8)
            {
                szansa=rand.nextInt(2)+1;
            }
            if(x.poziomUlepszenia>=8)
            {
                szansa=rand.nextInt(4)+1;
            }
            if(szansa==1) {
                x.poziomUlepszenia += 1;
                x.atkbohater+=40;
                Crit.startCrit(success);
                Snackbar.make(v,"Udało Ci się ulepszyć Broń",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

            }
            if(szansa!=1)
            {

                Crit.startCrit(fail);
                Snackbar.make(v,"Niestety, nie udało Ci się ulepszyć Broni",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();
                if(x.poziomUlepszenia>0)
                {
                    x.poziomUlepszenia-=1;
                    x.atkbohater-=40;
                }

            }

        }
        else if(x.drop.equalsIgnoreCase("kamienPewny"))
        {
            x.drop="brak";
            textt.setText("Twoje itemy:"+x.drop);

            x.poziomUlepszenia += 1;
            x.atkbohater+=40;
            Crit.startCrit(success);
            Snackbar.make(v,"Udało Ci się ulepszyć Broń",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

        }
        else
        {
            Snackbar.make(v,"Nie posiadasz Kamienia",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }


    public static void ulepszZbroje(ImageView fail, ImageView success,Bohaterowie x, Bohaterowie xhp, View v,TextView text)
    {
        Random rand = new Random();
        int szansa=0;
        if(x.hajs>=150)
        {
            x.hajs-=150;
            if(x.poziomUlepszeniaZbroji<4)
            {
                szansa = rand.nextInt(1) + 1;
            }
            if(x.poziomUlepszeniaZbroji>=4&&x.poziomUlepszeniaZbroji<6)
            {
                szansa=rand.nextInt(2)+1;
            }
            if(x.poziomUlepszeniaZbroji>=6&&x.poziomUlepszeniaZbroji<8)
            {
                szansa=rand.nextInt(3)+1;
            }
            if(x.poziomUlepszeniaZbroji>=8)
            {
                szansa=rand.nextInt(5)+1;
            }
            if(szansa==1) {
                x.poziomUlepszeniaZbroji += 1;
                Snackbar.make(v,"Udało Ci się ulepszyć Zbroje",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();
                Crit.startCrit(success);
                x.obrona+=40;
            }
            if(szansa!=1)
            {


                Crit.startCrit(fail);
                Snackbar.make(v,"Niestety, nie udało Ci się ulepszyć Zbroji",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();
                if(x.poziomUlepszeniaZbroji>0)
                {
                    x.poziomUlepszeniaZbroji-=1;

                    x.obrona-=40;
                }

            }
        text.setText("Twoje złoto: "+x.hajs);


        }
        else
        {
            Snackbar.make(v,"Niemasz wystarczającej ilośći Pieniędzy",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }
    public static void ulepszzaKamienZbroje(ImageView fail, ImageView success, Bohaterowie x, Bohaterowie xhp, View v,TextView textt)
    {
        Random rand = new Random();
        int szansa=0;

        if(x.drop.equals("kamien"))
        {

            x.drop="brak";
            textt.setText("Twoje itemy:"+x.drop);


            if(x.poziomUlepszeniaZbroji<4)
            {
                szansa = rand.nextInt(0) + 1;
            }
            if(x.poziomUlepszeniaZbroji>=4&&x.poziomUlepszeniaZbroji<8)
            {
                szansa=rand.nextInt(2)+1;
            }
            if(x.poziomUlepszeniaZbroji>=8)
            {
                szansa=rand.nextInt(4)+1;
            }
            if(szansa==1) {
                x.poziomUlepszeniaZbroji += 1;
                x.obrona+=40;
                Crit.startCrit(success);
                Snackbar.make(v,"Udało Ci się ulepszyć Zbroje",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

            }
            if(szansa!=1)
            {

                Crit.startCrit(fail);
                Snackbar.make(v,"Niestety, nie udało Ci się ulepszyć Zbroji",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();
                if(x.poziomUlepszeniaZbroji>0)
                {
                    x.poziomUlepszeniaZbroji-=1;
                    x.obrona-=40;
                }

            }

        }
        else if(x.drop.equalsIgnoreCase("kamienPewny"))
        {
            x.drop="brak";
            textt.setText("Twoje itemy:"+x.drop);

            x.poziomUlepszeniaZbroji += 1;
            x.obrona+=40;
            Crit.startCrit(success);
            Snackbar.make(v,"Udało Ci się ulepszyć Zbroje",Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

        }
        else
        {
            Snackbar.make(v,"Nie posiadasz Kamienia",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }


    public static void sprawdzenieEQWymag(Bohaterowie x, TextView text, TextView textGold)
    {
        if(x.sett==1)
        {
            text.setText("Lvl: 10");
            textGold.setText("500 golda");
        }
        if(x.sett==2)
        {
            text.setText("Lvl: 20");
            textGold.setText("1000 golda");
        }
        if(x.sett==3)
        {
            text.setText("Lvl: 30");
            textGold.setText("Monument");
        }
        if(x.sett==4)
        {
            text.setText("Niedostępny");
            textGold.setText("---");
        }
    }
    public static void kamien(Bohaterowie x, View v,TextView text1)
    {

        if(x.drop.equals("kamien"))
        {
            x.hajs+=150;
            x.drop="brak";
            text1.setText("Twoje itemy:"+x.drop);
            Snackbar.make(v,"Sprzedałeś Kamień za 150 golda",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();
        }
        else
        {
            Snackbar.make(v,"Niemasz tego niezwykle rzadkiego kamienia",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }
    public static void sprzedajMonument(Bohaterowie x, View v,TextView text1,TextView text2)
    {

        if(x.odlamek.equals("Antyczny fragment"))
        {
            x.hajs+=5000;
            x.odlamek="brak";
            text1.setText("Twoje monumenty: " + x.odlamek);
            text2.setText("Twoje złoto: " + x.hajs);
            Snackbar.make(v,"Sprzedałeś Monument",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();
        }
        else
        {
            Snackbar.make(v,"Niemasz tego niezwykle rzadkiego kamienia",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }
    }
    public static void buyEq(Bohaterowie x,Bohaterowie xhp, View v,TextView text)
    {
    if(x.hajs>=350&&x.set!="sgrade")
    {
        if(x.set.equals("non")&&x.lvl>=5&&x.lvl<10)
        {
            x.atkbohater+=100;
            xhp.atkbohater+=100;
            x.hpbohater+=100;
            xhp.hpbohater+=100;
            x.hajs-=350;
            x.set="agrade";
            text.setText("Twoje złoto: "+x.hajs);
            Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();
        }
        else if(x.set.equals("agrade")&&x.lvl>=10)
        {
            x.atkbohater+=100;
            xhp.atkbohater+=100;
            x.hpbohater+=100;
            xhp.hpbohater+=100;
            x.hajs-=350;
            x.set="sgrade";
            text.setText("Twoje złoto: "+x.hajs);
            Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();
        }
        else if(x.set.equals("non")&&x.lvl>=5)
        {
            x.atkbohater+=100;
            xhp.atkbohater+=100;
            x.hpbohater+=100;
            xhp.hpbohater+=100;
            x.hajs-=350;
            x.set="agrade";
            text.setText("Twoje złoto: "+x.hajs);
            Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();
        }

    }}
    public static void buyEqInt(Bohaterowie x,Bohaterowie xhp, View v,TextView text,TextView textMonument)
    {
    if(x.hajs>=500)
    {
        if(x.sett==1&&x.lvl>=10&&x.lvl<20)
        {
            x.atkbohater+=200;
            xhp.atkbohater+=200;
            x.hpbohater+=200;
            xhp.hpbohater+=200;
            x.hajs-=500;
            x.sett=2;
            x.obrona+=200;
            int g = x.poziomUlepszenia;
            int gg = x.poziomUlepszeniaZbroji;
            x.obrona-=gg*40;
            x.atkbohater-=g*40;
            x.poziomUlepszenia=0;
            x.poziomUlepszeniaZbroji=0;
            text.setText("Twoje złoto: "+x.hajs);
//            Snackbar.make(v,"Kupiłeś nowe wyposażenie, Atak i Życie rośnie",Snackbar.LENGTH_LONG).setDuration(3000).setActionTextColor(Color.RED).show();
        }
        else if(x.sett==2&&x.lvl>=20&&x.hajs>=1000)
        {
            x.atkbohater+=200;
            xhp.atkbohater+=200;
            x.hpbohater+=200;
            xhp.hpbohater+=200;
            x.hajs-=1000;
            x.sett=3;
            x.obrona+=200;
            text.setText("Twoje złoto: "+x.hajs);
            int g = x.poziomUlepszenia;
            x.atkbohater-=g*40;
            int gg = x.poziomUlepszeniaZbroji;
            x.obrona-=gg*40;
            x.poziomUlepszenia=0;
            x.poziomUlepszeniaZbroji=0;
        }
        else if(x.sett==1&&x.lvl>=10)
        {
            x.atkbohater+=200;
            xhp.atkbohater+=200;
            x.hpbohater+=200;
            xhp.hpbohater+=200;
            x.hajs-=500;
            x.sett=2;
            x.obrona+=200;
            text.setText("Twoje złoto: "+x.hajs);
            int g = x.poziomUlepszenia;
            int gg = x.poziomUlepszeniaZbroji;
            x.obrona-=gg*40;

            x.atkbohater-=g*40;
            x.poziomUlepszeniaZbroji=0;
            x.poziomUlepszenia=0;
        }

        else if(x.sett==3&&x.lvl>=30&&x.odlamek.equalsIgnoreCase("Antyczny fragment"))
        {
            x.atkbohater+=350;
            xhp.atkbohater+=350;
            x.hpbohater+=350;
            xhp.hpbohater+=350;
//            x.hajs-=500;
            x.odlamek="brak";
            x.sett=4;
            x.obrona+=350;
            text.setText("Twoje złoto: "+x.hajs);
            textMonument.setText("Twoje monumenty: " + x.odlamek);
            int g = x.poziomUlepszenia;
            int gg = x.poziomUlepszeniaZbroji;
            x.obrona-=gg*40;

            x.atkbohater-=g*40;
            x.poziomUlepszeniaZbroji=0;
            x.poziomUlepszenia=0;
        }
        else if(x.sett==4)
        {
            Snackbar.make(v, "Osiągnałeś najlepszy set", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();

        }
        else
        {
            Snackbar.make(v, "Nie spełniasz warunków do posiadania tego EQ", Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).show();
        }

    }

    }


}

