package pl.marcinos.expfor2.Archer.Karczma;

import java.util.List;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.kolczykLajamira;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.naszyjnikTorosa;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.pierscienVolda;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.antycznyFragment;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.bron;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamien;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamienPewny;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.klucz;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.set;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.zloto;

public class ArcherEqGenerator {
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
        if(x.getKolczykiLajamira()>=1)
        {
            list.add(kolczykLajamira);
        }
        if(x.getPierscienVolda()>=1)
        {
            list.add(pierscienVolda);
        }
        if(x.getNaszyjnikTorosa()>=1)
        {
            list.add(naszyjnikTorosa);
        }



            if(x.getSett()==1) {
                set.setSciezkaDoObrazka(R.drawable.archersetb);
                bron.setSciezkaDoObrazka(R.drawable.bowb);
                set.setNazwaWlasna("Miedziana Zbroja +"+x.poziomUlepszeniaZbroji);
                bron.setNazwaWlasna("Perłowy Łuk +"+x.poziomUlepszenia);
                list.add(bron);
                list.add(set);
            }
            else if(x.getSett()==2)
            {
                set.setSciezkaDoObrazka(R.drawable.archerseta);
                bron.setSciezkaDoObrazka(R.drawable.bowa);
                set.setNazwaWlasna("Kapitańska Zbroja +"+x.poziomUlepszeniaZbroji);
                bron.setNazwaWlasna("Pajęczy Łuk +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }
            else if(x.getSett()==3)
            {
                set.setSciezkaDoObrazka(R.drawable.archersets);
                bron.setSciezkaDoObrazka(R.drawable.bows);
                set.setNazwaWlasna("Smocza Zbroja +"+x.poziomUlepszeniaZbroji);
                bron.setNazwaWlasna("Smoczy Łuk +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }
            else if(x.getSett()==4)
            {
                set.setSciezkaDoObrazka(R.drawable.archersetd);
                bron.setSciezkaDoObrazka(R.drawable.bowd);
                set.setNazwaWlasna(("Diamentowa Zbroja +"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Diamentowe Łuk +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }

        list.add(zloto);
    }
}
