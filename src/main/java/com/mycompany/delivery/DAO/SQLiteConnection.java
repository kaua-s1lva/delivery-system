package com.mycompany.delivery.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    private static Connection connection;
    private static SQLiteConnection sqLiteConnection = new SQLiteConnection();

    private SQLiteConnection () {

    }

    public static Connection getInstance() {
        if (connection == null) {
            synchronized (SQLiteConnection.class) {
                if (connection == null) { // Double-check locking
                    try {
                        // Configuração do URL de conexão
                        String url = "jdbc:sqlite:db/log.db";
                        connection = DriverManager.getConnection(url);
                        System.out.println("Conexão estabelecida com sucesso!");
                    } catch (SQLException e) {
                        throw new IllegalStateException("Erro ao conectar no banco de dados: " + e.getMessage());
                    }
                }
            }
        }
        return connection;
    }
}
