package com.java.projeto_JAVA.service;

import com.java.projeto_JAVA.model.Aluno;
import com.java.projeto_JAVA.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;
    public Aluno criaAluno(Aluno aluno){
        return repository.save(aluno);
    }
    public List<Aluno> buscaAlunos(){
        return repository.findAll();
    }
    public Optional<Aluno> buscaId(Integer id){
        return repository.findById(id);
    }
}
