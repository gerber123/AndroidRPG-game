package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.05.2018.
 */

public class PvpPrzeciwnik extends Potwory
{


    public PvpPrzeciwnik(double atk, int obrona, int hajs) {
        this.atk = atk;
        this.obrona = obrona;
        this.hajs = hajs;
    }

    @Override
    public String getNazwaPrzeciwnika() {
        return super.getNazwaPrzeciwnika();
    }

    public PvpPrzeciwnik()
    {

    }
    @Override

    public int getHajs() {
        return hajs;
    }
    @Override

    public void setHajs(int hajs) {
        this.hajs = hajs;
    }
    @Override
    public void setSett(int sett) {
        super.setSett(sett);
    }

    @Override
    public int getSett() {
        return super.getSett();
    }

    @Override
    public int getPunktyHonoruPvp() {
        return super.getPunktyHonoruPvp();
    }

    @Override
    public void setPunktyHonoruPvp(int punktyHonoruPvp) {
        super.setPunktyHonoruPvp(punktyHonoruPvp);
    }

    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public PvpPrzeciwnik(int hp, double atk)
    {
        super(hp, atk);
        this.lvl=1;

    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getHp() {
        return super.getHp();
    }

    @Override
    public String getAtkDoListy() {
        return super.getAtkDoListy();
    }

    @Override
    public double getLvl() {
        return super.getLvl();
    }
}

