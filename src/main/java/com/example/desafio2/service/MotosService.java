package com.example.desafio2.service;

import com.example.desafio2.entity.Carros;
import com.example.desafio2.entity.Motos;
import com.example.desafio2.exception.MotosException;
import com.example.desafio2.repository.MotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotosService {
        @Autowired
        MotosRepository motosRepository;

        public Motos salvar(Motos motos) {
            if (motosRepository.existsByMarca(motos.getMarca())) {
                throw new MotosException("Moto ja existente");
            }
            return motosRepository.save(motos);
        }

        public Motos atualizar(Motos motos, Long id) {
            if (!motosRepository.existsById(id)) {
                throw new MotosException("moto nao encontrado");
            }
            motos.setId(id);
            return motosRepository.save(motos);
        }

        public List<Motos> listarTodos() {
            List<Motos> motos = motosRepository.findAll();
            if (motos.isEmpty()) {
                throw new MotosException("Nenhum moto encontrado");
            }
            return motos;
        }

        public Motos buscarPorMarca(Long marca) {
            Motos motos = motosRepository.findByMarca(marca);
            if (motos == null) {
                throw new MotosException("motos nao encontrado");
            }
            return motos;
        }

        public void deletar(Long id){
            Motos motos = motosRepository.findById(id)
                    .orElseThrow(() -> new MotosException("moto nao encontrado"));
            motosRepository.delete(motos);
        }
}
