package com.example.kaloripaivakirja;

/**
 * Luo uuden ruuan
 * @author Jere
 */
public class Ruoka {
    private String ruoka;
    private int kcal;

    /**
     * Uusi ruoka jossa on annetut tiedot.
     * @param ruoka Syödyn aterian nimi.
     * @param kcal Aterian kalorien määrä.
     */
    public Ruoka(String ruoka, int kcal){
        this.kcal = kcal;
        this.ruoka = ruoka;
    }

    /**
     * Palauttaa ruuan nimen
     * @return Ruuan nimi
     */
    public String getRuoka(){
        return this.ruoka;
    }

    /**
     * Palauttaa kalorimäärän
     * @return kalorimäärä
     */
    public int getKcal(){
        return this.kcal;
    }
}
