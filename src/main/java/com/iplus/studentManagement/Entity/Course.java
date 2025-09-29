package com.iplus.studentManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // From wireframe: "COURSE NAME"
    @Column(name = "course_name", nullable = false, unique = true)
    private String courseName;

    // From wireframe: "DESCRIPTION"
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // --- Constructors, Getters, and Setters ---
    public Course() {}

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}