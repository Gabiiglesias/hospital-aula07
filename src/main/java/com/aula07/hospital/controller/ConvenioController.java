package com.aula07.hospital.controller;

import com.aula07.hospital.model.Convenio;
import com.aula07.hospital.service.ConvenioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    private ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    @PostMapping
    public Convenio salvar(@RequestBody Convenio convenio) {
        return service.salvar(convenio);
    }

    @GetMapping
    public List<Convenio> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Convenio buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Convenio atualizar(@PathVariable Long id, @RequestBody Convenio convenio) {
        return service.atualizar(id, convenio);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}