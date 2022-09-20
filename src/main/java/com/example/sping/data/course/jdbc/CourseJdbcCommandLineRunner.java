package com.example.sping.data.course.jdbc;

import com.example.sping.data.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insertByHardCodedSQLQuery();

        repository.insertByCoursePOJO(new Course(2, "Learn Spring Data JDBC", "Udemy"));
        repository.insertByCoursePOJO(new Course(3, "Learn Spring Data Spring JDBC", "Udemy"));
        repository.insertByCoursePOJO(new Course(4, "Learn Spring Data Spring JPA", "Udemy"));

        repository.deleteByCourseId(4);

        System.out.println(repository.selectCourseByCourseId(1));
        System.out.println(repository.selectCourseByCourseId(2));
        System.out.println(repository.selectCourseByCourseId(3));
    }
}
