package com.in28minutesspringboot.learnjpaandhibernate.course.jpa;

import com.in28minutesspringboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }
    public Course findById(long Id){
        return entityManager.find(Course.class, id);
    }
    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
         entityManager.remove(course);
    }
}
