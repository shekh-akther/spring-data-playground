package com.example.manytomany.jpa.repository;

import com.example.manytomany.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReposiroty extends JpaRepository<Course, Long> {
}
