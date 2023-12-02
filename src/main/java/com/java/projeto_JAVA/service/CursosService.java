package com.java.projeto_JAVA.service;

import com.java.projeto_JAVA.model.Aluno;
import com.java.projeto_JAVA.model.Cursos;
import com.java.projeto_JAVA.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {
    @Autowired
    private CursosRepository repository;
    public Cursos criaCursos(Cursos curso){
        return repository.save(curso);
    }
    public List<Cursos> buscaCursos(){
        return repository.findAll();
    }
    public Optional<Cursos> buscaId(Integer id){
        return repository.findById(id);
    }
    public void deleteCursos(Optional<Cursos> cursos){
        repository.delete(cursos.get());
    }
}
