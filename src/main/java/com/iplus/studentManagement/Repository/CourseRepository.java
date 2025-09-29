package com.iplus.studentManagement.Repository;

import com.iplus.studentManagement.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Basic CRUD methods inherited
}