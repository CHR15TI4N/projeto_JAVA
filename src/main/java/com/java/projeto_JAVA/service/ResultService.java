package com.java.projeto_JAVA.service;

import com.java.projeto_JAVA.model.Aluno;
import com.java.projeto_JAVA.model.Cursos;
import com.java.projeto_JAVA.model.Disciplinas;
import com.java.projeto_JAVA.model.Result;
import com.java.projeto_JAVA.repository.AlunoRepository;
import com.java.projeto_JAVA.repository.CursosRepository;
import com.java.projeto_JAVA.repository.DisciplinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private AlunoRepository aRepository;
    private CursosRepository cRepository;
    private DisciplinasRepository dRepository;

    public List<Result> countResult(){
        List<Aluno> alunos = aRepository.findAll();
        List<Result> results = new ArrayList<>();

        for (Aluno aluno : alunos){
            for (Cursos cursos : aluno.getCursos()){
                for (Disciplinas disciplinas : cursos.getDisciplinas()){
                    Result result = new Result();
                    result.setAlunoId(aluno.getIdAluno());
                    result.setAlunoN(aluno.getNome());
                    result.setCursoN(cursos.getCurso());
                    result.setDisciplinaN(disciplinas.getDisciplina());
                    result.setNota(disciplinas.getNota());

                    if(result.getNota()!=null) {
                        if(result.getNota().compareTo(new BigDecimal(0)) < 0){
                            result.setSituacao("Nota é invalida, menor que 0!");
                        }else if(result.getNota().compareTo(new BigDecimal(10)) > 0) {
                            result.setSituacao("Nota é invalida, maior que 10!");
                        }else if(result.getNota().compareTo(new BigDecimal(7)) >= 0){
                            result.setSituacao("Aluno aprovado!");
                        }else if(result.getNota().compareTo(new BigDecimal(4)) >= 0){
                            result.setSituacao("Aluno esta de exame!");
                        }else{
                            result.setSituacao("Aluno REPROVADO!!");
                        }
                    }else{
                        result.setSituacao("Em andamento!");
                    }

                    results.add(result);
                }
            }
        }
        return results;
    }

    public List<Result> countResultId(Integer id){
        List<Result> results = countResult();
        List<Result> resultsAluno = new ArrayList<>();

        for (Result result : results){
            if(result.getAlunoId().equals(id)){
                resultsAluno.add(result);
            }
        }

        return resultsAluno;
    }
}
