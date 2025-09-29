package com.iplus.studentManagement.Entity;

import jakarta.persistence.Entity; // Use jakarta.persistence for Spring Boot 3+
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students") // Optional: specifies the table name
public class Student {

    // FIX: ADD THE PRIMARY KEY FIELD AND ANNOTATIONS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // For auto-incrementing ID in MySQL
    private Long id; 

    private String firstName;
    private String lastName;
    private String email;
	public void setFirstName(String firstName2) {
		// TODO Auto-generated method stub
		
	}
	public void setLastName(String lastName2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}

    // Constructors (make sure to include a no-arg constructor if needed by Hibernate)
    // Getters and Setters for all fields (including the new 'id' field)
    // ...
}