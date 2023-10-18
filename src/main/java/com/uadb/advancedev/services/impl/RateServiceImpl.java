package com.uadb.advancedev.services.impl;


import com.uadb.advancedev.dto.RateDTO;

import com.uadb.advancedev.entities.Rate;


import com.uadb.advancedev.repositories.RateRepository;
import com.uadb.advancedev.services.RateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;

    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public void save(RateDTO rateDTO) {

        Rate rate = new Rate();

        rate.setRating(rateDTO.getRating());

        rateRepository.save(rate);

    }

    @Override
    public List<RateDTO> getAllRates() {
        return rateRepository.findAll().stream().map(rate -> {

            RateDTO rateDTO = new RateDTO();
            rateDTO.setRating(rate.getRating());
            rateDTO.setId(rate.getId());

            return rateDTO;
        }).toList();
    }

    @Override
    public Optional<RateDTO> getRateById(long idRate) {
        Optional<Rate> rateOpt = rateRepository.findById(idRate);

        if(rateOpt.isPresent()) {
            Rate rate = rateOpt.get();
            RateDTO rateDTO = new RateDTO();

            rateDTO.setId(rate.getId());
            rateDTO.setRating(rate.getRating());

            return Optional.of(rateDTO);
        }

        return Optional.empty();
    }
}
