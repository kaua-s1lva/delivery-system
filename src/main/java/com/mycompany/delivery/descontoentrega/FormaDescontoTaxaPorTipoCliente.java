package com.mycompany.delivery.descontoentrega;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.delivery.descontoentrega.interfaces.IFormaDescontoTaxaEntrega;
import com.mycompany.delivery.descontoentrega.models.CupomDescontoEntrega;
import com.mycompany.delivery.models.Pedido;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega {
    private final Map<String,Double> clientes;

    public FormaDescontoTaxaPorTipoCliente() {
        clientes = new HashMap<>();
        clientes.put("Ouro", 0.3);
        clientes.put("Prata", 0.2);
        clientes.put("Bronze", 0.1);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if (seAplica(pedido)) {
            double valorDesconto = clientes.get(pedido.getCliente().getTipo()) * pedido.getTaxaEntrega();
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por Cliente", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return clientes.containsKey(pedido.getCliente().getTipo());
    }

}