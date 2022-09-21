package com.example.sping.data.course;

import com.example.sping.data.course.jdbc.CourseJdbcRepository;
import com.example.sping.data.course.jpa.CourseJpaRepository;
import com.example.sping.data.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {

//        JDBC

        System.out.println("Spring JDBC:");
        courseJdbcRepository.insertByHardCodedSQLQuery();

        courseJdbcRepository.insertByCoursePOJO(new Course(2, "Learn Spring Data Spring JPA", "Udemy"));
        courseJdbcRepository.insertByCoursePOJO(new Course(3, "Learn Spring Data JDBC", "Udemy"));
        courseJdbcRepository.insertByCoursePOJO(new Course(4, "Learn Spring Data Spring JDBC", "Udemy"));

        courseJdbcRepository.deleteByCourseId(4);

        System.out.println("CourseId:" + "1" + "; Course:" + courseJdbcRepository.selectCourseByCourseId(1));
        System.out.println("CourseId:" + "2" + "; Course:" + courseJdbcRepository.selectCourseByCourseId(2));
        System.out.println("CourseId:" + "3" + "; Course:" + courseJdbcRepository.selectCourseByCourseId(3));
        System.out.println("CourseId:" + "4" + "; Course:" + courseJdbcRepository.selectCourseByCourseId(4));

//        JPA

        System.out.println("Spring JPA:");
        courseJpaRepository.insert(new Course(5, "Learn Spring JPA", "Udemy"));

        courseJpaRepository.findCourseByCourseId(5);

        courseJpaRepository.deleteByCourseId(2);

        System.out.println("CourseId:" + "1" + "; Course:" + courseJpaRepository.findCourseByCourseId(1));
        System.out.println("CourseId:" + "2" + "; Course:" + courseJpaRepository.findCourseByCourseId(2));
        System.out.println("CourseId:" + "3" + "; Course:" + courseJpaRepository.findCourseByCourseId(3));
        System.out.println("CourseId:" + "5" + "; Course:" + courseJpaRepository.findCourseByCourseId(5));

//        Spring Data JPA

        System.out.println("Spring Data JPA:");
        courseSpringDataJpaRepository.save(new Course(6, "Learn Spring Data JPA", "Udemy"));

        courseSpringDataJpaRepository.deleteById(1);

        System.out.println("CourseId:" + "1" + "; Course:" + courseSpringDataJpaRepository.findById(1));
        System.out.println("CourseId:" + "2" + "; Course:" + courseSpringDataJpaRepository.findById(2));
        System.out.println("CourseId:" + "3" + "; Course:" + courseSpringDataJpaRepository.findById(3));
        System.out.println("CourseId:" + "5" + "; Course:" + courseSpringDataJpaRepository.findById(5));
        System.out.println("CourseId:" + "6" + "; Course:" + courseSpringDataJpaRepository.findById(6));
    }
}
