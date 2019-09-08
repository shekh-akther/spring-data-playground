package com.example.manytomany.jpa.repository;

import com.example.manytomany.jpa.model.Course;
import com.example.manytomany.jpa.model.CourseRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRatingReposiroty extends JpaRepository<CourseRating, Long> {
}
