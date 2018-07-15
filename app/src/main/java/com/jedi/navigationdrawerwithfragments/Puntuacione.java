package com.jedi.navigationdrawerwithfragments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Puntuacione {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}