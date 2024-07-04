package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

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
    
     public List<Produto> getProduto() {
        String sql = "SELECT * FROM produto";
        try {

            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            List<Produto> listaProduto = new ArrayList<>();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getString("quantidade"));
                produto.setValor(rs.getString("valor"));
                listaProduto.add(produto);
            }
            return listaProduto;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    public int salvar(Produto produt) {
        int status;
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO produto (nome, tamanho, descricao, quantidade, valor) VALUES(?, ?, ?, ?, ?)");
            st.setString(1, produt.getNome());
            st.setString(2, produt.getTamanho());
            st.setString(3, produt.getDescricao());
            st.setString(4, produt.getQuantidade());
            st.setString(5, produt.getValor());

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }

    }

    public List<Produto> listagem(String termoBusca) {

        try {

            List<Produto> lista = new ArrayList<>();

            String sqlFiltro = "select * from produto";
            if (!termoBusca.isEmpty()) {
                sqlFiltro = sqlFiltro + " WHERE nome like ?";
            }

            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            if (!termoBusca.isEmpty()) {
                st.setString(1, "%" + termoBusca + "%");
            }
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Produto produtoEncontrado = new Produto();

                produtoEncontrado.setId(rs.getInt("id"));
                produtoEncontrado.setNome(rs.getString("nome"));
                produtoEncontrado.setTamanho(rs.getString("tamanho"));
                produtoEncontrado.setDescricao(rs.getString("descricao"));
                produtoEncontrado.setQuantidade(rs.getString("quantidade"));
                produtoEncontrado.setValor(rs.getString("valor"));
                lista.add(produtoEncontrado);
            }
            return lista;

        } catch (SQLException ex) {
            System.out.println("Erro ao Listar" + ex.getMessage());
            return null;

        }
    }

    public boolean excluir(int id) {

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM produto WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao Excluir" + ex.getMessage());
            return false;
        }
    }

    public int alterar(Produto produt) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE produto SET nome=?, tamanho=?, descricao=?, quantidade=?, valor=? WHERE id=?");
            st.setString(1, produt.getNome());
            st.setString(2, produt.getTamanho());
            st.setString(3, produt.getDescricao());
            st.setString(4, produt.getQuantidade());
            st.setString(5, produt.getValor());
            st.setInt(6, produt.getId());

            int status = st.executeUpdate();
            System.out.println("Produto alterado com sucesso. Linhas afetadas: " + status);
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar produto: " + ex.getMessage());
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
