package pl.marcinos.expfor2.Model;

/**
 * Created by marci on 02.04.2018.
 */

public class Dorosle
{
    public String nazwisko;
    public String imie;
    public String miejscowosc;
    public String wzrost;
    public String wiek;
    public String obwodTali;
    public String obwodBioder;

    public Dorosle()
    {

    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getWzrost() {
        return wzrost;
    }

    public String getWiek() {
        return wiek;
    }

    public String getObwodTali() {
        return obwodTali;
    }

    public String getObwodBioder() {
        return obwodBioder;
    }

    public Dorosle(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek, String obwodTali, String obwodBioder) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.obwodTali = obwodTali;

        this.obwodBioder = obwodBioder;
    }
}
