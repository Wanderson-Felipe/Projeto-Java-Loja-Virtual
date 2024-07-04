package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/w13_imports",
                    "root",
                    "Wanderfelipe13$"
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao Conectar: " + e.getMessage());
            return null;
        }
    }
}
