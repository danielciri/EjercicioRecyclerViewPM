package com.danielcirilo.recyclerviewcountries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountriesViewHolder> {
    private Country[] countries;

    public CountryAdapter(Country[] countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false);
        return new CountriesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        Country country = countries[position];
        holder.bindCountries(country);

    }

    @Override
    public int getItemCount() {
        return countries.length;
    }


    public  class CountriesViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameCoutry;
        private TextView tvNameCapital;
        private TextView tvPopulation;
        private ImageView ivFlag;
        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCoutry = itemView.findViewById(R.id.tvNomPais);
            tvNameCapital = itemView.findViewById(R.id.tvNomCapital);
            tvPopulation = itemView.findViewById(R.id.tvNumPoblacio);
            ivFlag = itemView.findViewById(R.id.ivBanderas);

        }
        public void bindCountries(Country country){
            tvNameCoutry.setText(country.getCountryName());
            tvNameCapital.setText(country.getCapital());
            tvPopulation.setText(String.valueOf(country.getPopulation()));
            int id = itemView.getContext().getResources().getIdentifier("_"+country.getCountryCode().toLowerCase(),
                    "drawable", ivFlag.getContext().getPackageName());
            ivFlag.setImageResource(id);
        }
    }


}