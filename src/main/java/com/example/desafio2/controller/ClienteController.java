package com.example.desafio2.controller;

import com.example.desafio2.entity.ClienteEntity;
import com.example.desafio2.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> salvar(@RequestBody ClienteEntity cliente) {
        ClienteEntity novoCliente = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizar(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        ClienteEntity clienteAtualizado = service.atualizar(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok(Map.of("mensagem", "Cliente excluído com sucesso"));
    }
}