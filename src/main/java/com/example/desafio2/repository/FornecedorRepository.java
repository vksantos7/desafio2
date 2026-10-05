package com.example.desafio2.repository;

import com.example.desafio2.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {
    boolean existsByCnpj(String Cnpj);
}
