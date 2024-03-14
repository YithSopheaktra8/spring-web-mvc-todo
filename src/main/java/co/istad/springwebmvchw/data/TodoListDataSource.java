package co.istad.springwebmvchw.data;

import co.istad.springwebmvchw.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Configuration
public class TodoListDataSource {
    public static List<Todo> todoList = new ArrayList<>();
    public TodoListDataSource(){
        todoList.add(Todo.builder().id(1).task("Learn Spring MVC").description("Learn Spring MVC").isDone(true).createdAt(LocalDate.now()).build());
        todoList.add(Todo.builder().id(2).task("Learn Spring Boot").description("Learn Spring Boot").isDone(false).createdAt(LocalDate.now()).build());
        todoList.add(Todo.builder().id(3).task("Learn Spring Data JPA").description("Learn Spring Data JPA").isDone(false).createdAt(LocalDate.now()).build());
    }
}
