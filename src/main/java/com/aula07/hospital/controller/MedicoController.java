package com.aula07.hospital.controller;

import com.aula07.hospital.model.Medico;
import com.aula07.hospital.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public Medico salvar(@RequestBody Medico medico) {
        return service.salvar(medico);
    }

    @GetMapping
    public List<Medico> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody Medico medico) {
        return service.atualizar(id, medico);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}