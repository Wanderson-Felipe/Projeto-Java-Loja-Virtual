package w13imports;

import java.util.ArrayList;
import java.util.List;

public class W13imports {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Produto 1", "Tamanho P", 10.0);
        Produto produto2 = new Produto("Produto 2", "Tamanho M", 20.0);

        Cliente cliente1 = new Cliente("Felipe", "Senador teotonio vilela 892", "989027319");

        List<Produto> produtosVenda = new ArrayList<>();
        produtosVenda.add(produto1);
        produtosVenda.add(produto2);

        Venda venda = new Venda(produtosVenda, cliente1);

        System.out.println("Detalhes da Venda:");
        System.out.println("Data: " + venda.getData());
        System.out.println (venda.getClientes());

    }
}
