package pl.marcinos.expfor2.Metody;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;

/**
 * Created by marci on 30.03.2018.
 */

public class ButtonPotkow {
public static void uzyjPota(Bohaterowie x,Bohaterowie xhp, ImageView imageStopPotek, ImageButton imageButton, TextView textHpB, ProgressBar progresHpB)
{
    if(x.hpbohater>0&&x.hpbohater<=xhp.hpbohater-300)
    {
        imageStopPotek.setVisibility(View.VISIBLE);
        x.hpbohater+=300;
        imageButton.setEnabled(false);
        textHpB.setText("Hp bohatera: "+x.hpbohater);
        progresHpB.setProgress(x.hpbohater);


    }
    else if(x.hpbohater<=0)
    {
        imageStopPotek.setVisibility(View.VISIBLE);
        imageButton.setEnabled(false);
    }
    else
    {

    }
}
}
