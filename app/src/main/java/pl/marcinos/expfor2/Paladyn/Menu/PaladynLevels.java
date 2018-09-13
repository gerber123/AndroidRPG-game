package pl.marcinos.expfor2.Paladyn.Menu;

import android.widget.ImageView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

public class PaladynLevels
{
    public static void SetCheck(Bohaterowie x,ImageView imageWalka, ImageView imageAtak, ImageView imageSkill)
    {
        if(x.sett==1&&x.getProfesja().equalsIgnoreCase("paladyn"))
        {
            imageWalka.setImageResource(R.drawable.paladynbwalcz);
            imageAtak.setImageResource(R.drawable.paladynbatak);
            imageSkill.setImageResource(R.drawable.paladynbskill);
        }
        else if(x.sett==1&&x.getProfesja().equalsIgnoreCase("berserker"))
        {
            imageWalka.setImageResource(R.drawable.paladynbwalcz);
            imageAtak.setImageResource(R.drawable.paladynbatak);
            imageSkill.setImageResource(R.drawable.paladynbskill);
        }
        else if(x.sett==2&&x.getProfesja().equalsIgnoreCase("paladyn"))
        {
            imageWalka.setImageResource(R.drawable.paladynawalcz);
            imageAtak.setImageResource(R.drawable.paladynaatak);
            imageSkill.setImageResource(R.drawable.paladynaskill);
        }
        else   if(x.sett==2&&x.getProfesja().equalsIgnoreCase("berserker"))
        {
            imageWalka.setImageResource(R.drawable.paladynawalcz);
            imageAtak.setImageResource(R.drawable.paladynaatak);
            imageSkill.setImageResource(R.drawable.paladynaskill);
        }
        else if(x.sett==3&&x.getProfesja().equalsIgnoreCase("paladyn"))
        {
            imageWalka.setImageResource(R.drawable.paladynwalcz);
            imageAtak.setImageResource(R.drawable.paladynsatak);
            imageSkill.setImageResource(R.drawable.paladynsskill);
        }
        else  if(x.sett==3&&x.getProfesja().equalsIgnoreCase("berserker"))
        {
            imageWalka.setImageResource(R.drawable.paladynwalcz);
            imageAtak.setImageResource(R.drawable.paladynsatak);
            imageSkill.setImageResource(R.drawable.paladynsskill);
        }
        else  if(x.sett==4&&x.getProfesja().equalsIgnoreCase("paladyn"))
        {
            imageWalka.setImageResource(R.drawable.paladynd);
            imageAtak.setImageResource(R.drawable.paladyndatak);
            imageSkill.setImageResource(R.drawable.paladyndskill);
        }
        else if(x.sett==4&&x.getProfesja().equalsIgnoreCase("berserker"))
        {
            imageWalka.setImageResource(R.drawable.paladynd);
            imageAtak.setImageResource(R.drawable.paladyndatak);
            imageSkill.setImageResource(R.drawable.paladyndskill);
        }
    }
}
