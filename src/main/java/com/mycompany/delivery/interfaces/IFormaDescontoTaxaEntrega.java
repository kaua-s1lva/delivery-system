package src.main.java.com.mycompany.delivery.interfaces;

import src.main.java.com.mycompany.delivery.models.Pedido;

public interface IFormaDescontoTaxaEntrega {
    public void calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
