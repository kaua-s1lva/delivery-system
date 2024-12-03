package com.mycompany.delivery.log;

import com.mycompany.delivery.interfaces.ILog;
import java.io.FileWriter;
import java.io.IOException;

public class JSONLog implements ILog {
    private final String nomeArquivo;

    public JSONLog(String nomeArquivo) {
        if(nomeArquivo == null) {
            throw new IllegalArgumentException("Nome do arquivo nao pode ser nulo!");
        }
        String caminhoArquivo = "json/"+nomeArquivo;
        this.nomeArquivo = caminhoArquivo;
    }

    @Override
    public void escreverMensagem(String mensagem) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(mensagem);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo JSON: " + e.getMessage(), e);
      }
    }
}