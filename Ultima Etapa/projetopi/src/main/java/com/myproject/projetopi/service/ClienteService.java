package com.myproject.projetopi.service;

import com.myproject.projetopi.model.Cliente;
import com.myproject.projetopi.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
