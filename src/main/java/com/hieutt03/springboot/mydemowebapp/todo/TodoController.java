package com.hieutt03.springboot.mydemowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    protected TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    // list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName(getLoggedInUserName(model));
        model.put("todos", todos);
        return "listTodos";
    }

    private static String getLoggedInUserName(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewToDoPage(ModelMap model) {
        Todo todo = new Todo(0, getLoggedInUserName(model), "Default Desc", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }

//    @RequestMapping(value = "addtodo", method = RequestMethod.POST)
//    public String addNewTodo(@RequestParam String description, ModelMap model) {
//        todoService.addTodo((String) model.get("name"), description, LocalDate.now().plusYears(1), false);
//        return "redirect:list-todos";
//    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        todoService.addTodo(getLoggedInUserName(model), todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        todo.setUsername(getLoggedInUserName(model));
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }


}
