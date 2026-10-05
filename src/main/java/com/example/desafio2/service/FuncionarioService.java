package com.example.desafio2.service;

import com.example.desafio2.entity.Funcionario;
import com.example.desafio2.exception.FuncionarioException;
import com.example.desafio2.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    FuncionarioRepository funcionarioRepository;

    FuncionarioService( FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository=funcionarioRepository;
    }

        public Funcionario salvar(Funcionario funcionario){
            if (funcionarioRepository.existsByNome(funcionario.getNome())){
                throw  new FuncionarioException("Funcionario já existe");
            }
               return funcionarioRepository.save(funcionario);

        }

        public Funcionario atualizar(Long id, Funcionario funcionario){
            if (!funcionarioRepository.existsByNome(funcionario.getNome())){
                throw  new FuncionarioException("Funcionario não existe");
            }
            funcionario.setId(id);

            return funcionarioRepository.save(funcionario);
        }

        public List<Funcionario> todos(){
        return funcionarioRepository.findAll();
        }
        public Funcionario buscarPorId(Long id){

        return funcionarioRepository.findById(id).orElseThrow(
                ()-> new FuncionarioException("Funcionario não existe")
        );
        }

        public void deletar(Long id){
            if (!funcionarioRepository.existsById(id)){
                throw  new FuncionarioException("Funcionario não existe");
            }
            funcionarioRepository.deleteById(id);
        }
}
