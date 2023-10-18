package com.uadb.advancedev.services;

import com.uadb.advancedev.dto.CourseDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

    void save(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();

    Optional<CourseDTO> getCourseById(long idCourse);
}
