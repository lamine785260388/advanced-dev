package com.uadb.advancedev.services.impl;

import com.uadb.advancedev.dto.ProfessorDTO;

import com.uadb.advancedev.entities.Professor;

import com.uadb.advancedev.repositories.ProfessorRepository;
import com.uadb.advancedev.services.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void save(ProfessorDTO professorDTO) {

        Professor professor = new Professor();

        professor.setName(professorDTO.getName());

        professorRepository.save(professor);

    }

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream().map(professor -> {

            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setName(professor.getName());
            professorDTO.setId(professor.getId());

            return professorDTO;
        }).toList();
    }

    @Override
    public Optional<ProfessorDTO> getProfessorById(long idProfessor) {
        Optional<Professor> professorOpt = professorRepository.findById(idProfessor);

        if(professorOpt.isPresent()) {
            Professor professor = professorOpt.get();
            ProfessorDTO professorDTO = new ProfessorDTO();

            professorDTO.setId(professor.getId());
            professorDTO.setName(professor.getName());

            return Optional.of(professorDTO);
        }

        return Optional.empty();
    }
}
