package pl.marcinos.expfor2.Metody;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.expfor2.Bohaterowie.Bohaterowie;
import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.Potwory.Potwory;

import pl.marcinos.expfor2.R;



public class Ograbienie
{

    public static void OgrabLubNie(FirebaseDatabase database, DatabaseReference userss, final Potwory przeciwnikpvp) {


        database = FirebaseDatabase.getInstance();


        userss = database.getReference("Users");

        final DatabaseReference finalUserss = userss;
        userss.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User przeciwnik = dataSnapshot.child(przeciwnikpvp.getNazwaPrzeciwnika()).getValue(User.class);


                przeciwnik.setHpbohater(Integer.parseInt(przeciwnikpvp.getHp()));
                przeciwnik.setHajs(przeciwnikpvp.getHajs());
                finalUserss.child(przeciwnik.getUserName()).setValue(przeciwnik);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public static void HonorLubNie(FirebaseDatabase database, DatabaseReference userss, final Potwory przeciwnikpvp)
    {


        database=FirebaseDatabase.getInstance();


        userss=database.getReference("Users");

        final DatabaseReference finalUserss = userss;
        userss.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User przeciwnikk = dataSnapshot.child(przeciwnikpvp.getNazwaPrzeciwnika()).getValue(User.class);



                przeciwnikk.setHpbohater(Integer.parseInt(przeciwnikpvp.getHp()));
                przeciwnikk.setPunktyHonoru(przeciwnikpvp.getPunktyHonoruPvp());

                finalUserss.child(przeciwnikpvp.getNazwaPrzeciwnika()).setValue(przeciwnikk);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public static int hajsSkradziony =0;
   public static void nextFightDialog (final AlertDialog.Builder abc,final AlertDialog.Builder b, final View v, final Potwory przeciwnikpvp, final Bohaterowie bohater, final FirebaseDatabase database, final DatabaseReference userss) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Honor czy Złoto?");
        alertDialogBuilder.setMessage("Czy ograbić przeciwnika czy zyskac na honorze?");

       alertDialogBuilder.setPositiveButton(("Dawaj jego łupy"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                int hpprzeciwnikapoczatkowy = Integer.parseInt(przeciwnikpvp.getHp());
                int a = (przeciwnikpvp.getHajs()*5)/100;
                przeciwnikpvp.setHajs(przeciwnikpvp.getHajs()-a);
                bohater.hajs = bohater.getHajs() + a;
                bohater.punktyHonoru=bohater.getPunktyHonoru()-1;
                hajsSkradziony=a;
                OgrabLubNie(database,userss,przeciwnikpvp);
                AlertDialog alertDialoggg = b.create();

                alertDialoggg.show();

                Snackbar.make(v,"Ukradłeś ze zwłok "+a+" złota",Snackbar.LENGTH_LONG).show();

            }
        });
        alertDialogBuilder.setNegativeButton(("Tylko Honor! "), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                przeciwnikpvp.setPunktyHonoruPvp(przeciwnikpvp.getPunktyHonoruPvp()-1);
                bohater.punktyHonoru = bohater.getPunktyHonoru() +1;
                HonorLubNie(database,userss,przeciwnikpvp);
                AlertDialog alertDialoggg = abc.create();

                alertDialoggg.show();

            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.pvpikon);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }


}