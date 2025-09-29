package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Entity.Enrollment;

public interface EnrollmentService {
    // For the initial ENROLLMENT step (selecting student/course, possibly assigning initial grade)
    Enrollment enrollStudent(Long studentId, Long courseId);
    
    // For the GRADING step (SELECT GRADE V)
    Enrollment assignGrade(Long enrollmentId, String grade);
}