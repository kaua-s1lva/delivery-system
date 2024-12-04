package com.mycompany.delivery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static Connection connect(String nomeArq) {
        Connection connection = null;
        try {
            // Caminho do arquivo do banco de dados SQLite
            //String url = "jdbc:sqlite:db/chinook.db" + nomeBD;
            String url = "jdbc:sqlite:db/" + nomeArq;

            // Estabelece a conexão
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao conectar no banco de dados: " + e.getMessage());
        }
        return connection;
    }
}
