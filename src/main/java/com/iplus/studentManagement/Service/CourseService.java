package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Entity.Course;
import java.util.List;

public interface CourseService {
    Course saveCourse(String courseName, String description);
    List<Course> getAllCourses();
}