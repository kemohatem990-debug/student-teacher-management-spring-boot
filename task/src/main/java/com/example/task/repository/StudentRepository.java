package com.example.task.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.model.Student;
public interface  StudentRepository extends JpaRepository<Student, Long> {
    
}
