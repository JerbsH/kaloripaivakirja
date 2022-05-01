package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class tietojenlisays extends AppCompatActivity {
    public String sukupuoli = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EditText lisaaPituus = (EditText) findViewById(R.id.lisaaPituus);
        EditText lisaaIka = (EditText) findViewById(R.id.lisaaIka);
        EditText lisaaPaino = (EditText) findViewById(R.id.lisaaPaino);
        RadioButton radioSukupuoliMies = (RadioButton) findViewById(R.id.radioSukupuoliMies);
        RadioButton radioSukupuoliNainen = (RadioButton) findViewById(R.id.radioSukupuoliNainen);


        Button myButton = (Button) findViewById(R.id.lisaaButton);
        myButton.setOnClickListener(
        new View.OnClickListener() {

            public void onClick(View view) {
                if (radioSukupuoliMies.isChecked()) {
                    sukupuoli = "mies";
                } else if (radioSukupuoliNainen.isChecked()) {
                    sukupuoli = "nainen";
                }
                henkilo uusiHenkilo = new henkilo(lisaaPaino.getText().toString(), lisaaPituus.getText().toString(), lisaaIka.getText().toString(), sukupuoli);
            }
        });

        setContentView(R.layout.activity_tietojenlisays);
    }
   }

    //henkilö class sama kun tiedot.java, tässä lisätään tiedot muuttujiin
