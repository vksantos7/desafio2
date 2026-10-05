package com.example.desafio2.repository;

import com.example.desafio2.entity.Carros;
import com.example.desafio2.entity.Motos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotosRepository extends JpaRepository<Motos, Long> {
    Carros findByMarca(Long marca);
    boolean existsByMarca(String marca);
    boolean existsById(Long id);
}
