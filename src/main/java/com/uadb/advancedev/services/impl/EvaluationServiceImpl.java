package com.uadb.advancedev.services.impl;

import com.uadb.advancedev.dto.EvaluationDTO;
import com.uadb.advancedev.dto.ProfessorDTO;
import com.uadb.advancedev.entities.Evaluation;
import com.uadb.advancedev.entities.Professor;
import com.uadb.advancedev.entities.Student;
import com.uadb.advancedev.repositories.EvaluationRepository;
import com.uadb.advancedev.services.EvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EvaluationServiceImpl implements EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public void save(EvaluationDTO evaluationDTO) {
        Evaluation evaluation = new Evaluation();

        evaluation.setRating(evaluationDTO.getRating());

        evaluationRepository.save(evaluation);

    }

    @Override
    public List<EvaluationDTO> getAllEvaluations() {
        return evaluationRepository.findAll().stream().map(evaluation -> {

            EvaluationDTO evaluationDTO = new EvaluationDTO();
            evaluationDTO.setRating(evaluation.getRating());
            evaluationDTO.setId(evaluation.getId());

            return evaluationDTO;
        }).toList();
    }

    @Override
    public Optional<EvaluationDTO> getEvaluationById(long idEvaluation) {

        Optional<Evaluation> evaluationOpt = evaluationRepository.findById(idEvaluation);

        if(evaluationOpt.isPresent()) {
            Evaluation evaluation = evaluationOpt.get();
            EvaluationDTO evaluationDTO = new EvaluationDTO();

            evaluationDTO.setId(evaluation.getId());
            evaluationDTO.setRating(evaluation.getRating());

            return Optional.of(evaluationDTO);
        }

        return Optional.empty();
    }
}
