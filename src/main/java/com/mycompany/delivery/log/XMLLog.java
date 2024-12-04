package com.mycompany.delivery.log;

import com.mycompany.delivery.DAO.ArquivoDAO;
import com.mycompany.delivery.interfaces.ILog;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLLog implements ILog {
    private ArquivoDAO arquivoDAO;
    
    public XMLLog(){
        String caminhoArquivo = "logs/XMLLog.xml";
        arquivoDAO = new ArquivoDAO(caminhoArquivo);
    }  
    
    @Override
    public void escreverMensagem(String mensagem) {
        try {
            arquivoDAO.escreverNoArquivo(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}