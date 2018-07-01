package pl.marcinos.expfor2.IntroActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Model.User;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.IntroActivity.LoginActivity.user123;

/**
 * Created by marci on 04.04.2018.
 */

public class eeee {
    FirebaseDatabase database;
    DatabaseReference users;
  public  void   gowno ()
    {

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


}}
