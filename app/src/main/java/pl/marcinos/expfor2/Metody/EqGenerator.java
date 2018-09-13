package pl.marcinos.expfor2.Metody;

import java.util.List;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.antycznyFragment;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.bron;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamien;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.klucz;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamienPewny;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.set;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.zloto;

public class EqGenerator {
    public static void sprawdzEq(Bohaterowie x, List list)
    {
        if(x.getIloscKamieni()>=1)
        {
            list.add(kamien);
        }
        if(x.getIloscKamieniPewnych()>=1)
        {
            list.add(kamienPewny);
        }
        if(x.getIloscMonumentow()>=1)
        {
            list.add(antycznyFragment);
        }
        if(x.getIloscKluczy()>=1)
        {
            list.add(klucz);
        }




            if(x.getSett()==1) {
                set.setSciezkaDoObrazka(R.drawable.wizardsetb);
                bron.setSciezkaDoObrazka(R.drawable.wizardwepb);
                set.setNazwaWlasna(("Piórkowa Szata +"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Miecz Valahali +"+x.poziomUlepszenia);
                list.add(bron);
                list.add(set);
            }
            else if(x.getSett()==2)
            {
                set.setSciezkaDoObrazka(R.drawable.wizardseta);
                bron.setSciezkaDoObrazka(R.drawable.wizardwepa);
                set.setNazwaWlasna(("Kapitańska Szata ++"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Zaklęty Szpikulec +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }
            else if(x.getSett()==3)
            {
                set.setSciezkaDoObrazka(R.drawable.wizardsets);
                bron.setSciezkaDoObrazka(R.drawable.wizardweps);
                set.setNazwaWlasna(("Łuskowa Zbroja +"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Słoneczne Bława +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }
            else if(x.getSett()==4)
            {
                set.setSciezkaDoObrazka(R.drawable.wizardsetd);
                bron.setSciezkaDoObrazka(R.drawable.wizardwepd);
                set.setNazwaWlasna(("Diamentowa Zbroja +"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Diamentowe miecz +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }

        list.add(zloto);
    }
}
