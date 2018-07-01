package pl.marcinos.expfor2.Metody;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Potwory.Potwory;

/**
 * Created by marci on 09.03.2018.
 */

public class ExpLvl
{
    Bohaterowie x;
    Bohaterowie xhp;
    Potwory y;
    Potwory yhp;
    public static void LvlUp(Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, View v)
    {
        if(x.exp>=xhp.exp)
        {
            x.staty+=5;
            x.exp=0;
            x.lvl+=1;
            xhp.exp+=30;
            x.hpbohater=xhp.hpbohater;
            Dialog.lvlUp(v);
            //Snackbar.make(v,"LVL UP! \n Zysukujesz 5 punktów do statystyk ",Snackbar.LENGTH_LONG).show();


        }


    }
    public static boolean LvlUpMiniGra(Bohaterowie x, Bohaterowie xhp)
    {
        if(x.exp>=xhp.exp)
        {
            x.staty+=5;
            x.exp=0;
            x.lvl+=1;
            xhp.exp+=30;
            x.hpbohater=xhp.hpbohater;
            return true;
            //Snackbar.make(v,"LVL UP! \n Zysukujesz 5 punktów do statystyk ",Snackbar.LENGTH_LONG).show();


        }
return false;

    }
}
