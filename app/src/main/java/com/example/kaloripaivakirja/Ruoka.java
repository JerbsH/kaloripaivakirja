package com.example.kaloripaivakirja;

/**
 * @author Jere
 */
public class Ruoka {
    private String ruoka;
    private int kcal;

    public Ruoka(String ruoka, int kcal){
        this.kcal = kcal;
        this.ruoka = ruoka;
    }
    public String getRuoka(){
        return this.ruoka;
    }
    public int getKcal(){
        return this.kcal;
    }
}
