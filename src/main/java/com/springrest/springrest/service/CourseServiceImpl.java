package com.springrest.springrest.service;

import com.springrest.springrest.Repository.CourseRepository;
import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{


    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(long id) {

        Optional<Course> courseOptional = courseRepository.findById(id);

        if(courseOptional.isPresent()){
            courseRepository.delete(courseOptional.get());
        } else {
            throw new RuntimeException("Course not found.");
        }
    }
}


