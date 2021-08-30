package com.example.tests.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(value = "cliente")
@TypeAlias(value = "cliente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = 6823400498011328527L;

    @Id
    private String id;

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

}
