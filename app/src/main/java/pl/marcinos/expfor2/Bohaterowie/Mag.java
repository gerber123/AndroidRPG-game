package pl.marcinos.expfor2.Bohaterowie;

/**
 * Created by marci on 07.03.2018.
 */

public class Mag extends Bohaterowie
{
    @Override
    public int getPunktyHonoru() {
        return super.getPunktyHonoru();
    }

    @Override
    public void setPunktyHonoru(int punktyHonoru) {
        super.setPunktyHonoru(punktyHonoru);
    }
    public Mag(int hpbohater, int atkbohater,int exp,int hajs)
    {
        super(hpbohater, atkbohater, exp,hajs);
    }
    public Mag()
    {
        this.hpbohater=2220;
        this.maxhp=2220;
        this.maxexp=30;
        this.atkbohater=500;

        this.exp=0;
        this.hajs=150;
        this.lvl=1;
        this.drop="brak";

        this.quest1=0;
        this.quest2=0;
        this.quest3=0;
        this.quest4=0;
        this.quest5=0;
        this.quest6=0;
        this.iloscZabitychPotworów=0;

        this.staty=5;
        this.statyatk=0;
        this.statyhp=0;
        this.set="non";

        this.odlegloscKrytyczna=45;
        this.atakcritical=190;
        this.nazwa="Mag";
        this.szansaCrit =45;

        this.statyCrit=0;
        this.skillDamage=600;
        this.sett=1;
        this.punktyHonoru=30;
        this.online=1;
        this.bohater ="mag";
        this.poziomUlepszenia=0;
        this.obrona=400;
        this.poziomUlepszeniaZbroji=0;
        this.klucz="brak";
        this.odlamek="brak";
    }
    public Mag(String userName, String password, String email, String Bohater)
    {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.voteScore=1;
        this.bohater ="mag";

        this.hpbohater=2220;
        this.atkbohater=500;
        this.exp=0;
        this.hajs=200;
        this.lvl=1;

        this.drop="brak";
        this.staty=5;
        this.statyatk=0;
        this.statyhp=0;
        this.set="non";

        this.odlegloscKrytyczna=45;
        this.atakcritical=190;
        this.nazwa="Mag";
        this.szansaCrit =45;
        this.statyCrit=0;
        this.sett=1;
        this.skillDamage=600;
        this.punktyHonoru=0;
    }



}
