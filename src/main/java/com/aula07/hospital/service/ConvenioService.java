package com.aula07.hospital.service;

import com.aula07.hospital.model.Convenio;
import com.aula07.hospital.repository.ConvenioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioService {

    private ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    public Convenio salvar(Convenio convenio) {
        return repository.save(convenio);
    }

    public List<Convenio> listarTodos() {
        return repository.findAll();
    }

    public Convenio buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Convenio atualizar(Long id, Convenio convenio) {
        Convenio existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNome(convenio.getNome());
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