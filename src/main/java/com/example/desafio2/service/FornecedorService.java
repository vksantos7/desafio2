package com.example.desafio2.service;

import com.example.desafio2.entity.Fornecedor;
import com.example.desafio2.exception.FornecedorException;
import com.example.desafio2.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    FornecedorRepository fornecedorRepository;

    FornecedorService(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository=fornecedorRepository;
    }

        public Fornecedor salvar(Fornecedor fornecedor){
            if (fornecedorRepository.existsByCnpj(fornecedor.getCnpj())){
                throw  new FornecedorException("Fornecedor já existe");
            }
               return fornecedorRepository.save(fornecedor);

        }

        public Fornecedor atualizar(Long id, Fornecedor fornecedor){
            if (!fornecedorRepository.existsByCnpj(fornecedor.getCnpj())){
                throw  new FornecedorException("Fornecedor não existe");
            }
            fornecedor.setId(id);

            return fornecedorRepository.save(fornecedor);
        }

        public List<Fornecedor> todos(){
        return fornecedorRepository.findAll();
        }
        public Fornecedor buscarPorId(Long id){

        return fornecedorRepository.findById(id).orElseThrow(
                ()-> new FornecedorException("Fornecedor não existe")
        );
        }

        public void deletar(Long id){
            if (!fornecedorRepository.existsById(id)){
                throw  new FornecedorException("Fornecedor não existe");
            }
            fornecedorRepository.deleteById(id);
        }
}
