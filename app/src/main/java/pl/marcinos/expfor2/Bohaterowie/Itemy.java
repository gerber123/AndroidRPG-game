package pl.marcinos.expfor2.Bohaterowie;

public class Itemy
{
    String nazwaItema;
    String wartoscItema;
    String opis;
    int iloscItemow;
    int sciezkaDoObrazka;
    String nazwaWlasna;

    public Itemy(String nazwaItema, String wartoscItema, int iloscItemow, int sciezkaDoObrazka,String opis) {
        this.nazwaItema = nazwaItema;
        this.wartoscItema = wartoscItema;
        this.iloscItemow = iloscItemow;
        this.sciezkaDoObrazka = sciezkaDoObrazka;
        this.opis=opis;
    }

    public Itemy(String nazwaItema, String wartoscItema, String opis, int iloscItemow, int sciezkaDoObrazka, String nazwaWlasna) {
        this.nazwaItema = nazwaItema;
        this.wartoscItema = wartoscItema;
        this.opis = opis;
        this.iloscItemow = iloscItemow;
        this.sciezkaDoObrazka = sciezkaDoObrazka;
        this.nazwaWlasna = nazwaWlasna;
    }

    public String getNazwaWlasna() {
        return nazwaWlasna;
    }

    public void setNazwaWlasna(String nazwaWlasna) {
        this.nazwaWlasna = nazwaWlasna;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getSciezkaDoObrazka() {
        return sciezkaDoObrazka;
    }

    public void setSciezkaDoObrazka(int sciezkaDoObrazka) {
        this.sciezkaDoObrazka = sciezkaDoObrazka;
    }

    public String getNazwaItema() {
        return nazwaItema;
    }

    public void setNazwaItema(String nazwaItema) {
        this.nazwaItema = nazwaItema;
    }

    public String getWartoscItema() {
        return wartoscItema;
    }

    public void setWartoscItema(String wartoscItema) {
        this.wartoscItema = wartoscItema;
    }

    public int getIloscItemow() {
        return iloscItemow;
    }

    public void setIloscItemow(int iloscItemow) {
        this.iloscItemow = iloscItemow;
    }
}
