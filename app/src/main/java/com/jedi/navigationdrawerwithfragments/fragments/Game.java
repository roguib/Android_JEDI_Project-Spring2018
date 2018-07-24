package com.jedi.navigationdrawerwithfragments.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jedi.navigationdrawerwithfragments.LoginActivity;
import com.jedi.navigationdrawerwithfragments.Puntuacion;
import com.jedi.navigationdrawerwithfragments.R;
import com.jedi.navigationdrawerwithfragments.User;

import java.util.Random;

import io.realm.Realm;
import android.content.SharedPreferences;
/**
 * A simple {@link Fragment} subclass.
 */
public class Game extends Fragment {

    private Chronometer c;
    Button logOut;
    ImageButton b0, b1, b2, b3;
    ImageButton b4, b5, b6, b7;
    ImageButton b8, b9, b10, b11;
    ImageButton b12, b13, b14, b15;
    int cards[] = {R.drawable.as, R.drawable.as, R.drawable.five_of_diamonds, R.drawable.five_of_diamonds,
            R.drawable.five_of_hearts, R.drawable.five_of_hearts, R.drawable.jack_of_diamonds, R.drawable.jack_of_diamonds,
            R.drawable.nine_of_trebols, R.drawable.nine_of_trebols, R.drawable.queen_of_trebols, R.drawable.queen_of_trebols,
            R.drawable.seven_of_diamonds, R.drawable.seven_of_diamonds, R.drawable.two_of_hearts, R.drawable.two_of_hearts};
    Boolean firstCardPressed;
    Boolean stardOfTheGame;
    ImageButton firstImgButton;
    int firstCardId;
    int found;
    String finalTime;
    Realm realm;

    public Game() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        c = (Chronometer) v.findViewById(R.id.chrono);
        b0 = (ImageButton) v.findViewById(R.id.imageButton1);
        b1 = (ImageButton) v.findViewById(R.id.imageButton2);
        b2 = (ImageButton) v.findViewById(R.id.imageButton3);
        b3 = (ImageButton) v.findViewById(R.id.imageButton4);
        b4 = (ImageButton) v.findViewById(R.id.imageButton5);
        b5 = (ImageButton) v.findViewById(R.id.imageButton6);
        b6 = (ImageButton) v.findViewById(R.id.imageButton7);
        b7 = (ImageButton) v.findViewById(R.id.imageButton8);
        b8 = (ImageButton) v.findViewById(R.id.imageButton9);
        b9 = (ImageButton) v.findViewById(R.id.imageButton10);
        b10 = (ImageButton) v.findViewById(R.id.imageButton11);
        b11 = (ImageButton) v.findViewById(R.id.imageButton12);
        b12 = (ImageButton) v.findViewById(R.id.imageButton13);
        b13 = (ImageButton) v.findViewById(R.id.imageButton14);
        b14 = (ImageButton) v.findViewById(R.id.imageButton15);
        b15 = (ImageButton) v.findViewById(R.id.imageButton16);
        logOut = (Button) v.findViewById(R.id.logOut);
        firstCardPressed = false;
        stardOfTheGame = false;
        finalTime = "";
        found = 0;
        shuffleArray(cards);
        initRealm();
        View.OnClickListener appendNumber2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                if (b == logOut) {
                    SharedPreferences prefs = getActivity().getSharedPreferences("sp", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("open session", false);
                    editor.commit();
                    Log.v("debug message", "hola");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        };

        View.OnClickListener appendNumber = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton ib = (ImageButton) view;
                if(ib == b0) {
                    changeImageButton(ib, 0);
                }
                else if(ib == b1) {
                    changeImageButton(ib, 1);
                }
                else if(ib == b2) {
                    changeImageButton(ib, 2);
                }
                else if(ib == b3) {
                    changeImageButton(ib, 3);
                }
                else if(ib == b4) {
                    changeImageButton(ib, 4);
                }
                else if(ib == b5) {
                    changeImageButton(ib, 5);
                }
                else if(ib == b6) {
                    changeImageButton(ib, 6);
                }
                else if(ib == b7) {
                    changeImageButton(ib, 7);
                }
                else if(ib == b8) {
                    changeImageButton(ib, 8);
                }
                else if(ib == b9) {
                    changeImageButton(ib, 9);
                }
                else if(ib == b10) {
                    changeImageButton(ib, 10);
                }
                else if(ib == b11) {
                    changeImageButton(ib, 11);
                }
                else if(ib == b12) {
                    changeImageButton(ib, 12);
                }
                else if(ib == b13) {
                    changeImageButton(ib, 13);
                }
                else if(ib == b14) {
                    changeImageButton(ib, 14);
                }
                else if(ib == b15) {
                    changeImageButton(ib, 15);
                }
                if(!stardOfTheGame) {
                    stardOfTheGame = true;
                    c.start();
                }
                if(found == 8) {
                    c.stop();
                    finalTime = c.getText().toString();
                    //Log.v("time", finalTime);
                    SharedPreferences prefs = getActivity().getSharedPreferences("sp", 0);
                    Puntuacion p = new Puntuacion(prefs.getString("usuari", "wrrong"), finalTime);
                    //Log.v("p", "new p");
                    savePuntuacionToRealm(p);
                    //Log.v("realm", "saved to realm");

                }
            }
        };
        b0.setOnClickListener(appendNumber);
        b1.setOnClickListener(appendNumber);
        b2.setOnClickListener(appendNumber);
        b3.setOnClickListener(appendNumber);
        b4.setOnClickListener(appendNumber);
        b5.setOnClickListener(appendNumber);
        b6.setOnClickListener(appendNumber);
        b7.setOnClickListener(appendNumber);
        b8.setOnClickListener(appendNumber);
        b9.setOnClickListener(appendNumber);
        b10.setOnClickListener(appendNumber);
        b11.setOnClickListener(appendNumber);
        b12.setOnClickListener(appendNumber);
        b13.setOnClickListener(appendNumber);
        b14.setOnClickListener(appendNumber);
        b15.setOnClickListener(appendNumber);
        logOut.setOnClickListener(appendNumber2);
        return v;
    }

    public static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    private void changeImageButton(final ImageButton ib, int id) {
        if(!firstCardPressed) {
            firstCardPressed = true;
            firstImgButton = ib;
            ib.setImageResource(cards[id]);
            firstCardId = cards[id];
        }
        else if(firstCardPressed && firstImgButton != ib) {
            firstCardPressed = false;
            ib.setImageResource(cards[id]);
            if(firstCardId == cards[id]) ++found;
            else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ib.setImageResource(R.drawable.card_back);
                        firstImgButton.setImageResource(R.drawable.card_back);
                    }
                }, 1000);
            }
        }
    }

    private void initRealm() {
        Realm.init(getActivity().getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void savePuntuacionToRealm(Puntuacion p) {
        realm.beginTransaction();
        final Puntuacion aux = realm.copyToRealm(p);
        realm.commitTransaction();
        //Log.v("realm", "commitTransaction");
    }
}
