package com.mycompany.delivery.descontopedido.interfaces;

import com.mycompany.delivery.models.Pedido;

public interface IFormaDescontoValorPedido {
    public void calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
