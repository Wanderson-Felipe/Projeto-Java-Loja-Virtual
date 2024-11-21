package com.myproject.projetopi.repository;

import com.myproject.projetopi.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
