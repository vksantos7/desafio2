package com.example.desafio2.repository;

import com.example.desafio2.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<ClienteEntity, Long> {
}
