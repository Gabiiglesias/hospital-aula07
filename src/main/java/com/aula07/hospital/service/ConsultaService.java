package com.aula07.hospital.service;

import com.aula07.hospital.model.Consulta;
import com.aula07.hospital.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public List<Consulta> listarTodos() {
        return repository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Consulta atualizar(Long id, Consulta consulta) {
        Consulta existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setDescricao(consulta.getDescricao());
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