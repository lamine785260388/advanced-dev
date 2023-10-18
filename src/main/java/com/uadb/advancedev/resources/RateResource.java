package com.uadb.advancedev.resources;

import com.uadb.advancedev.dto.RateDTO;
import com.uadb.advancedev.services.RateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RateResource {

    private final RateService rateService;

    public RateResource(RateService rateService) {
        this.rateService = rateService;
    }


    @PostMapping("/rates")
    public ResponseEntity<Void> save(@RequestBody RateDTO rateDTO) {

        rateService.save(rateDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/rates")
    public ResponseEntity<List<RateDTO>> getRates() {

        return ResponseEntity.ok(rateService.getAllRates());
    }

    @GetMapping("/rates/{rateId}")
    public ResponseEntity<RateDTO> getRateById(@PathVariable long rateId) {

        Optional<RateDTO> rateByIdOpt = rateService.getRateById(rateId);
        return rateByIdOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
