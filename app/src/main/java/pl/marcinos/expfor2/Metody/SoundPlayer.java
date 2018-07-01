package pl.marcinos.expfor2.Metody;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import pl.marcinos.expfor2.R;

/**
 * Created by marci on 22.03.2018.
 */

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSound;
    private static int overSound;


    public SoundPlayer(Context context)
    {
        soundPool= new SoundPool(2, AudioManager.STREAM_MUSIC,0);

        hitSound = soundPool.load(context, R.raw.hit,1);
        overSound = soundPool.load(context,R.raw.trolo,1);
    }

    public void playHitSound()
    {
        soundPool.play(hitSound,1.0f,1.0f,1,0,1.0f);

    }
    public void playOverSound()
  {
       soundPool.play(overSound,1.0f,1.0f,1,0,1.0f);
   }
}
