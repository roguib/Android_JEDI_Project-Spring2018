package com.jedi.navigationdrawerwithfragments;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Puntuacion {

    @SerializedName("puntuaciones")
    @Expose
    private List<Puntuacione> puntuaciones = null;

    public List<Puntuacione> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(List<Puntuacione> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
}
