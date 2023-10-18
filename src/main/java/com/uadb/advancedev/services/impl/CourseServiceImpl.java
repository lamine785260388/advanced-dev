package com.uadb.advancedev.services.impl;

import com.uadb.advancedev.dto.CourseDTO;
import com.uadb.advancedev.dto.EvaluationDTO;
import com.uadb.advancedev.entities.Course;
import com.uadb.advancedev.entities.Evaluation;
import com.uadb.advancedev.repositories.CourseRepository;
import com.uadb.advancedev.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService {
    private  final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(CourseDTO courseDTO) {

        Course course = new Course();

        course.setName(courseDTO.getName());

        courseRepository.save(course);

    }

    @Override
    public List<CourseDTO> getAllCourses() {

        return courseRepository.findAll().stream().map(course -> {

            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(course.getName());
            courseDTO.setId(course.getId());

            return courseDTO;
        }).toList();
    }

    @Override
    public Optional<CourseDTO> getCourseById(long idCourse) {

        Optional<Course> courseOpt = courseRepository.findById(idCourse);

        if(courseOpt.isPresent()) {
            Course course = courseOpt.get();
            CourseDTO courseDTO = new CourseDTO();

            courseDTO.setId(course.getId());
            courseDTO.setName(course.getName());

            return Optional.of(courseDTO);
        }

        return Optional.empty();
    }
}
