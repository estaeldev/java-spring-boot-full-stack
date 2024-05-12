package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        String author = "in28minutes";

        Course course1 = new Course(1, "Learn AWS", author);
        Course course2 = new Course(2, "Learn Azure", author);
        Course course3 = new Course(3, "Learn DevOps", author);

        this.repository.insert(course1, course2, course3);  

        this.repository.deleteByCourse(course1);

        System.out.println(this.repository.findById(course2.getId()));
        

    }
    
}
