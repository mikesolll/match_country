package com.artimatic.match_county.controller;

import com.artimatic.match_county.model.Country;
import com.artimatic.match_county.service.CountryService;
import com.artimatic.match_county.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @Autowired
    ResponseService responseService;

    @GetMapping("/all")
    public ResponseEntity<?> getCountries(){
       return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> searchByContryCode(@RequestParam("code") String code, @RequestParam(required = false, value = "region") Optional<String> region, @RequestParam(required = false, value = "incomeLevel") Optional<String> incomeLevel, @RequestParam(required = false, value = "lendingType") Optional<String> lendingType) {
        return responseService.getResponse(countryService.getCountries(code, region, incomeLevel, lendingType));
    }


}
