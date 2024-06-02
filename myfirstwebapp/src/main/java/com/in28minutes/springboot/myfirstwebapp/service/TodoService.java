package com.in28minutes.springboot.myfirstwebapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        String username = "estael";
        todos.add(new Todo(++todoCount, username, "Get AWS Certified", 
            LocalDate.now().plusYears(1), Boolean.FALSE));

        todos.add(new Todo(++todoCount, username, "Learn DevOps", 
            LocalDate.now().plusYears(2), Boolean.FALSE));

        todos.add(new Todo(++todoCount, username, "Learn Full Stack Development", 
            LocalDate.now().plusYears(3), Boolean.FALSE));
    }

    public List<Todo> getTodos(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void addTodo(Todo todo) {
        todo.setId(++todoCount);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
    
    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

}
