package com.mycompany.delivery.DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteQuery {
    
    public static String retornaRegistros() {
        
        StringBuilder registros = new StringBuilder();
        String sql = "SELECT * FROM registro";
        try {
            Statement stmt = SQLiteConnection.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                registros.append("Registro:\n");
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = rs.getString(i);
                    registros.append("  ").append(columnName).append(": ").append(columnValue).append("\n");
                }
                registros.append("\n");
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao criar a tabela: " + e.getMessage());
        }
        return registros.toString();
    }
}
