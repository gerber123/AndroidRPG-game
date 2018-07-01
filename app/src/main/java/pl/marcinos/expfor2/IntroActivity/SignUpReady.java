package pl.marcinos.expfor2.IntroActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.IntroActivity.SignUp.user123Registered;

public class SignUpReady extends AppCompatActivity {
ImageView czaszka;
    Button buttonSignUp;
    FirebaseDatabase database;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_ready);

        czaszka=(ImageView)findViewById(R.id.czacha);
        startAnim(czaszka);

        database= FirebaseDatabase.getInstance();
        users=database.getReference("Users");
        buttonSignUp=(Button)findViewById(R.id.btnSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user=new User(user123Registered.getUserName(),user123Registered.getPassword()
                        ,user123Registered.getEmail(),user123Registered.getBohater());


                users.child(user123Registered.getUserName()).setValue(user);
                Toast.makeText(SignUpReady.this,"Utworzono Konto",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }



    private void startAnim(final ImageView logo)
    {
        Animation scale = new ScaleAnimation(1f,1.2f,1f,1.2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


        scale.setDuration(2000);
        scale.setFillAfter(true);
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                startAnim2(logo);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo.startAnimation(scale);

    }
    private void startAnim2(final ImageView logo)
    {
        Animation scale = new ScaleAnimation(1.2f,1f,1.2f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


        scale.setDuration(2000);
        scale.setFillAfter(true);
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                startAnim(logo);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo.startAnimation(scale);
    }
}
