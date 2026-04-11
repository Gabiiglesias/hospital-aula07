package com.aula07.hospital.repository;

import com.aula07.hospital.model.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
}