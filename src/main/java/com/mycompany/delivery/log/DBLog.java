package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.SQLiteConnection;
import com.mycompany.delivery.interfaces.ILog;
import java.sql.SQLException;

public class DBLog implements ILog {
    
    @Override
    public void escreverMensagem(String mensagem) {
        try {
            SQLiteConnection.getInstance().createStatement().execute(mensagem);
            System.out.println("Dado registrado com sucesso!");
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao registrar dado: " + e.getMessage());
        }
    }
}
