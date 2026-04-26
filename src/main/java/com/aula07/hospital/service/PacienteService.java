package com.aula07.hospital.service;

import org.springframework.stereotype.Service;

import com.aula07.hospital.dto.PacienteRequestDTO;
import com.aula07.hospital.dto.PacienteResponseDTO;
import com.aula07.hospital.model.Paciente;
import com.aula07.hospital.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    private Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setEmail(dto.getEmail());
        return paciente;
    }

    private PacienteResponseDTO toDTO(Paciente paciente) {
        return PacienteResponseDTO.builder()
                .nome(paciente.getNome())
                .email(paciente.getEmail())
                .build();
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {

        Paciente paciente = toEntity(dto);

        Paciente salvo = repository.save(paciente);

        return toDTO(salvo);
    }
}