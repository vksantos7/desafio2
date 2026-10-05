package com.example.desafio2.service;

import com.example.desafio2.entity.Carros;
import com.example.desafio2.exception.CarrosException;
import com.example.desafio2.repository.MotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotosService {
        @Autowired
        MotosRepository motosRepository;

        public Carros salvar(Carros carros) {
            if (motosRepository.existsByMarca(carros.getMarca())) {
                throw new CarrosException("Carro ja existente");
            }
            return motosRepository.save(carros);
        }

        public Carros atualizar(Carros carros, Long id) {
            if (!motosRepository.existsById(id)) {
                throw new CarrosException("Carro nao encontrado");
            }
            carros.setId(id);
            return motosRepository.save(carros);
        }

        public List<Carros> listarTodos() {
            List<Carros> carros = motosRepository.findAll();
            if (carros.isEmpty()) {
                throw new CarrosException("Nenhum carro encontrado");
            }
            return carros;
        }

        public Carros buscarPorMarca(Long marca) {
            Carros carros = motosRepository.findByMarca(marca);
            if (carros == null) {
                throw new CarrosException("Carro nao encontrado");
            }
            return carros;
        }

        public void deletar(Long id){
            Carros carros = motosRepository.findById(id)
                    .orElseThrow(() -> new CarrosException("Carro nao encontrado"));
            motosRepository.delete(carros);
        }
}
