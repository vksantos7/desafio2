package com.example.desafio2.repository;

import com.example.desafio2.entity.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long> {
    Carros findByMarca(Long marca);
    boolean existsByMarca(String marca);
    boolean existsById(Long id);
}
