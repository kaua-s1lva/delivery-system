package src.main.java.com.mycompany.delivery.services;

import src.main.java.com.mycompany.delivery.interfaces.ILog;
import src.main.java.com.mycompany.delivery.models.Cobranca;

public class RegistradoraLogService {
    public void registrar(Cobranca cobranca, ILog log) {
        log.escreverMensagem(cobranca.toString());
    }
}
