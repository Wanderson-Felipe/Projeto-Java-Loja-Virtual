package w13imports;

import java.util.Date;
import java.util.List;

public class Venda {

    private List<Produto> produtos;
    private Cliente clientes;
    private double valorTotal;
    private Date data;

    public Venda(List<Produto> produto, Cliente clientes) {
        this.produtos = produto;
        this.clientes = clientes;
        this.data = new Date();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
 
