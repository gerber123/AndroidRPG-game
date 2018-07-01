package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.03.2018.
 */

public class Szkielet extends Potwory
{


    public Szkielet()
    {
        this.name="Szkielet";
        this.hp = 2400;
        this.atk= 850;
        this.lvl=3;
    }
    public Szkielet(ImageView imageView)
    {
        this.name="Szkielet";
        this.hp = 2200;
        this.atk= 500;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Szkielet(int hp, double atk)
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
