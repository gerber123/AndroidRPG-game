package pl.marcinos.expfor2.Potwory;

import android.widget.ImageView;

/**
 * Created by marci on 08.03.2018.
 */
public class Zombie extends Potwory
{

    public Zombie()
    {
        this.name="Zombie";
        this.hp = 3000;
        this.atk= 790;
        this.lvl=3;
    }
    public Zombie(ImageView imageView)
    {
        this.name="Zombie";
        this.hp = 2600;
        this.atk= 350;
        this.imageView=imageView;
    }
    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }
    public Zombie(int hp, double atk)
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
