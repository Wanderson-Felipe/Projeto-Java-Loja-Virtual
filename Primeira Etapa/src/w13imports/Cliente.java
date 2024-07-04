package w13imports;

public class Cliente {

    private String nome;
    private String endereco;
    private String celular;

    public Cliente(String nome, String endereco, String celular) {
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
    }

    public String toString() {
        return "Cliente: " + nome + ", Endereço: " + endereco + ", Celular: " + celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void cadastrarCliente(String nome, String endereco, String celular) {
        Cliente clientes = new Cliente(nome, endereco, celular);
        System.out.println("Cliente cadastrado com sucesso: " + clientes.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
