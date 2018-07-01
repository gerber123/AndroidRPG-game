package pl.marcinos.expfor2.IntroActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;
import static pl.marcinos.expfor2.IntroActivity.SignUp.user123Registered;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class SignUpCharacter extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users;
    Button buttonWybierzLucznika;
    Button buttonWybierzMaga;
    Button buttonWybierzWojownika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_character);

//         final String paladynek = "paladyn";

        buttonWybierzLucznika=(Button)findViewById(R.id.buttonWybierzLucznika);
        buttonWybierzMaga=(Button)findViewById(R.id.buttonWybierzMaga);
        buttonWybierzWojownika=(Button)findViewById(R.id.buttonWybierzWojownika);


//
//        database= FirebaseDatabase.getInstance();
//        users=database.getReference("Users");




        buttonWybierzLucznika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user123Registered.setBohater("archer");
                Intent intent = new Intent(SignUpCharacter.this,SignUpReady.class);
                startActivity(intent);
                finish();
//                final User user=new User(user123Registered.getUserName(),user123Registered.getPassword()
//                        ,user123Registered.getEmail(),user123Registered.getBohater());


//                archer.setUserName(user.getUserName());
//                archer.setPassword(user.getPassword());
//                archer.setEmail(user.getEmail());
//                archer.setVoteScore(user.getVoteScore());
////                archer.setBohater(user.getBohater());
//                if(user.getBohater().equalsIgnoreCase("archer")) {
//                    users.child(user123Registered.getUserName()).setValue(user);
//                    Toast.makeText(SignUpCharacter.this,"Utworzono Konto",Toast.LENGTH_SHORT).show();
//                    finish();
//                }

            }
        });

        buttonWybierzMaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                user123Registered.setBohater("mag");
                Intent intent = new Intent(SignUpCharacter.this,SignUpReady.class);
                startActivity(intent);
                finish();
//                final User user=new User(user123Registered.getUserName(),user123Registered.getPassword()
//                        ,user123Registered.getEmail(),user123Registered.getBohater());
//
//
//                if(user.getBohater().equalsIgnoreCase("mag")) {
//                    users.child(user123Registered.getUserName()).setValue(user);
//                    Toast.makeText(SignUpCharacter.this,"Utworzono Konto",Toast.LENGTH_SHORT).show();
//                    finish();
//                }

            }
        });

        buttonWybierzWojownika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user123Registered.setBohater("paladyn");

                Intent intent = new Intent(SignUpCharacter.this,SignUpReady.class);
                startActivity(intent);
                finish();
//                final User user=new User(user123Registered.getUserName(),user123Registered.getPassword()
//                        ,user123Registered.getEmail(),user123Registered.getBohater());
//

//                        paladyn.setUserName(user.getUserName());
//                        paladyn.setPassword(user.getPassword());
//                        paladyn.setEmail(user.getEmail());
//                        paladyn.setVoteScore(user.getVoteScore());
//                        paladyn.setBohater(user.getBohater());
//                        if(user.getBohater().equalsIgnoreCase("paladyn")) {
//                            users.child(user123Registered.getUserName()).setValue(user);
//                            Toast.makeText(SignUpCharacter.this,"Utworzono Konto",Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });



            }
        });


    }
}
