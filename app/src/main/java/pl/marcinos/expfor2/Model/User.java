package pl.marcinos.expfor2.Model;

/**
 * Created by marci on 01.04.2018.
 */

public class User
{
    public String userName;
    public String password;
    public String email;
    public String bohater;
    public String profesja="brak";

    public int pierscienVolda;
    public int naszyjnikTorosa;
    public int kolczykiLajamira;

    public int getPierscienVolda() {
        return pierscienVolda;
    }

    public void setPierscienVolda(int pierscienVolda) {
        this.pierscienVolda = pierscienVolda;
    }

    public int getNaszyjnikTorosa() {
        return naszyjnikTorosa;
    }

    public void setNaszyjnikTorosa(int naszyjnikTorosa) {
        this.naszyjnikTorosa = naszyjnikTorosa;
    }

    public int getKolczykiLajamira() {
        return kolczykiLajamira;
    }

    public void setKolczykiLajamira(int kolczykiLajamira) {
        this.kolczykiLajamira = kolczykiLajamira;
    }

    public int iloscZabitychPotworów;
    public int quest1;
    public int quest2;
    public int quest3;
    public int quest4;
    public int quest5;
    public int quest6;

    public void setQuest6(int quest6) {
        this.quest6 = quest6;
    }

    public void setQuest1(int quest1) {
        this.quest1 = quest1;
    }

    public void setQuest2(int quest2) {
        this.quest2 = quest2;
    }

    public void setQuest3(int quest3) {
        this.quest3 = quest3;
    }

    public void setQuest4(int quest4) {
        this.quest4 = quest4;
    }

    public void setQuest5(int quest5) {
        this.quest5 = quest5;
    }

    public int getQuest1() {
        return quest1;
    }

    public int getQuest2() {
        return quest2;
    }

    public int getQuest3() {
        return quest3;
    }

    public int getQuest4() {
        return quest4;
    }

    public int getQuest5() {
        return quest5;
    }

    public int getQuest6() {
        return quest6;
    }

    public int getIloscZabitychPotworów() {
        return iloscZabitychPotworów;
    }

    public void setIloscZabitychPotworów(int iloscZabitychPotworów) {
        this.iloscZabitychPotworów = iloscZabitychPotworów;
    }


    public void setSett(int sett) {
        this.sett = sett;
    }

    public int voteScore;
    public int hpbohater;
    public int atkbohater;
    public int exp;



    public int hajs;
    public int lvl;
    public int mana;
    public int maxMana;
    public String drop;
    public int staty;


    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public String getBohater() {
        return bohater;
    }

    public void setBohater(String bohater) {
        this.bohater = bohater;
    }

    public void setHpbohater(int hpbohater) {
        this.hpbohater = hpbohater;
    }
    public int maxhp;
    public int maxexp;
    public int statyhp;
    public int statyatk;
    public String set;
    public int odlegloscKrytyczna;

    public int atakcritical;
    public String nazwa;
    public int szansaCrit;
    public int statyCrit;

    public int skillDamage;
    public int sett;
    public int punktyHonoru;
    public int online;
    public int poziomUlepszenia;
    public int obrona;
    public String klucz;
    public String odlamek;

    public String getOdlamek() {
        return odlamek;
    }

    public void setOdlamek(String odlamek) {
        this.odlamek = odlamek;
    }

    public int getObrona() {
        return obrona;
    }

    public void setObrona(int obrona) {
        this.obrona = obrona;
    }

    public int getPoziomUlepszenia() {
        return poziomUlepszenia;
    }

