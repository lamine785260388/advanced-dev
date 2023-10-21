package com.uadb.advancedev.services.impl;

import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.entities.Student;
import com.uadb.advancedev.mappers.StudentMapper;
import com.uadb.advancedev.repositories.StudentRepository;
import com.uadb.advancedev.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public void save(StudentDTO studentDTO) {

        Student student = studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        log.info("Get all students service");

        List<Student> studentList = studentRepository.findAll();
        return studentMapper.toDto(studentList);
    }

    @Override
    public StudentDTO getStudentById(long idStudent) {
        log.info("Get student by id");
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + idStudent + " not found"));


        return studentMapper.toDto(student);

    }

    @Override
    public List<StudentDTO> searchStudent(String name) {
        List<Student> students = studentRepository.findByName(name);
        return studentMapper.toDto(students);
    }

    @Override
    public void update(StudentDTO studentDTO) {

        Student student = studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }

}
