package com.example.kaloripaivakirja;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class henkilo extends AppCompatActivity {

    private String paino;
    private String pituus;
    private String ika;
    private String sukupuoli;

    public henkilo() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public henkilo(String paino, String pituus, String ika, String sukupuoli) {
        this.paino = paino;
        this.pituus = pituus;
        this.ika = ika;
        this.sukupuoli = sukupuoli;

    }
}