package com.mycompany.delivery.services;

import com.mycompany.delivery.format.IFormat;
import com.mycompany.delivery.interfaces.ILog;
import com.mycompany.delivery.models.RegistroOperacao;

public class LogService {
    private static LogService singleInstance = null;
    private ILog log;
    private IFormat formatLog;
    
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
    
    public IFormat getFormatLog(){
        return formatLog;
    }
     
    public void setLog(ILog log){
        if(log == null){
            throw new IllegalArgumentException("O tipo de log nao pode ser nulo");
        }
        this.log = log;
    }
    
    public void setFormatLog(IFormat formatLog){
        if(formatLog == null){
            throw new IllegalArgumentException("Formato nulo, necessario passar um formato valido");
        }
        
        this.formatLog = formatLog;
    }
    
    public static void registrarLog(RegistroOperacao registro) {
        ILog log = getInstance().getLog();
        IFormat formatLog = getInstance().getFormatLog();
        
        if(log == null || formatLog == null){
            throw new IllegalStateException("O log ou formato nao foi configurado ");
        }
        log.escreverMensagem(formatLog.formatar(registro));
    }
}
