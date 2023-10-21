package com.uadb.advancedev.resources;

import com.uadb.advancedev.dto.CourseDTO;
import com.uadb.advancedev.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseResource {

    private final CourseService courseService;


    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/courses")
    public ResponseEntity<Void> save(@Valid @RequestBody CourseDTO courseDTO) {

        courseService.save(courseDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getStudents() {

        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable long courseId) {


        CourseDTO courseDTO = courseService.getCourseById(courseId);
        return ResponseEntity.ok(courseDTO);
    }
}
