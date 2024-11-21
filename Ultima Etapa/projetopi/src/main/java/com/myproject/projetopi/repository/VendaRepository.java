package com.myproject.projetopi.repository;

import com.myproject.projetopi.model.Venda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByClienteNomeContainingIgnoreCase(String nomeCliente);
}
