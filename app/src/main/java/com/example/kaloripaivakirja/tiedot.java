package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Listaa henkilön antamat tiedot ruudulle.
 * Molemmat muokanneet ja kirjoittaneet tämän tiedoston koodia.
 */
public class tiedot extends AppCompatActivity {
    String omaPituus, omaPaino, omaIka, omaSuku, tarve;
    TextView paino, pituus, ika, suku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);
        Button muokkaa = findViewById(R.id.muokkaaButton);
        muokkaa.setOnClickListener(view -> muokkaaTietoja()); // listeneri napin painamiseen joka vie tietojen muokkaamiseen
    }

    /**
     * Menee seuraavaan aktiviteettin, joka on tietojen muokkaus / lisääminen.
     */
    public void muokkaaTietoja() {
        Intent muokkaaTiedot = new Intent(this, tietojenlisays.class);
        startActivity(muokkaaTiedot);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences henkiloTiedot = getSharedPreferences("Henkilötiedot", Activity.MODE_PRIVATE);
        omaPaino = henkiloTiedot.getString("paino", "");
        omaPituus = henkiloTiedot.getString("pituus", "");
        omaIka = henkiloTiedot.getString("ika", "");
        omaSuku = henkiloTiedot.getString("sukupuoli", "");
        paino = findViewById(R.id.tiedotPainoText);
        pituus = findViewById(R.id.tiedotPituusText);
        ika = findViewById(R.id.tiedotIkaText);
        suku = findViewById(R.id.tiedotSukupuoliText);

        // Hakee tiedot sharedpreferenceistä ja asettaa ne tekstikenttiin oikeisiin paikkoihin.

        paino.setText(omaPaino);
        pituus.setText(omaPituus);
        ika.setText(omaIka);
        suku.setText(omaSuku);
    }
}