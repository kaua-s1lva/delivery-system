package com.mycompany.delivery.format;

import com.mycompany.delivery.models.RegistroOperacao;

/**
 *
 * @author tetzner
 */
public class FormatXML implements IFormat {

    @Override
    public String format(RegistroOperacao registroOperacao) {
       String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
               
        xml += "<RegistroOperacao>"
            + "<nomeUsuario>" + registroOperacao.getNomeUsuario() + "</nomeUsuario>"
            + "<data>" + registroOperacao.getData() + "</data>"
            + "<hora>" + registroOperacao.getHora() + "</hora>"
            + "<codigoPedido>" + registroOperacao.getCodPedido() + "</codigoPedido>"
            + "<nomeOperacao>" + registroOperacao.getNomeOperacao() + "</nomeOperacao>"
            + "<nomeCliente>" + registroOperacao.getNomeCliente() + "</nomeCliente>"
            + "</RegistroOperacao>";
        return xml;
    }
    
}
