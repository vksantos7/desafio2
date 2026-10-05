package com.example.desafio2.controller;

import com.example.desafio2.entity.Fornecedor;
import com.example.desafio2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fornecedors")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> porId(@PathVariable Long id){
      return ResponseEntity.ok(fornecedorService.buscarPorId(id));
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Fornecedor>> todos(){
      return ResponseEntity.ok(fornecedorService.todos());
    }

    @PostMapping("/criar")
    public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor){
        return ResponseEntity.ok(fornecedorService.salvar(fornecedor));
    }


    @PutMapping("/atualizar/{id}")
        public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id,@RequestBody Fornecedor fornecedor){

        return ResponseEntity.ok(fornecedorService.atualizar(id,fornecedor));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
       fornecedorService.deletar(id);
    }



}
