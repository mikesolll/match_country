package com.artimatic.match_county.controller;

import com.artimatic.match_county.model.Country;
import com.artimatic.match_county.service.CountryService;
import com.artimatic.match_county.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/contrycode")
    public ResponseEntity<?> searchByContryCode(@RequestParam("code") String code){
        return responseService.getResponse(countryService.getByContryCode(code));

    }

    @GetMapping("/region")
    public ResponseEntity<?> searchRegion(@RequestParam("region") String region){
        return responseService.getResponse(countryService.getByMathRegion(region));
    }
    @GetMapping("/incomeLevel")
    public ResponseEntity<?> searchByIncomeLevel(@RequestParam("incomeLevel") String incomeLevel){
        return responseService.getResponse(countryService.getByIncomeLevel(incomeLevel));
    }
    @GetMapping("/lendingType")
    public ResponseEntity<?> searchByLendingType(@RequestParam("lendingType") String lendingType){
        return responseService.getResponse(countryService.getBylendingType(lendingType));
    }


}
