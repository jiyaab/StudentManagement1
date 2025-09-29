package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Entity.Course;
import com.iplus.studentManagement.Entity.Enrollment;
import com.iplus.studentManagement.Entity.Student;
import com.iplus.studentManagement.Repository.CourseRepository;
import com.iplus.studentManagement.Repository.EnrollmentRepository;
import com.iplus.studentManagement.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setGrade("N/A"); // Default grade upon enrollment
        
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment assignGrade(Long enrollmentId, String grade) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        
        enrollment.setGrade(grade); // Update the grade
        return enrollmentRepository.save(enrollment);
    }
}