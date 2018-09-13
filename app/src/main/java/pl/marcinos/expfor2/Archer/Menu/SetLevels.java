package pl.marcinos.expfor2.Archer.Menu;

import android.widget.ImageView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

public class SetLevels
{
    public static void SetCheck(Bohaterowie x,ImageView imageWalka, ImageView imageAtak, ImageView imageSkill)
    {
        if(x.sett==1&&x.getProfesja().equalsIgnoreCase("ogien"))
        {
            imageWalka.setImageResource(R.drawable.wizardbwalczogien);
            imageAtak.setImageResource(R.drawable.wizardbatakogien);
            imageSkill.setImageResource(R.drawable.wizardbskillogien);
        }
        else if(x.sett==1&&x.getProfesja().equalsIgnoreCase("woda"))
        {
            imageWalka.setImageResource(R.drawable.wizardbwalczwoda);
            imageAtak.setImageResource(R.drawable.wizardbatakwoda);
            imageSkill.setImageResource(R.drawable.wizardbskillwoda);
        }
        else if(x.sett==2&&x.getProfesja().equalsIgnoreCase("ogien"))
        {
            imageWalka.setImageResource(R.drawable.wizardawalczogien);
            imageAtak.setImageResource(R.drawable.wizardaatakogien);
            imageSkill.setImageResource(R.drawable.wizardaskillogien);
        }
        else   if(x.sett==2&&x.getProfesja().equalsIgnoreCase("woda"))
        {
            imageWalka.setImageResource(R.drawable.wizardawalczwoda);
            imageAtak.setImageResource(R.drawable.wizardaatakwoda);
            imageSkill.setImageResource(R.drawable.wizardaskillwoda);
        }
        else if(x.sett==3&&x.getProfesja().equalsIgnoreCase("ogien"))
        {
            imageWalka.setImageResource(R.drawable.wizardswalczogien);
            imageAtak.setImageResource(R.drawable.wizardsatakogien);
            imageSkill.setImageResource(R.drawable.wizardsskillogien);
        }
        else  if(x.sett==3&&x.getProfesja().equalsIgnoreCase("woda"))
        {
            imageWalka.setImageResource(R.drawable.wizardswalczwoda);
            imageAtak.setImageResource(R.drawable.wizardsatakwoda);
            imageSkill.setImageResource(R.drawable.wizardaskillwoda);
        }
        else  if(x.sett==4&&x.getProfesja().equalsIgnoreCase("ogien"))
        {
            imageWalka.setImageResource(R.drawable.wizarddwalczogien);
            imageAtak.setImageResource(R.drawable.wizarddatakogien);
            imageSkill.setImageResource(R.drawable.wizarddskillogien);
        }
        else if(x.sett==4&&x.getProfesja().equalsIgnoreCase("woda"))
        {
            imageWalka.setImageResource(R.drawable.wizarddwalczwoda);
            imageAtak.setImageResource(R.drawable.wizarddatakwoda);
            imageSkill.setImageResource(R.drawable.wizarddskillwoda);
        }
    }
}
