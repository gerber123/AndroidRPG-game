package pl.marcinos.expfor2.Metody;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Mag.Walka.Walka.Walka.MagKot;
import pl.marcinos.expfor2.R;

/**
 * Created by marci on 10.03.2018.
 */

public class AnimacjaPrzegranej {
    public static ImageView g;


    public static void startAnim1(ImageView image) {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(200);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }

    public static void startAnim2(ImageView image) {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(1500);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
    public static void startAnimWalka(final ImageView image) {
        image.setVisibility(View.VISIBLE);
        Animation alpha = new AlphaAnimation(0f, 1f);

        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                startAnimWalkaschowaj(image);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
    public static void startAnimWalkaschowaj(ImageView image)
    {

        Animation alpha = new AlphaAnimation(1f, 0f);

        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }

    public static void startAnimacjaWalk(final ImageView image,final  ImageView imageB)
    {
        imageB.setVisibility(View.VISIBLE);
        Animation alpha = new AlphaAnimation(0f, 1f);


        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                walkaZnikniecie(image);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                walkaPojawienie(image);
                walkaZnikniecieAtaku(imageB);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageB.startAnimation(alpha);
    }
    public static void walkaZnikniecie(final ImageView image)
    {

        Animation alpha = new AlphaAnimation(1f, 0f);




        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
    public static void walkaPojawienie(final ImageView image)
    {

        Animation alpha = new AlphaAnimation(0f, 1f);




        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
    public static void walkaZnikniecieAtaku(final ImageView image)
    {

        Animation alpha = new AlphaAnimation(1f, 0f);




        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }

}
