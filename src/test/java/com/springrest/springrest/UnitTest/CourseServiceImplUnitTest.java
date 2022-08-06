package com.springrest.springrest.UnitTest;

import com.springrest.springrest.Repository.CourseRepository;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;
import com.springrest.springrest.service.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseServiceImplUnitTest {

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private CourseRepository courseRepository;

    @Test
    public void getAllCourse(){
        List<Course> courseList = new ArrayList<>();
        Course course = new Course(1, "CSE101", "Programming Language 1");
        courseList.add(course);

        Mockito.when(courseRepository.findAll()).thenReturn(courseList);

        List<Course> actual = courseService.getAllCourses();

        assertThat(courseList).isEqualTo(actual);
    }

    @Test
    public void addCourse(){
        Course course = new Course(1, "CSE101", "Programming Language 1");
        Mockito.when(courseService.addCourse(course)).thenReturn(course);

        Course actual = courseService.addCourse(course);

        assertThat(course).isEqualTo(actual);
    }

    @Test
    public void updateCourse(){
        Course course = new Course(1, "CSE111", "Programming Language 2");
        Mockito.when(courseService.updateCourse(course)).thenReturn(course);

        Course actual = courseService.updateCourse(course);

        assertThat(course).isEqualTo(actual);
    }

    @Test
    public void getCourseById(){
        Course course = new Course(1, "CSE111", "Programming Language 2");
        Mockito.when(courseService.getCourseById(1)).thenReturn(Optional.of(course));

        Optional<Course> actual = courseService.getCourseById(1);

        assertThat(Optional.of(course)).isEqualTo(actual);
    }
}
