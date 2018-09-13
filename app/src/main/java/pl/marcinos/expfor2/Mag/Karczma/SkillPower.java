package pl.marcinos.expfor2.Mag.Karczma;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Potwory.Potwory;

public class SkillPower {
    public static void skillDifference(Bohaterowie x,Potwory y)
    {
        if(x.getProfesja().equalsIgnoreCase("woda"))
        {
            x.hpbohater+=300;
            y.hp-=x.skillDamage+x.atkbohater+x.skillDamage;

        }
        if(x.getProfesja().equalsIgnoreCase("woda"))
        {
            x.hpbohater+=300;
            y.hp-=x.skillDamage+x.atkbohater;

        }
    }
}