    public void setPoziomUlepszenia(int poziomUlepszenia) {
        this.poziomUlepszenia = poziomUlepszenia;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public User() {
    }

    public int getPunktyHonoru() {
        return punktyHonoru;
    }

    public void setPunktyHonoru(int punktyHonoru) {
        this.punktyHonoru = punktyHonoru;
    }

    public void setVoteScore(int voteScore) {
        this.voteScore = voteScore;
    }
    public int poziomUlepszeniaZbroji;

    public int getPoziomUlepszeniaZbroji() {
        return poziomUlepszeniaZbroji;
    }

    public void setPoziomUlepszeniaZbroji(int poziomUlepszeniaZbroji) {
        this.poziomUlepszeniaZbroji = poziomUlepszeniaZbroji;
    }

    public int getSzansaCrit() {
        return szansaCrit;
    }

    public int getLvl() {
        return lvl;
    }

    public int getExp() {
        return exp;
    }

    public int getMaxexp() {
        return maxexp;
    }

    public int getAtkbohater() {
        return atkbohater;
    }

    public int getHpbohater() {
        return hpbohater;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setAtkbohater(int atkbohater) {
        this.atkbohater = atkbohater;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setHajs(int hajs) {
        this.hajs = hajs;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setStaty(int staty) {
        this.staty = staty;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public void setSzansaCrit(int szansaCrit) {
        szansaCrit = szansaCrit;
    }

    public void setOdlegloscKrytyczna(int odlegloscKrytyczna) {
        this.odlegloscKrytyczna = odlegloscKrytyczna;
    }




    public String getKlucz() {
        return klucz;
    }

    public void setKlucz(String klucz) {
        this.klucz = klucz;
    }

    public void setStatyCrit(int statyCrit) {
        this.statyCrit = statyCrit;
    }

    public void setAtakcritical(int atakcritical) {
        this.atakcritical = atakcritical;
    }

    public void setStatyhp(int statyhp) {
        this.statyhp = statyhp;
    }

    public void setStatyatk(int statyatk) {
        this.statyatk = statyatk;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }



    public void setMaxexp(int maxexp) {
        this.maxexp = maxexp;

    }

    public String getProfesja() {
        return profesja;
    }

    public void setProfesja(String profesja) {
        this.profesja = profesja;
    }
    public int iloscKamieni;
    public int iloscKamieniPewnych;
    public int iloscKluczy;
    public int iloscMonumentow;

    public int getIloscKamieni() {
        return iloscKamieni;
    }

    public void setIloscKamieni(int iloscKamieni) {
        this.iloscKamieni = iloscKamieni;
    }

    public int getIloscKamieniPewnych() {
        return iloscKamieniPewnych;
    }

    public void setIloscKamieniPewnych(int iloscKamieniPewnych) {
        this.iloscKamieniPewnych = iloscKamieniPewnych;
    }

    public int getIloscKluczy() {
        return iloscKluczy;
    }

    public void setIloscKluczy(int iloscKluczy) {
        this.iloscKluczy = iloscKluczy;
    }

    public int getIloscMonumentow() {
        return iloscMonumentow;
    }

    public void setIloscMonumentow(int iloscMonumentow) {
        this.iloscMonumentow = iloscMonumentow;
    }

    public User(String userName, String password, String email, String Bohater) {
        this.online=1;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.voteScore=1;
        this.bohater =Bohater;
        this.punktyHonoru=30;
        this.poziomUlepszenia=0;
        this.poziomUlepszeniaZbroji=0;
        this.quest1=0;
        this.quest2=0;
        this.quest3=0;
        this.quest4=0;
        this.quest5=0;
        this.quest6=0;
        this.iloscKamieni=0;
        this.iloscKamieniPewnych=0;
        this.iloscKluczy=0;
        this.iloscMonumentow=0;
        this.iloscZabitychPotworów=0;
        this.profesja="brak";
        this.pierscienVolda=0;
        this.kolczykiLajamira=0;
        this.naszyjnikTorosa=0;
        if(Bohater.equals("mag"))
        {

            this.hpbohater=2220;
            this.atkbohater=500;
            this.maxexp=80;
            this.odlamek="brak";

            this.maxhp=2220;
            this.exp=0;
            this.hajs=200;
            this.lvl=1;

            this.mana=600;
            this.maxMana=600;
            this.sett=1;
            this.drop="brak";
            this.staty=5;
            this.statyatk=0;
            this.statyhp=0;
            this.set="non";
            this.odlegloscKrytyczna=45;
            this.atakcritical=190;
            this.nazwa="Mag";
            this.szansaCrit =45;
            this.statyCrit=0;
            this.skillDamage=600;
            this.obrona=400;
            this.klucz="brak";
        }
        else if(Bohater.equals("paladyn"))
        {


            this.hpbohater=3200;
            this.atkbohater=300;
            this.exp=0;
            this.hajs=200;
            this.lvl=1;
            this.drop="brak";
            this.staty=5;
            this.statyatk=0;
            this.statyhp=0;
            this.set="non";
            this.sett=1;
            this.odlegloscKrytyczna=40;
            this.atakcritical=170;
            this.nazwa="Paladyn";
            this.szansaCrit =40;
            this.statyCrit=0;
            this.skillDamage=500;
            this.maxhp=3200;
            this.maxexp=80;
            this.obrona=600;
            this.klucz="brak";
            this.odlamek="brak";
        }
        else if(Bohater.equals("archer"))
        {
            this.maxMana=8;
            this.mana=0;
            this.hpbohater=2420;
            this.atkbohater=400;
            this.exp=0;
            this.hajs=200;
            this.lvl=1;
            this.drop="brak";
            this.staty=5;
            this.statyatk=0;
            this.statyhp=0;
            this.set="non";
            this.odlegloscKrytyczna=35;
            this.atakcritical=255;
            this.nazwa="Archer";
            this.szansaCrit =35;
            this.skillDamage=500;
            this.statyCrit=0;
            this.sett=1;
            this.maxhp=2420;
            this.maxexp=80;
            this.obrona=500;
            this.klucz="brak";
            this.odlamek="brak";
        }


    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getSett() {
        return sett;
    }

    public int getHajs() {
        return hajs;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getVoteScore() {
        return voteScore;
    }
}
