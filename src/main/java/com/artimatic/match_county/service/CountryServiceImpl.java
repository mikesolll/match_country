package com.artimatic.match_county.service;

import com.artimatic.match_county.Repository.CountryRepository;
import com.artimatic.match_county.model.Country;
import com.artimatic.match_county.model.CountryDTO;
import com.artimatic.match_county.model.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> loadCountry() {
        return countryRepository.addAllCountry(getAllCountries());
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.getCountries();
    }

    private List<Country> getAllCountries() {

        ObjectMapper mapper= new ObjectMapper();
        List<Country> countries1=null;
        Page page=null;
        try {
            // to get the country on the first page
            ResponseEntity<Object[]> countries= restTemplate.getForEntity("http://api.worldbank.org/v2/country?format=json", Object[].class);

            // get the page detail form the the JSON response
          page= mapper.convertValue(countries.getBody()[0], Page.class);

            countries1= mapper.convertValue(countries.getBody()[1],  new TypeReference<List<Country>>(){});

            // to get the country on the rest of the page
            for(int i =2; i<=page.getPages(); i++){
                ResponseEntity<Object[]> countriList= restTemplate.getForEntity("http://api.worldbank.org/v2/country?format=json&page="+i, Object[].class);
                countries1.addAll(mapper.convertValue(countriList.getBody()[1],  new TypeReference<List<Country>>(){}));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return countries1;
    }

    @Override
    public List<CountryDTO> getCountries(String code, Optional<String> region, Optional<String> incomeLevel, Optional<String> lendingType) {
        List<CountryDTO> countries = new ArrayList<>();
        Predicate<Country> predicate = getCountryPredicate(code);
        Predicate<Country> regionPredicate = getRegionPredicate(region);
        Predicate<Country> incomeLevelPredicate = getIncomeLevelPredicate(incomeLevel);
        Predicate<Country> lendingTypePredicate = getLendingTypePredicate(lendingType);
        countries.addAll(getCountries().stream().filter(regionPredicate.or(incomeLevelPredicate).or(lendingTypePredicate).or(predicate)).map(country -> new CountryDTO(country.getName(),country.getCapitalCity())).collect(Collectors.toList()));
        return countries;
    }

    private Predicate<Country> getCountryPredicate(String code) {
        return c -> {
                return c.getIso2Code().equals(code);
            };
    }

    private Predicate<Country> getRegionPredicate(Optional<String> region) {
        return c -> {
                if(region.isPresent()) {
                    return c.getRegion().getIso2code().equals(region.get());
                }
                return false;
            };
    }

    private Predicate<Country> getIncomeLevelPredicate(Optional<String> incomeLevel) {
        return c -> {
                if(incomeLevel.isPresent()) {
                    return c.getIncomeLevel().getIso2code().equals(incomeLevel.get());
                }
                return false;
            };
    }

    private Predicate<Country> getLendingTypePredicate(Optional<String> lendingType) {
        return c -> {
                if(lendingType.isPresent()) {
                    return c.getLendingType().getIso2code().equals(lendingType.get());
                }
                return false;
            };
    }


    @Override
    public List<Country> getByContryCode(String code) {
        return countryRepository.getCountries().stream().filter(country -> country.getIso2Code().equals(code)).collect(Collectors.toList());
    }

    @Override
    public List<Country> getByMathRegion(String region) {
        return countryRepository.getCountries().stream().filter( reg -> reg.getRegion().getValue().equals(region)).collect(Collectors.toList());
    }

    @Override
    public List<Country> getByIncomeLevel(String incomeLevel) {
        return countryRepository.getCountries().stream().filter( reg -> reg.getIncomeLevel().getValue().equals(incomeLevel)).collect(Collectors.toList());
    }

    @Override
    public List<Country> getBylendingType(String lendingType) {
        return countryRepository.getCountries().stream().filter( reg -> reg.getLendingType().getValue().equals(lendingType)).collect(Collectors.toList());
    }
}
