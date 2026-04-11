package com.aula07.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula07.hospital.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}