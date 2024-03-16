package co.istad.springwebmvchw.controller;

import co.istad.springwebmvchw.model.Todo;
import co.istad.springwebmvchw.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo")
    public String getAllTodos(Model model){
        model.addAttribute("todos", todoService.findAllTodos());
        model.addAttribute("newTodo", new Todo());
        return "index";
    }

    @GetMapping("/todo/{id}")
    public String getTodoById(Model model, @PathVariable("id") Integer id){
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }
    @GetMapping("/todo/search")
    public String searchTodoByTask(Model model, @RequestParam(value = "task", required = false) String task, @RequestParam(value = "isDone", required = false) Boolean isDone){
        List<Todo> todos;
        if(task != null && !task.isEmpty()) {
            todos = todoService.searchByTask(task);
        } else {
            todos = todoService.findAllTodos();
        }
        // Filter todos by isDone if the checkbox is checked
        // Filter todos by isDone
        if(isDone == null) {
            isDone = false; // Set a default value if isDone is null
        }
        Boolean finalIsDone = isDone;
        todos = todos.stream().filter(todo -> todo.isDone() == finalIsDone).collect(Collectors.toList());
        model.addAttribute("todos",todos);
        return "result";
    }
    @GetMapping("/todo/new")
    public String newTodo(@ModelAttribute("newTodo") Todo todo){
        todoService.save(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/markDone")
    public String markTodoAsDone(@RequestParam("id") Integer id) {
        todoService.markAsDone(id);
        return "redirect:/todo";
    }

    @GetMapping("/todo/delete")
    public String deleteTodoById(@RequestParam("id") Integer id) {
        todoService.delete(id);
        return "redirect:/todo";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model) {
        Todo foundTodo = todoService.getTodoById(id);
        model.addAttribute("todo", foundTodo);
        return "update";
    }

    @GetMapping("/update")
    public String updateProduct(@ModelAttribute("todo") Todo todo) {
        todoService.update(todo);
        return "redirect:/todo";
    }

}
