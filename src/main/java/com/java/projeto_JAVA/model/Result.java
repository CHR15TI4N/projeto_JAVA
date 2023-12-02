package com.java.projeto_JAVA.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Result implements Serializable {
    private Integer alunoId;
    private String cursoN;
    private String alunoN;
    private String disciplinaN;
    private BigDecimal nota;
    private String situacao;

    public Result() {
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public String getCursoN() {
        return cursoN;
    }

    public void setCursoN(String cursoN) {
        this.cursoN = cursoN;
    }

    public String getAlunoN() {
        return alunoN;
    }

    public void setAlunoN(String alunoN) {
        this.alunoN = alunoN;
    }

    public String getDisciplinaN() {
        return disciplinaN;
    }

    public void setDisciplinaN(String disciplinaN) {
        this.disciplinaN = disciplinaN;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
