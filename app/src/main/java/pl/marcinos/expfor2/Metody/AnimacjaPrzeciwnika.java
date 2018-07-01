package pl.marcinos.expfor2.Metody;

import android.media.Image;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;

/**
 * Created by marci on 13.03.2018.
 */

public class AnimacjaPrzeciwnika
{
public static void startAnim(final ImageView image,final ImageView image2)
{
    float b = image.getX();
    float a = -image2.getPivotX();
    float c = a-b;
    Animation scale = new TranslateAnimation(0f,a-100f,0f,0f);
    final Animation scale1 = new TranslateAnimation(a-100f,0f,0f,0f);
    scale.setDuration(500);
    scale.setFillAfter(true);
    scale1.setDuration(500);
    scale1.setFillAfter(true);


    scale.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
        image.startAnimation(scale1);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });
    image.startAnimation(scale);
}
public static void startAnim1(final ImageView image,final ImageView image2,final ImageView image3)
{
    float b = image.getX();
    float a = -image2.getPivotX();
    float c = a-b;
    Animation scale = new TranslateAnimation(0f,a+100f,0f,0f);
    final Animation scale1 = new TranslateAnimation(a+100f,0f,0f,0f);
    scale.setDuration(500);
    scale.setFillAfter(true);
    scale1.setDuration(500);
    scale1.setFillAfter(true);


    scale.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            startAnimWalka(image3);
        image.startAnimation(scale1);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });
    image.startAnimation(scale);
}
    public static void startAnimWalka(final ImageView image) {
        image.setVisibility(View.VISIBLE);
        Animation alpha = new AlphaAnimation(0f, 1f);

            alpha.setDuration(150);
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

        alpha.setDuration(150);
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
    public static void gin(ImageView image)
    {

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

}
