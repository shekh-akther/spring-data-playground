package com.example.manytomany.api.model;

import java.util.Set;

public class StudentResource {

    private Long id;
    private String name;
    private int age;

    private Set<CourseRatingResource> ratings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<CourseRatingResource> getRatings() {
        return ratings;
    }

    public void setRatings(Set<CourseRatingResource> ratings) {
        this.ratings = ratings;
    }
}
