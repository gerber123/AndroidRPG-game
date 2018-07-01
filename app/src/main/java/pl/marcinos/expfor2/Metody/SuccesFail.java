package pl.marcinos.expfor2.Metody;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import pl.marcinos.expfor2.IntroActivity.LoginActivity;
import pl.marcinos.expfor2.IntroActivity.MainActivity;

/**
 * Created by marci on 10.05.2018.
 */

public class SuccesFail {
    public static void startAnim(final ImageView image)
    {
        image.setVisibility(ImageView.VISIBLE);
        Animation scale = new ScaleAnimation(1f,1.5f,1f,1.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


        scale.setDuration(1000);
        scale.setFillAfter(true);
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                startAnim2(image);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(scale);

    }
    public static void startAnim2(final ImageView image)
    {
        Animation alpha = new AlphaAnimation(1f,0f);
        alpha.setDuration(500);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

                image.setVisibility(ImageView.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
}
