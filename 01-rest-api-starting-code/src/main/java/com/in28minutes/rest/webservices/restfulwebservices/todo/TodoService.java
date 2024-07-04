package com.in28minutes.rest.webservices.restfulwebservices.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(getTodoCount(), "estael","Get AWS Certified", 
							LocalDate.now().plusYears(10), false ));
		todos.add(new Todo(getTodoCount(), "estael","Learn DevOps", 
				LocalDate.now().plusYears(11), false ));
		todos.add(new Todo(getTodoCount(), "in28minutes","Learn Full Stack Development", 
				LocalDate.now().plusYears(12), false ));
	}
	
	public List<Todo> findByUsername(String username){
		return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
	}
	
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(getTodoCount(), username, description, targetDate, done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(String username, int id) {
		todos.removeIf(todo -> (todo.getUsername().equalsIgnoreCase(username) && todo.getId() == id));
	}
	
	public Todo findById(String username, int id) {
		List<Todo> todoList = findByUsername(username);
		Optional<Todo> todoOpt = todoList.stream().filter(todo -> todo.getId() == id).findFirst();
		return todoOpt.orElse(null);
	}

	public Todo updateTodo(String username, int id, Todo todo) {
		deleteById(username, id);
		todo.setId(id);
		todo.setUsername(username);
		todos.add(todo);
		return todo;
	}

	public Todo createTodo(Todo todo) {

		if(Objects.nonNull(todo.getId())) {
			return null;
		}

		todo.setId(todosCount);
		todos.add(todo);
		return todo;
	}

	private static int getTodoCount() {
		return ++todosCount;
	}

}
