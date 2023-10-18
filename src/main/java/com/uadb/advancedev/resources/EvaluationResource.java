package com.uadb.advancedev.resources;

import com.uadb.advancedev.dto.EvaluationDTO;
import com.uadb.advancedev.services.EvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EvaluationResource {

    private final EvaluationService evaluationService;

    public EvaluationResource(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }


    @PostMapping("/evaluations")
    public ResponseEntity<Void> save(@RequestBody EvaluationDTO evaluationDTO) {

        evaluationService.save(evaluationDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/evaluations")
    public ResponseEntity<List<EvaluationDTO>> getEvaluations() {

        return ResponseEntity.ok(evaluationService.getAllEvaluations());
    }

    @GetMapping("/evaluations/{evaluationId}")
    public ResponseEntity<EvaluationDTO> getEvaluationById(@PathVariable long evaluationId) {


        Optional<EvaluationDTO> evaluationByIdOpt = evaluationService.getEvaluationById(evaluationId);
        return evaluationByIdOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
