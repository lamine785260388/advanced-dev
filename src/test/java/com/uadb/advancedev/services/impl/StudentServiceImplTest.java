package com.uadb.advancedev.services.impl;

import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.entities.Course;
import com.uadb.advancedev.entities.Student;
import com.uadb.advancedev.repositories.StudentRepository;
import com.uadb.advancedev.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceImplTest {

    private final static String studentName = "Serigne";
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepositoryMock;

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {

        StudentDTO studentDTO = getStudentDTO("Serigne");
        when(studentRepositoryMock.save(any(Student.class))).thenReturn(null);

        studentService.save(studentDTO);

        verify(studentRepositoryMock).save(any(Student.class));

    }

    @Test
    void getAllStudents() {

        when(studentRepositoryMock.findAll()).thenReturn(getStudentList());

        List<StudentDTO> allStudents = studentService.getAllStudents();

        assertEquals(1, allStudents.size());
        assertEquals("Fatou", allStudents.get(0).getName());
        assertEquals(1L, allStudents.get(0).getId());
    }

    @Test
    void getStudent_whenStudentExist() {
        long studentId = 1L;
        when(studentRepositoryMock.findById(studentId))
                .thenReturn(Optional.of(getStudent(studentId, studentName)));

        StudentDTO studentDTO = studentService.getStudentById(studentId);

        assertEquals(studentId, studentDTO.getId());
        assertEquals(studentName, studentDTO.getName());
    }

    @Test
    void getStudent_whenStudentDoesNotExist() {
        long studentId = 1L;
        when(studentRepositoryMock.findById(studentId))
                .thenReturn(Optional.of(getStudent(1, studentName)));

        StudentDTO studentDTO = studentService.getStudentById(studentId);

        assertNotNull(studentDTO);
    }
    public static StudentDTO getStudentDTO(String name) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        return studentDTO;
    }

    public static Student getStudent(long id, String name) {
        Student student = new Student();
        student.setName(name);
        student.setId(id);
        Course course = new Course();
        course.setName("JUNIT");
        course.setId(1);
        student.setCourses(Set.of(course));
        return student;
    }

    private List<Student> getStudentList() {
        return List.of(getStudent(1, "Fatou"));
    }
}