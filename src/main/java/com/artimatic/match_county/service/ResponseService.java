package com.artimatic.match_county.service;

import com.artimatic.match_county.model.Country;
import com.artimatic.match_county.model.CountryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResponseService {

    ResponseEntity<?> getResponse(List<CountryDTO> countries);
}
