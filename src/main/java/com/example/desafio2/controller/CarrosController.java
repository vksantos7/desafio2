package com.example.desafio2.controller;


import com.example.desafio2.entity.Carros;
import com.example.desafio2.service.CarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class CarrosController {
    @Autowired
    CarrosService carrosService;

    @PostMapping("/salvar")
    public ResponseEntity<Carros> salvar(@RequestBody Carros carros) {
        return ResponseEntity.ok().body(carrosService.salvar(carros));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Carros> atualizar(@RequestBody Carros carros, @PathVariable Long id) {
        return ResponseEntity.ok().body(carrosService.atualizar(carros, id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Carros>> todos() {
        return ResponseEntity.ok(carrosService.listarTodos());
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<Carros> buscarPorMarca(@PathVariable Long marca) {
        return ResponseEntity.ok(carrosService.buscarPorMarca(marca));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        carrosService.deletar(id);
    }
}
