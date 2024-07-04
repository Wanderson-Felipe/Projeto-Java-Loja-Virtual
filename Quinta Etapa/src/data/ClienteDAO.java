package data;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;

    public boolean conectar() {

        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        if (this.conn == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<Cliente> getCliente() {
        String sql = "SELECT * FROM cliente";
        try {

            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            List<Cliente> listaCliente = new ArrayList<>();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                listaCliente.add(cliente);
            }
            return listaCliente;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    public int salvar(Cliente client) {
        int status;
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO cliente (nome, cpf, telefone, endereco) VALUES(?, ?, ?, ?)");
            st.setString(1, client.getNome());
            st.setString(2, client.getCpf());
            st.setString(3, client.getTelefone());
            st.setString(4, client.getEndereco());

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }

    }

    public List<Cliente> listagem(String termoBusca) {

        try {

            List<Cliente> lista = new ArrayList<>();

            String sqlFiltro = "select * from cliente";
            if (!termoBusca.isEmpty()) {
                sqlFiltro = sqlFiltro + " WHERE nome like ?";
            }

            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            if (!termoBusca.isEmpty()) {
                st.setString(1, "%" + termoBusca + "%");
            }
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Cliente clienteEncontrado = new Cliente();

                clienteEncontrado.setId(rs.getInt("id"));
                clienteEncontrado.setNome(rs.getString("nome"));
                clienteEncontrado.setCpf(rs.getString("cpf"));
                clienteEncontrado.setTelefone(rs.getString("telefone"));
                clienteEncontrado.setEndereco(rs.getString("endereco"));
                lista.add(clienteEncontrado);
            }
            return lista;

        } catch (SQLException ex) {
            System.out.println("Erro ao Listar" + ex.getMessage());
            return null;

        }
    }

    public boolean excluir(int id) {

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao Excluir" + ex.getMessage());
            return false;
        }
    }

    public int alterar(Cliente client) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE cliente SET nome=?, cpf=?, telefone=?, endereco=? WHERE id=?");
            st.setString(1, client.getNome());
            st.setString(2, client.getCpf());
            st.setString(3, client.getTelefone());
            st.setString(4, client.getEndereco());
            st.setInt(5, client.getId());

            int status = st.executeUpdate();
            System.out.println("Cliente alterado com sucesso. Linhas afetadas: " + status);
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar cliente: " + ex.getMessage());
            ex.printStackTrace();
            return -1;
        }
    }

    public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Desconectar " + ex.getMessage());
        }
    }
}
