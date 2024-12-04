package com.mycompany.delivery.DAO;

public class SQLiteDAO {

    public static void createRegistroTable() {
        // SQL para criar uma nova tabela
        //INSERT INTO registro (nomeUsuario, data, hora, codigoPedido, nomeOperacao, nomeCliente) "
        String sql = "CREATE TABLE IF NOT EXISTS registro (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    nomeUsuario VARCHAR(200) NOT NULL,\n"
                + "    data TEXT NOT NULL,\n"
                + "    hora TEXT NOT NULL,\n"
                + "    codigoPedido INT NOT NULL,\n"
                + "    nomeOperacao VARCHAR(200) NOT NULL,\n"
                + "    nomeCliente VARCHAR(200) NOT NULL\n"
                + ");";

        try {
            SQLiteConnection.connect("log.db").createStatement().execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao criar a tabela: " + e.getMessage());
        }
    }
    
    
}
