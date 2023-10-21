package com.uadb.advancedev.mappers;


import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student>{


    @Mapping(source = "courses", target = "courseDTOs")
    StudentDTO toDto(Student student);

    @Mapping(source = "courseDTOs", target = "courses")
    Student toEntity(StudentDTO studentDTO);

    @Mapping(source = "courses", target = "courseDTOs")
    List<StudentDTO> toDto(List<Student> studentList);
}
