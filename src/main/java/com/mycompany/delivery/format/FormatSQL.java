package com.mycompany.delivery.format;

import com.mycompany.delivery.models.RegistroOperacao;

/**
 *
 * @author tetzner
 */
public class FormatSQL implements IFormat {

    @Override
    public String formatar(RegistroOperacao registroOperacao) {
        String queryInsert = String.format("INSERT INTO registro (nomeUsuario, data, hora, codigoPedido, nomeOperacao, nomeCliente) "
            + "VALUES ('%s', '%s', '%s', %d, '%s', '%s');", 
            registroOperacao.getNomeUsuario(), 
            registroOperacao.getData(), 
            registroOperacao.getHora(), 
            registroOperacao.getCodPedido(), 
            registroOperacao.getNomeOperacao(), 
            registroOperacao.getNomeCliente());
        return queryInsert;
    }
    
}
