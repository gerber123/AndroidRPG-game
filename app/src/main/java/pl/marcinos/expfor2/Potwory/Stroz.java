package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.03.2018.
 */

public class Stroz extends Potwory
{


    public Stroz()
    {
        this.name="Stroz";
        this.hp = 7500;
        this.atk= 1550;
        this.lvl=9;
    }
    public Stroz(ImageView imageView)
    {
        this.name="Stroz";
        this.hp = 4900;
        this.atk= 350;
        this.lvl=1;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Stroz(int hp, double atk)
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