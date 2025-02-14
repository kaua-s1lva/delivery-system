package com.mycompany.delivery.descontopedido;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.delivery.descontopedido.interfaces.IFormaDescontoValorPedido;
import com.mycompany.delivery.descontopedido.models.CupomDescontoValorPedido;
import com.mycompany.delivery.models.Pedido;

public class FormaDescontoTipoClienteValorPedido implements IFormaDescontoValorPedido {
    private final Map<String,Double> clientes;

    public FormaDescontoTipoClienteValorPedido() {
        clientes = new HashMap<>();
        clientes.put("Ouro", 0.3);
        clientes.put("Prata", 0.2);
        clientes.put("Bronze", 0.1);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if (seAplica(pedido)) {
            double valorDesconto = clientes.get(pedido.getCliente().getTipo()) * pedido.getValorPedido();
            pedido.aplicarDescontoValorPedido(new CupomDescontoValorPedido("Desconto por Cliente", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for(CupomDescontoValorPedido cupom : pedido.getCuponsDescontoValorPedido()) {
            if (cupom.getNomeMetodo().equals("Desconto por Item")) return false;
        }

        return clientes.containsKey(pedido.getCliente().getTipo());
    }

}