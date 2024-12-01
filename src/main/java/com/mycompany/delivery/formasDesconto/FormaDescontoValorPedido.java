package src.main.java.com.mycompany.delivery.formasDesconto;

import src.main.java.com.mycompany.delivery.interfaces.IFormaDescontoTaxaEntrega;
import src.main.java.com.mycompany.delivery.models.CupomDescontoEntrega;
import src.main.java.com.mycompany.delivery.models.Pedido;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {
    private static double valorDesconto = 0.15;

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
