package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

public class henkilo  extends AppCompatActivity {
    private String paino;
    private String pituus;
    private String ika;

    public henkilo() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public henkilo(String paino, String pituus, String ika) {
        this.paino = paino;
        this.pituus = pituus;
        this.ika = ika;

    }
}