package pl.marcinos.expfor2.Bohaterowie;

/**
 * Created by marci on 07.03.2018.
 */

public class Paladyn extends Bohaterowie
{

    @Override
    public int getPunktyHonoru() {
        return super.getPunktyHonoru();
    }

    @Override
    public void setPunktyHonoru(int punktyHonoru) {
        super.setPunktyHonoru(punktyHonoru);
    }
    public Paladyn()
    {
        this.iloscKamieni=0;
        this.iloscKamieniPewnych=0;
        this.iloscKluczy=0;
        this.iloscMonumentow=0;
        this.sett=1;
        this.hpbohater=3200;
        this.atkbohater=300;
        this.maxexp=30;
        this.maxhp=3200;
        this.exp=0;
        this.profesja="brak";
        this.hajs=150;
        this.lvl=1;
        this.drop="brak";
        this.staty=5;
        this.statyatk=0;
        this.statyhp=0;
        this.set="non";
        this.odlegloscKrytyczna=40;
        this.atakcritical=170;
        this.nazwa="Paladyn";
        this.szansaCrit =40;
        this.bohater ="paladyn";
        this.statyCrit=0;
        this.skillDamage=500;
        this.punktyHonoru=30;
        this.online=1;
        this.poziomUlepszenia=0;
        this.obrona=650;
        this.poziomUlepszeniaZbroji=0;
        this.klucz="brak";
        this.odlamek="brak";
        this.kolczykiLajamira=0;
        this.naszyjnikTorosa=0;
        this.pierscienVolda=0;
        this.quest1=0;
        this.quest2=0;
        this.quest3=0;
        this.quest4=0;
        this.quest5=0;
        this.quest6=0;
        this.iloscZabitychPotworów=0;

    }


    public Paladyn(int hpbohater, int atkbohater, int exp,int hajs)
    {
        super(hpbohater, atkbohater, exp, hajs);

    }

}
