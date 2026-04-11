package com.aula07.hospital.controller;

import com.aula07.hospital.model.Receita;
import com.aula07.hospital.service.ReceitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public Receita salvar(@RequestBody Receita receita) {
        return service.salvar(receita);
    }

    @GetMapping
    public List<Receita> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Receita buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita receita) {
        return service.atualizar(id, receita);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}