package pl.marcinos.expfor2.Metody;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Potwory.Potwory;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by marci on 08.03.2018.
 */

public class Walka {
    public static boolean flagaSkilla =true;
    Bohaterowie x;
    Bohaterowie xhp;
    TextView textHpB;
    TextView textHpP;
    Potwory y;
    Potwory yhp;
    View v;
    static Time time;
    View v1;

    public static void atakPotwora(ImageView imageB,ImageView imageBatak,ImageView imageP,Bohaterowie x,Potwory y,Potwory yhp,TextView textHpB,View v,ImageButton image1,ImageButton image2, ImageButton image3)
    {
        if(x.hpbohater>0&&y.hp>0)
        {
            AnimacjaPrzeciwnika.startAnim(imageP, imageB);

            int atak= (int) (y.atk-x.obrona);
            if(atak<=0)
            {
                x.hpbohater-=1;
            }
            else
            {
                x.hpbohater-=atak;
            }

        }
        else if(x.hpbohater<=0)
        {
            AnimacjaPrzegranej.startAnim2(imageB);
            AnimacjaPrzegranej.startAnim2(imageBatak);
            AnimacjaPrzeciwnika.gin(imageB);
            AnimacjaPrzeciwnika.gin(imageBatak);
            x.hpbohater=0;
            image1.setEnabled(false);
            image2.setEnabled(false);
            image3.setEnabled(false);
        }
        else if(y.hp<=0)
        {
            image1.setEnabled(false);
            image2.setEnabled(false);
            image3.setEnabled(false);
            y.ileRazyUmarl+=1;
        }
        textHpB.setText("Hp Bohatera to: " + x.hpbohater);
//        textHpP.setText("Hp Potwora to: " + y.hp);
    }
    public static void atakPotworaTest(ImageView imageB,ImageView imageBatak,ImageView imageP,Bohaterowie x,Potwory y,Potwory yhp,TextView textHpB,View v,ImageView image1,ImageView image2)
    {
        if(x.hpbohater>0&&y.hp>0)
        {
            AnimacjaPrzeciwnika.startAnim(imageP, imageB);

            int atak= (int) (y.atk-x.obrona);
            if(atak<=0)
            {
                x.hpbohater-=1;
            }
            else
            {
                x.hpbohater-=atak;
            }

        }
        else if(x.hpbohater<=0)
        {
            AnimacjaPrzegranej.startAnim2(imageB);
            AnimacjaPrzegranej.startAnim2(imageBatak);
            AnimacjaPrzeciwnika.gin(imageB);
            AnimacjaPrzeciwnika.gin(imageBatak);
            x.hpbohater=0;
            image1.setEnabled(false);
            image2.setEnabled(false);

        }
        else if(y.hp<=0)
        {
            image1.setEnabled(false);
            image2.setEnabled(false);

            y.ileRazyUmarl+=1;
        }
        textHpB.setText("Hp Bohatera to: " + x.hpbohater);
//        textHpP.setText("Hp Potwora to: " + y.hp);
    }
  public static void atakPvpPrzeciwnik(ImageView imageB,ImageView imageBatak,ImageView imageP,ImageView imagePatak,Bohaterowie x,Potwory y,Potwory yhp,TextView textHpB,View v,ImageButton image1,ImageButton image2, ImageButton image3)
    {
        if(x.hpbohater>0&&y.hp>0)
        {
//            AnimacjaPrzeciwnika.startAnim(imageP, imageB);
//            AnimacjaPrzegranej.startAnim2(imageP);
//            AnimacjaPrzegranej.startAnim2(imagePatak);
            AnimacjaPrzegranej.startAnimacjaWalk(imageP, imagePatak);
//            AnimacjaPrzeciwnika.gin(imageP);
//            AnimacjaPrzeciwnika.gin(imagePatak);
            Random rand = new Random();
            int szansa = 0;
            szansa = rand.nextInt(y.odlegloscKrytyczna) + 1;

            if (y.odlegloscKrytyczna == szansa) {



                int atakzcritem= (int) (y.atk-x.obrona+y.atakcritical);
                if(atakzcritem<=0)
                {
                    x.hpbohater-=1;
                }
                else
                {
                    x.hpbohater-=atakzcritem;
                }

            }
            else
            {

                int atak= (int) (y.atk-x.obrona);
                if(atak<=0)
                {
                    x.hpbohater-=1;
                }
                else
                {
                    x.hpbohater-=atak;
                }

            }


        }
        else if(x.hpbohater<=0)
        {
            AnimacjaPrzegranej.startAnim2(imageB);
            AnimacjaPrzegranej.startAnim2(imageBatak);
            AnimacjaPrzeciwnika.gin(imageB);
            AnimacjaPrzeciwnika.gin(imageBatak);
            x.hpbohater=0;
//            image1.setEnabled(false);
//            image2.setEnabled(false);
//            image3.setEnabled(false);
        }
        else if(y.hp<=0)
        {
//            image1.setEnabled(false);
//            image2.setEnabled(false);
//            image3.setEnabled(false);
            AnimacjaPrzegranej.startAnim2(imageP);
            AnimacjaPrzegranej.startAnim2(imagePatak);
           AnimacjaPrzeciwnika.gin(imageP);
           AnimacjaPrzeciwnika.gin(imagePatak);
        }
        textHpB.setText("Hp Bohatera to: " + x.hpbohater);
//        textHpP.setText("Hp Potwora to: " + y.hp);
    }

