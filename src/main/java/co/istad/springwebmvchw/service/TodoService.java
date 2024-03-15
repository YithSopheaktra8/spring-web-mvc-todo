package co.istad.springwebmvchw.service;

import co.istad.springwebmvchw.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAllTodos();
    Todo getTodoById(Integer id);
    void save(Todo todo);
    void update(Todo todo);
    void delete(Integer id);
    void markAsDone(Integer id);
    List<Todo> searchByTask(String task);
}
