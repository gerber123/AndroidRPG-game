package pl.marcinos.expfor2.Metody;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.view.View;

import pl.marcinos.expfor2.IntroActivity.MainActivity;
import pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity;
import pl.marcinos.expfor2.Questy.Questy;
import pl.marcinos.expfor2.R;

import static android.support.v4.app.ActivityCompat.finishAffinity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by marci on 10.03.2018.
 */

public class Dialog {
    View v;

    public static void przegrana(View v) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Przegrałeś... ");
        alertDialogBuilder.setMessage("Niemasz hp i nie stać Cię na bandaż, Zaczynasz od nowa !");
        alertDialogBuilder.setIcon(R.drawable.sad);
        alertDialogBuilder.setNeutralButton(("Nie"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                      System.exit(0);
                        dialog.cancel();
                    }
                });
        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();


    }

    public static void lvlUp(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Lvl Up !!!");
        alertDialogBuilder.setMessage("Dostajesz 5 punktów statystyk do rozdania !");

        alertDialogBuilder.setPositiveButton(("Dzięki za info"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();


            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.lvlup);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
    public void nextFight(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Potwór Pokonany !!!");
        alertDialogBuilder.setMessage("Walczysz Dalej Podróżniku ?!");

        alertDialogBuilder.setPositiveButton(("Walcze dalej!"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();


            }
        });
        alertDialogBuilder.setNegativeButton(("Wracam do Miasta"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.lvlup);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
    public static void zapisz(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Zapis? ");
        alertDialogBuilder.setMessage("Czy Chcesz zapisać aktualny stan gry !");

        alertDialogBuilder.setPositiveButton(("Tak"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });        alertDialogBuilder.setNegativeButton(("Nie"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.lvlup);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }
    public static void NowySet(View v) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Odblokowujesz Nowy Set!!!");
        alertDialogBuilder.setMessage("Odblokowałeś nowego seta !");

        alertDialogBuilder.setPositiveButton(("Dzięki za info"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();



            }
        });

        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.lvlup);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }
    public static void ZakonczonyQuest(View v,Questy quest) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
        alertDialogBuilder.setTitle("Nagroda!!!");
        alertDialogBuilder.setMessage("Udało Ci się wykonać zadanie!"+quest.getNagrodaExp()+"exp, "+quest.getNagroda()+"$");

        alertDialogBuilder.setPositiveButton(("Dzięki za info"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();



            }
        });

        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.lvlup);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }




}