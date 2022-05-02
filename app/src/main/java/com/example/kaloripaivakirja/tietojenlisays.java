package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class tietojenlisays extends AppCompatActivity {
    public String sukupuoli, paino, ika, pituus;
    EditText lisaaPituus, lisaaIka, lisaaPaino;
    Henkilo henkilo;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tietojenlisays);
        Button lisaa = findViewById(R.id.lisaaButton);
        lisaaPituus = findViewById(R.id.lisaaPituus);
        lisaaIka = findViewById(R.id.lisaaIka);
        lisaaPaino = findViewById(R.id.lisaaPaino);
        lisaa.setOnClickListener(view -> vieTiedot());
    }
    public void onRadioButtonClicked(View view) {
        this.view = view;
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.radioSukupuoliMies && checked) {
            sukupuoli = "mies";
        } else if(view.getId() == R.id.radioSukupuoliNainen && checked){
            sukupuoli = "nainen";
        } else {
            sukupuoli = "";
        }
    }
    public void vieTiedot(){
        pituus = lisaaPituus.getText().toString();
        paino = lisaaPaino.getText().toString();
        ika = lisaaIka.getText().toString();
        henkilo = new Henkilo(paino, pituus,ika, sukupuoli);
        String omaPituus = henkilo.getPituus();
        String omaPaino = henkilo.getPaino();
        String omaIka = henkilo.getIka();
        String omaSuku = henkilo.getSukupuoli();
        String kaloriTarve = henkilo.getKalorit();
        Log.d("MY", kaloriTarve);
        SharedPreferences henkiloTiedot = getSharedPreferences("Henkilötiedot", Activity.MODE_PRIVATE);
        SharedPreferences.Editor henkEditor = henkiloTiedot.edit();
        henkEditor.putString("paino", omaPaino);
        henkEditor.apply();
        henkEditor.putString("pituus", omaPituus);
        henkEditor.apply();
        henkEditor.putString("ika", omaIka);
        henkEditor.apply();
        henkEditor.putString("sukupuoli", omaSuku);
        henkEditor.apply();
        henkEditor.putString("kaloriTarve", kaloriTarve);
        henkEditor.apply();
        finish();
    }
}