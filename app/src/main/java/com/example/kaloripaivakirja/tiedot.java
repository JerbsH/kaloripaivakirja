package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class tiedot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);
        Button muokkaa = findViewById(R.id.muokkaaButton);
        muokkaa.setOnClickListener(view -> muokkaaTietoja());
    }
    public void muokkaaTietoja(){
        Intent muokkaaTiedot = new Intent(this, tietojenlisays.class);
        startActivity(muokkaaTiedot);
    }

}