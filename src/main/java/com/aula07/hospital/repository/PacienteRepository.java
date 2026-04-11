package com.aula07.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula07.hospital.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}