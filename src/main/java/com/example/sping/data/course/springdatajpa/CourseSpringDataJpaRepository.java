package com.example.sping.data.course.springdatajpa;

import com.example.sping.data.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {

}
