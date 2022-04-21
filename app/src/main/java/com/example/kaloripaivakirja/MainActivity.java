package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Ryhmä 1 sovellus kaloripäiväkirja
 * Sovelluksen tehnyt Petteri Helttula ja Jere Hippeläinen
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ruoka = (Button) findViewById(R.id.buttonLisaaRuoka);
        Button tiedot = (Button) findViewById(R.id.buttonOmatTiedot);
        ruoka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisaaRuoka();
            }
        }); //onClickListener ruoka napin painamiseen
        tiedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naytaTiedot();
            }
        }); //onClickListener tiedot napin painamiseen
    }

    public void lisaaRuoka(){
        Intent ruokaLisaa = new Intent(this, ruokalisays.class);
        startActivity(ruokaLisaa);
    } // Ruuan lisäämiseen tarkoitettuun aktiviteettiin siirtyminen
    public void naytaTiedot(){
        Intent omatTiedot = new Intent(this, tiedot.class);
        startActivity(omatTiedot);
    } // Omien tietojen katsomiseen siirtyminen
}