package com.myproject.projetopi.service;

import com.myproject.projetopi.model.Cliente;
import com.myproject.projetopi.model.Produto;
import com.myproject.projetopi.model.Venda;
import com.myproject.projetopi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    public Venda realizarVenda(Long clienteId, Long produtoId, int quantidade) {
        Optional<Cliente> cliente = clienteService.obterClientePorId(clienteId);
        Optional<Produto> produto = produtoService.obterProdutoPorId(produtoId);

        if (produto.isPresent()) {
            Produto produtoVendido = produto.get();

            Venda venda = new Venda();
            venda.setProduto(produtoVendido);
            venda.setQuantidade(quantidade);
            venda.setValor(produtoVendido.getValor());

            cliente.ifPresent(venda::setCliente);

            return vendaRepository.save(venda);
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    public List<Venda> obterTodasVendas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> obterVendaPorId(Long id) {
        return vendaRepository.findById(id);
    }
}
