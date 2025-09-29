package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Entity.Course;
import com.iplus.studentManagement.Repository.CourseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Implements the "SAVE" button logic in the COURSE section of the wireframe
    @Override
    public Course saveCourse(String courseName, String description) {
        Course course = new Course(courseName, description);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}