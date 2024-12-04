package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
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
            arquivoDAO.escreverNoArquivo(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void criarArquivoXML(String caminhoArquivo){
        try {
            arquivoDAO.criarArquivo(caminhoArquivo);
            arquivoDAO.escreverNoArquivo(obterCabecalhoXML());
        } catch (IOException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String obterCabecalhoXML(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    }
}