package com.mycompany.delivery.descontoentrega.services;

import java.util.ArrayList;

import com.mycompany.delivery.descontoentrega.FormaDescontoTaxaPorBairro;
import com.mycompany.delivery.descontoentrega.FormaDescontoTaxaPorTipoCliente;
import com.mycompany.delivery.descontoentrega.FormaDescontoTipoItem;
import com.mycompany.delivery.descontoentrega.FormaDescontoValorPedido;
import com.mycompany.delivery.descontoentrega.interfaces.IFormaDescontoTaxaEntrega;
import com.mycompany.delivery.models.Pedido;
import java.util.List;

public class CalculadoraDeDescontoTaxaEntregaService {
    private final List<IFormaDescontoTaxaEntrega> metodosDeDesconto;

    public CalculadoraDeDescontoTaxaEntregaService() {
        this.metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(new FormaDescontoTaxaPorBairro());
        metodosDeDesconto.add(new FormaDescontoTaxaPorTipoCliente());
        metodosDeDesconto.add(new FormaDescontoTipoItem());
        metodosDeDesconto.add(new FormaDescontoValorPedido());
    }

    public void calcularDescontoTaxaEntrega(Pedido pedido) {
        for (IFormaDescontoTaxaEntrega formas : metodosDeDesconto) {
            formas.calcularDesconto(pedido);
        }
    }
}
