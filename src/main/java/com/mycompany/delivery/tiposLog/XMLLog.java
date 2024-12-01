package src.main.java.com.mycompany.delivery.tiposLog;

import src.main.java.com.mycompany.delivery.interfaces.ILog;

public class XMLLog implements ILog {
    public void escreverMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
