package com.example.kaloripaivakirja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tiedot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);
        Button muokkaa = findViewById(R.id.muokkaaButton);
        muokkaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muokkaaTietoja();
            }
        });
    }

    public void muokkaaTietoja() {
        Intent muokkaaTiedot = new Intent(this, tietojenlisays.class);
        startActivity(muokkaaTiedot);
    }

    {
        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        TextView tiedotPainoText = (TextView)findViewById(R.id.lisaaPaino);
        TextView.setText(text);
        //henkilö class josta otetaan tiedot tähän näkymään
    }
}