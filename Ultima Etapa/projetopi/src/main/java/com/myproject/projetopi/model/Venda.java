package com.myproject.projetopi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Produto produto;

    private int quantidade;

    private String valor;

    private LocalDate data;

    @Override
    public String toString() {
        return "Venda{"
                + "id=" + id
                + ", cliente=" + (cliente != null ? cliente.getNome() : "Cliente não informado")
                + ", produto=" + produto.getNome()
                + ", quantidade=" + quantidade
                + ", valor=" + valor
                + ", data=" + data
                + '}';
    }
}
