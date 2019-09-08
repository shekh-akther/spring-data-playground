package com.example.manytomany.api;

import com.example.manytomany.api.model.CourseRatingResource;
import com.example.manytomany.api.model.StudentResource;
import com.example.manytomany.jpa.model.Course;
import com.example.manytomany.jpa.model.CourseRating;
import com.example.manytomany.jpa.model.CourseRatingKey;
import com.example.manytomany.jpa.model.Student;
import com.example.manytomany.jpa.repository.CourseRatingReposiroty;
import com.example.manytomany.jpa.repository.CourseReposiroty;
import com.example.manytomany.jpa.repository.StudentReposiroty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class StudentApi {

    private StudentReposiroty studentReposiroty;
    private CourseRatingReposiroty courseRatingReposiroty;
    private CourseReposiroty courseReposiroty;

    public StudentApi(StudentReposiroty studentReposiroty, CourseRatingReposiroty courseRatingReposiroty, CourseReposiroty courseReposiroty) {
        this.studentReposiroty = studentReposiroty;
        this.courseRatingReposiroty = courseRatingReposiroty;
        this.courseReposiroty = courseReposiroty;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public void create() {

        Student student = new Student();
        student.setName("Fatiha Akther");
        student.setAge(6);
        student.setId(1L);

        Optional<Course> courseOptional = courseReposiroty.findById(1L);

        Course course = courseOptional.get();

        CourseRatingKey courseRatingKey = new CourseRatingKey();
        courseRatingKey.setCourseId(course.getId());
        courseRatingKey.setStudentId(student.getId());

        CourseRating courseRating = new CourseRating();
        courseRating.setId(courseRatingKey);
        courseRating.setRating(4);
        courseRating.setCourse(course);
        courseRating.setStudent(student);

       // List<CourseRating> ratings = new ArrayList<>();
       // ratings.add(courseRating);
       // course.setRatings(ratings);
       // student.setRatings(ratings);

        studentReposiroty.save(student);

        courseRatingReposiroty.save(courseRating);

    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public StudentResource getStudent(@PathVariable("id") Long id) {
        Optional<Student> studentOptional = studentReposiroty.findById(id);

        Student student = studentOptional.get();

        StudentResource resource = new StudentResource();
        resource.setAge(student.getAge());
        resource.setName(student.getName());
        resource.setId(student.getId());
        Set<CourseRatingResource> ratings = new HashSet<>();
        CourseRatingResource rating = new CourseRatingResource();
        rating.setRating(student.getRatings().get(0).getRating());
        ratings.add(rating);
        resource.setRatings(ratings);

        return resource;
    }
}
