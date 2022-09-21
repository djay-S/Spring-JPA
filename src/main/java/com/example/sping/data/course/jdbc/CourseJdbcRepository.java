package com.example.sping.data.course.jdbc;

import com.example.sping.data.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insertByHardCodedSQLQuery() {
        springJdbcTemplate.update("insert into COURSE (id, name, author) values (1, 'Learn Spring Data', 'Udemy')");
    }

    public void insertByCoursePOJO(Course course) {
        springJdbcTemplate.update("insert into course (id, name, author) values (?, ?, ?)", course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteByCourseId(int courseId) {
        springJdbcTemplate.update("delete from course where id = ?", courseId);
    }

    public Course selectCourseByCourseId(int courseId) {
        Course course = null;
        try {
            course = springJdbcTemplate.queryForObject("select * from course where id = ?", new BeanPropertyRowMapper<>(Course.class), courseId);
        }
        catch (DataAccessException e) {
            System.out.printf("Exception thrown for courseId:%d, : %s%n", courseId, e.getLocalizedMessage());
        }
        return course;
    }
}
