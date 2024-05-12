package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import java.util.Arrays;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Course... course) {
        String sql = 
        """
            INSERT INTO course (id, name, author)
            VALUES (?, ?, ?);
        """;

        Arrays.stream(course).forEach(c -> this.jdbcTemplate.update(sql, c.getId(), c.getName(), c.getAuthor()));
        
    }
    
    public void deleteByCourse(Course... course) {
        String sql = "DELETE FROM course WHERE id=?";

        Arrays.stream(course).forEach(c -> this.jdbcTemplate.update(sql, c.getId()));
    }

    public Course findById(int id) {
        String sql = "SELECT * FROM course WHERE id=?";

        return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
