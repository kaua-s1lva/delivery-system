package com.mycompany.delivery.database.migrations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mycompany.delivery.DAO.SQLiteConnection;

public class SQLiteTableCreation {

    public static void createRegistroTable() {
        // SQL para criar uma nova tabela
        String sql = "CREATE TABLE IF NOT EXISTS registros (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    registro TEXT NOT NULL\n"
                + ");";

        try {
            SQLiteConnection.connect("log.db").createStatement().execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao criar a tabela: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String url = "jdbc:sqlite:db/usuarios.db";

        // SQL para criar uma nova tabela
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    nome TEXT NOT NULL,\n"
                + "    email TEXT NOT NULL UNIQUE\n"
                + ");";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            // Executa o comando SQL
            statement.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao criar a tabela: " + e.getMessage());
        }
    }
}
