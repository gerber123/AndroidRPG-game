package pl.marcinos.expfor2.Mag.Menu;

import android.widget.ImageView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

public class SetLevels
{
    public static void SetCheck(Bohaterowie x,ImageView imageWalka, ImageView imageAtak, ImageView imageSkill)
    {
        if(x.sett==1&&x.getProfesja().equalsIgnoreCase(("brak")))
        {
            imageWalka.setImageResource(R.drawable.wizardbwalczwoda);
            imageAtak.setImageResource(R.drawable.wizardbatakwoda);
            imageSkill.setImageResource(R.drawable.wizardbskillwoda);
        }
        if(x.sett==2&&x.getProfesja().equalsIgnoreCase(("brak")))
        {
            imageWalka.setImageResource(R.drawable.wizardawalczwoda);
            imageAtak.setImageResource(R.drawable.wizardaatakwoda);
            imageSkill.setImageResource(R.drawable.wizardaskillwoda);
        }
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
    }public static void ArcherSetCheck(Bohaterowie x,ImageView imageWalka, ImageView imageAtak, ImageView imageSkill)
    {
        if(x.sett==1&&x.getProfesja().equalsIgnoreCase(("brak")))
        {
            imageWalka.setImageResource(R.drawable.archerbwalcz);
            imageAtak.setImageResource(R.drawable.archerbatak);
            imageSkill.setImageResource(R.drawable.imagebskill);
        }
        if(x.sett==2&&x.getProfesja().equalsIgnoreCase(("brak")))
        {
            imageWalka.setImageResource(R.drawable.archerawalcz);
            imageAtak.setImageResource(R.drawable.archeraatak);
            imageSkill.setImageResource(R.drawable.imageaskill);
        }
        else if(x.sett==1&&x.getProfesja().equalsIgnoreCase("bow"))
        {
            imageWalka.setImageResource(R.drawable.archerbwalcz);
            imageAtak.setImageResource(R.drawable.archerbatak);
            imageSkill.setImageResource(R.drawable.imagebskill);
        }
        else if(x.sett==1&&x.getProfesja().equalsIgnoreCase("dagger"))
        {
            imageWalka.setImageResource(R.drawable.archerbwalcz);
            imageAtak.setImageResource(R.drawable.archerbatak);
            imageSkill.setImageResource(R.drawable.imagebskill);
        }
        else if(x.sett==2&&x.getProfesja().equalsIgnoreCase("bow"))
        {
            imageWalka.setImageResource(R.drawable.archerawalcz);
            imageAtak.setImageResource(R.drawable.archeraatak);
            imageSkill.setImageResource(R.drawable.imageaskill);
        }
        else   if(x.sett==2&&x.getProfesja().equalsIgnoreCase("dagger"))
        {
            imageWalka.setImageResource(R.drawable.archerawalcz);
            imageAtak.setImageResource(R.drawable.archeraatak);
            imageSkill.setImageResource(R.drawable.imageaskill);
        }
        else if(x.sett==3&&x.getProfesja().equalsIgnoreCase("bow"))
        {
            imageWalka.setImageResource(R.drawable.archerwalcz);
            imageAtak.setImageResource(R.drawable.archersatak);
            imageSkill.setImageResource(R.drawable.imagesskill);
        }
        else  if(x.sett==3&&x.getProfesja().equalsIgnoreCase("dagger"))
        {
            imageWalka.setImageResource(R.drawable.archerwalcz);
            imageAtak.setImageResource(R.drawable.archersatak);
            imageSkill.setImageResource(R.drawable.imagesskill);
        }
        else  if(x.sett==4&&x.getProfesja().equalsIgnoreCase("bow"))
        {
            imageWalka.setImageResource(R.drawable.archerd);
            imageAtak.setImageResource(R.drawable.archerdatak);
            imageSkill.setImageResource(R.drawable.archerdskill);
        }
        else if(x.sett==4&&x.getProfesja().equalsIgnoreCase("dagger"))
        {
            imageWalka.setImageResource(R.drawable.archerd);
            imageAtak.setImageResource(R.drawable.archerdatak);
            imageSkill.setImageResource(R.drawable.archerdskill);
        }
    }
}
