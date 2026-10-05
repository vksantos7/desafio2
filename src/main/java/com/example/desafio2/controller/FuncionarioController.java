package com.example.desafio2.controller;

import com.example.desafio2.entity.Funcionario;
import com.example.desafio2.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> porId(@PathVariable Long id){
      return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Funcionario>> todos(){
      return ResponseEntity.ok(funcionarioService.todos());
    }

    @PostMapping("/criar")
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.salvar(funcionario));
    }


    @PutMapping("/atualizar/{id}")
        public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,@RequestBody Funcionario funcionario){

        return ResponseEntity.ok(funcionarioService.atualizar(id,funcionario));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
       funcionarioService.deletar(id);
    }



}
