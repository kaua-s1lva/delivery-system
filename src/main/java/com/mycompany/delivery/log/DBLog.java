package com.mycompany.delivery.log;

import com.mycompany.delivery.database.SQLiteConnection;
import com.mycompany.delivery.interfaces.ILog;

public class DBLog implements ILog {
    
    @Override
    public void escreverMensagem(String mensagem) {
        try {
            SQLiteConnection.connect("log.db").createStatement().execute(mensagem);
            System.out.println("Dado registrado com sucesso!");
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao registrar dado: " + e.getMessage());
        }
    }
}
