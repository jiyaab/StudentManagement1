// Expected content of StudentRepository.java
package com.iplus.studentManagement.Repository;

import com.iplus.studentManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // ...
}