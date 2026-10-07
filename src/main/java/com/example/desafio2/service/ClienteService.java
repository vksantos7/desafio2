package com.example.desafio2.service;

import com.example.desafio2.entity.ClienteEntity;
import com.example.desafio2.exception.ClienteException;
import com.example.desafio2.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<ClienteEntity> listarTodos() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ClienteEntity buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteException("Cliente não encontrado com o ID: " + id));
    }

    @Transactional
    public ClienteEntity salvar(ClienteEntity cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new ClienteException("Já existe um cliente cadastrado com o CPF: " + cliente.getCpf());
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new ClienteException("Já existe um cliente cadastrado com o e-mail: " + cliente.getEmail());
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public ClienteEntity atualizar(Long id, ClienteEntity clienteAtualizado) {
        ClienteEntity clienteExistente = buscarPorId(id);

        if (!clienteExistente.getCpf().equals(clienteAtualizado.getCpf())
                && clienteRepository.existsByCpf(clienteAtualizado.getCpf())) {
            throw new ClienteException("Já existe outro cliente cadastrado com o CPF fornecido.");
        }

        if (!clienteExistente.getEmail().equalsIgnoreCase(clienteAtualizado.getEmail())
                && clienteRepository.existsByEmail(clienteAtualizado.getEmail())) {
            throw new ClienteException("Já existe outro cliente cadastrado com o e-mail fornecido.");
        }

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());

        return clienteRepository.save(clienteExistente);
    }

    @Transactional
    public void deletar(Long id) {
        ClienteEntity cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}