package com.java.projeto_JAVA.service;

import com.java.projeto_JAVA.model.Cursos;
import com.java.projeto_JAVA.model.Disciplinas;
import com.java.projeto_JAVA.repository.CursosRepository;
import com.java.projeto_JAVA.repository.DisciplinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinasService {
    @Autowired
    private DisciplinasRepository repository;
    public Disciplinas criaDisciplinas(Disciplinas disciplinas){
        return repository.save(disciplinas);
    }
    public List<Disciplinas> buscaDisciplinas(){
        return repository.findAll();
    }
    public Optional<Disciplinas> buscaId(Integer id){
        return repository.findById(id);
    }
    public void deleteDisciplinas(Optional<Disciplinas> disciplinas){
        repository.delete(disciplinas.get());
    }

}
