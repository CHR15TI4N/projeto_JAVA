package com.java.projeto_JAVA.controller;

import com.java.projeto_JAVA.model.Aluno;
import com.java.projeto_JAVA.model.Cursos;
import com.java.projeto_JAVA.model.Disciplinas;
import com.java.projeto_JAVA.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService service;
    @GetMapping
    public ResponseEntity<List<Aluno>> buscarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaAlunos());
    }
    @PostMapping
    public ResponseEntity<Object> gravaAluno(@RequestBody Aluno aluno){
        if (!aluno.getCursos().isEmpty()) {
            for (Cursos cursos : aluno.getCursos()) {
                cursos.setAluno(aluno);

                List<Disciplinas> disciplinas = cursos.getDisciplinas();
                if (!disciplinas.isEmpty()) {
                    for (Disciplinas disciplina : disciplinas) {
                        BigDecimal nota = disciplina.getNota();
                        if(nota != null) {
                            if (nota.compareTo(BigDecimal.ZERO) < 0) {
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A nota (" + nota + ") é inválida, ela é menor que 0!");
                            } else if (nota.compareTo(new BigDecimal(10)) > 0) {
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A nota (" + nota + ") é invalida, ela é maior que 10!");
                            }
                        }
                        disciplina.setCursos(cursos);
                    }
                }
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.criaAluno(aluno));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraAluno(@RequestBody Aluno aluno, @PathVariable(value = "id") Integer id){
        Optional<Aluno> alunoExiste = service.buscaId(id);
        if(alunoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }

        Aluno newAluno = alunoExiste.get();
        newAluno.setNome(aluno.getNome());
        newAluno.setCpf(aluno.getCpf());
        newAluno.setDtNascimento(aluno.getDtNascimento());

        return ResponseEntity.status(HttpStatus.OK).body(service.criaAluno(newAluno));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaPorId(@PathVariable(value = "id") Integer id){
        Optional<Aluno> alunoExiste = service.buscaId(id);
        if (alunoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Aluno não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.buscaId(id));
    }
}
