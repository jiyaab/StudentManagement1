package com.iplus.studentManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many Enrollments belong to one Student (From wireframe: ENROLLMENT links STUDENT)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Many Enrollments belong to one Course (From wireframe: ENROLLMENT links COURSE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // From wireframe: "GRADE" (e.g., A, B, C, etc.)
    private String grade;

    // --- Constructors, Getters, and Setters ---
    public Enrollment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}