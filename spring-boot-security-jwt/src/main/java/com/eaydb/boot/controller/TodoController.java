package com.eaydb.boot.controller;

import com.eaydb.boot.entity.Todo;
import com.eaydb.boot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:54 PM
 * <p/>
 * @DESCRIPTION
 **/
@RestController
@RequestMapping("/todos")
@PreAuthorize("hasRole('USER')")
public class TodoController {

    private TodoService service;

    @Autowired
    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping()
    public List<Todo> getAllTodos(@RequestHeader(value = "username") String username) {
        return service.findAll(username);
    }

    @PostMapping()
    Todo addTodo(Todo addedTodo) {
        return service.addTodo(addedTodo);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    Todo updateTodo(@PathVariable String id, Todo updatedTodo) {
        updatedTodo.setId(id);
        return service.update(updatedTodo);
    }

    @DeleteMapping( "/{id}")
    Todo removeTodo(@PathVariable String id) {
        return service.deleteTodo(id);
    }
}