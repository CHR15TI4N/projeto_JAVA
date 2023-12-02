package com.java.projeto_JAVA.repository;

import com.java.projeto_JAVA.model.Disciplinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinasRepository extends JpaRepository<Disciplinas, Integer> {
}