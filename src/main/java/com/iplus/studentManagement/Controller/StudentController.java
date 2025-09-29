package com.iplus.studentManagement.Controller;

import com.iplus.studentManagement.Entity.Student;
// FIX 1: Import the correct interface (StudentService)
import com.iplus.studentManagement.Service.StudentService; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    // FIX 2: Correct the field type to the interface StudentService
    private final StudentService studentService; 

    // FIX 3: Correct the constructor parameter to StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ... (rest of the code is fine) ...
    @PostMapping("/student/save")
    public String saveStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email) {

        // FIX 4: Call the correct method defined in StudentService (saveStudent)
        studentService.saveStudent(firstName, lastName, email); 

        return "redirect:/home?studentAdded";
    }
}