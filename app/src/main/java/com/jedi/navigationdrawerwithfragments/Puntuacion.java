package com.jedi.navigationdrawerwithfragments;
import io.realm.RealmObject;

public class Puntuacion extends RealmObject {
    private String user;
    private String t;

    public Puntuacion() {
    }

    public Puntuacion(String user, String t) {
        this.user = user;
        this.t = t;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}
