package com.uadb.advancedev.mappers;

import com.uadb.advancedev.dto.CourseDTO;
import com.uadb.advancedev.dto.StudentDTO;

import com.uadb.advancedev.services.impl.StudentServiceImplTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void toDto() {

        String name = "Serigne";
        StudentDTO studentDTO = studentMapper.toDto(StudentServiceImplTest.getStudent(1, name));

        assertEquals(1, studentDTO.getId());
        assertEquals(name, studentDTO.getName());
        assertEquals(1, studentDTO.getCourseDTOs().size());
        Set<CourseDTO> courseDTOSet = studentDTO.getCourseDTOs();
        CourseDTO courseDTO = courseDTOSet.stream().toList().get(0);
        assertEquals("JUNIT", courseDTO.getName());
    }

}


