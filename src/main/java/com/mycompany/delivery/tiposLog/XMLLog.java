package com.mycompany.delivery.tiposLog;

import com.mycompany.delivery.interfaces.ILog;

public class XMLLog implements ILog {
    public void escreverMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
