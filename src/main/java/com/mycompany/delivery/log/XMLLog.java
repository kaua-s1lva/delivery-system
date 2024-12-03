package com.mycompany.delivery.log;

import com.mycompany.delivery.interfaces.ILog;
import java.io.FileWriter;
import java.io.IOException;

public class XMLLog implements ILog {
    private final String nomeArquivo;
    
    public XMLLog(String nomeArquivo){
        if(nomeArquivo == null){
            throw new IllegalArgumentException("O nome do arquivo nao pode ser nulo ");
        }
        this.nomeArquivo = nomeArquivo;
    }  
    
    @Override
    public void escreverMensagem(String mensagem) {
        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);
            writer.write(mensagem + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
