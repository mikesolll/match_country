package com.artimatic.match_county.service;

import com.artimatic.match_county.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    List<Country> getByContryCode(String code);

    List<Country> getByMathRegion(String region);

    List<Country> getByIncomeLevel(String incomeLevel);

    List<Country> getBylendingType(String lendingType);

}
