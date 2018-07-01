package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 19.03.2018.
 */

public class Hellgate extends Potwory {
    public Hellgate()
    {
        this.name="HellGate";
        this.hp = 9770;
        this.atk= 1500;
        this.lvl=12;
    }
    public Hellgate(ImageView imageView)
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
    public Hellgate(int hp, double atk)
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
    public String getAtk() {
        return super.getAtk();
    }

    @Override
    public double getLvl() {
        return super.getLvl();
    }
}

