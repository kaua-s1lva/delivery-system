package com.mycompany.delivery.descontopedido;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.delivery.descontopedido.interfaces.IFormaDescontoValorPedido;
import com.mycompany.delivery.descontopedido.models.CupomDescontoValorPedido;
import com.mycompany.delivery.models.Pedido;

public class FormaDescontoCodCupomValorPedido implements IFormaDescontoValorPedido {
    private final Map<String,Double> cupons;
    private final String cupomCliente;

    public FormaDescontoCodCupomValorPedido(String cupomCliente) {
        cupons = new HashMap<>();
        cupons.put("DESC10", 0.1);
        cupons.put("DESC20", 0.2);
        cupons.put("DESC30", 0.3);
        this.cupomCliente = cupomCliente;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if (seAplica(pedido)) {
            double valorDesconto = cupons.get(cupomCliente) * pedido.getValorPedido();
            pedido.aplicarDescontoValorPedido(new CupomDescontoValorPedido("Desconto por Código de Cupom", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for(CupomDescontoValorPedido cupom : pedido.getCuponsDescontoValorPedido()) {
            if (cupom.getNomeMetodo().equals("Desconto por Item")) {
                throw new RuntimeException("Desconto por Código de Cupom não pode ser aplicado pois desconto por item já foi aplicado");
                //return false;
            }
        }

        return cupons.containsKey(cupomCliente);
    }
}
