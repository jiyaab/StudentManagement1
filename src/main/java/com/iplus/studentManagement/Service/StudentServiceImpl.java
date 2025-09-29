package com.iplus.studentManagement.Service;
// You need to import the Student class from the Entity package.
import com.iplus.studentManagement.Entity.Student;
import com.iplus.studentManagement.Repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(String firstName, String lastName, String email) {
        // Map the data to the Student entity
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);

        return studentRepository.save(student);
    }
}