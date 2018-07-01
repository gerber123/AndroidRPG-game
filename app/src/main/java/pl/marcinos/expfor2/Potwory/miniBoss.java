package pl.marcinos.expfor2.Potwory;

/**
 * Created by marci on 08.03.2018.
 */

public class miniBoss extends Potwory
{


    public miniBoss()
    {
        this.name="miniBoss";
        this.hp = 3000;
        this.atk= 500;
        this.lvl=1;
    }

    public miniBoss(int hp, double atk)
    {
        super(hp, atk);
        this.lvl=1;

    }

}