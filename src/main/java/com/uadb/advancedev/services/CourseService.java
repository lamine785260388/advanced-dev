package com.uadb.advancedev.services;

import com.uadb.advancedev.dto.CourseDTO;
import com.uadb.advancedev.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    void save(CourseDTO courseDTO);

    CourseDTO getCourseById(long courseId);

    List<CourseDTO> getAllCourses();
}
