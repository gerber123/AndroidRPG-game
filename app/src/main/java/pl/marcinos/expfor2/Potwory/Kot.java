package pl.marcinos.expfor2.Potwory;

import android.media.Image;
import android.widget.ImageView;

import pl.marcinos.expfor2.R;

/**
 * Created by marci on 08.03.2018.
 */

public class Kot extends Potwory
{


    public Kot()
    {

        this.name="Kot";
        this.hp = 2500;
        this.atk= 750;
        this.lvl=1;

    }

    public Kot(ImageView imageView)
    {

        this.name="Kot";
        this.hp = 3000;
        this.atk= 200;
        this.imageView=imageView;
    }

    public Kot(int hp, double atk)
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