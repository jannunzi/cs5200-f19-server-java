package com.example.cs5200f19serverjava.controllers;

import com.example.cs5200f19serverjava.models.Course;
import com.example.cs5200f19serverjava.models.User;
import com.example.cs5200f19serverjava.repositories.CourseRepository;
import com.example.cs5200f19serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository repository;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/api/create/course/{title}")
    public Course createCourse(
            @PathVariable("title") String title) {
        Course course = new Course();
        course.setTitle(title);
        return repository.save(course);
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return (List<Course>)repository.findAll();
    }

    @GetMapping("/api/add/course/{courseId}/to/faculty/{facultyId}")
    public User addCourseToFaculty(
            @PathVariable("facultyId") Integer facultyId,
            @PathVariable("courseId") Integer courseId) {
        System.out.println(facultyId);
        System.out.println(courseId);
        Course course = repository.findById(courseId).get();
        User faculty = userRepository.findById(facultyId).get();
        course.setUser(faculty);
        repository.save(course);
        return faculty;
    }
}
