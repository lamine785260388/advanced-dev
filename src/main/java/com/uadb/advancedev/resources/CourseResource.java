package com.uadb.advancedev.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uadb.advancedev.dto.CourseDTO;
import com.uadb.advancedev.services.CourseService;

@RestController
public class CourseResource {

    private final CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public ResponseEntity<Void> save(@RequestBody CourseDTO courseDTO) {

        courseService.save(courseDTO);

        return ResponseEntity.status(201).build();
    }

     @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getCourses() {

        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable long courseId) {


        Optional<CourseDTO> courseByIdOpt = courseService.getCourseById(courseId);
        return courseByIdOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
