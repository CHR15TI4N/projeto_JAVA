package com.java.projeto_JAVA.controller;

import com.java.projeto_JAVA.model.Cursos;
import com.java.projeto_JAVA.model.Disciplinas;
import com.java.projeto_JAVA.service.CursosService;
import com.java.projeto_JAVA.service.DisciplinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinasController {
    @Autowired
    private DisciplinasService service;
    @GetMapping
    public ResponseEntity<List<Disciplinas>> buscarDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaDisciplinas());
    }
    @PostMapping
    public ResponseEntity<Disciplinas> gravaDisciplinas(@RequestBody Disciplinas disciplinas){
        return ResponseEntity.status(HttpStatus.OK).body(service.criaDisciplinas(disciplinas));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraDisciplina(@RequestBody Disciplinas disciplinas, @PathVariable(value = "id") Integer id){
        Optional<Disciplinas> disciplinasExiste = service.buscaId(id);
        if(disciplinasExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }

        Disciplinas newDisciplinas = disciplinasExiste.get();
        newDisciplinas.setDisciplina(disciplinas.getDisciplina());
        newDisciplinas.setNota(disciplinas.getNota());

        return ResponseEntity.status(HttpStatus.OK).body(service.criaDisciplinas(newDisciplinas));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaPorId(@PathVariable(value = "id") Integer id){
        Optional<Disciplinas> disciplinaExiste = service.buscaId(id);
        if (disciplinaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Disciplina não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.buscaId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> detelaDisciplina(@PathVariable(value = "id") Integer id){
        Optional<Disciplinas> disciplinaExiste = service.buscaId(id);
        if (disciplinaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Disciplina não encontrada!");
        }
        service.deleteDisciplinas(disciplinaExiste);

        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletado com sucesso!");
    }

}
