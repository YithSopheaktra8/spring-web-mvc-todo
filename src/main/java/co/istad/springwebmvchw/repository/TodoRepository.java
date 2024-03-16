package co.istad.springwebmvchw.repository;

import co.istad.springwebmvchw.data.TodoListDataSource;
import co.istad.springwebmvchw.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    public List<Todo> getAllTodos(){
        return TodoListDataSource.todoList;
    }
}
