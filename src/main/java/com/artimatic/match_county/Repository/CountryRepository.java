package com.artimatic.match_county.Repository;

import com.artimatic.match_county.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepository {

    private List<Country> countries= new ArrayList<>();

    public List<Country> addCountry(Country country){
        countries.add(country);
        return countries;
    }

    public List<Country> addAllCountry(List<Country> countryList){
        countries.addAll(countryList);
        return countries;
    }

    public List<Country> getCountries() {
        return countries;
    }
}
