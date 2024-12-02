package com.mycompany.delivery.interfaces;

import com.mycompany.delivery.models.Pedido;

public interface IFormaDescontoValorPedido {
    public void calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
