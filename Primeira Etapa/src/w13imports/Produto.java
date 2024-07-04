package w13imports;

public class Produto {

    private String nome;
    private String tamanho;
    private double preco;

    public Produto(String nome, String tamanho, double preco) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public void cadastrarProduto(String nome, String tamanho, double preco) {
        Produto produto = new Produto(nome, tamanho, preco);
        System.out.println("Produto cadastrado com sucesso: " + produto.getNome());
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
