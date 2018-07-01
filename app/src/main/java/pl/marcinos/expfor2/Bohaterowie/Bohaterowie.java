package pl.marcinos.expfor2.Bohaterowie;

import pl.marcinos.expfor2.Model.User;

/**
 * Created by marci on 07.03.2018.
 */

public class Bohaterowie extends User
{

    public int hpbohater;
    public int atkbohater;
    public int exp;
    public int hajs;
    public int lvl;
    public int obrona;
    public int iloscZabitychPotworów;
    public int quest1;
    public int quest2;
    public int quest3;
    public int quest4;
    public int quest5;
    public int quest6;
    public int ileTrzebaZabic;


    public int getIloscZabitychPotworów() {
        return iloscZabitychPotworów;
    }

    public void setIloscZabitychPotworów(int iloscZabitychPotworów) {
        this.iloscZabitychPotworów = iloscZabitychPotworów;
    }

    public int getQuest1() {
        return quest1;
    }

    public void setQuest1(int quest1) {
        this.quest1 = quest1;
    }

    public int getQuest2() {
        return quest2;
    }

    public void setQuest2(int quest2) {
        this.quest2 = quest2;
    }

    public int getQuest3() {
        return quest3;
    }

    public void setQuest3(int quest3) {
        this.quest3 = quest3;
    }

    public int getQuest4() {
        return quest4;
    }

    public void setQuest4(int quest4) {
        this.quest4 = quest4;
    }

    public int getQuest5() {
        return quest5;
    }

    public void setQuest5(int quest5) {
        this.quest5 = quest5;
    }

    public int getQuest6() {
        return quest6;
    }

    public void setQuest6(int quest6) {
        this.quest6 = quest6;
    }

    public String getSet() {
        return set;
    }

    public int getOdlegloscKrytyczna() {
        return odlegloscKrytyczna;
    }

    public int getAtakcritical() {
        return atakcritical;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public int getSzansaCrit() {
        return szansaCrit;
    }



    public int getStatyCrit() {
        return statyCrit;
    }

    @Override
    public int getMaxhp() {
        return maxhp;
    }

    @Override
    public int getMaxexp() {
        return maxexp;
    }

    public int getSkillDamage() {
        return skillDamage;
    }

    @Override
    public int getSett() {
        return sett;
    }

    public int getObrona() {
        return obrona;
    }

    public void setObrona(int obrona) {
        this.obrona = obrona;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public void setMaxexp(int maxexp) {
        this.maxexp = maxexp;
    }

    public String drop;
    public int staty;
    public int statyhp;
    public int statyatk;
    public String set;
    public int odlegloscKrytyczna;
    public int atakcritical;
    public String nazwa;
    public int szansaCrit;
    public int statyCrit;
    public int maxhp;
    public int maxexp;
    public String bohater;

    @Override
    public String getPassword() {
        return password;
    }


    public String getBohater() {
        return bohater;
    }

    public void setBohater(String bohater) {
        bohater = bohater;
    }

    public String getUserName() {
        return userName;
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

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public void setStaty(int staty) {
        this.staty = staty;
    }

    public void setStatyhp(int statyhp) {
        this.statyhp = statyhp;
    }

    public void setStatyatk(int statyatk) {
        this.statyatk = statyatk;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public void setOdlegloscKrytyczna(int odlegloscKrytyczna) {
        this.odlegloscKrytyczna = odlegloscKrytyczna;
    }

    public void setAtakcritical(int atakcritical) {
        this.atakcritical = atakcritical;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setSzansaCrit(int szansaCrit) {
        szansaCrit = szansaCrit;
    }

    public void setStatyCrit(int statyCrit) {
        this.statyCrit = statyCrit;
    }

    public void setSkillDamage(int skillDamage) {
        this.skillDamage = skillDamage;
    }

    public void setSett(int sett) {
        this.sett = sett;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVoteScore(int voteScore) {
        this.voteScore = voteScore;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int getVoteScore() {
        return voteScore;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setHpbohater(int hpbohater) {

        this.hpbohater = hpbohater;
    }

    public int getPunktyHonoru() {
        return punktyHonoru;
    }

    public void setPunktyHonoru(int punktyHonoru)
    {
        this.punktyHonoru = punktyHonoru;
    }

    public int punktyHonoru;
    public int skillDamage;
    public int sett;
    public String userName;
    public int voteScore;
    public String password;
    public int online;
    public int poziomUlepszenia;
    public int poziomUlepszeniaZbroji;
    public String klucz;
    public String odlamek;

    public String getOdlamek() {
        return odlamek;
    }

    public void setOdlamek(String odlamek) {
        this.odlamek = odlamek;
    }

    public String getKlucz() {
        return klucz;
    }

    public void setKlucz(String klucz) {
        this.klucz = klucz;
    }

    public int getPoziomUlepszeniaZbroji() {
        return poziomUlepszeniaZbroji;
    }

    public void setPoziomUlepszeniaZbroji(int poziomUlepszeniaZbroji) {
        this.poziomUlepszeniaZbroji = poziomUlepszeniaZbroji;
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
    public void setAtkbohater(int atkbohater) {
        this.atkbohater = atkbohater;
    }

    public String email;

    public int getHpbohater() {
        return hpbohater;
    }

    public int getAtkbohater() {
        return atkbohater;
    }

    public int getExp() {
        return exp;
    }

    public int getHajs() {
        return hajs;
    }

    public int getLvl() {
        return lvl;
    }

    public String getDrop() {
        return drop;
    }

    public int getStaty() {
        return staty;
    }

    public int getStatyhp() {
        return statyhp;
    }

    public int getStatyatk() {
        return statyatk;
    }

    Bohaterowie()
    {

    }

    Bohaterowie(int hpbohater, int atkbohater, int exp, int hajs)
    {
        this.atkbohater=atkbohater;
        this.hpbohater=hpbohater;
        this.exp=exp;
        this.hajs=hajs;

    }








}