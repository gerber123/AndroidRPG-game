package pl.marcinos.expfor2.Metody;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;

/**
 * Created by marci on 10.05.2018.
 */

public class Ulepszanie
{
    public static void SprawdzPoziomEnchantu(Bohaterowie x)
    {
        if(x.poziomUlepszenia==0)
        {
            x.atkbohater+=0;
        }
        if(x.poziomUlepszenia==1)
        {
            x.atkbohater+=20;
        }

        if(x.poziomUlepszenia==2)
        {
            x.atkbohater+=40;
        }
        if(x.poziomUlepszenia==3)
        {
            x.atkbohater+=60;
        }
        if(x.poziomUlepszenia==4)
        {
            x.atkbohater+=80;
        }
        if(x.poziomUlepszenia==5)
        {
            x.atkbohater+=100;
        }
        if(x.poziomUlepszenia==6)
        {
            x.atkbohater+=120;
        }
        if(x.poziomUlepszenia==7)
        {
            x.atkbohater+=140;
        }
        if(x.poziomUlepszenia==8)
        {
            x.atkbohater+=160;
        }
        if(x.poziomUlepszenia==9)
        {
            x.atkbohater+=180;
        }
    }
}
