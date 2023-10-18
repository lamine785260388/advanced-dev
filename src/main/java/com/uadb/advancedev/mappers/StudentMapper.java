package com.uadb.advancedev.mappers;


import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {


    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);
}
