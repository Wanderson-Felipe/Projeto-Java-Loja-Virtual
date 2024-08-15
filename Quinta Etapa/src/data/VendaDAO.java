package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

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

    public int finalizar(Venda vend) {
        int status;
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO venda (data, quantidade, cliente_id, produto_id, valor) VALUES(?, ?, ?, ?, ?)");
            st.setDate(1, vend.getData());
            st.setString(2, vend.getQuantidade());
            if (vend.getCliente_id() != null) {
                st.setInt(3, vend.getCliente_id().getId());
            } else {
                st.setNull(3, java.sql.Types.INTEGER);
            }
            st.setInt(4, vend.getProduto_id().getId());
            st.setString(5, vend.getValor());

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }

    }

    public List<Venda> listagem(String termoBusca) {

        try {

            List<Venda> lista = new ArrayList<>();

            String sqlFiltro = "select A.id, A.data, A.quantidade," + "COALESCE (B.nome, 'Cliente não informado') AS nome_cliente, C.nome AS nome_produto, A.valor FROM venda A "
                    + "left join cliente B on A.cliente_id = B.id "
                    + "inner join produto C on A.produto_id = C.id";
            if (!termoBusca.isEmpty()) {
                sqlFiltro = sqlFiltro + " WHERE B.nome like ?";
            }

            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            if (!termoBusca.isEmpty()) {
                st.setString(1, "%" + termoBusca + "%");
            }
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Venda vendaEncontrada = new Venda();

                vendaEncontrada.setId(rs.getInt("id"));
                vendaEncontrada.setData(rs.getDate("data"));
                vendaEncontrada.setQuantidade(rs.getString("quantidade"));

                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome_cliente"));
                vendaEncontrada.setCliente_id(cliente);

                Produto produto = new Produto();
                produto.setNome(rs.getString("nome_produto"));
                vendaEncontrada.setProduto_id(produto);

                vendaEncontrada.setValor(rs.getString("valor"));
                lista.add(vendaEncontrada);
            }
            return lista;

        } catch (SQLException ex) {
            System.out.println("Erro ao Listar" + ex.getMessage());
            return null;

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
