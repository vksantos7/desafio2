package com.example.desafio2.service;

import com.example.desafio2.entity.Carros;
import com.example.desafio2.exception.CarrosException;
import com.example.desafio2.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrosService {
    @Autowired
    CarrosRepository carrosRepository;

    public Carros salvar(Carros carros) {
        if (carrosRepository.existsByMarca(carros.getMarca())) {
            throw new CarrosException("Carro ja existente");
        }
        return carrosRepository.save(carros);
    }

    public Carros atualizar(Carros carros, Long id) {
        if (!carrosRepository.existsById(id)) {
            throw new CarrosException("Carro nao encontrado");
        }
        carros.setId(id);
        return carrosRepository.save(carros);
    }

    public List<Carros> listarTodos() {
        List<Carros> carros = carrosRepository.findAll();
        if (carros.isEmpty()) {
            throw new CarrosException("Nenhum carro encontrado");
        }
        return carros;
    }

    public Carros buscarPorMarca(Long marca) {
        Carros carros = carrosRepository.findByMarca(marca);
        if (carros == null) {
            throw new CarrosException("Carro nao encontrado");
        }
        return carros;
    }

    public void deletar(Long id){
        Carros carros = carrosRepository.findById(id)
                .orElseThrow(() -> new CarrosException("Carro nao encontrado"));
        carrosRepository.delete(carros);
    }
}
