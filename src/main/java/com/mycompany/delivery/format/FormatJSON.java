/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery.format;

import com.mycompany.delivery.models.RegistroOperacao;

/**
 *
 * @author tetzner
 */
public class FormatJSON implements IFormat {

    @Override
    public String format(RegistroOperacao registroOperacao) {
        String json = "{"
            + "\"nomeUsuario\": \"" + registroOperacao.getNomeUsuario() + "\", "
            + "\"data\": \"" + registroOperacao.getData() + "\", "
            + "\"hora\": \"" + registroOperacao.getHora() + "\", "
            + "\"codigoPedido\": " + registroOperacao.getCodPedido() + ", "
            + "\"nomeOperacao\": \"" + registroOperacao.getNomeOperacao() + "\", "
            + "\"nomeCliente\": \"" + registroOperacao.getNomeCliente() + "\""
            + "}";
        return json;
    }
    
}
