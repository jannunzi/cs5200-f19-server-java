package com.example.cs5200f19serverjava.controllers;

import com.example.cs5200f19serverjava.models.Course;
import com.example.cs5200f19serverjava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestfulController {

    @Autowired
    CourseRepository repository;

    @PostMapping("/courses")
    public Course createCourse(
            @RequestBody Course course) {
        return repository.save(course);
    }
    @GetMapping("/courses")
    public List<Course> findAllCourses() {
        return repository.findAllCourses();
    }
    @GetMapping("/courses/{id}")
    public Course findCourseById(
            @PathVariable("id") Integer courseId) {
        return repository.findCourseById(courseId);
    }
    @PutMapping("/courses/{id}")
    public Course updateCourse(
            @PathVariable("id") Integer courseId,
            @RequestBody Course newCourse) {
        Course oldCourse = repository.findCourseById(courseId);
        oldCourse.setTitle(newCourse.getTitle());
        return repository.save(oldCourse);
    }
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(
            @PathVariable("id") Integer courseId) {
        repository.deleteById(courseId);
    }
}
