package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.03.2018.
 */

public class Wilkor extends Potwory
{


    public Wilkor()
    {
        this.name="Wilk";
        this.hp = 2800;
        this.atk= 850;
        this.lvl=1;
    }
    public Wilkor(ImageView imageView)
    {
        this.name="Wilk";
        this.hp = 6000;
        this.atk= 500;
        this.lvl=1;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Wilkor(int hp, double atk)
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