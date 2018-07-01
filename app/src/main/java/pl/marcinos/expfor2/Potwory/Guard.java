package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 19.03.2018.
 */

public class Guard extends Potwory {
    public Guard()
    {
        this.name="Guard";
        this.hp = 8000;
        this.atk= 1929;
        this.lvl=15;
    }
    public Guard(ImageView imageView)
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
    public Guard(int hp, double atk)
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

