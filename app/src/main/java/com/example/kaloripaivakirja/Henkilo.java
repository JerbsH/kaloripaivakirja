package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Petteri
 */
public class Henkilo extends AppCompatActivity {

    private double paino;
    private double pituus;
    private double ika;
    private String sukupuoli;
    private double tarve;

    /**
     *
     * @param paino Henkilön paino kiloina
     * @param pituus Henkilön pituus sentteinä
     * @param ika Henkilön ikä vuosina
     * @param sukupuoli Henkilön sukupuoli
     */
    public Henkilo(String paino, String pituus, String ika, String sukupuoli) {
        this.paino = Double.parseDouble(paino);
        this.pituus = Double.parseDouble(pituus);
        this.ika = Double.parseDouble(ika);
        this.sukupuoli = sukupuoli;

    }

    /**
     * Palauttaa henkilön painon
     * @return Henkilön paino
     */
    public String getPaino(){
        tarkastaArvot();
        return String.valueOf(this.paino);
    }

    /**
     * Palauttaa henkilön pituuden
     * @return Henkilön pituus
     */
    public String getPituus(){
        tarkastaArvot();
        return String.valueOf(this.pituus);
    }

    /**
     * Palauttaa henkilön iän
     * @return Henkilön ikä
     */
    public String getIka(){
        tarkastaArvot();
        return String.valueOf(this.ika);
    }
    /**
     * Palauttaa henkilön sukupuolen
     * @return Henkilön sukupuoli
     */
    public String getSukupuoli(){
        return this.sukupuoli;
    }

    /**
     * laskee kaloritarpeen henkilölle riippuen sukupuolesta. Laskee keskivertoaktiivisen henkilön kaloritarpeen
     */
    public void setKaloritarve() {
        switch (sukupuoli) {
            case "mies":
                this.tarve = (66.47 + (13.75 * this.paino) + (5 * this.pituus) - (6.76 * this.ika)) * 1.5;
                break;
            case "nainen":
                this.tarve = (655.1 + (9.563 * this.paino) + (1.85 * this.pituus) - (4.68 * this.ika)) * 1.5;
                break;
            case "":
                this.tarve = 0;
                break;
        }
    }
    public void tarkastaArvot(){
        if (pituus > 250){
            this.pituus = 250;
        }
        if (paino > 200){
            this.paino = 200;
        }
        if (ika > 120){
            this.ika = 120;
        }
    }

    /**
     * Laskee kaloritarpeen setKaloritarve avulla ja palauttaa kaloritarpeen
     * @return kaloritarve
     */
    public String getKalorit(){
        tarkastaArvot();
        setKaloritarve();
        int kaloritarve = (int) tarve;
        return String.valueOf(kaloritarve);
    }
}