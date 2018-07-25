package com.jedi.navigationdrawerwithfragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jedi.navigationdrawerwithfragments.Puntuacion;
import com.jedi.navigationdrawerwithfragments.R;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ranking extends Fragment {
    Realm realm;
    RealmResults<Puntuacion> p;
    TextView ranking;

    public Ranking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);
        //textViewResult = (TextView) v.findViewById(R.id.textViewResult);
        ranking = (TextView) v.findViewById(R.id.textViewRanking);
        initRealm();
        search();
        print();
        return v;
    }


    private void initRealm() {
        Realm.init(getActivity().getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void search() {
        p = realm.where(Puntuacion.class).sort("t").findAll();
        p.sort("t", Sort.DESCENDING);
    }

    private void print() {
        int i = 0;
        String text = "";
        while (i < 5 && i < p.size()) {
            text = Integer.toString(i+1) + ". " + p.get(i).getUser().toString() + " " + p.get(i).getT().toString() + '\n';
            ranking.append(text);
            ++i;
        }
    }
}