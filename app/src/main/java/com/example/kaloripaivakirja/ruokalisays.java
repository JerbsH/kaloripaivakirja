package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * @author Jere
 * Ruokien kalorien lisäämiseen tarkoitettu class
 */
public class ruokalisays extends AppCompatActivity {
    public String ruoka;
    public String kcalValue;
    public int kcal;
    EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruokalisays);
        num = findViewById(R.id.kaloritText);
        Button lisaa = findViewById(R.id.buttonRuoka);
        lisaa.setOnClickListener(view -> takaisinMain());
    }
    /**
     * Tarkistaa mikä radiobutton on valittu ja asettaa oikein ruuan nimen
     */
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.radioAamiainen && checked) {
            ruoka = "aamu";
        } else if(view.getId() == R.id.radioLounas && checked){
            ruoka = "lounas";
        } else if(view.getId() == R.id.radioPaivallinen && checked){
            ruoka = "paiva";
        } else if(view.getId() == R.id.radioIltapala && checked){
            ruoka = "ilta";
        } else {
            ruoka = "";
        }
    }

    /**
     * Palaa takaisin main activityyn ja vie samalla annetun ruuan tiedot
     */
    public void takaisinMain(){
        kcalValue = num.getText().toString(); // kalorit muuttujaan
        if (kcalValue.equals("")){ // Jos kenttä on tyhjä arvoksi nolla
            kcal = 0;
        }else{
            kcal = Integer.parseInt(kcalValue);
        }
        Ruoka food;
        food = new Ruoka(ruoka, kcal); // uusi ruoka annetuista tiedoista
        String ruoka = food.getRuoka();
        int kcal = food.getKcal();
        SharedPreferences ruokatieto = getSharedPreferences("Ruokatieto" , Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = ruokatieto.edit();
        editor.putInt("kalori", kcal); // kalorimäärä sharedpreferenceihin jotta ne saadaan mainiin
        editor.apply();
        editor.putString("Ruoka", ruoka); // ruuan nimi sharedpreferenceihin jotta se saadaan mainiin
        editor.apply();
        finish();
    }
}