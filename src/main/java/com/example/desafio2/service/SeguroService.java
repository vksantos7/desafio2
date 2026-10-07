package com.example.desafio2.service;

import com.example.desafio2.entity.SeguroEntity;
import com.example.desafio2.exception.SegurosException;
import com.example.desafio2.repository.SeguroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeguroService {

    private final SeguroRepository repository;

    public SeguroService(SeguroRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<SeguroEntity> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public SeguroEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SegurosException("Seguro não encontrado com o ID: " + id));
    }

    @Transactional
    public SeguroEntity salvar(SeguroEntity seguro) {
        if (repository.existsByNumeroApolice(seguro.getNumeroApolice())) {
            throw new SegurosException("Já existe um seguro cadastrado com a apólice: " + seguro.getNumeroApolice());
        }
        return repository.save(seguro);
    }

    @Transactional
    public SeguroEntity atualizar(Long id, SeguroEntity seguroAtualizado) {
        SeguroEntity seguroExistente = buscarPorId(id);

        if (!seguroExistente.getNumeroApolice().equals(seguroAtualizado.getNumeroApolice())
                && repository.existsByNumeroApolice(seguroAtualizado.getNumeroApolice())) {
            throw new SegurosException("Já existe um seguro cadastrado com a apólice fornecida.");
        }

        seguroExistente.setNumeroApolice(seguroAtualizado.getNumeroApolice());
        seguroExistente.setTipo(seguroAtualizado.getTipo());
        seguroExistente.setValorPremio(seguroAtualizado.getValorPremio());
        seguroExistente.setDataInicio(seguroAtualizado.getDataInicio());
        seguroExistente.setDataFim(seguroAtualizado.getDataFim());
        seguroExistente.setStatus(seguroAtualizado.getStatus());

        return repository.save(seguroExistente);
    }

    @Transactional
    public void excluir(Long id) {
        SeguroEntity seguro = buscarPorId(id);
        repository.delete(seguro);
    }
}