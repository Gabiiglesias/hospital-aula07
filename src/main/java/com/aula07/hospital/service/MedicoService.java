package com.aula07.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aula07.hospital.model.Medico;
import com.aula07.hospital.repository.MedicoRepository;

@Service
public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico salvar(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Medico atualizar(Long id, Medico medico) {
        Medico existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNome(medico.getNome());
            existente.setEspecialidade(medico.getEspecialidade());
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