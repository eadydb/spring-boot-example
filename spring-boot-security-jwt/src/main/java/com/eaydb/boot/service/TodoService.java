package com.eaydb.boot.service;

import com.eaydb.boot.entity.Todo;

import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:52 PM
 * <p/>
 * @DESCRIPTION
 **/
public interface TodoService {

    Todo addTodo(Todo todo);

    Todo deleteTodo(String id);

    List<Todo> findAll(String username);

    Todo findById(String id);

    Todo update(Todo todo);
}
