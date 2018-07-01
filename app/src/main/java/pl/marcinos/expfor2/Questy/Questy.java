package pl.marcinos.expfor2.Questy;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Metody.Dialog;
import pl.marcinos.expfor2.Potwory.Potwory;

/**
 * Created by marci on 29.05.2018.
 */

public class Questy
{


    int lvl;
    String NazwaQuesta;
    int Nagroda;
    int NagrodaExp;
    String tekstQuesta;
    int ImageResource;
    int ileZabic;
    public int stanQuesta;

    public Questy(int lvl, String nazwaQuesta,String tekstQuesta, int nagroda, int nagrodaExp, int ImageResource,int ileZabic,Bohaterowie x) {
        this.lvl = lvl;
        this.NazwaQuesta = nazwaQuesta;
        this.Nagroda = nagroda;
        this.tekstQuesta=tekstQuesta;
        this.NagrodaExp = nagrodaExp;
        this.ImageResource=ImageResource;
        this.ileZabic=ileZabic;
        this.stanQuesta=0;
    }
    public static void sprawdzQuesta(Bohaterowie x, Questy wzgorza,Questy wyspa,Questy katakumby,Questy kraniec,Questy lodowiec)
    {

        if(x.quest1==1)
        {
            wzgorza.setStanQuesta(1);
        }
        else if(x.quest1==2)
        {
            wzgorza.setStanQuesta(2);
        }
        if(x.quest2==1)
        {
            wyspa.setStanQuesta(1);
        }
        else if(x.quest2==2)
        {
            wyspa.setStanQuesta(2);
        }
        if(x.quest3==1)
        {
            katakumby.setStanQuesta(1);
        }
        else if(x.quest3==2)
        {
            katakumby.setStanQuesta(2);
        }
        if(x.quest4==1)
        {
            kraniec.setStanQuesta(1);
        }
        else if(x.quest4==2)
        {
            kraniec.setStanQuesta(2);
        }
        if(x.quest5==1)
        {
            lodowiec.setStanQuesta(1);
        }
        else if(x.quest5==2)
        {
            lodowiec.setStanQuesta(2);
        }
    }

