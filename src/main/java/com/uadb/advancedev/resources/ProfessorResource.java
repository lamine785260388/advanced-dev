package com.uadb.advancedev.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uadb.advancedev.dto.ProfessorDTO;
import com.uadb.advancedev.services.ProfessorService;

@RestController
public class ProfessorResource {
    private final ProfessorService professorService;

    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping("/professors")
    public ResponseEntity<Void> save(@RequestBody ProfessorDTO professorDTO) {

        professorService.save(professorDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/professors")
    public ResponseEntity<List<ProfessorDTO>> getProfessors() {

        return ResponseEntity.ok(professorService.getAllProfessors());
    }
     @GetMapping("/professors/{professorId}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable long professorId) {


        Optional<ProfessorDTO> professorByIdOpt = professorService.getProfessorById(professorId);
        return professorByIdOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
