package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.03.2018.
 */

public class Moskit extends Potwory
{


    public Moskit()
    {
        this.name="Moskit";
        this.hp = 4200;
        this.atk= 1600;
        this.lvl=6;
    }
    public Moskit(ImageView imageView)
    {
        this.name="Moskit";
        this.hp = 5500;
        this.atk= 400;
        this.lvl=6;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Moskit(int hp, double atk)
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