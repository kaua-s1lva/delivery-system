package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    
    
    private void criarArquivoJSON(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            try {
                arquivoDAO.criarArquivo();
            } catch (IOException ex) {
                Logger.getLogger(JSONLog.class.getName()).log(Level.SEVERE, "Erro ao criar o arquivo JSON.", ex);
            }
        }  
    }
    
    @Override
    public void escreverMensagem(String mensagem) {
        File file = new File(arquivoDAO.getCaminhoArquivo());
    
        try {
            StringBuilder conteudoAtual = new StringBuilder();

            if (file.length() > 2) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        conteudoAtual.append(linha);
                    }
                }

                int posicaoFechamento = conteudoAtual.lastIndexOf("]");
                
                if (posicaoFechamento != -1) {
                    conteudoAtual.deleteCharAt(posicaoFechamento);
                    conteudoAtual.append(",\n").append(mensagem).append("\n]");
                }
            } else {
                conteudoAtual.append("[\n").append(mensagem).append("\n]");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(conteudoAtual.toString());
            }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao escrever no arquivo JSON: " + e.getMessage(), e);
            }
    }
}