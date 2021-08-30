package com.example.tests.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String id;

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

}
