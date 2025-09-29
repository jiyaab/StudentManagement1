package com.iplus.studentManagement.Repository;

import com.iplus.studentManagement.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Basic CRUD methods inherited
}