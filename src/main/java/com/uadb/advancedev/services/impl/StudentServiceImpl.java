package com.uadb.advancedev.services.impl;

import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.entities.Student;
import com.uadb.advancedev.repositories.StudentRepository;
import com.uadb.advancedev.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());

        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        return studentRepository.findAll().stream().map(student -> {

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTO.setId(student.getId());

            return studentDTO;
        }).toList();
    }

    @Override
    public Optional<StudentDTO> getStudentById(long idStudent) {
        Optional<Student> studentOpt = studentRepository.findById(idStudent);

        if(studentOpt.isPresent()) {
            Student student = studentOpt.get();
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());

            return Optional.of(studentDTO);
        }

        return Optional.empty();
    }
}
