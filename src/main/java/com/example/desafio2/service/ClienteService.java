package com.example.desafio2.service;

import com.example.desafio2.entity.ClienteEntity;
import com.example.desafio2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity salvar(ClienteEntity cliente) {
        ClienteEntity save = clienteRepository.save(cliente);
        return save;
    }

    public List<ClienteEntity> listarTodos() {
        return clienteRepository.findAll();

    }

    public Optional<ClienteEntity> buscarPorId(Long id) {
        return  clienteRepository.findById(id);
    }
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }
}
