package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 16.05.2018.
 */

public class Boss extends Potwory {
    public Boss()
    {
        this.name="Guard";
        this.hp = 20000;
        this.atk= 3000;
        this.lvl=99;
    }
    public Boss(ImageView imageView)
    {
        this.name="Boss";
        this.hp = 5000;
        this.atk= 400;
        this.lvl=35;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Boss(int hp, double atk)
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

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void setAtk(double atk) {
        super.setAtk(atk);
    }
}

