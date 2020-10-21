package com.danielcirilo.recyclerviewcountries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private CountryParser parser;
    private Country datos[];
    private RecyclerView rvListado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parser = new CountryParser((getResources().openRawResource(R.raw.countries)));
        datos = parser.parseCountriesFromXml();
        rvListado = findViewById(R.id.rvListado);
        rvListado.setHasFixedSize(true);
        rvListado.setAdapter(new CountryAdapter(datos));
        rvListado.setAdapter(new CountryAdapter(datos));
        rvListado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));


    }
}