package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.03.2018.
 */

public class Potwory
{
    public static Kot kot = new Kot();
    public static Szkielet szkielet= new Szkielet();
    public static Wilkor wilkorhp = new Wilkor();
    public static Wilkor wilkor= new Wilkor();
    public static Zombie zombie = new Zombie();
    public static Kot kothp = new Kot();
    public static Szkielet szkielethp= new Szkielet();
    public static Zombie zombiehp = new Zombie();
    public static Moskit moskit= new Moskit();
    public static Moskit moskithp = new Moskit();
    public static Mnich mnich= new Mnich();
    public static Mnich mnichhp = new Mnich();
    public static Stroz stroz= new Stroz();
    public static Stroz strozhp = new Stroz();
    public static Orc orchp= new Orc();
    public static Orc orc = new Orc();
    public static Guard guard = new Guard();
    public static Guard guardhp = new Guard();
    public static Rycerz rycerz = new Rycerz();
    public static Rycerz rycerzhp = new Rycerz();
    public static Hellgate hellgate = new Hellgate();
    public static Hellgate hellgatehp = new Hellgate();
    public static Boss boss = new Boss();
    public static Boss bosshp = new Boss();
    public static Turtle turtle = new Turtle();
    public static Turtle turtlehp = new Turtle();
    public static Fishman fishman = new Fishman();
    public static Fishman fishmanhp = new Fishman();
    public static Soldier soldier = new Soldier();
    public static Soldier soldierhp = new Soldier();

    public int atakcritical;
    public int odlegloscKrytyczna;
    public int ImageAvatar;

    public int ileRazyUmarl;



    public int getImageAvatar() {
        return ImageAvatar;
    }

    public void setImageAvatar(int imageAvatar) {
        ImageAvatar = imageAvatar;
    }

    public int getOdlegloscKrytyczna() {
        return odlegloscKrytyczna;
    }

    public void setOdlegloscKrytyczna(int odlegloscKrytyczna) {
        this.odlegloscKrytyczna = odlegloscKrytyczna;
    }

    public int getAtakcritical() {
        return atakcritical;
    }

    public void setAtakcritical(int atakcritical) {
        this.atakcritical = atakcritical;
    }

    public int punktyHonoruPvp;

    public int obrona;

    public void setObrona(int obrona) {
        this.obrona = obrona;
    }

    public int getObrona() {
        return obrona;
    }

    public int getPunktyHonoruPvp() {
        return punktyHonoruPvp;
    }

    public void setPunktyHonoruPvp(int punktyHonoruPvp)
    {
        this.punktyHonoruPvp = punktyHonoruPvp;
    }

    public void setSett(int sett) {
        this.sett = sett;
    }

    public int getSett() {
        return sett;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public ImageView getImageView() {
        return imageView;
    }
    public String nazwaPrzeciwnika;

    public void setNazwaPrzeciwnika(String nazwaPrzeciwnika) {
        this.nazwaPrzeciwnika = nazwaPrzeciwnika;
    }

    public String getNazwaPrzeciwnika() {
        return nazwaPrzeciwnika;
    }

    public int getHajs() {
        return hajs;
    }

    public void setHajs(int hajs) {
        this.hajs = hajs;
    }

    ImageView imageView;
    public String name;
    public int hp;
    public double atk;
    public double lvl;
    public int sett;
    public int hajs;

    Potwory()
    {

    }

    Potwory(int hp, double atk)
    {
        this.hp=hp;
        this.atk=atk;
    }


    public String getName() {
        return name;
    }

    public String getHp() {
        return hp+"";
    }

    public String getAtk() {
        return atk+"";
    }

    public double getLvl() {
        return lvl;
    }
}