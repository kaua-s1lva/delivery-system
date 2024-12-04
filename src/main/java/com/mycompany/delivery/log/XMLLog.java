package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLLog implements ILog {
    
    private final String caminhoArquivo = "logs/XMLLog.xml";
    
    public XMLLog(){
        criarArquivoXML();
    }  
   
    private void criarArquivoXML() {
        
        File arquivo = new File(caminhoArquivo);
        
        if (!arquivo.exists() || arquivo.length() == 0) {
            try {
                arquivo.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                    writer.write(obterCabecalhoXML());
                    writer.write("<Registros>\n");
                    writer.write("</Registros>");
                }
            } catch (IOException ex) {
                Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, "Erro ao criar o arquivo XML.", ex);
            }
        }
    }

    @Override
    public void escreverMensagem(String mensagem) {
         try {
            processarArquivoXML(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void processarArquivoXML(String mensagem) throws IOException {
        File file = new File(caminhoArquivo);
        StringBuilder conteudoXML = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudoXML.append(linha).append("\n");
            }
        }
        
        int posicaoFechamento = conteudoXML.lastIndexOf("</Registros>");
        
        if (posicaoFechamento != -1) {
            conteudoXML.delete(posicaoFechamento, conteudoXML.length());
            conteudoXML.append("  <registro>").append(mensagem).append("</registro>\n");
            conteudoXML.append("</Registros>");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(conteudoXML.toString());
        }
    }

    private String obterCabecalhoXML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    }

}