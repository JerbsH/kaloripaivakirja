package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Ryhmä 1 sovellus kaloripäiväkirja
 * Sovelluksen tehnyt Petteri Helttula ja Jere Hippeläinen
 */
public class MainActivity extends AppCompatActivity {
    String ruokaNimi;
    int kalorit;
    TextView aamu, lounas, paiva, ilta;
    Intent ruokaTiedot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MY_TAG", "teki sovelluksen");
        setContentView(R.layout.activity_main);
        Button ruoka = findViewById(R.id.buttonLisaaRuoka);
        Button tiedot = findViewById(R.id.buttonOmatTiedot);
        ruoka.setOnClickListener(view -> lisaaRuoka()); // onClickListener ruoka napin painamiseen
        tiedot.setOnClickListener(view -> naytaTiedot()); // onClickListener tiedot napin painamiseen

    }

    public void lisaaRuoka(){
        Intent ruokaLisaa = new Intent(this, ruokalisays.class);
        startActivity(ruokaLisaa);
    } // Ruuan lisäämiseen tarkoitettuun aktiviteettiin siirtyminen
    public void naytaTiedot(){
        Intent omatTiedot = new Intent(this, tiedot.class);
        startActivity(omatTiedot);
    } // Omien tietojen katsomiseen siirtyminen

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MY_TAG", "meni main");
        ruokaTiedot = getIntent();
        SharedPreferences ruokatieto = getSharedPreferences("Ruokatieto" , Activity.MODE_PRIVATE);
        ruokaNimi = ruokatieto.getString("Ruoka", "");
        kalorit = ruokatieto.getInt("kalori", -1);
        String k = String.valueOf(kalorit);
        switch (ruokaNimi) {
            case "aamu":
                aamu = findViewById(R.id.aamuArvo);
                aamu.setText(k);
                break;
            case "lounas":
                lounas = findViewById(R.id.lounasArvo);
                lounas.setText(k);
                break;
            case "paiva":
                paiva = findViewById(R.id.paivaArvo);
                paiva.setText(k);
                break;
            case "ilta":
                ilta = findViewById(R.id.iltaArvo);
                ilta.setText(k);
                break;
        }
    }
}