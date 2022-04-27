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


public class ruokalisays extends AppCompatActivity {
    public String ruoka;
    public String kcalValue;
    public int kcal;
    EditText num;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MY_TAG", "meni lisäykseen");
        setContentView(R.layout.activity_ruokalisays);
        num = findViewById(R.id.kaloritText);
        Button lisaa = findViewById(R.id.buttonRuoka);
        lisaa.setOnClickListener(view -> takaisinMain());
    }

    // Tarkastaa mikä ruoka valittuna
    public void onRadioButtonClicked(View view) {
        this.view = view;
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.radioAamiainen && checked) {
            ruoka = "aamu";
            Log.d("MY_TAG", ruoka);
        } else if(view.getId() == R.id.radioLounas && checked){
            ruoka = "lounas";
            Log.d("MY_TAG", ruoka);
        } else if(view.getId() == R.id.radioPaivallinen && checked){
            ruoka = "paiva";
            Log.d("MY_TAG", ruoka);
        } else if(view.getId() == R.id.radioIltapala && checked){
            ruoka = "ilta";
            Log.d("MY_TAG", ruoka);
        } else {
            ruoka = "";
            Log.d("MY_TAG", ruoka);
        }
    }
    public void takaisinMain(){
        kcalValue = num.getText().toString(); // kalorit muuttujaan
        Log.d("MY_TAG", kcalValue);
        kcal = Integer.parseInt(kcalValue);
        Ruoka food;
        food = new Ruoka(ruoka, kcal);
        String ruoka = food.getRuoka();
        Log.d("MY_TAG", ruoka);
        int kcal = food.getKcal();
        Log.d("MY_TAG", "kcalValue");
        SharedPreferences ruokatieto = getSharedPreferences("Ruokatieto" , Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = ruokatieto.edit();
        editor.putInt("kalori", kcal);
        editor.apply();
        editor.putString("Ruoka", ruoka);
        editor.apply();
        finish();
    }
}