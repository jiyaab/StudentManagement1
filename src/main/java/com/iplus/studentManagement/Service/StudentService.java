package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Entity.Student;

public interface StudentService {
    Student saveStudent(String firstName, String lastName, String email);
    // ... potentially other methods
}
