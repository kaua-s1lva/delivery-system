package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLLog implements ILog {
    private final ArquivoDAO arquivoDAO;

    public XMLLog(){
        String caminhoArquivo = "logs/XMLLog.xml";
        arquivoDAO = new ArquivoDAO(caminhoArquivo);
        
        criarArquivoXML(caminhoArquivo);
    }  
   

    @Override
    public void escreverMensagem(String mensagem) {
        try {
            arquivoDAO.escreverNoArquivo(mensagem+"\n");
        } catch (IOException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void criarArquivoXML(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            try {
                arquivoDAO.criarArquivo(caminhoArquivo); // Cria o arquivo
                arquivoDAO.escreverNoArquivo(obterCabecalhoXML()); // Escreve o cabeçalho
            } catch (IOException ex) {
                Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, "Erro ao criar o arquivo XML.", ex);
            }
        }  
    }
     
    private String obterCabecalhoXML(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    }
}