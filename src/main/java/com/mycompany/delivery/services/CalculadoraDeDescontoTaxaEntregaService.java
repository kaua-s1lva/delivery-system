package src.main.java.com.mycompany.delivery.services;

import java.util.ArrayList;

import src.main.java.com.mycompany.delivery.formasDesconto.FormaDescontoTaxaPorBairro;
import src.main.java.com.mycompany.delivery.formasDesconto.FormaDescontoTaxaPorTipoCliente;
import src.main.java.com.mycompany.delivery.formasDesconto.FormaDescontoTipoItem;
import src.main.java.com.mycompany.delivery.formasDesconto.FormaDescontoValorPedido;
import src.main.java.com.mycompany.delivery.interfaces.IFormaDescontoTaxaEntrega;
import src.main.java.com.mycompany.delivery.models.Pedido;

public class CalculadoraDeDescontoTaxaEntregaService {
    private ArrayList<IFormaDescontoTaxaEntrega> metodosDeDesconto = new ArrayList<>();

    public CalculadoraDeDescontoTaxaEntregaService() {
        metodosDeDesconto.add(new FormaDescontoTaxaPorBairro());
        metodosDeDesconto.add(new FormaDescontoTaxaPorTipoCliente());
        metodosDeDesconto.add(new FormaDescontoTipoItem());
        metodosDeDesconto.add(new FormaDescontoValorPedido());
    }

    public void addFormaDesconto(Pedido pedido) {
        for (IFormaDescontoTaxaEntrega formas : metodosDeDesconto) {
            formas.calcularDesconto(pedido);
        }
    }
}
