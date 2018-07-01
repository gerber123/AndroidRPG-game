package pl.marcinos.expfor2.Metody;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.Random;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;

/**
 * Created by marci on 14.03.2018.
 */

public class Crit
{
    public static void startCrit(final ImageView image) {
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

}
