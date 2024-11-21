package com.myproject.projetopi.controller;

import com.myproject.projetopi.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.myproject.projetopi.repository.ClienteRepository;
import com.myproject.projetopi.repository.ProdutoRepository;
import com.myproject.projetopi.repository.VendaRepository;

@Controller
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/vendas")
    public String exibirRegistroEListagem(@RequestParam(value = "nomeCliente", required = false) String nomeCliente,
            @RequestParam(value = "error", required = false) String error,
            Model model) {
        model.addAttribute("venda", new Venda());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("produtos", produtoRepository.findAll());

        if (error != null && error.equals("produtoNaoSelecionado")) {
            model.addAttribute("errorProduto", "Você precisa selecionar um produto!");
        } else if (error != null && error.equals("clienteNaoSelecionado")) {
            model.addAttribute("errorCliente", "Você precisa selecionar um cliente!");
        }

        if (nomeCliente != null && !nomeCliente.isEmpty()) {
            model.addAttribute("listaVendas", vendaRepository.findByClienteNomeContainingIgnoreCase(nomeCliente));
        } else {
            model.addAttribute("listaVendas", vendaRepository.findAll());
        }

        return "venda";
    }

    @PostMapping("/vendas")
    public String registrarVenda(@ModelAttribute Venda venda) {
        if (venda.getProduto() == null) {

            return "redirect:/vendas?error=produtoNaoSelecionado";
        }

        if (venda.getCliente() == null) {
        }

        vendaRepository.save(venda);
        return "redirect:/vendas";
    }
}
