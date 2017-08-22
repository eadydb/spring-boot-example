package com.eaydb.boot.service.impl;

import com.eaydb.boot.entity.Todo;
import com.eaydb.boot.repository.TodoRepository;
import com.eaydb.boot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:53 PM
 * <p/>
 * @DESCRIPTION
 **/
@Service
public class TodoServiceImpl  implements TodoService {

    private final TodoRepository repository;

    @Autowired
    TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return repository.insert(todo);
    }

    @Override
    public Todo deleteTodo(String id) {
        Todo deletedTodo = repository.findOne(id);
        repository.delete(id);
        return deletedTodo;
    }

    @Override
    public List<Todo> findAll(String username) {
        return repository.findByUserUsername(username);
    }

    @Override
    public Todo findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public Todo update(Todo todo) {
        repository.save(todo);
        return todo;
    }
}
