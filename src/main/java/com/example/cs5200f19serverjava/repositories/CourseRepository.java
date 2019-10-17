package com.example.cs5200f19serverjava.repositories;

import com.example.cs5200f19serverjava.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository
        extends CrudRepository<Course, Integer> {
    @Query("SELECT c FROM Course c")
    public List<Course> findAllCourses();

    @Query("SELECT c FROM Course c WHERE c.id=:courseId")
    public Course findCourseById(
            @Param("courseId") Integer id
    );
    @Query("DELETE FROM Course c WHERE c.id=:courseId")
    public void deleteCourseById(
            @Param("courseId") Integer id
    );
}
