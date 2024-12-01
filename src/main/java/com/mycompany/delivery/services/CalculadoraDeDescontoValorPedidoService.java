package src.main.java.com.mycompany.delivery.services;

import src.main.java.com.mycompany.delivery.interfaces.IFormaDescontoValorPedido;
import src.main.java.com.mycompany.delivery.models.Pedido;

public class CalculadoraDeDescontoValorPedidoService {
    IFormaDescontoValorPedido desconto;

    public void aplicarDesconto(Pedido pedido, IFormaDescontoValorPedido formaDesconto) {
        if(formaDesconto == null) {
            throw new RuntimeException("forma de desconto não adicionada");
        }
        formaDesconto.calcularDesconto(pedido);
    }
}
