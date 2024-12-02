package com.mycompany.delivery.services;

import com.mycompany.delivery.interfaces.ILog;
import com.mycompany.delivery.models.Cobranca;

public class RegistradoraLogService {
    public void registrar(Cobranca cobranca, ILog log) {
        log.escreverMensagem(cobranca.toString());
    }
}
