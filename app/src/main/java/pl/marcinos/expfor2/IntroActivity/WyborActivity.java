package pl.marcinos.expfor2.IntroActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity;
import pl.marcinos.expfor2.Mag.Menu.MagMenuActivity;
import pl.marcinos.expfor2.Metody.SoundPlayer;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.R;

public class WyborActivity extends AppCompatActivity {

    Button buttonMag;
    Button buttonPaladyn;
    Button buttonLucznik;
    SoundPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybor);
        Button buttonMag = (Button)findViewById(R.id.wyborMag);
        Button buttonPaladyn = (Button)findViewById(R.id.wyborPaladyn);
        Button buttonLucznik = (Button)findViewById(R.id.wyborLucznik);
        
        buttonMag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WyborActivity.this, MagMenuActivity.class);
                startActivity(intent);

               // WyborActivity.this.finish();

            }
        });
        buttonPaladyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WyborActivity.this, PaladynMenuActivity.class);
                startActivity(intent);

             //   WyborActivity.this.finish();
            }
        });
        buttonLucznik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WyborActivity.this, ArcherMenuActivity.class);
                startActivity(intent);


              //  WyborActivity.this.finish();
            }
        });


    }
}
