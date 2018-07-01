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

                y.hp -= x.atkbohater + x.atakcritical;
                Crit.startCrit(imagee);
            } else
                {

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
    public static void walczzPotworemPVP(final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
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

                int atakzcritem = (x.atkbohater + x.atakcritical)-y.obrona;
                int atak=(x.atkbohater-y.obrona);
                if(atakzcritem<=0)
                {
                    y.hp=-1;
                }
                else
                {
                    y.hp -= atakzcritem;
                }
                Crit.startCrit(imagee);
            }
            else
            {

                int atak=x.atkbohater-y.obrona;
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

    public static void walnijzeskilla(final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
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

                y.hp -= x.atkbohater + x.atakcritical+x.skillDamage;
                Crit.startCrit(imagee);
            } else
            {

                y.hp -= x.atkbohater+x.skillDamage;
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
    public static void walnijzeskillaPVP(final ImageView timer, ImageView imagee, ImageView anim, ImageView imageBatak, ImageView imageB, ImageView imageP, Bohaterowie x, Bohaterowie xhp, Potwory y, Potwory yhp, TextView textHpB, TextView textHpP, View v, final ImageButton b) {
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
                int atakCritSkill = (x.atkbohater+x.atakcritical+x.skillDamage)-y.obrona;
                if(atakCritSkill<=0)
                {
                    y.hp-=1;
                }
                else
                {
                    y.hp -= atakCritSkill;
                }

                Crit.startCrit(imagee);
            }
            else
            {

                int atakSkill =(x.atkbohater+ x.skillDamage)-y.obrona;
                if(atakSkill<=0)
                {
                    y.hp-=1;
                }
                else
                {
                    y.hp -= atakSkill;
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





