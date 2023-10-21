package com.uadb.advancedev.mappers;

import com.uadb.advancedev.dto.CourseDTO;

import com.uadb.advancedev.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface CourseMapper extends EntityMapper<CourseDTO, Course> {


    @Mapping(source = "students", target = "studentDTOs")
    CourseDTO toDto(Course course);

    @Mapping(source = "studentDTOs", target = "students")
    Course toEntity(CourseDTO courseDTO);

    List<Course> toEntity(List<CourseDTO> courseDTOList);

    List<CourseDTO> toDto(List<Course> courseList);
}
