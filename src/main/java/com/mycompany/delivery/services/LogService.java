package com.mycompany.delivery.services;

import com.mycompany.delivery.interfaces.ILog;
import com.mycompany.delivery.models.RegistroOperacao;

public class LogService {
    private static LogService singleInstance = null;
    private ILog log;
    
    private LogService(){
        
    }
    
    public static LogService getInstance(){
        if(singleInstance == null){
            singleInstance = new LogService();
        }
        return singleInstance;
    }
    
    public ILog getILog(){
        return log;
    }
    
    public void setILog(ILog log){
        this.log = log;
    }
    
    public static void registrar(RegistroOperacao cobranca) {
        getInstance().getILog().escreverMensagem(cobranca.toString());
    }
}
