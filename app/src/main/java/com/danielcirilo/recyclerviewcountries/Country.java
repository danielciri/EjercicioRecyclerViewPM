package com.danielcirilo.recyclerviewcountries;

public class Country {
    private String countryCode;
    private String countryName;
    private float population;
    private String capital;
    private String countryIso3;
    private int bandera;

    public Country(String countryCode, String countryName, float population, String capital) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.capital = capital;
        this.population = population;
        this.bandera = bandera;
        this.countryIso3 = countryIso3;
    }
    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }


    public int getBandera() {
        return bandera;
    }
}
