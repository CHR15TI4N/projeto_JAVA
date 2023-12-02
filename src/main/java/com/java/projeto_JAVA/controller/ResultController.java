package com.java.projeto_JAVA.controller;

import com.java.projeto_JAVA.model.Result;
import com.java.projeto_JAVA.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {
    @Autowired
    private ResultService service;
    @GetMapping
    public List<Result> mostraNota(){
        return service.countResult();
    }
    @GetMapping("/{id}")
    public List<Result> mostraNotaId(@PathVariable(value = "id") Integer id){
        return service.countResultId(id);
    }
}
