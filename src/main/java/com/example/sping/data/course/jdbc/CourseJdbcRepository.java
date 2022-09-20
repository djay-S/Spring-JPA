package com.example.sping.data.course.jdbc;

import com.example.sping.data.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insertByHardCodedSQLQuery() {
        springJdbcTemplate.update("insert into COURSE values (1, 'Learn Spring Data', 'Udemy')");
    }

    public void insertByCoursePOJO(Course course) {
        springJdbcTemplate.update("insert into course values (?, ?, ?)", course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteByIdUsingSpringJDBC(int courseId) {
        springJdbcTemplate.update("delete from course where id = ?", courseId);
    }
}
