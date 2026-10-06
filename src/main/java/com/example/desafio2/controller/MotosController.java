package com.example.desafio2.controller;

import com.example.desafio2.entity.Motos;
import com.example.desafio2.service.MotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("motos")
public class MotosController {
        @Autowired
        MotosService motosService;

        @PostMapping("/salvar")
        public ResponseEntity<Motos> salvar(@RequestBody Motos motos) {
            return ResponseEntity.ok().body(motosService.salvar(motos));
        }

        @PutMapping("/atualizar/{id}")
        public ResponseEntity<Motos> atualizar(@RequestBody Motos motos, @PathVariable Long id) {
            return ResponseEntity.ok().body(motosService.atualizar(motos, id));
        }

        @GetMapping("/")
        public ResponseEntity<List<Motos>> todos() {
            return ResponseEntity.ok(motosService.listarTodos());
        }

        @GetMapping("/marca/{marca}")
        public ResponseEntity<Motos> buscarPorMarca(@PathVariable Long marca) {
            return ResponseEntity.ok(motosService.buscarPorMarca(marca));
        }

        @DeleteMapping("/deletar/{id}")
        public void deletar(@PathVariable Long id) {
            motosService.deletar(id);
        }
}