    public static void walczzPotworem(final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
        Random rand = new Random();
        int szansa = 0;


        if (x.hpbohater > 0 && y.hp > 0) {
            timer.setVisibility(View.VISIBLE);
            b.setEnabled(false);
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {
                if(x.getProfesja().equalsIgnoreCase("bow")||x.getProfesja().equalsIgnoreCase("dagger")) {
                    if (x.mana < 8)
                    {
                        x.mana+=1;
                    }
                }

                y.hp -= x.atkbohater + x.atakcritical;
                Crit.startCrit(imagee);
            } else
                {
                    if(x.getProfesja().equalsIgnoreCase("bow")||x.getProfesja().equalsIgnoreCase("dagger")) {
                        if (x.mana < 8)
                        {
                            x.mana+=1;
                        }
                    }
                y.hp -= x.atkbohater;
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
            CountDownTimer t=    new CountDownTimer(1000, 100) {

                @Override
                public void onTick(long millisUntilFinished) {



                }

                @Override
                public void onFinish()
                {
                    timer.setVisibility(View.INVISIBLE);

                    b.setEnabled(true);
                    flagaSkilla=true;

                }
            }.start();

            if (y.hp < 0) {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
                Drop.drop(x, xhp, y, v);
                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {

                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzegranej.startAnim2(imageBatak);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
//                y.hp = yhp.hp;
                b.setEnabled(false);

            }
        }
        else
        {
            timer.setVisibility(View.VISIBLE);
        }
    }


    public static void walczzPotworemTest(ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageView b) {
        Random rand = new Random();
        int szansa = 0;


        if (x.hpbohater > 0 && y.hp > 0) {

            b.setVisibility(View.INVISIBLE);
            b.setEnabled(false);
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }






            if (x.odlegloscKrytyczna == szansa) {

                if(x.getProfesja().equalsIgnoreCase("bow")||x.getProfesja().equalsIgnoreCase("dagger")) {
                    if (x.mana < 8)
                    {
                        x.mana+=1;
                    }
                }

                y.hp -= x.atkbohater + x.atakcritical;
                Crit.startCrit(imagee);
            } else
                {
                    if(x.getProfesja().equalsIgnoreCase("bow")||x.getProfesja().equalsIgnoreCase("dagger")) {
                        if (x.mana < 8)
                        {
                            x.mana+=1;
                        }
                    }
                y.hp -= x.atkbohater;
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
            CountDownTimer t=    new CountDownTimer(1000, 100) {

                @Override
                public void onTick(long millisUntilFinished) {



                }

                @Override
                public void onFinish()
                {
                    b.setVisibility(View.VISIBLE);

                    b.setEnabled(true);
                    flagaSkilla=true;

                }
            }.start();

            if (y.hp < 0) {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
                Drop.drop(x, xhp, y, v);
                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {

                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzegranej.startAnim2(imageBatak);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
//                y.hp = yhp.hp;
                b.setEnabled(false);

            }
        }
        else
        {
            b.setVisibility(View.INVISIBLE);
        }
    }
    public static void walczzPotworemPVP(final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
        Random rand = new Random();
        int szansa = 0;
        int atakzCritem = (x.atkbohater-y.obrona)+x.atakcritical;
        int atak = (x.atkbohater-y.obrona);
        System.out.println(atak);


        if (x.hpbohater > 0 && y.hp > 0) {
            timer.setVisibility(View.VISIBLE);
            b.setEnabled(false);
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {


                if(atakzCritem<=0)
                {
                    y.hp=-1;
                }
                else
                {
                    y.hp -= atakzCritem;
                }
                Crit.startCrit(imagee);
            }
            else
            {


                if(atak<=0)
                {
                    y.hp=-1;
                }
                else
                {
                    y.hp -= atak;
                }
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
            CountDownTimer t=    new CountDownTimer(1000, 100) {

                @Override
                public void onTick(long millisUntilFinished) {



                }

                @Override
                public void onFinish()
                {
                    timer.setVisibility(View.INVISIBLE);

                    b.setEnabled(true);
                    flagaSkilla=true;

                }
            }.start();

            if (y.hp < 0) {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
//                Drop.drop(x, xhp, y, v);
//                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {

                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();

                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzegranej.startAnim2(imageBatak);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
//                y.hp = yhp.hp;
                b.setEnabled(false);

            }
        }
        else
        {
            timer.setVisibility(View.VISIBLE);
        }
    }

    public static void walnijzeskilla( final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, final Bohaterowie x, Bohaterowie xhp, final Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
        Random rand = new Random();
        int szansa = 0;

        if (x.hpbohater > 0 && y.hp > 0) {
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            timer.setVisibility(View.VISIBLE);
                b.setEnabled(false);
                flagaSkilla=false;
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()>=60)
                {
                    x.hpbohater+=300;
                    x.mana-=60;

                    y.hp-=(x.skillDamage+x.atkbohater+x.atakcritical)-y.obrona;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(x.hpbohater<=x.maxhp-50)
                            x.hpbohater=+50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).show();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()>=60)
                {
                    x.mana-=60;

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("bow"))
                {
                    if(x.getMana()>0)
                    {
                        if(x.getMana()<=2&&x.getMana()>0)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona-200;x.mana=0;
                        }
                        if(x.getMana()<=4&&x.getMana()>2)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona +100;x.mana=0;
                        }
                        if(x.getMana()<=6&&x.getMana()>4)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona +200;x.mana=0;
                        }
                        if(x.getMana()>6)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona +300;
                            x.mana=0;
                        }



                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();  }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                    }
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {
                    if(x.getMana()>0) {
                        if (x.getMana() <= 2 && x.getMana() > 0) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona-200;x.mana=0;
                        }
                        if (x.getMana() <= 4 && x.getMana() > 2) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona - 100;x.mana=0;
                        }
                        if (x.getMana() <= 6 && x.getMana() > 4) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona + 200;x.mana=0;
                        }
                        if (x.getMana() > 6) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona + 500;x.mana=0;
                        }


                    }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();

                    }
                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;

                               CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {



                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-599) {
                                x.hpbohater += 599;
                            }
                           x.obrona+=500;

                            CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                                }

                                @Override
                                public void onFinish()
                                {
//                                    x.hpbohater-=800;
                                    x.obrona-=500;
                                }
                            }.start();
                        }
                    }.start();

                }
                Crit.startCrit(imagee);
            } else
            {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getHpbohater()<=x.getMaxhp()-500&&x.getMana()>=60)
                {
                    x.mana-=60;
                    x.hpbohater+=500;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()>=60)
                {
                    x.mana-=60;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("bow"))
                {
                    if(x.getMana()>0) {
                        if (x.getMana() <= 2 && x.getMana() > 0) {
                            y.hp -= x.skillDamage + x.atkbohater - y.obrona-200;
                        }
                        if (x.getMana() <= 4 && x.getMana() > 2) {
                            y.hp -= x.skillDamage + x.atkbohater - y.obrona - 100;
                        }
                        if (x.getMana() <= 6 && x.getMana() > 4) {
                            y.hp -= x.skillDamage + x.atkbohater  - y.obrona + 200;
                        }
                        if (x.getMana() <= 8 && x.getMana() > 6) {
                            y.hp -= x.skillDamage + x.atkbohater - y.obrona + 400;
                        }
                        AnimacjaPrzegranej.startAnimWalka(anim);
                        x.mana=0;

                    }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();

                    }
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=20;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {
                    if(x.getMana()>0) {
                        if (x.getMana() <= 2 && x.getMana() > 0) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3)-400;
                            Crit.startCrit(imagee);
                        }
                        if (x.getMana() <= 4 && x.getMana() > 2) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3)- 300;
                            Crit.startCrit(imagee);
                        }
                        if (x.getMana() <= 6 && x.getMana() > 4) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3) + 200;
                            Crit.startCrit(imagee);
                        }
                        if (x.getMana() > 6) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3) + 500;
                            Crit.startCrit(imagee);
                        }
                        AnimacjaPrzegranej.startAnimWalka(anim);
                        x.mana=0;
                    }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();

                    }


                }
                if(x.getProfesja().equalsIgnoreCase("brak"))
                {

                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;
                                               CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()

                                {
                                    y.obrona+=250;
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-599) {
                                x.hpbohater += 599;
                            }
                            x.obrona+=300;
                            CountDownTimer t=    new CountDownTimer(2000, 2000) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.obrona-=300;
                                }
                            }.start();
                        }
                    }.start();

                }
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
//                AnimacjaPrzegranej.startAnimWalka(anim);

                CountDownTimer t=    new CountDownTimer(3000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {



                    }

                    @Override
                    public void onFinish()
                    {
                        timer.setVisibility(View.INVISIBLE);

                        b.setEnabled(true);
                        flagaSkilla=true;

                    }
                    }.start();



            if (y.hp < 0)
            {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
                Drop.drop(x, xhp, y, v);
                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {
                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();


//                y.hp = yhp.hp;
                b.setEnabled(false);

            }

        }
        else
        {
            timer.setVisibility(View.VISIBLE);
        }
    }
   public static void walnijzeskillaTest( ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, final Bohaterowie x, Bohaterowie xhp, final Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageView b) {
        Random rand = new Random();
        int szansa = 0;

        if (x.hpbohater > 0 && y.hp > 0) {
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            b.setVisibility(View.INVISIBLE);
                b.setEnabled(false);
                flagaSkilla=false;
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()>=60)
                {
                    x.hpbohater+=300;
                    x.mana-=60;

                    y.hp-=(x.skillDamage+x.atkbohater+x.atakcritical)-y.obrona;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(x.hpbohater<=x.maxhp-50)
                            x.hpbohater=+50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).show();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()>=60)
                {
                    x.mana-=60;

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }

                if(x.getProfesja().equalsIgnoreCase("bow"))
                {
                    if(x.getMana()>0)
                    {
                        if(x.getMana()<=2&&x.getMana()>0)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona-200;x.mana=0;
                        }
                        if(x.getMana()<=4&&x.getMana()>2)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona +100;x.mana=0;
                        }
                        if(x.getMana()<=6&&x.getMana()>4)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona +200;x.mana=0;
                        }
                        if(x.getMana()>6)
                        {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona +300;
                            x.mana=0;
                        }



                        CountDownTimer t=    new CountDownTimer(1000, 100) {

                            @Override
                            public void onTick(long millisUntilFinished) {
                                y.hp-=50;


                            }

                            @Override
                            public void onFinish()
                            {


                            }
                        }.start();  }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                    }
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {
                    if(x.getMana()>0) {
                        if (x.getMana() <= 2 && x.getMana() > 0) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona-200;x.mana=0;
                        }
                        if (x.getMana() <= 4 && x.getMana() > 2) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona - 100;x.mana=0;
                        }
                        if (x.getMana() <= 6 && x.getMana() > 4) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona + 200;x.mana=0;
                        }
                        if (x.getMana() > 6) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - y.obrona + 500;x.mana=0;
                        }


                    }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();

                    }
                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;

                               CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {



                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-599) {
                                x.hpbohater += 599;
                            }
                           x.obrona+=500;

                            CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                                }

                                @Override
                                public void onFinish()
                                {
//                                    x.hpbohater-=800;
                                    x.obrona-=500;
                                }
                            }.start();
                        }
                    }.start();

                }
                Crit.startCrit(imagee);
            } else
            {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getHpbohater()<=x.getMaxhp()-500&&x.getMana()>=60)
                {
                    x.mana-=60;
                    x.hpbohater+=500;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()>=60)
                {
                    x.mana-=60;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }

                if(x.getProfesja().equalsIgnoreCase("bow"))
                {
                    if(x.getMana()>0) {
                        if (x.getMana() <= 2 && x.getMana() > 0) {
                            y.hp -= x.skillDamage + x.atkbohater - y.obrona-200;
                        }
                        if (x.getMana() <= 4 && x.getMana() > 2) {
                            y.hp -= x.skillDamage + x.atkbohater - y.obrona - 100;
                        }
                        if (x.getMana() <= 6 && x.getMana() > 4) {
                            y.hp -= x.skillDamage + x.atkbohater  - y.obrona + 200;
                        }
                        if (x.getMana() <= 8 && x.getMana() > 6) {
                            y.hp -= x.skillDamage + x.atkbohater - y.obrona + 400;
                        }
                        x.mana=0;

                    }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();

                    }
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=20;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {
                    if(x.getMana()>0) {
                        if (x.getMana() <= 2 && x.getMana() > 0) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3)-400;
                            Crit.startCrit(imagee);
                        }
                        if (x.getMana() <= 4 && x.getMana() > 2) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3)- 300;
                            Crit.startCrit(imagee);
                        }
                        if (x.getMana() <= 6 && x.getMana() > 4) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3) + 200;
                            Crit.startCrit(imagee);
                        }
                        if (x.getMana() > 6) {
                            y.hp -= x.skillDamage + x.atkbohater + x.atakcritical - (y.obrona / 3) + 500;
                            Crit.startCrit(imagee);
                        }
                        x.mana=0;
                    }
                    else
                    {
                        Snackbar.make(v, "Brak Chęci mordu", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();

                    }


                }
                if(x.getProfesja().equalsIgnoreCase("brak"))
                {

                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;
                                               CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()

                                {
                                    y.obrona+=250;
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-599) {
                                x.hpbohater += 599;
                            }
                            x.obrona+=300;
                            CountDownTimer t=    new CountDownTimer(2000, 2000) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.obrona-=300;
                                }
                            }.start();
                        }
                    }.start();

                }
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
                AnimacjaPrzegranej.startAnimWalka(anim);

                CountDownTimer t=    new CountDownTimer(3000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {



                    }

                    @Override
                    public void onFinish()
                    {
                        b.setVisibility(View.VISIBLE);

                        b.setEnabled(true);
                        flagaSkilla=true;

                    }
                    }.start();



            if (y.hp < 0)
            {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
                Drop.drop(x, xhp, y, v);
                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {
                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();


//                y.hp = yhp.hp;
                b.setEnabled(false);

            }

        }
        else
        {
            b.setVisibility(View.INVISIBLE);
        }
    }
    public static void walnijzeskillaMana(final TextView energia, final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, final Bohaterowie x, Bohaterowie xhp, final Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
        Random rand = new Random();
        int szansa = 0;

        if (x.hpbohater > 0 && y.hp > 0) {
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            timer.setVisibility(View.VISIBLE);
                b.setEnabled(false);
                flagaSkilla=false;
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()>=60)
                {
                    x.hpbohater+=300;
                    x.mana-=60;
                    energia.setText(x.mana);
                    y.hp-=(x.skillDamage+x.atkbohater+x.atakcritical)-y.obrona;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(x.hpbohater<=x.maxhp-50)
                            x.hpbohater=+50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).show();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()>=60)
                {
                    x.mana-=60;
                    energia.setText(x.mana);
                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("bow"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;

                               CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {



                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-599) {
                                x.hpbohater += 599;
                            }
                           x.obrona+=500;

                            CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                                }

                                @Override
                                public void onFinish()
                                {
//                                    x.hpbohater-=800;
                                    x.obrona-=500;
                                }
                            }.start();
                        }
                    }.start();

                }
                Crit.startCrit(imagee);
            } else
            {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getHpbohater()<=x.getMaxhp()-500&&x.getMana()>=60)
                {    energia.setText(x.mana);
                    x.mana-=60;
                    x.hpbohater+=500;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()>=60)
                {    energia.setText(x.getMana());
                    x.mana-=60;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("ogien")&&x.getMana()<60)
                {
                    Snackbar.make(v, "Brak Many", Snackbar.LENGTH_SHORT).setDuration(1500).setActionTextColor(Color.RED).show();
                }
                if(x.getProfesja().equalsIgnoreCase("bow"))
                {
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=20;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-(y.obrona/3);
                    Crit.startCrit(imagee);
                }
                if(x.getProfesja().equalsIgnoreCase("brak"))
                {

                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;
                                               CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()

                                {
                                    y.obrona+=250;
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-599) {
                                x.hpbohater += 599;
                            }
                            x.obrona+=300;
                            CountDownTimer t=    new CountDownTimer(2000, 2000) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.obrona-=300;
                                }
                            }.start();
                        }
                    }.start();

                }
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
                AnimacjaPrzegranej.startAnimWalka(anim);

                CountDownTimer t=    new CountDownTimer(3000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {



                    }

                    @Override
                    public void onFinish()
                    {
                        timer.setVisibility(View.INVISIBLE);

                        b.setEnabled(true);
                        flagaSkilla=true;

                    }
                    }.start();



            if (y.hp < 0)
            {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
                Drop.drop(x, xhp, y, v);
                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {
                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();


//                y.hp = yhp.hp;
                b.setEnabled(false);

            }

        }
        else
        {
            timer.setVisibility(View.VISIBLE);
        }
    }
    public static void walnijzeskillaPVP(final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, final Bohaterowie x, Bohaterowie xhp, final Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
        Random rand = new Random();
        int szansa = 0;

        if (x.hpbohater > 0 && y.hp > 0) {
            AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
            timer.setVisibility(View.VISIBLE);
                b.setEnabled(false);
                flagaSkilla=false;
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {

                if(x.getProfesja().equalsIgnoreCase("woda"))
                {
                    if(x.hpbohater<=x.maxhp-300) {
                        x.hpbohater += 300;
                    }
                        y.hp-=(x.skillDamage+x.atkbohater+x.atakcritical)-y.obrona;
                }
                if(x.getProfesja().equalsIgnoreCase("ogien"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("bow"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {
                    y.obrona-=250;
                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            x.atkbohater+=300;
                            CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    y.obrona+=250;
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {



                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.hpbohater-300) {
                                x.hpbohater += 300;
                            }x.obrona+=500;

                            CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {
//                            x.hpbohater+=800;
//                            x.obrona+=500;


                                }

                                @Override
                                public void onFinish()
                                {
//                                    x.hpbohater-=800;
                                    x.obrona-=500;
                                }
                            }.start();
                        }
                    }.start();

                }
                Crit.startCrit(imagee);
            } else
            {

                if(x.getProfesja().equalsIgnoreCase("woda")&&x.getHpbohater()<=x.getMaxhp()-500)
                {
                    if(x.hpbohater<=x.maxhp-500) {
                        x.hpbohater += 500;
                    }
                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                }
                if(x.getProfesja().equalsIgnoreCase("ogien"))
                {

                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=50;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("bow"))
                {
                    y.hp-=(x.skillDamage+x.atkbohater)-y.obrona;;
                    CountDownTimer t=    new CountDownTimer(1000, 100) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            y.hp-=20;


                        }

                        @Override
                        public void onFinish()
                        {


                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("dagger"))
                {

                    y.hp-=x.skillDamage+x.atkbohater+x.atakcritical-(y.obrona/3);
                    Crit.startCrit(imagee);
                }
                if(x.getProfesja().equalsIgnoreCase("brak"))
                {

                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                }
                if(x.getProfesja().equalsIgnoreCase("berserker"))
                {

                    y.hp-=x.skillDamage+x.atkbohater-y.obrona;;

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        { y.obrona-=250;
                            x.atkbohater+=300;
                            CountDownTimer t=    new CountDownTimer(1500, 1500) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {

                                    y.obrona+=250;
                                    x.atkbohater-=300;
                                }
                            }.start();
                        }
                    }.start();
                }
                if(x.getProfesja().equalsIgnoreCase("paladyn"))
                {

                    CountDownTimer t=    new CountDownTimer(1, 1) {

                        @Override
                        public void onTick(long millisUntilFinished) {



                        }

                        @Override
                        public void onFinish()
                        {
                            if(x.hpbohater<=x.maxhp-300)
                            {
                                x.hpbohater+=300;
                            }
                            x.obrona+=300;

                            CountDownTimer t=    new CountDownTimer(2000, 2000) {

                                @Override
                                public void onTick(long millisUntilFinished) {



                                }

                                @Override
                                public void onFinish()
                                {
                                    x.hpbohater-=999999;
                                    x.obrona-=300;
                                }
                            }.start();
                        }
                    }.start();

                }
                AnimacjaPrzegranej.startAnimWalka(anim);
            }
            AnimacjaPrzegranej.startAnimWalka(anim);

            CountDownTimer t=    new CountDownTimer(3000, 100) {

                @Override
                public void onTick(long millisUntilFinished) {



                }

                @Override
                public void onFinish()
                {
                    timer.setVisibility(View.INVISIBLE);

                    b.setEnabled(true);
                    flagaSkilla=true;

                }
            }.start();



            if (y.hp < 0)
            {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

//            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
//                Drop.drop(x, xhp, y, v);
//                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
//                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {
                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();


//                y.hp = yhp.hp;
                b.setEnabled(false);

            }

        }
        else
        {
            timer.setVisibility(View.VISIBLE);
        }
    }

    public static void walcz4(ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, Button b) {
        Random rand = new Random();
        int szansa = 0;
        AnimacjaPrzegranej.startAnimacjaWalk(imageB, imageBatak);
        AnimacjaPrzeciwnika.startAnim(imageP, imageB);
        if (x.hpbohater > 0 && y.hp > 0) {
            if (x.nazwa.equals("Archer")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Mag")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            } else if (x.nazwa.equals("Paladyn")) {
                szansa = rand.nextInt(x.odlegloscKrytyczna) + 1;
            }

            if (x.odlegloscKrytyczna == szansa) {
                x.hpbohater -= y.atk;
                y.hp -= x.atkbohater + x.atakcritical;
                Crit.startCrit(imagee);
            } else
                {
                x.hpbohater -= y.atk;
                y.hp -= x.atkbohater;
                AnimacjaPrzegranej.startAnimWalka(anim);
            }


            if (y.hp < 0) {

                y.hp = 0;
            } else if (x.hpbohater < 0) {

                x.hpbohater = 0;
            } else if (x.hpbohater < 0 && y.hp < 0) {

                x.hpbohater = 0;
                y.hp = 0;
            }

            textHpB.setText("Hp Bohatera to: " + x.hpbohater);
            textHpP.setText("Hp Potwora to: " + y.hp);

            if (y.hp <= 0) {
                Drop.drop(x, xhp, y, v);
                ExpLvl.LvlUp(x, xhp, y, yhp, v);

                b.setEnabled(false);
                AnimacjaPrzegranej.startAnim2(imageP);
                y.hp = yhp.hp;


            }
            if (x.hpbohater <= 0) {
                AnimacjaPrzegranej.startAnim2(imageB);
                AnimacjaPrzeciwnika.gin(imageB);
                AnimacjaPrzeciwnika.gin(imageBatak);
                Snackbar.make(v, "Przegrałeś, wróć się uleczyć", Snackbar.LENGTH_SHORT).setDuration(3000).setActionTextColor(Color.RED).show();


//                y.hp = yhp.hp;
                b.setEnabled(false);

            }
        }
    }

    ;
}





