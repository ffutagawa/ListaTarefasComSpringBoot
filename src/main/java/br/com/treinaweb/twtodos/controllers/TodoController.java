package br.com.treinaweb.twtodos.controllers;

import br.com.treinaweb.twtodos.models.Todo;
import br.com.treinaweb.twtodos.repositories.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TodoController {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ModelAndView list() {
        var modelAndView = new ModelAndView("todo/list");
        modelAndView.addObject("todos", todoRepository.findAll());
        return modelAndView;

//     outra maneira desta maneira abaixo
//        return new ModelAndView("todo/list", Map.of("todos", todoRepository.findAll()));
    }
    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("todo/form", Map.of("todo", new Todo()));
    }

    @PostMapping("/create")
    public String create(@Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo/form";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        var todo = todoRepository.findById(id);
        if(todo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("todo/form", Map.of("todo", todo.get()));
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid @PathVariable Long id, Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo/form";
        }
//        todo.setId(id);
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable Long id){
        var todo = todoRepository.findById(id);
        if(todo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("todo/delete", Map.of("todo", todo.get()));
    }

    @PostMapping("/delete/{id}")
    public String delete(Todo todo){
        todoRepository.delete(todo);
        return "redirect:/";
    }

}



