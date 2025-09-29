package com.iplus.studentManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // As per your wireframe: "USER NAME"
    @Column(nullable = false, unique = true)
    private String username;
    
    // As per your wireframe: "PASSWORD"
    @Column(nullable = false)
    private String password;
    
    // As per your wireframe: "ROLE"
    private String role; // e.g., "STUDENT", "ADMIN"

    // Default constructor (required by JPA)
    public User() {}
    
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}