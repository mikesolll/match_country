package com.artimatic.match_county.util;

import com.artimatic.match_county.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements ApplicationRunner {

    @Autowired
    private CountryService countryService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        countryService.loadCountry();
    }
}