    public static void stanQuesta(Bohaterowie x,TextView WzgorzaText,TextView zatrutaWyspa,TextView KatakubmyText,TextView lodowiecGeista,TextView KraniecSwiatow)
    {
        if(x.quest1==0)
        {

            WzgorzaText.setText("Stan: Nie Wykonano");
        }
        if(x.quest1==1)
        {
            WzgorzaText.setTextColor(Color.YELLOW);
            WzgorzaText.setText("Stan: W trakcie");
        }
        if(x.quest1==2)
        {
            WzgorzaText.setTextColor(Color.GREEN);
            WzgorzaText.setText("Stan: Wykonany");
        }
        if(x.quest2==0)
        {
            zatrutaWyspa.setText("Stan: Nie Wykonano");
        }
        if(x.quest2==1)
        {
            zatrutaWyspa.setTextColor(Color.YELLOW);
            zatrutaWyspa.setText("Stan: W trakcie");
        }
        if(x.quest2==2)
        {

            zatrutaWyspa.setText("Stan: Wykonany");
            zatrutaWyspa.setTextColor(Color.GREEN);
        }
        if(x.quest3==0)
        {
            KatakubmyText.setText("Stan: Nie Wykonano");
        }
        if(x.quest3==1)
        {
            KatakubmyText.setTextColor(Color.YELLOW);
            KatakubmyText.setText("Stan: W trakcie");
        }
        if(x.quest3==2)
        {
            KatakubmyText.setText("Stan: Wykonany");
            KatakubmyText.setTextColor(Color.GREEN);
        }
        if(x.quest5==0)
        {
            lodowiecGeista.setText("Stan: Nie Wykonano");
        }
        if(x.quest5==1)
        {
            lodowiecGeista.setTextColor(Color.YELLOW);
            lodowiecGeista.setText("Stan: W trakcie");
        }
        if(x.quest5==2)
        {
            lodowiecGeista.setText("Stan: Wykonany");
            lodowiecGeista.setTextColor(Color.GREEN);
        }
        if(x.quest4==0)
        {
            KraniecSwiatow.setText("Stan: Nie Wykonano");
        }
        if(x.quest4==1)
        {
            KraniecSwiatow.setTextColor(Color.YELLOW);
            KraniecSwiatow.setText("Stan: W trakcie");
        }
        if(x.quest4==2)
        {
            KraniecSwiatow.setTextColor(Color.GREEN);
            KraniecSwiatow.setText("Stan: Wykonany");
        }
    }
    public void wykonanoMisje(Bohaterowie x, Potwory y,View v,Questy quest,TextView StanQuestaText)
    {
    if(x.iloscZabitychPotworów>=ileZabic) {
        if (NazwaQuesta.equalsIgnoreCase("Zaginiony Kot") ) {
            Dialog.ZakonczonyQuest(v, quest);
            y.ileRazyUmarl = 0;
            x.quest1 = 2;
            x.iloscZabitychPotworów = 0;
            x.exp += NagrodaExp;

            x.hajs += Nagroda;
            stanQuesta = 2;
            StanQuestaText.setText("Stan: Zakończony");
            Toast.makeText(v.getContext(), "O Udało Ci się", Toast.LENGTH_SHORT).show();

        }
        if (NazwaQuesta.equalsIgnoreCase("Oblężenie Orców") && x.iloscZabitychPotworów == ileZabic) {
            Dialog.ZakonczonyQuest(v, quest);
            y.ileRazyUmarl = 0;
            x.quest2 = 2;
            x.iloscZabitychPotworów = 0;
            x.exp += NagrodaExp;

            x.hajs += Nagroda;
            stanQuesta = 2;
            StanQuestaText.setText("Stan: Zakończony");
            Toast.makeText(v.getContext(), "O Udało Ci się", Toast.LENGTH_SHORT).show();

        }
        if (NazwaQuesta.equalsIgnoreCase("Szczątki Gwardii") && x.iloscZabitychPotworów == ileZabic) {
            Dialog.ZakonczonyQuest(v, quest);
            y.ileRazyUmarl = 0;
            x.quest3 = 2;
            x.iloscZabitychPotworów = 0;
            x.exp += NagrodaExp;

            x.hajs += Nagroda;
            stanQuesta = 2;
            StanQuestaText.setText("Stan: Zakończony");
            Toast.makeText(v.getContext(), "O Udało Ci się", Toast.LENGTH_SHORT).show();

        }
        if (NazwaQuesta.equalsIgnoreCase("Zaginiony Rybak") && x.iloscZabitychPotworów == ileZabic) {
            Dialog.ZakonczonyQuest(v, quest);
            y.ileRazyUmarl = 0;
            x.quest4 = 2;
            x.iloscZabitychPotworów = 0;
            x.exp += NagrodaExp;

            x.hajs += Nagroda;
            stanQuesta = 2;
            StanQuestaText.setText("Stan: Zakończony");
            Toast.makeText(v.getContext(), "O Udało Ci się", Toast.LENGTH_SHORT).show();

        }
        if (NazwaQuesta.equalsIgnoreCase("Szalony Nożownik") && x.iloscZabitychPotworów == ileZabic) {
            Dialog.ZakonczonyQuest(v, quest);
            y.ileRazyUmarl = 0;
            x.quest5 = 2;
            x.iloscZabitychPotworów = 0;
            x.exp += NagrodaExp;
            x.drop="kamienPewny";
            x.klucz="Posiadany";
            x.hajs += Nagroda;
            stanQuesta = 2;
            StanQuestaText.setText("Stan: Zakończony");
            Toast.makeText(v.getContext(), "O Udało Ci się", Toast.LENGTH_SHORT).show();

        }
    }else {
            Toast.makeText(v.getContext(), "Nie ukończyłeś jeszcze Questa", Toast.LENGTH_SHORT).show();
        }

    }
    public void zaczetoMisje(Bohaterowie x,Potwory y,TextView StanQuestaText){

        if(NazwaQuesta.equalsIgnoreCase("Zaginiony Kot"))
        {
            x.ileTrzebaZabic=ileZabic;
            y.ileRazyUmarl=0;
            x.iloscZabitychPotworów=0;
            x.quest1=1;
            stanQuesta=1;
//            stanQuesta.setTextColor(Color.YELLOW);
            StanQuestaText.setText("Stan: W trakcie");

        }

        if(NazwaQuesta.equalsIgnoreCase("Oblężenie Orców"))
        {
            x.ileTrzebaZabic=ileZabic;
            y.ileRazyUmarl=0;
            x.iloscZabitychPotworów=0;
            x.quest2=1;
            stanQuesta=1;
//            stanQuesta.setTextColor(Color.YELLOW);
            StanQuestaText.setText("Stan: W trakcie");

        }
        if(NazwaQuesta.equalsIgnoreCase("Szczątki Gwardii"))
        {
            x.ileTrzebaZabic=ileZabic;
            y.ileRazyUmarl=0;
            x.iloscZabitychPotworów=0;
            x.quest3=1;
            stanQuesta=1;
//            stanQuesta.setTextColor(Color.YELLOW);
            StanQuestaText.setText("Stan: W trakcie");

        }
        if(NazwaQuesta.equalsIgnoreCase("Zaginiony Rybak"))
        {
            x.ileTrzebaZabic=ileZabic;
            y.ileRazyUmarl=0;
            x.iloscZabitychPotworów=0;
            x.quest4=1;
            stanQuesta=1;
//            stanQuesta.setTextColor(Color.YELLOW);
            StanQuestaText.setText("Stan: W trakcie");

        }
        if(NazwaQuesta.equalsIgnoreCase("Szalony Nożownik"))
        {
            x.ileTrzebaZabic=ileZabic;
            y.ileRazyUmarl=0;
            x.iloscZabitychPotworów=0;
            x.quest5=1;
            stanQuesta=1;
//            stanQuesta.setTextColor(Color.YELLOW);
            StanQuestaText.setText("Stan: W trakcie");

        }


    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getNazwaQuesta() {
        return NazwaQuesta;
    }

    public void setNazwaQuesta(String nazwaQuesta) {
        NazwaQuesta = nazwaQuesta;
    }

    public int getNagroda() {
        return Nagroda;
    }

    public void setNagroda(int nagroda) {
        Nagroda = nagroda;
    }

    public int getNagrodaExp() {
        return NagrodaExp;
    }

    public void setNagrodaExp(int nagrodaExp) {
        NagrodaExp = nagrodaExp;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public void setImageResource(int imageResource) {
        ImageResource = imageResource;
    }

    public int getIleZabic() {
        return ileZabic;
    }

    public void setIleZabic(int ileZabic) {
        this.ileZabic = ileZabic;
    }

    public String getTekstQuesta() {
        return tekstQuesta;
    }

    public void setTekstQuesta(String tekstQuesta) {
        this.tekstQuesta = tekstQuesta;
    }

    public int getStanQuesta() {
        return stanQuesta;
    }

    public void setStanQuesta(int stanQuesta) {
        this.stanQuesta = stanQuesta;
    }
}
