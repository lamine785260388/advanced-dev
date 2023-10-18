package com.uadb.advancedev.services;

import com.uadb.advancedev.dto.EvaluationDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface EvaluationService {

    void save(EvaluationDTO evaluationDTO);

    List<EvaluationDTO> getAllEvaluations();

    Optional<EvaluationDTO> getEvaluationById(long idEvaluation);
}
