package com.example.desafio2.repository;

import com.example.desafio2.entity.SeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {
    Optional<SeguroEntity> findByNumeroApolice(String numeroApolice);
    boolean existsByNumeroApolice(String numeroApolice);
}