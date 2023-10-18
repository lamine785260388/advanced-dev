package com.uadb.advancedev.services;

import com.uadb.advancedev.dto.RateDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface RateService {

    void save(RateDTO rateDTO);

    List<RateDTO> getAllRates();

    Optional<RateDTO> getRateById(long idRate);
}
