package com.jedi.navigationdrawerwithfragments.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jedi.navigationdrawerwithfragments.R;

public class Player extends Fragment {

    Button player, previous, next;
    Button s1, s2, s3, s4;
    MediaPlayer mp;
    Boolean playing;
    int index = 0;
    final int playlist[] = {R.raw.a, R.raw.b, R.raw.c, R.raw.d};

    public Player() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_player, container, false);
        //Log.v("debug", "onCreateView");
        player = (Button) v.findViewById(R.id.play);
        previous = (Button) v.findViewById(R.id.previous);
        next = (Button) v.findViewById(R.id.next);

        s1 = (Button) v.findViewById(R.id.s1);
        s2 = (Button) v.findViewById(R.id.s2);
        s3 = (Button) v.findViewById(R.id.s3);
        s4 = (Button) v.findViewById(R.id.s4);

        //en vez de this, como estamos en un fragment para obtener el contexto de la app debemos
        //usar el getActivity seguido del get application context
        mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
        playing = false;
        //Log.v("debug", "playing false");
        View.OnClickListener appendNumber = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.v("debug", "onClick");
                Button b = (Button) view;
                if(b == s1) {
                    playing = true;
                    player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                    mp.release();
                    index = 0;
                    mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                    mp.start();
                }
                else if(b == s2) {
                    playing = true;
                    player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                    mp.release();
                    index = 1;
                    mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                    mp.start();
                }
                else if(b == s3) {
                    playing = true;
                    player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                    mp.release();
                    index = 2;
                    mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                    mp.start();
                }
                else if(b == s4) {
                    playing = true;
                    player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                    mp.release();
                    index = 3;
                    mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                    mp.start();
                }
                if(b == player) {
                    if(!playing) {
                        mp.start();
                        playing = true;
                        //Log.v("debug", "player --> !playing --> playing = true");
                        player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                    }
                    else {
                        mp.pause();
                        playing = false;
                        //Log.v("debug", "player --> playing --> playing = false");
                        player.setBackgroundResource(R.drawable.baseline_play_arrow_black_36dp);
                    }
                }
                else if(b == previous) {
                    if(index > 0) {
                        --index;
                        mp.pause();
                        mp.release();
                        mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                        mp.start();
                    }
                    else {
                        index = 3;
                        mp.pause();
                        mp.release();
                        player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                        mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                        mp.start();
                    }
                }
                else if(b == next) {
                    if(index < 3) {
                        ++index;
                        mp.pause();
                        mp.release();
                        player.setBackgroundResource(R.drawable.baseline_pause_circle_outline_black_36dp);
                        mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                        mp.start();
                    }
                    else {
                        index = 0;
                        mp.pause();
                        mp.release();
                        mp = MediaPlayer.create(getActivity().getApplicationContext(), playlist[index]);
                        mp.start();
                    }
                }
            }
        };
        player.setOnClickListener(appendNumber);
        previous.setOnClickListener(appendNumber);
        next.setOnClickListener(appendNumber);
        s1.setOnClickListener(appendNumber);
        s2.setOnClickListener(appendNumber);
        s3.setOnClickListener(appendNumber);
        s4.setOnClickListener(appendNumber);
        return v;
    }
}
