package com.springrest.springrest.service;

import com.springrest.springrest.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    Optional<Course> getCourseById(long courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long id);
}