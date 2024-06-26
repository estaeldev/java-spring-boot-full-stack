package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import java.util.List;


public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
    
}
