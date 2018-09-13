package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

import pl.marcinos.expfor2.R;

/**
 * Created by marci on 17.05.2018.
 */

public class Soldier extends Potwory {
    public Soldier()
    {
        this.name="Soldier";
        this.hp = 9500;
        this.atk= 3129;
        this.lvl=21;
        this.ImageAvatar= R.drawable.warpokaz;
    }
    public Soldier(ImageView imageView)
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
    public Soldier(int hp, double atk)
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

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void setAtk(double atk) {
        super.setAtk(atk);
    }
}

