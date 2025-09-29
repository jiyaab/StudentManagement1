package com.iplus.studentManagement.Controller;

import com.iplus.studentManagement.Service.CourseService;
import com.iplus.studentManagement.Service.EnrollmentService;
import com.iplus.studentManagement.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcademicController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    // You might need StudentService too for drop-down lists

    public AcademicController(CourseService courseService, EnrollmentService enrollmentService, UserServiceImpl studentService) {
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    // --- COURSE CREATION PAGE (GET) ---
    @GetMapping("/course/create")
    public String showCourseForm() {
        return "course_form"; // Renders course_form.html/jsp
    }

    // --- COURSE SAVE (POST) ---
    // Handles the "SAVE" button in the COURSE section
    @PostMapping("/course/save")
    public String saveCourse(@RequestParam("courseName") String courseName,
                             @RequestParam("description") String description) {
        
        courseService.saveCourse(courseName, description);
        return "redirect:/course/list";
    }

    // --- ENROLLMENT PAGE (GET) ---
    // Requires lists of existing Students and Courses
    @GetMapping("/enrollment/create")
    public String showEnrollmentForm(Model model) {
        // You would fetch and add lists here:
        // model.addAttribute("students", studentService.getAllStudents());
        // model.addAttribute("courses", courseService.getAllCourses());
        return "enrollment_form"; // Renders enrollment_form.html/jsp
    }

    // --- ENROLLMENT SAVE (POST) ---
    @PostMapping("/enrollment/save")
    public String saveEnrollment(@RequestParam("studentId") Long studentId,
                                 @RequestParam("courseId") Long courseId) {
        
        enrollmentService.enrollStudent(studentId, courseId);
        return "redirect:/enrollment/list";
    }

    // --- GRADING PAGE (GET) ---
    // Handles the "GRADING / SELECT GRADE" flow
    @GetMapping("/grade/assign")
    public String showGradeForm(Model model) {
        // Fetch list of current enrollments to grade
        // model.addAttribute("enrollments", enrollmentRepository.findAll());
        return "grade_form"; // Renders grade_form.html/jsp
    }
    
    // --- GRADING SAVE (POST) ---
    @PostMapping("/grade/save")
    public String saveGrade(@RequestParam("enrollmentId") Long enrollmentId,
                            @RequestParam("grade") String grade) {
        
        enrollmentService.assignGrade(enrollmentId, grade);
        return "redirect:/enrollment/list";
    }
}