package com.mycompany.delivery.log.services;

import com.br.log.DBLog;
import com.br.log.JSONLog;
import com.br.log.XMLLog;
import com.mycompany.delivery.log.adapter.LogAdapter;
import com.mycompany.delivery.log.models.RegistroOperacao;

public class LogService {
    private final LogAdapter logAdapter;
    
    public LogService(){
        logAdapter = new LogAdapter(new JSONLog());
    }
    
    public void registrarLog(RegistroOperacao registro) {
        logAdapter.escreverMensagem(registro);
    }
    
}
