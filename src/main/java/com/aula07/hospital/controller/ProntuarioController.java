package com.aula07.hospital.controller;

import com.aula07.hospital.model.Prontuario;
import com.aula07.hospital.service.ProntuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {

    private ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @GetMapping
    public List<Prontuario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Prontuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return service.atualizar(id, prontuario);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}