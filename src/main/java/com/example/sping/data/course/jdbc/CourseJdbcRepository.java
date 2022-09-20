package com.example.sping.data.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String insertQuery = "insert into COURSE values (1, 'Learn Spring Data', 'Udemy')";

    public void insert() {
        springJdbcTemplate.update(insertQuery);
    }
}
