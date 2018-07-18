package com.jedi.navigationdrawerwithfragments.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jedi.navigationdrawerwithfragments.LoginActivity;
import com.jedi.navigationdrawerwithfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Game extends Fragment {

    Button logOut;
    ImageButton b0, b1, b2, b3;
    ImageButton b4, b5, b6, b7;
    ImageButton b8, b9, b10, b11;
    ImageButton b12, b13, b14, b15;

    public Game() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_game, container, false);
        //textViewResult = (TextView) v.findViewById(R.id.textViewResult);
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
        logOut = (Button) v.findViewById(R.id.logOut);
        //textViewResult = (TextView) v.findViewById(R.id.textViewResult);

        //en vez de int es una variable click
        View.OnClickListener appendNumber = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                /* girar la imagen:
                b0.setImageResource(R.drawable.as); */
                if(b == logOut)
                {
                    //SharedPreferences.Editor.clear();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
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
        logOut.setOnClickListener(appendNumber);
        return v;
    }

}
