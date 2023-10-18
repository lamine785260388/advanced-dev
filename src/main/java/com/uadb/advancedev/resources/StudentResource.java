package com.uadb.advancedev.resources;

import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public ResponseEntity<Void> save(@RequestBody StudentDTO studentDTO) {

        studentService.save(studentDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable long studentId) {


        Optional<StudentDTO> studentByIdOpt = studentService.getStudentById(studentId);
        return studentByIdOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
