package com.uadb.advancedev.resources;

import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentResource {

    private final StudentService studentService;

    private final Logger log = LoggerFactory.getLogger(StudentResource.class);

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
        log.info("Get all student resource");

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/students/search")
    public ResponseEntity<List<StudentDTO>> searchStudent(@RequestParam String name) {

        return ResponseEntity.ok(studentService.searchStudent(name));
    }

    @PutMapping("/students")
    public ResponseEntity<Void> updateStudent(@RequestBody StudentDTO studentDTO) {

        studentService.update(studentDTO);

        return ResponseEntity.ok().build();
    }

}
