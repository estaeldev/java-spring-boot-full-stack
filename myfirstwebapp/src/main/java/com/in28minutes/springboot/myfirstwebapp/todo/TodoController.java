package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.in28minutes.springboot.myfirstwebapp.service.TodoService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    
    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername();
        List<Todo> todos = this.todoService.getTodos(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now(), Boolean.FALSE);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addTodoPage(@Valid Todo todo, ModelMap model, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        if(Objects.isNull(todo.getDone())) {
            todo.setDone(Boolean.FALSE);
        }

        String username = getLoggedInUsername();
        Todo todoSaved = new Todo(0, username, todo.getDescription(), todo.getTargetDate(), todo.getDone());
        this.todoService.addTodo(todoSaved);
        return "redirect:list-todos";
    }
    
    @GetMapping("/delete-todo")
    public String deleteTodo(@PathParam("id") int id) {
        this.todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("/update-todo")
    public String updateTodo(@PathParam("id") int id, ModelMap model) {
        Todo todo = this.todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String addUpdateTodo(@Valid Todo todo, ModelMap model) {

        if(Objects.isNull(todo.getDone())) {
            todo.setDone(Boolean.FALSE);
        }

        String username = getLoggedInUsername();
        todo.setUsername(username);
        this.todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
    
     private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
