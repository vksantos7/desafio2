package com.example.desafio2.repository;

import com.example.desafio2.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    boolean existsByNome(String nome);
}
