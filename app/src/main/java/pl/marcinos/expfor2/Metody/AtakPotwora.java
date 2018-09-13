package pl.marcinos.expfor2.Metody;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Potwory.Potwory;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.uzytyPotekHp;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.uzytyPotekMp;
import static pl.marcinos.expfor2.Potwory.Potwory.kot;
import static pl.marcinos.expfor2.Potwory.Potwory.kothp;

/**
 * Created by marci on 29.03.2018.
 */

public class AtakPotwora
{

    public static void AtakPotwora(final ImageView imageB,final ImageView imageBatakuj, final ImageView imageP, final Bohaterowie x, final Potwory y, final Potwory yhp, final TextView textHpB, final View v, final ProgressBar progresHpB, final ProgressBar progresHpP, final ImageButton button1, final ImageButton button2, final ImageButton button3)
    {
        CountDownTimer t=    new CountDownTimer(1000, 100) {

            @Override
            public void onTick(long millisUntilFinished) {



            }

            @Override
            public void onFinish() {
                if(y.hp>0) {

                    start();
                    Walka.atakPotwora(imageB,imageBatakuj, imageP,x,y,yhp,textHpB,v,button1,button2,button3);
//                            findViewById(android.R.id.content), buttonWalcz);
                    progresHpB.setProgress(x.hpbohater);
                    progresHpP.setProgress(y.hp);
                }
                if(y.hp<=0) {

                    this.cancel();

                }
                if(x.hpbohater<0||y.hp<0)
                {
                    this.cancel();

                }
                if(y.hp<0)
                {
                    this.cancel();

                }
                if(x.hpbohater<0)
                {
                    this.cancel();
                    AnimacjaPrzegranej.startAnim2(imageB);
                    AnimacjaPrzeciwnika.gin(imageB);
                    AnimacjaPrzeciwnika.gin(imageBatakuj);
                }
            }

        }.start();

    }
    public static void AtakPotworaPotki(final ImageView hpPotek, final ImageView mpPotek, final ImageView imageB,final ImageView imageBatakuj, final ImageView imageP, final Bohaterowie x, final Potwory y, final Potwory yhp, final TextView textHpB, final View v, final ProgressBar progresHpB, final ProgressBar progresHpP, final ImageButton button1, final ImageButton button2, final ImageButton button3)
    {
        CountDownTimer t=    new CountDownTimer(1000, 100) {


            @Override
            public void onTick(long millisUntilFinished) {



            }

            @Override
            public void onFinish() {
                if(y.hp>0) {

                    start();
                    Walka.atakPotwora(imageB,imageBatakuj, imageP,x,y,yhp,textHpB,v,button1,button2,button3);
//                            findViewById(android.R.id.content), buttonWalcz);
                    progresHpB.setProgress(x.hpbohater);
                    progresHpP.setProgress(y.hp);
                    if(x.getMana()<=300&&uzytyPotekMp==0)
                    {
                        mpPotek.setEnabled(true);
                        mpPotek.setVisibility(View.VISIBLE);
                        uzytyPotekMp+=1;

                    }
                    if(x.getHpbohater()<=x.getMaxhp()-300&&uzytyPotekHp==0)
                    {
                        hpPotek.setEnabled(true);
                        hpPotek.setVisibility(View.VISIBLE);
                        uzytyPotekHp+=1;
                    }
                }
                if(y.hp<=0) {

                    this.cancel();

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;

                }
                if(x.hpbohater<0||y.hp<0)
                {
                    this.cancel();

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;

                }
                if(y.hp<0)
                {
                    this.cancel();

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;

                }
                if(x.hpbohater<0)
                {
                    this.cancel();
                    AnimacjaPrzegranej.startAnim2(imageB);
                    AnimacjaPrzeciwnika.gin(imageB);
                    AnimacjaPrzeciwnika.gin(imageBatakuj);

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;
                }
            }

        }.start();

    }
    public static void AtakPotworaPotkiTest(final ImageView hpPotek, final ImageView mpPotek, final ImageView imageB,final ImageView imageBatakuj, final ImageView imageP, final Bohaterowie x, final Potwory y, final Potwory yhp, final TextView textHpB, final View v, final ProgressBar progresHpB, final ProgressBar progresHpP, final ImageView button1, final ImageView button2)
    {
        CountDownTimer t=    new CountDownTimer(1000, 100) {


            @Override
            public void onTick(long millisUntilFinished) {



            }

            @Override
            public void onFinish() {
                if(y.hp>0) {

                    start();
                    Walka.atakPotworaTest(imageB,imageBatakuj, imageP,x,y,yhp,textHpB,v,button1,button2);
//                            findViewById(android.R.id.content), buttonWalcz);
                    progresHpB.setProgress(x.hpbohater);
                    progresHpP.setProgress(y.hp);
                    if(x.getMana()<=300&&uzytyPotekMp==0&&x.getProfesja().equalsIgnoreCase("ogien")||x.getProfesja().equalsIgnoreCase("woda"))
                    {
                        mpPotek.setEnabled(true);
                        mpPotek.setVisibility(View.VISIBLE);
                        uzytyPotekMp+=1;

                    }
                    if(x.getHpbohater()<=x.getMaxhp()-300&&uzytyPotekHp==0)
                    {
                        hpPotek.setEnabled(true);
                        hpPotek.setVisibility(View.VISIBLE);
                        uzytyPotekHp+=1;
                    }
                }
                if(y.hp<=0) {

                    this.cancel();

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;

                }
                if(x.hpbohater<0||y.hp<0)
                {
                    this.cancel();

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;

                }
                if(y.hp<0)
                {
                    this.cancel();

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;

                }
                if(x.hpbohater<0)
                {
                    this.cancel();
                    AnimacjaPrzegranej.startAnim2(imageB);
                    AnimacjaPrzeciwnika.gin(imageB);
                    AnimacjaPrzeciwnika.gin(imageBatakuj);

                    uzytyPotekHp=0;
                    uzytyPotekMp=0;
                }
            }

        }.start();

    }
    public static void AtakPvpPrzeciwnik(final ImageView imageB,final ImageView imageBatakuj, final ImageView imageP,final ImageView imagePatakuj, final Bohaterowie x, final Potwory y, final Potwory yhp, final TextView textHpB, final View v, final ProgressBar progresHpB, final ProgressBar progresHpP, final ImageButton button1, final ImageButton button2, final ImageButton button3)
    {
        imageP.setVisibility(View.VISIBLE);
        CountDownTimer t=    new CountDownTimer(1000, 100) {

            @Override
            public void onTick(long millisUntilFinished) {



            }

            @Override
            public void onFinish() {
                if(y.hp>0) {

                    start();
                    Walka.atakPvpPrzeciwnik(imageB,imageBatakuj, imageP,imagePatakuj,x,y,yhp,textHpB,v,button1,button2,button3);
//                            findViewById(android.R.id.content), buttonWalcz);
                    progresHpB.setProgress(x.hpbohater);
                    progresHpP.setProgress(y.hp);
                }
                if(y.hp<=0) {
                    AnimacjaPrzegranej.startAnim2(imageP);
                    AnimacjaPrzeciwnika.gin(imageP);
                    AnimacjaPrzeciwnika.gin(imagePatakuj);
                    this.cancel();

                }
                if(x.hpbohater<0||y.hp<0)
                {
                    this.cancel();

                }
                if(y.hp<0)
                {
                    this.cancel();

                }
                if(x.hpbohater<0)
                {
                    this.cancel();
                    AnimacjaPrzegranej.startAnim2(imageB);
                    AnimacjaPrzeciwnika.gin(imageB);
                    AnimacjaPrzeciwnika.gin(imageBatakuj);
                }
            }

        }.start();

    }
}
