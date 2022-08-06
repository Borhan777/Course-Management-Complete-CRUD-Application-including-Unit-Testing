package com.springrest.springrest.controller;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RequestMapping("/api/courses")
@RestController
public class MyController {


    private final CourseService courseService;

    public MyController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/getAll")
    public List<Course> getAll() {
        return courseService.getAllCourses();
    }

    @GetMapping("/get/{id}")
    public Optional<Course> getById( @PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}