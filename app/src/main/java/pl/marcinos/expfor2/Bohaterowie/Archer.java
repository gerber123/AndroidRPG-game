package pl.marcinos.expfor2.Bohaterowie;

/**
 * Created by marci on 07.03.2018.
 */

public class Archer extends Bohaterowie
{

    @Override
    public int getHpbohater() {
        return super.getHpbohater();
    }

    @Override
    public int getAtkbohater() {
        return super.getAtkbohater();
    }

    @Override
    public int getExp() {
        return super.getExp();
    }

    @Override
    public int getHajs() {
        return super.getHajs();
    }

    @Override
    public int getLvl() {
        return super.getLvl();
    }

    @Override
    public String getDrop() {
        return super.getDrop();
    }

    @Override
    public int getStaty() {
        return super.getStaty();
    }

    @Override
    public int getStatyhp() {
        return super.getStatyhp();
    }

    @Override
    public int getStatyatk() {
        return super.getStatyatk();
    }

    @Override
    public int getPunktyHonoru() {
        return super.getPunktyHonoru();
    }

    @Override
    public void setPunktyHonoru(int punktyHonoru) {
        super.setPunktyHonoru(punktyHonoru);
    }

    public Archer()
    {
        this.iloscKamieni=0;
        this.iloscKamieniPewnych=0;
        this.iloscKluczy=0;
        this.iloscMonumentow=0;
        this.hpbohater=2420;
        this.atkbohater=400;
        this.maxhp=2420;
        this.maxexp=30;
        this.profesja="brak";
        this.exp=0;
        this.hajs=150;
        this.lvl=1;
        this.drop="brak";
        this.mana=0;
        this.maxMana=8;
        this.quest1=0;
        this.quest2=0;
        this.quest3=0;
        this.quest4=0;
        this.quest5=0;
        this.quest6=0;
        this.iloscZabitychPotworów=0;
        this.kolczykiLajamira=0;
        this.naszyjnikTorosa=0;
        this.pierscienVolda=0;
        this.staty=5;
        this.statyatk=0;
        this.statyhp=0;
        this.set="non";

        this.bohater ="archer";
        this.odlegloscKrytyczna=35;
        this.atakcritical=255;
        this.nazwa="Archer";
        this.szansaCrit =35;

        this.skillDamage=500;
        this.statyCrit=0;
        this.sett=1;
        this.punktyHonoru=30;
        this.online=1;



        this.poziomUlepszenia=0;
        this.obrona=500;
        this.poziomUlepszeniaZbroji=0;
        this.klucz="brak";
        this.odlamek="brak";
    }



    public Archer(int hpbohater, int atkbohater, int exp,int hajs)
    {
        super(hpbohater, atkbohater, exp, hajs);

    }


}


