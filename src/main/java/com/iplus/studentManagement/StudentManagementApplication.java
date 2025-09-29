package com.iplus.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Correct import for the annotation

@SpringBootApplication
public class StudentManagementApplication { // <-- FIX: Class name added here

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}