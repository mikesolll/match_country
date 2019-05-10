package com.artimatic.match_county.model;

public class CountryDTO {

    private String name;

    private String capitalCity;

    public CountryDTO(String name, String capitalCity) {
        this.name = name;
        this.capitalCity = capitalCity;
    }

    public CountryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}
