package co.istad.springwebmvchw.service;

import co.istad.springwebmvchw.model.Todo;
import co.istad.springwebmvchw.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public void save(Todo todo) {
        Todo lastTodo = todoRepository.getAllTodos().get(todoRepository.getAllTodos().size() - 1);
        todo.setId(lastTodo.getId() + 1);
        todo.setCreatedAt(LocalDate.now());
        todoRepository.getAllTodos().add(todo);
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void markAsDone(Integer id) {
        List<Todo> todoList = todoRepository.getAllTodos();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setDone(true);
            }
        }
    }
}
