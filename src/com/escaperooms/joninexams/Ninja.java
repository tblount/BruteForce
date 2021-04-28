package com.escaperooms.joninexams;


import com.escaperooms.application.User;

public class Ninja {

    private int ninjaHP = 10;
    private String ninjaName;

    public Ninja(String ninjaName, int ninjaHP) {
        this.ninjaName = ninjaName;
        this.ninjaHP = ninjaHP;
    }

    public int getNinjaHP() {
        return ninjaHP;
    }

    public void setNinjaHP(int ninjaHP) {
        this.ninjaHP = ninjaHP;
    }

    public String getNinjaName() {
        return ninjaName;
    }

    public void setNinjaName(String ninjaName) {
        this.ninjaName = ninjaName;
    }
}
