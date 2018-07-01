package pl.marcinos.expfor2.Metody;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.R;

/**
 * Created by marci on 12.03.2018.
 */

public class Set
{
    public static void zmianaSetu(Bohaterowie x, ImageView image, ImageView image5, ImageView image10)
    {
        if(x.set.equals("non"))
        {
            image.setVisibility(View.VISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);
        }
        else if(x.set.equals("agrade"))
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.VISIBLE);
            image10.setVisibility(View.INVISIBLE);

        }
        else if(x.set.equals("sgrade"))
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.VISIBLE);

        }
    }    public static void zmianaSetuWalka(Bohaterowie x, ImageView image, ImageView image5, ImageView image10,ImageView image15)
    {
        if(x.set.equals("non"))
        {
            image.setVisibility(View.VISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image15=image;
        }
        else if(x.set.equals("agrade"))
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.VISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image15=image5;
        }
        else if(x.set.equals("sgrade"))
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.VISIBLE);
            image15=image10;

        }
    }
    public static void zmianaSetuWalkaInt(Bohaterowie x, ImageView image, ImageView image5, ImageView image10)
    {
        if(x.sett==1)
        {
            image.setVisibility(View.VISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);

        }
        else if(x.sett==2)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.VISIBLE);
            image10.setVisibility(View.INVISIBLE);

        }
        else if(x.sett==3)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.VISIBLE);


        }
    }
    public static void zmianaSetuWalkaIntSetD(Bohaterowie x, ImageView image, ImageView image5, ImageView image10,ImageView image15)
    {
        if(x.sett==1)
        {
            image.setVisibility(View.VISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image15.setVisibility(View.INVISIBLE);

        }
        else if(x.sett==2)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.VISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image15.setVisibility(View.INVISIBLE);

        }
        else if(x.sett==3)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.VISIBLE);
            image15.setVisibility(View.INVISIBLE);


        }
        else if(x.sett==4)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image15.setVisibility(View.VISIBLE);


        }
    }
    public static void zmianaSetuWalkaIntPvpPrzeciwnik(Potwory x, ImageView image, ImageView image5, ImageView image10)
    {
        if(x.sett==1)
        {
            image.setVisibility(View.VISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);

        }
        else if(x.sett==2)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.VISIBLE);
            image10.setVisibility(View.INVISIBLE);

        }
        else if(x.sett==3)
        {
            image.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.VISIBLE);


        }
    }
    public static void zmianaNazwSetu(Bohaterowie x,TextView nazwaBroni, TextView nazwaZbroji)
    {
        if(x.sett==1&&x.bohater.equalsIgnoreCase("archer"))
        {
            nazwaZbroji.setText("Miedziana Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Perłowy Łuk +"+x.poziomUlepszenia);
        }
        else if(x.sett==2&&x.bohater.equalsIgnoreCase("archer"))
        {
            nazwaZbroji.setText("Kapitańska Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Pajęczy Łuk +"+x.poziomUlepszenia);
        }
        else if(x.sett==3&&x.bohater.equalsIgnoreCase("archer"))
        {
            nazwaZbroji.setText("Smocza Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Smoczy Łuk +"+x.poziomUlepszenia);
        }
        else if(x.sett==4&&x.bohater.equalsIgnoreCase("archer"))
        {
            nazwaZbroji.setText("Diamentowa Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Diamentowy Łuk +"+x.poziomUlepszenia);
        }

        if(x.sett==1&&x.bohater.equalsIgnoreCase("paladyn"))
        {
            nazwaZbroji.setText("Miedziana Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Samurajskie Katany +"+x.poziomUlepszenia);
        }
        else if(x.sett==2&&x.bohater.equalsIgnoreCase("paladyn"))
        {
            nazwaZbroji.setText("Kapitańska Zbroja  +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Ostrza Fiodora +"+x.poziomUlepszenia);
        }
        else if(x.sett==3&&x.bohater.equalsIgnoreCase("paladyn"))
        {
            nazwaZbroji.setText("Smocza Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Słoneczne Miecze +"+x.poziomUlepszenia);
        }
        else if(x.sett==4&&x.bohater.equalsIgnoreCase("paladyn"))
        {
            nazwaZbroji.setText("Diamentowa Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Diamentowe miecze +"+x.poziomUlepszenia);
        }

        if(x.sett==1&&x.bohater.equalsIgnoreCase("mag"))
        {
            nazwaZbroji.setText("Piórkowa Szata +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Miecz Valahali +"+x.poziomUlepszenia);
        }
        else if(x.sett==2&&x.bohater.equalsIgnoreCase("mag"))
        {
            nazwaZbroji.setText("Kapitańska Szata +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Zaklęty Szpikulec +"+x.poziomUlepszenia);
        }
        else if(x.sett==3&&x.bohater.equalsIgnoreCase("mag"))
        {
            nazwaZbroji.setText("Łuskowa Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Słoneczne Bława +"+x.poziomUlepszenia);
        }
        else if(x.sett==4&&x.bohater.equalsIgnoreCase("mag"))
        {
            nazwaZbroji.setText("Diamentowa Zbroja +"+x.poziomUlepszeniaZbroji);
            nazwaBroni.setText("Diamentowe miecz +"+x.poziomUlepszenia);
        }
    }


    public static void zmianaGrafikiSetuArcher(Bohaterowie x,ImageView image,ImageView imageSet)
    {
        if(x.sett==1)
        {
            image.setImageResource(R.drawable.bowb);
            imageSet.setImageResource(R.drawable.archersetb);

        }
        else if(x.sett==2)
        {
            image.setImageResource(R.drawable.bowa);
            imageSet.setImageResource(R.drawable.archerseta);

        }
        else if(x.sett==3)
        {

            imageSet.setImageResource(R.drawable.archersets);
            image.setImageResource(R.drawable.bows);
        }
        else if(x.sett==4)
        {
            image.setImageResource(R.drawable.bowd);
            imageSet.setImageResource(R.drawable.archersetd);

        }
    }
    public static void zmianaGrafikiSetuPaladyn(Bohaterowie x,ImageView image,ImageView imageSet)
    {
        if(x.sett==1)
        {
            image.setImageResource(R.drawable.swordsb);
            imageSet.setImageResource(R.drawable.paladynsetb);

        }
        else if(x.sett==2)
        {
            image.setImageResource(R.drawable.swordsa);
            imageSet.setImageResource(R.drawable.paladynseta);

        }
        else if(x.sett==3)
        {

            imageSet.setImageResource(R.drawable.paladynsets);
            image.setImageResource(R.drawable.swordss);
        }
        else if(x.sett==4)
        {
            image.setImageResource(R.drawable.swordsd);
            imageSet.setImageResource(R.drawable.paladynsetd);

        }
    }
    public static void zmianaGrafikiSetuWizard(Bohaterowie x,ImageView image,ImageView imageSet)
    {
        if(x.sett==1)
        {
            image.setImageResource(R.drawable.wizardwepb);
            imageSet.setImageResource(R.drawable.wizardsetb);

        }
        else if(x.sett==2)
        {
            image.setImageResource(R.drawable.wizardwepa);
            imageSet.setImageResource(R.drawable.wizardseta);

        }
        else if(x.sett==3)
        {

            imageSet.setImageResource(R.drawable.wizardsets);
            image.setImageResource(R.drawable.wizardweps);
        }
        else if(x.sett==4)
        {
            image.setImageResource(R.drawable.wizardwepd);
            imageSet.setImageResource(R.drawable.wizardsetd);

        }
    }
    public static void zmianaGrafikiSetuSklepWizard(Bohaterowie x,ImageView imageSet)
    {

        if(x.sett==1)
        {

            imageSet.setImageResource(R.drawable.wizardseta);

        }
        else if(x.sett==2)
        {

            imageSet.setImageResource(R.drawable.wizardsets);

        }
        else if(x.sett==3)
        {

            imageSet.setImageResource(R.drawable.wizardsetd);

        }
    }
    public static void zmianaGrafikiSetuSklepArcher(Bohaterowie x,ImageView imageSet)
    {

        if(x.sett==1)
        {

            imageSet.setImageResource(R.drawable.archerseta);

        }
        else if(x.sett==2)
        {

            imageSet.setImageResource(R.drawable.archersets);

        }
        else if(x.sett==3) {

            imageSet.setImageResource(R.drawable.archersetd);
        }}

    public static void zmianaGrafikiSetuSklepPaladyn(Bohaterowie x,ImageView imageSet)
    {

        if(x.sett==1)
        {

            imageSet.setImageResource(R.drawable.paladynseta);

        }
        else if(x.sett==2)
        {

            imageSet.setImageResource(R.drawable.paladynsets);

        }
        else if(x.sett==3)
        {

            imageSet.setImageResource(R.drawable.paladynsetd);

        }
    }
}
