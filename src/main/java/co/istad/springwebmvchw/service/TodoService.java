package co.istad.springwebmvchw.service;

import co.istad.springwebmvchw.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAllTodos();
    Todo getTodoById(Integer id);
    Todo save(Todo todo);
    Todo update(Todo todo);
    void delete(Integer id);
}
