package com.aula07.hospital.controller;

import com.aula07.hospital.dto.PacienteRequestDTO;
import com.aula07.hospital.dto.PacienteResponseDTO;
import com.aula07.hospital.service.PacienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public PacienteResponseDTO salvar(@RequestBody PacienteRequestDTO dto) {
        return service.salvar(dto);
    }
}