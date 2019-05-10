package com.artimatic.match_county.service;

import com.artimatic.match_county.model.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Country> getCountries() {
        ResponseEntity<Object[]> countries= restTemplate.getForEntity("http://api.worldbank.org/country?format=json", Object[].class);
        ObjectMapper mapper= new ObjectMapper();
        List<Country> countries1=null;
        try {
            countries1= mapper.convertValue(countries.getBody()[1],  new TypeReference<List<Country>>(){});
        }catch (Exception e){
            e.printStackTrace();
        }
        return countries1;
    }


    @Override
    public List<Country> getByContryCode(String code) {
        return getCountries().stream().filter(country -> country.getIso2Code().equals(code)).collect(Collectors.toList());
    }

    @Override
    public List<Country> getByMathRegion(String region) {
        return getCountries().stream().filter( reg -> reg.getRegion().getValue().equals(region)).collect(Collectors.toList());
    }

    @Override
    public List<Country> getByIncomeLevel(String incomeLevel) {
        return getCountries().stream().filter( reg -> reg.getIncomeLevel().getValue().equals(incomeLevel)).collect(Collectors.toList());
    }

    @Override
    public List<Country> getBylendingType(String lendingType) {
        return getCountries().stream().filter( reg -> reg.getLendingType().getValue().equals(lendingType)).collect(Collectors.toList());
    }
}
