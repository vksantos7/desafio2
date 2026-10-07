package com.example.desafio2.controller;

import com.example.desafio2.entity.SeguroEntity;
import com.example.desafio2.service.SeguroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    private final SeguroService service;

    public SeguroController(SeguroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SeguroEntity>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguroEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SeguroEntity> salvar(@RequestBody SeguroEntity seguro) {
        SeguroEntity novoSeguro = service.salvar(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSeguro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguroEntity> atualizar(@PathVariable Long id, @RequestBody SeguroEntity seguro) {
        SeguroEntity seguroAtualizado = service.atualizar(id, seguro);
        return ResponseEntity.ok(seguroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok(Map.of("mensagem", "Seguro excluído com sucesso"));
    }
}