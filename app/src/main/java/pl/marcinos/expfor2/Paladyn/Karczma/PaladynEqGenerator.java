package pl.marcinos.expfor2.Paladyn.Karczma;

import java.util.List;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.antycznyFragment;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.bron;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamien;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.kamienPewny;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.klucz;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.set;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.zloto;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.kolczykLajamira;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.naszyjnikTorosa;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.pierscienVolda;

public class PaladynEqGenerator {
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
                set.setSciezkaDoObrazka(R.drawable.paladynsetb);
                bron.setSciezkaDoObrazka(R.drawable.swordsb);
                set.setNazwaWlasna(("Miedziana Zbroja +"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Samurajskie Katany +"+x.poziomUlepszenia);
                list.add(bron);
                list.add(set);
            }
            else if(x.getSett()==2)
            {
                set.setSciezkaDoObrazka(R.drawable.paladynseta);
                bron.setSciezkaDoObrazka(R.drawable.swordsa);
                set.setNazwaWlasna("Kapitańska Zbroja  +"+x.poziomUlepszeniaZbroji);
                bron.setNazwaWlasna("Ostrza Fiodora +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }
            else if(x.getSett()==3)
            {
                set.setSciezkaDoObrazka(R.drawable.paladynsets);
                bron.setSciezkaDoObrazka(R.drawable.swordss);
                set.setNazwaWlasna("Smocza Zbroja +"+x.poziomUlepszeniaZbroji);
                bron.setNazwaWlasna("Słoneczne Miecze +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }
            else if(x.getSett()==4)
            {
                set.setSciezkaDoObrazka(R.drawable.paladynsetd);
                bron.setSciezkaDoObrazka(R.drawable.swordsd);
                set.setNazwaWlasna(("Diamentowa Zbroja +"+x.poziomUlepszeniaZbroji));
                bron.setNazwaWlasna("Diamentowe miecze +"+x.poziomUlepszenia);
                list.add(set);
                list.add(bron);
            }

        list.add(zloto);
    }
}
