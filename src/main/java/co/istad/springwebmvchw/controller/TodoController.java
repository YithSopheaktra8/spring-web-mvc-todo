package co.istad.springwebmvchw.controller;

import co.istad.springwebmvchw.model.Todo;
import co.istad.springwebmvchw.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String searchTodoByTask(Model model, @RequestParam("task") String task){
        System.out.println(task);
        List<Todo> todo = todoService.searchByTask(task);
        System.out.println(todo);
        model.addAttribute("todos",todo);
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

}
