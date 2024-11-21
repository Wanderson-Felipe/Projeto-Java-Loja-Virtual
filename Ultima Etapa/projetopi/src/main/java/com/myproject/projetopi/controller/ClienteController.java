package com.myproject.projetopi.controller;

import com.myproject.projetopi.model.Cliente;
import com.myproject.projetopi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/cadastro")
    public String showCadastroPage(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("listaClientes", clienteRepository.findAll());
        return "/cadastro";
    }

    @PostMapping("/clientes/cadastro")
    public String cadastroCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteRepository.save(cliente);
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("listaClientes", clienteRepository.findAll());
        return "/cadastro";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        model.addAttribute("cliente", cliente);
        return "/cadastro";
    }

    @GetMapping("/clientes/excluir/{id}")
    public String excluirCliente(@PathVariable Long id, Model model) {
        clienteRepository.deleteById(id);
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("listaClientes", clienteRepository.findAll());
        return "/cadastro";
    }
}
