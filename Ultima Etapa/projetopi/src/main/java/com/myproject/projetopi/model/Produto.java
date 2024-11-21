package com.myproject.projetopi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(max = 100, message = "O nome do produto deve ter no máximo 100 caracteres")
    private String nome;

    @Size(max = 6, message = "O tamanho do produto deve ter no máximo 6 caracteres")
    private String tamanho;

    @Size(max = 100, message = "A descrição do produto deve ter no máximo 100 caracteres")
    private String descricao;

    @Size(max = 255, message = "A quantidade do produto deve ter no máximo 255 caracteres")
    private String quantidade;

    @Size(max = 13, message = "A quantidade do produto deve ter no máximo 255 caracteres")
    private String valor;
}
