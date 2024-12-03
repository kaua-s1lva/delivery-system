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
    
    public ILog getLog(){
        return log;
    }
    
    public void setLog(ILog log){
        if(log == null){
            throw new IllegalArgumentException("O tipo de log nao pode ser nulo");
        }
        this.log = log;
    }
    
    public static void registrarLog(RegistroOperacao registro) {
        ILog log = getInstance().getLog();
        if(log == null){
            throw new IllegalStateException("O log nao foi configurado ");
        }
        log.escreverMensagem(registro.toString());
    }
}
