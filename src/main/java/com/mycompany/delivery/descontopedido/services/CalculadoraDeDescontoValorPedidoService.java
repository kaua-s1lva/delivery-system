package com.mycompany.delivery.descontopedido.services;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.delivery.descontopedido.FormaDescontoCodCupomValorPedido;
import com.mycompany.delivery.descontopedido.FormaDescontoTipoClienteValorPedido;
import com.mycompany.delivery.descontopedido.FormaDescontoTipoItemValorPedido;
import com.mycompany.delivery.descontopedido.interfaces.IFormaDescontoValorPedido;
import com.mycompany.delivery.models.Pedido;

public class CalculadoraDeDescontoValorPedidoService {
    private List<IFormaDescontoValorPedido> descontos;

    public CalculadoraDeDescontoValorPedidoService (String cupomCliente) {
        descontos = new ArrayList<>();
        descontos.add(new FormaDescontoTipoItemValorPedido());
        descontos.add(new FormaDescontoCodCupomValorPedido(cupomCliente));
        descontos.add(new FormaDescontoTipoClienteValorPedido());
    }

    public void aplicarDesconto(Pedido pedido) {
        for (IFormaDescontoValorPedido desconto : descontos) {
            try {
                desconto.calcularDesconto(pedido);
            } catch (RuntimeException e) {
                System.out.println("Falha: " + e);
            }
        }
    }
}
