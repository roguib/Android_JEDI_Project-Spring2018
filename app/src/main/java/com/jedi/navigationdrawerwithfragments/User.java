package com.jedi.navigationdrawerwithfragments;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private String usuari;
    private String contrasenya;

    public User() {

    }

    public User (String usuari, String contrasenya) {
        this.usuari = usuari;
        this.contrasenya = contrasenya;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
