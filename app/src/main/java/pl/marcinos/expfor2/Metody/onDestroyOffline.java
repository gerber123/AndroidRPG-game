package pl.marcinos.expfor2.Metody;

import android.os.CountDownTimer;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Model.User;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archerhp;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

/**
 * Created by marci on 10.05.2018.
 */

public class onDestroyOffline
{
    public static void onDestroyVoid( FirebaseDatabase database, DatabaseReference userss)
    {
    database=FirebaseDatabase.getInstance();


    userss=database.getReference("Users");

    final DatabaseReference finalUserss = userss;
        userss.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        User login = dataSnapshot.child(user123.getUserName()).getValue(User.class);
//        login.setOnline(2);
//                        CountDownTimer t=    new CountDownTimer(3000, 100) {
//
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//
//
//
//                            }
//
//                            @Override
//                            public void onFinish()
//                            {
//
//
//                            }
//                        }.start();
//


        finalUserss.child(user123.getUserName()).setValue(login);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
}

}
