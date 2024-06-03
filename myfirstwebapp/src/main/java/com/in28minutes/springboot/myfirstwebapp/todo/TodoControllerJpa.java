package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.in28minutes.springboot.myfirstwebapp.repository.TodoRepository;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoControllerJpa {

    private final TodoRepository todoRepository;
    
    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername();
        List<Todo> todos = this.todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
        Todo todo = new Todo(null, username, "", LocalDate.now(), Boolean.FALSE);

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
        todo.setUsername(username);
        this.todoRepository.save(todo);
        return "redirect:list-todos";
    }
    
    @GetMapping("/delete-todo")
    public String deleteTodo(@PathParam("id") int id) {
        this.todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("/update-todo")
    public String updateTodo(@PathParam("id") int id, ModelMap model) {
        Optional<Todo> todoOpt = this.todoRepository.findById(id);

        if(todoOpt.isEmpty()) {
            return "redirect:list-todos";
        }
        
        model.addAttribute("todo", todoOpt.get());
        return "todo";

    }

    @PostMapping("/update-todo")
    public String addUpdateTodo(@Valid Todo todo, ModelMap model) {

        if(Objects.isNull(todo.getDone())) {
            todo.setDone(Boolean.FALSE);
        }

        String username = getLoggedInUsername();
        todo.setUsername(username);

        this.todoRepository.save(todo);
        return "redirect:list-todos";
    }
    
     private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
