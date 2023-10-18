package com.uadb.advancedev.mappers;


import com.uadb.advancedev.dto.StudentDTO;
import com.uadb.advancedev.entities.Rate;
import com.uadb.advancedev.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO,Student> {


    StudentDTO toDto(Student student);

    Student toEntity(StudentDTO studentDTO);
}
