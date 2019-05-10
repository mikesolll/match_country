package com.artimatic.match_county.service;

import com.artimatic.match_county.model.Country;
import com.artimatic.match_county.model.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> loadCountry();
    List<Country> getCountries();

    List<CountryDTO> getCountries(String code, Optional<String> region, Optional<String> incomeLevel, Optional<String> lendingType);

    List<Country> getByContryCode(String code);

    List<Country> getByMathRegion(String region);

    List<Country> getByIncomeLevel(String incomeLevel);

    List<Country> getBylendingType(String lendingType);

}
