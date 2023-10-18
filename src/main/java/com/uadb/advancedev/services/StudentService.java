package com.uadb.advancedev.services;

import com.uadb.advancedev.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {


    void save(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    Optional<StudentDTO> getStudentById(long idStudent);

}
