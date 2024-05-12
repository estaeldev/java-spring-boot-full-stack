package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository jdbcRepository;
    private final CourseJpaRepository jpaRepository;

    public CourseCommandLineRunner(CourseJdbcRepository jdbcRepository, CourseJpaRepository jpaRepository) {
        this.jdbcRepository = jdbcRepository;
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        String author = "in28minutes";

        Course course1 = new Course(1, "Learn AWS", author);
        Course course2 = new Course(2, "Learn Azure", author);
        Course course3 = new Course(3, "Learn DevOps", author);

        this.jpaRepository.insert(course1, course2, course3);  

        this.jdbcRepository.deleteByCourse(course1);

        System.out.println(this.jdbcRepository.findById(course2.getId()));

        
        

    }
    
}
