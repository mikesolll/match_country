package com.artimatic.match_county.model;

public class Country {

    private String id;

    private String iso2Code;

    private String name;

    private String longitude;

    private String latitude;

    private Pair region;

    private Pair incomeLevel;

    private Pair adminregion;

    private Pair lendingType;

    private String capitalCity;


    public String getId() {
        return id;
    }

    public Pair getAdminregion() {
        return adminregion;
    }

    public void setAdminregion(Pair adminregion) {
        this.adminregion = adminregion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso2Code() {
        return iso2Code;
    }

    public void setIso2Code(String iso2Code) {
        this.iso2Code = iso2Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pair getRegion() {
        return region;
    }

    public void setRegion(Pair region) {
        this.region = region;
    }

    public Pair getIncomeLevel() {
        return incomeLevel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Pair getLendingType() {
        return lendingType;
    }

    public void setLendingType(Pair lendingTyp) {
        this.lendingType = lendingTyp;
    }

    public void setIncomeLevel(Pair incomeLevel) {
        this.incomeLevel = incomeLevel;
    }


    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}
