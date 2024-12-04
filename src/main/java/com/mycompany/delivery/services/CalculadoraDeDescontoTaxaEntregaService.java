package com.mycompany.delivery.services;

import java.util.ArrayList;

import com.mycompany.delivery.formasDesconto.FormaDescontoTaxaPorBairro;
import com.mycompany.delivery.formasDesconto.FormaDescontoTaxaPorTipoCliente;
import com.mycompany.delivery.formasDesconto.FormaDescontoTipoItem;
import com.mycompany.delivery.formasDesconto.FormaDescontoValorPedido;
import com.mycompany.delivery.interfaces.IFormaDescontoTaxaEntrega;
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
