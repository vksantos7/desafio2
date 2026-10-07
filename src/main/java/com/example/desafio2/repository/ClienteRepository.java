package com.example.desafio2.repository;

import com.example.desafio2.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpf(String cpf);
    Optional<ClienteEntity> findByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}