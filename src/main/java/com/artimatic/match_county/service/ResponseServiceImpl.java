package com.artimatic.match_county.service;

import com.artimatic.match_county.model.Country;
import com.artimatic.match_county.model.CountryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Override
    public ResponseEntity<?> getResponse(List<CountryDTO> countries) {
        if(countries.size() > 0)
            return  new ResponseEntity<>(countries, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
