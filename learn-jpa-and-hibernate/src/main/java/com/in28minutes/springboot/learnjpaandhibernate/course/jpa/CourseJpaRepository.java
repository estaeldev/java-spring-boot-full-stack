package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

    private final EntityManager entityManager;

    public CourseJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Course... course) {
        Arrays.stream(course).forEach(this.entityManager::merge);
    }
    
    public Course findById(int id) {
        return this.entityManager.find(Course.class, id);
    }

    public void deleteById(int id) {
        Course course = findById(id);
        this.entityManager.remove(course);
    }

}
