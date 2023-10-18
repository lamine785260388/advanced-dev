package com.uadb.advancedev.services;

import com.uadb.advancedev.dto.ProfessorDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface ProfessorService {

    void save(ProfessorDTO professorDTO);

    List<ProfessorDTO> getAllProfessors();

    Optional<ProfessorDTO> getProfessorById(long idProfessor);
}
