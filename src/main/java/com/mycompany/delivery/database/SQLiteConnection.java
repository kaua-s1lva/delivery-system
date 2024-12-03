package com.mycompany.delivery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Caminho do arquivo do banco de dados SQLite
            String url = "jdbc:sqlite:db/chinook.db";

            // Estabelece a conexão
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao SQLite: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Fecha a conexão
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }
}
