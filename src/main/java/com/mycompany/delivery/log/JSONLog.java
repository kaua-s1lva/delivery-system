package com.mycompany.delivery.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.delivery.log.interfaces.ILog;

/**
 *
 * @author Monteiro
 */
public class JSONLog implements ILog {
    private final String caminhoArquivo = "logs/JSONLog.json";
    
    @Override
    public void escreverMensagem(String mensagem) {
        try {
            processarArquivoJSON(mensagem);
            System.out.println("\nLog registrado no arquivo JSON!");
        } catch (IOException ex) {
            Logger.getLogger(JSONLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void processarArquivoJSON(String mensagem) throws IOException {
         
        File file = new File(caminhoArquivo);
    
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