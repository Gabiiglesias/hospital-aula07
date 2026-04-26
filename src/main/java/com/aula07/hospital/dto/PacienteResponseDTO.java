package com.aula07.hospital.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteResponseDTO {

    private String nome;
    private String email;
}