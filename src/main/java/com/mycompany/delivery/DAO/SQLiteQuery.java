package com.mycompany.delivery.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteQuery {
    public String retornaRegistros() {
        String registros = "";
        String sql = "SELECT * FROM artists";
        try {
            Statement stmt = SQLiteConnection.connect("registro").createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                registros = rs.getString("register");
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao criar a tabela: " + e.getMessage());
        }
        return registros;
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:db/chinook.db";
        String sql = "SELECT * FROM artists";

        try (Connection connection = DriverManager.getConnection(url);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ArtistId"));
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados: " + e.getMessage());
        }
    }
}
