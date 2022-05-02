package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

public class Henkilo extends AppCompatActivity {

    private double paino = 0;
    private double pituus = 0;
    private double ika = 0;
    private String sukupuoli = "";
    private double tarve;

    /**
     *
     * @param paino
     * @param pituus
     * @param ika
     * @param sukupuoli
     */
    public Henkilo(String paino, String pituus, String ika, String sukupuoli) {
        this.paino = Double.parseDouble(paino);
        this.pituus = Double.parseDouble(pituus);
        this.ika = Double.parseDouble(ika);
        this.sukupuoli = sukupuoli;

    }
    public String getPaino(){
        return String.valueOf(this.paino);
    }
    public String getPituus(){
        return String.valueOf(this.pituus);
    }
    public String getIka(){
        return String.valueOf(this.ika);
    }
    public String getSukupuoli(){
        return this.sukupuoli;
    }
    public void setKaloritarve() {
        if (this.sukupuoli.equals("mies")) {
            this.tarve = (66.47 + (13.75 * this.paino) + (5 * this.pituus) - (6.76 * this.ika)) * 1.5;
        } else if (sukupuoli.equals("nainen")) {
            this.tarve = (655.1 + (9.563 * this.paino) + (1.85 * this.pituus) - (4.68 * this.ika)) * 1.5;
        } else {
            this.tarve = 0;
        }
    }
    public String getKalorit(){
        setKaloritarve();
        int kaloritarve = (int) tarve;
        return String.valueOf(kaloritarve);
    }
}