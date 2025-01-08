package com.mycompany.delivery.descontopedido.services;

import com.mycompany.delivery.descontopedido.interfaces.IFormaDescontoValorPedido;
import com.mycompany.delivery.models.Pedido;

public class CalculadoraDeDescontoValorPedidoService {
    private IFormaDescontoValorPedido desconto;

    public void aplicarDesconto(Pedido pedido, IFormaDescontoValorPedido formaDesconto) {
        if(formaDesconto == null) {
            throw new IllegalArgumentException("forma de desconto não adicionada");
        }
        desconto = formaDesconto;
        desconto.calcularDesconto(pedido);
    }
}
