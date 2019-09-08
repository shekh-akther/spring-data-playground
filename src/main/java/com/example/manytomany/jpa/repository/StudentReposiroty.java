package com.example.manytomany.jpa.repository;

import com.example.manytomany.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReposiroty extends JpaRepository<Student, Long> {
}
