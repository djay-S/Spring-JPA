package com.example.sping.data.course.springdatajpa;

import com.example.sping.data.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {

    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
