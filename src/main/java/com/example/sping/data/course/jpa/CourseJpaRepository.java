package com.example.sping.data.course.jpa;

import com.example.sping.data.course.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findCourseByCourseId(int courseId) {
//        Finds by primary key
        return entityManager.find(Course.class, courseId);
    }

    public void deleteByCourseId(int courseId) {
        Course course = findCourseByCourseId(courseId);
        entityManager.remove(course);
    }
}
