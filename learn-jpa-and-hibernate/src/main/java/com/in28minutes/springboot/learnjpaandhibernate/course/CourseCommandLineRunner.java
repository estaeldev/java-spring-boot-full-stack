package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private final CourseSpringDataJpaRepository springDataJpaRepository;

    public CourseCommandLineRunner(CourseSpringDataJpaRepository springDataJpaRepository) {
        this.springDataJpaRepository = springDataJpaRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        String author = "in28minutes";

        Course course1 = new Course(1, "Learn AWS", author);
        Course course2 = new Course(2, "Learn Azure", author);
        Course course3 = new Course(3, "Learn DevOps", author);


        this.springDataJpaRepository.save(course1);
        this.springDataJpaRepository.save(course2);
        this.springDataJpaRepository.save(course3);

        this.springDataJpaRepository.delete(course2);

    }
    
}
