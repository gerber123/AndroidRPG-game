package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 19.03.2018.
 */

public class Rycerz extends Potwory {
    public Rycerz()
    {
        this.name="Rycerz";
        this.hp = 8999;
        this.atk= 2300;
        this.lvl=13;
    }
    public Rycerz(ImageView imageView)
    {
        this.name="Moskit";
        this.hp = 5000;
        this.atk= 400;
        this.lvl=1;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Rycerz(int hp, double atk)
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

