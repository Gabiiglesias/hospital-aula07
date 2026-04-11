package com.aula07.hospital.service;

import com.aula07.hospital.model.Receita;
import com.aula07.hospital.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    public Receita salvar(Receita receita) {
        return repository.save(receita);
    }

    public List<Receita> listarTodos() {
        return repository.findAll();
    }

    public Receita buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Receita atualizar(Long id, Receita receita) {
        Receita existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setDescricao(receita.getDescricao());
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