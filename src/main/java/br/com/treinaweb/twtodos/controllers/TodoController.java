package br.com.treinaweb.twtodos.controllers;

import br.com.treinaweb.twtodos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
