package com.mycompany.delivery.log;

import com.mycompany.delivery.interfaces.ILog;

public class XMLLog implements ILog {
    
    @Override
    public void escreverMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    
}
