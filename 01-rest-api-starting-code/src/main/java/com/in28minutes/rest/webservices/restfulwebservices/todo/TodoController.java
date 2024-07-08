package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{username}")
    public ResponseEntity<?> findAll(@PathVariable final String username) {
        List<Todo> listTodos = this.todoService.findByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(listTodos);
    }

    @GetMapping("/{username}/{id}")
    public ResponseEntity<?> findById(@PathVariable final String username, @PathVariable final Integer id) {
        Todo todo = this.todoService.findById(username, id);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<?> deleteById(@PathVariable final String username, @PathVariable final Integer id) {
        this.todoService.deleteById(username, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/{username}/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable final String username, 
                                        @PathVariable final Integer id, 
                                        @RequestBody final Todo todo) {

        Todo updateTodo = this.todoService.updateTodo(username, id, todo);
        return ResponseEntity.status(HttpStatus.OK).body(updateTodo);
    }
        
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody final Todo todo) {
        Todo todoSaved = this.todoService.createTodo(todo);

        if(Objects.isNull(todoSaved)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(todoSaved);
    }


}
