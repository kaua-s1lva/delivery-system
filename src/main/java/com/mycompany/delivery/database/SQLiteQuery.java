package com.mycompany.delivery.database;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteQuery {
    public String retornaRegistros() {
        String registros = "";
        String sql = "SELECT * FROM registro";
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
}
