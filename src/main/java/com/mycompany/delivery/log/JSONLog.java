package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monteiro
 */
public class JSONLog implements ILog {
    private final ArquivoDAO arquivoDAO;

    public JSONLog() {
        String caminhoArquivo = "logs/JSONLog.json";
        arquivoDAO = new ArquivoDAO(caminhoArquivo);
        criarArquivoJSON(caminhoArquivo);
    }

    @Override
    public void escreverMensagem(String mensagem) {
        try {
            arquivoDAO.escreverNoArquivo(mensagem);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo JSON: " + e.getMessage(), e);
        }
    }
    
    
    private void criarArquivoJSON(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            try {
                arquivoDAO.criarArquivo(caminhoArquivo); // Cria o arquivo
                arquivoDAO.escreverNoArquivo("["); // Escreve o cabeçalho
            } catch (IOException ex) {
                Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, "Erro ao criar o arquivo XML.", ex);
            }
        }  
    }
     
}