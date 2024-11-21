package com.myproject.projetopi.controller;

import com.myproject.projetopi.model.Produto;
import com.myproject.projetopi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos/cadastro")
    public String showCadastroPage(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("listaProdutos", produtoRepository.findAll());
        return "produto";
    }

    @PostMapping("/produtos/cadastro")
    public String cadastroProduto(@ModelAttribute Produto produto, Model model) {
        produtoRepository.save(produto);
        model.addAttribute("produto", new Produto());
        model.addAttribute("listaProdutos", produtoRepository.findAll());
        return "produto";
    }

    @GetMapping("/produtos/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("produto", produto);
        return "produto";
    }

    @GetMapping("/produtos/excluir/{id}")
    public String excluirProduto(@PathVariable Long id, Model model) {
        produtoRepository.deleteById(id);
        model.addAttribute("produto", new Produto());
        model.addAttribute("listaProdutos", produtoRepository.findAll());
        return "produto";
    }
}
