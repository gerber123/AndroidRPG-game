package pl.marcinos.expfor2.IntroActivity;

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
import com.rengwuxian.materialedittext.MaterialEditText;

import pl.marcinos.expfor2.Model.CurrentUser;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;
import static pl.marcinos.expfor2.Mag.Menu.MagMenuActivity.mag;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class SignUp extends AppCompatActivity {


    static MaterialEditText edtNewUser;
    MaterialEditText edtNewPassword;
    MaterialEditText edtNewEmail;
    MaterialEditText edtNewBohater;
    Button IdzDalej;
    public static CurrentUser user123Registered = new CurrentUser();

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        database= FirebaseDatabase.getInstance();
        users=database.getReference("Users");

        edtNewUser=(MaterialEditText)findViewById(R.id.edtNewUserName);
        edtNewPassword=(MaterialEditText)findViewById(R.id.edtNewPassword);
        edtNewEmail=(MaterialEditText)findViewById(R.id.edtNewEmail);


        IdzDalej=(Button)findViewById(R.id.btnSignUp);
        IdzDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {   users.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(edtNewUser.getText().toString()).exists())
                    {
                        Toast.makeText(SignUp.this,"Taki użytkownik już istnieje", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {

                        user123Registered.setUserName(edtNewUser.getText().toString());
                        user123Registered.setPassword(edtNewPassword.getText().toString());
                        user123Registered.setEmail(edtNewEmail.getText().toString());
                        Intent intent = new Intent(SignUp.this,SignUpCharacter.class);
                        startActivity(intent);
                        SignUp.this.finish();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            }
        });




    }
}
