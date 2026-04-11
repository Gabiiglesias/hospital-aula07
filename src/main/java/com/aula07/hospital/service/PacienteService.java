package com.aula07.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aula07.hospital.model.Paciente;
import com.aula07.hospital.repository.PacienteRepository;

@Service
public class PacienteService {

    private PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        Paciente existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNome(paciente.getNome());
            return repository.save(existente);
        }

        return null;
    }

    public boolean deletar(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}