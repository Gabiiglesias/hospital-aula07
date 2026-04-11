package com.aula07.hospital.service;

import com.aula07.hospital.model.Prontuario;
import com.aula07.hospital.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {

    private ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public Prontuario salvar(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public List<Prontuario> listarTodos() {
        return repository.findAll();
    }

    public Prontuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Prontuario atualizar(Long id, Prontuario prontuario) {
        Prontuario existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setDescricao(prontuario.getDescricao());
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