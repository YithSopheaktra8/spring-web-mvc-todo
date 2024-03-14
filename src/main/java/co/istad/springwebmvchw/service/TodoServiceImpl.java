package co.istad.springwebmvchw.service;

import co.istad.springwebmvchw.model.Todo;
import co.istad.springwebmvchw.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.getAllTodos();
    }

    @Override
    public Todo getTodoById(Integer id) {
        List<Todo> todoList = todoRepository.getAllTodos();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo save(Todo todo) {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
