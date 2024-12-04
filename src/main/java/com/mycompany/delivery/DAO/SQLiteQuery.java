package com.mycompany.delivery.DAO;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteQuery {
    public static String retornaRegistros() {
        String registros = "";
        String sql = "SELECT * FROM registro";
        try {
            Statement stmt = SQLiteConnection.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                registros = rs.getString("nomeCliente");
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao criar a tabela: " + e.getMessage());
        }
        return registros;
    }
}
