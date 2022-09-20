package com.example.sping.data.course;

import com.example.sping.data.course.jdbc.CourseJdbcRepository;
import com.example.sping.data.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {

//        JDBC
        courseJdbcRepository.insertByHardCodedSQLQuery();

        courseJdbcRepository.insertByCoursePOJO(new Course(2, "Learn Spring Data Spring JPA", "Udemy"));
        courseJdbcRepository.insertByCoursePOJO(new Course(3, "Learn Spring Data JDBC", "Udemy"));
        courseJdbcRepository.insertByCoursePOJO(new Course(4, "Learn Spring Data Spring JDBC", "Udemy"));

        courseJdbcRepository.deleteByCourseId(4);

        System.out.println(courseJdbcRepository.selectCourseByCourseId(1));
        System.out.println(courseJdbcRepository.selectCourseByCourseId(2));
        System.out.println(courseJdbcRepository.selectCourseByCourseId(3));

//        JPA

        courseJpaRepository.insert(new Course(5, "Learn Spring Data Spring JPA", "Udemy"));

        courseJpaRepository.findCourseByCourseId(5);

        courseJpaRepository.deleteByCourseId(2);
    }
}
