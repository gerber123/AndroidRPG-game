package pl.marcinos.expfor2.Metody;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;
import static pl.marcinos.expfor2.R.color.cardview_dark_background;

public class Skille
{
    @SuppressLint("ResourceAsColor")
    public static void magDifference(ImageButton buttonSkill, ImageView timer)
    {
        if(mag.profesja.equalsIgnoreCase("ogien"))
        {
            buttonSkill.setImageResource(R.drawable.magskilogienicon);
        }
        else if(mag.profesja.equalsIgnoreCase("woda"))
        {
            buttonSkill.setImageResource(R.drawable.magskilicon);
        }
        else if(mag.profesja.equalsIgnoreCase("brak"))
        {
            buttonSkill.setImageResource(R.drawable.questionmark);
            buttonSkill.setBackgroundColor(R.color.black_overlay);

            buttonSkill.setEnabled(false);
        }

    }
    @SuppressLint("ResourceAsColor")
    public static void magDifferenceTest(ImageView buttonSkill)
    {
        if(mag.profesja.equalsIgnoreCase("ogien"))
        {
            buttonSkill.setImageResource(R.drawable.fireskills);
        }
        else if(mag.profesja.equalsIgnoreCase("woda"))
        {
            buttonSkill.setImageResource(R.drawable.waterskills);
        }
        else if(mag.profesja.equalsIgnoreCase("brak"))
        {
            buttonSkill.setImageResource(R.drawable.questionmark);
            buttonSkill.setBackgroundColor(R.color.black_overlay);
            buttonSkill.setVisibility(View.INVISIBLE);
            buttonSkill.setEnabled(false);
        }

    }  @SuppressLint("ResourceAsColor")
public static void archerDifference(ImageButton buttonSkill, ImageView timer)
    {
        if(archer.profesja.equalsIgnoreCase("dagger"))
        {
            buttonSkill.setImageResource(R.drawable.dagger);
        }
        else if(archer.profesja.equalsIgnoreCase("bow"))
        {
            buttonSkill.setImageResource(R.drawable.buttonskill);
        }
        else if(archer.profesja.equalsIgnoreCase("brak"))
        {
            buttonSkill.setImageResource(R.drawable.questionmark);
            buttonSkill.setBackgroundColor(R.color.black_overlay);

            buttonSkill.setEnabled(false);
        }}
        @SuppressLint("ResourceAsColor")
public static void archerDifferenceTest(ImageView buttonSkill, ImageView buttonAttack)
    {
        if(archer.profesja.equalsIgnoreCase("dagger"))
        {
            buttonAttack.setImageResource(R.drawable.dagger);
            buttonSkill.setImageResource(R.drawable.daggerskill);
        }
        else if(archer.profesja.equalsIgnoreCase("bow"))
        {
            buttonAttack.setImageResource(R.drawable.strzala);
            buttonSkill.setImageResource(R.drawable.strzalaskill);
        }
        else if(archer.profesja.equalsIgnoreCase("brak"))
        {
            buttonAttack.setImageResource(R.drawable.strzala);
      buttonSkill.setImageResource(R.drawable.questionmark);
            buttonSkill.setBackgroundColor(R.color.black_overlay);
            buttonSkill.setVisibility(View.INVISIBLE);
            buttonSkill.setEnabled(false);
        }}

    @SuppressLint("ResourceAsColor")
    public static void paladynDifference(ImageButton buttonSkill, ImageView timer)
    {
        if(paladyn.profesja.equalsIgnoreCase("paladyn"))
        {
            buttonSkill.setImageResource(R.drawable.paladynskillbutton);
        }
        else if(paladyn.profesja.equalsIgnoreCase("berserker"))
        {
            buttonSkill.setImageResource(R.drawable.berserkerskillbutton);
        }
        else if(paladyn.profesja.equalsIgnoreCase("brak"))
        {
            buttonSkill.setImageResource(R.drawable.questionmark);
            buttonSkill.setBackgroundColor(R.color.black_overlay);

            buttonSkill.setEnabled(false);
        }

    }
}
