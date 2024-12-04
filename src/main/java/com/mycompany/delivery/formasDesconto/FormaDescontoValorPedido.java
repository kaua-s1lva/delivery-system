package com.mycompany.delivery.formasDesconto;

import com.mycompany.delivery.interfaces.IFormaDescontoTaxaEntrega;
import com.mycompany.delivery.models.CupomDescontoEntrega;
import com.mycompany.delivery.models.Pedido;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {
    private static final double valorDesconto = 0.15;

    @Override
    public void calcularDesconto(Pedido pedido) {
        if (seAplica(pedido)) {
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por valor", valorDesconto * pedido.getTaxaEntrega()));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getValorPedido() > 2000;
    }
}
