package com.mycompany.delivery.services;

import com.mycompany.delivery.interfaces.IFormaDescontoValorPedido;
import com.mycompany.delivery.models.Pedido;

public class CalculadoraDeDescontoValorPedidoService {
    IFormaDescontoValorPedido desconto;

    public void aplicarDesconto(Pedido pedido, IFormaDescontoValorPedido formaDesconto) {
        if(formaDesconto == null) {
            throw new RuntimeException("forma de desconto não adicionada");
        }
        formaDesconto.calcularDesconto(pedido);
    }
}
