/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery.log.adapter;

import com.br.log.ILog;
import com.mycompany.delivery.log.models.RegistroOperacao;

/**
 *
 * @author tetzner
 */
public class LogAdapter {
    private final ILog log;
    
    public LogAdapter(ILog log){
        this.log = log;
    }
    
    public void escreverMensagem(RegistroOperacao registro){
        log.escrever(registro);
    }
    
}
