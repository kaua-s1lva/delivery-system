package com.mycompany.delivery.formasDesconto;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.delivery.interfaces.IFormaDescontoTaxaEntrega;
import com.mycompany.delivery.models.CupomDescontoEntrega;
import com.mycompany.delivery.models.Pedido;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega {
    private Map<String, Double> bairros;

    public FormaDescontoTaxaPorBairro() {
        bairros = new HashMap<>();
        bairros.put("Centro", 0.2);
        bairros.put("Bela Vista", 0.3);
        bairros.put("Cidade Maravilhosa", 0.15);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if (seAplica(pedido)) {
            pedido.aplicarDesconto(new CupomDescontoEntrega
                ("Desconto por bairro", bairros.get(pedido.getCliente().getBairro()) * pedido.getTaxaEntrega()));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return bairros.containsKey(pedido.getCliente().getBairro());
    }
}
