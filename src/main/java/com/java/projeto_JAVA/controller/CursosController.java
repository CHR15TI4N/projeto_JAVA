package com.java.projeto_JAVA.controller;

import com.java.projeto_JAVA.model.Aluno;
import com.java.projeto_JAVA.model.Cursos;
import com.java.projeto_JAVA.model.Disciplinas;
import com.java.projeto_JAVA.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursosController {
    @Autowired
    private CursosService service;
    @GetMapping
    public ResponseEntity<List<Cursos>> buscarCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaCursos());
    }
    @PostMapping
    public ResponseEntity<Cursos> gravaCursos(@RequestBody Cursos cursos){
        return ResponseEntity.status(HttpStatus.OK).body(service.criaCursos(cursos));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaPorId(@PathVariable(value = "id") Integer id){
        Optional<Cursos> cursoExiste = service.buscaId(id);
        if (cursoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Curso não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.buscaId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> detelaCurso(@PathVariable(value = "id") Integer id){
        Optional<Cursos> cursoExiste = service.buscaId(id);
        if (cursoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Curso não encontrado!");
        }
        service.deleteCursos(cursoExiste);

        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
    }

}
