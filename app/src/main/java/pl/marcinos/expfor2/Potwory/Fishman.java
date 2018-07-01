package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

import pl.marcinos.expfor2.R;

/**
 * Created by marci on 17.05.2018.
 */

public class Fishman extends Potwory {
    public Fishman()
    {
        this.name="Fishman";
        this.hp = 9000;
        this.atk= 2929;
        this.lvl=22;
        this.ImageAvatar= R.drawable.ryba;
    }
    public Fishman(ImageView imageView)
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
    public Fishman(int hp, double atk)
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

