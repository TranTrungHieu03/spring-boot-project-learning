package com.hieutt03.springboot.mydemowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<Todo>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Hieu", "Learn AWS 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Hieu", "Learn DevOps 1", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "Hieu", "Learn FullStack Dev 1", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUserName(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username)  ;
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
}
