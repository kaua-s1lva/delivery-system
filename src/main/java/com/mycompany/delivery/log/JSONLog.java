package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
import java.io.IOException;

/**
 *
 * @author Monteiro
 */
public class JSONLog implements ILog {
    private final ArquivoDAO arquivoDAO;

    public JSONLog(String nomeArquivo) {
        if(nomeArquivo == null) {
            throw new IllegalArgumentException("Nome do arquivo nao pode ser nulo!");
        }
        String caminhoArquivo = "logs/JSONLog.json";
        arquivoDAO = new ArquivoDAO(caminhoArquivo);
    }

    @Override
    public void escreverMensagem(String mensagem) {
        try {
            arquivoDAO.escreverNoArquivo(mensagem);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo JSON: " + e.getMessage(), e);
        }
    }
}