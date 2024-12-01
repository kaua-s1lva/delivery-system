package src.main.java.com.mycompany.delivery.formasDesconto;

import java.util.HashMap;
import java.util.Map;

import src.main.java.com.mycompany.delivery.interfaces.IFormaDescontoTaxaEntrega;
import src.main.java.com.mycompany.delivery.models.CupomDescontoEntrega;
import src.main.java.com.mycompany.delivery.models.Item;
import src.main.java.com.mycompany.delivery.models.Pedido;

public class FormaDescontoTipoItem implements IFormaDescontoTaxaEntrega {
    private Map<String,Double> descontosPorTipoItem;

    public FormaDescontoTipoItem() {
        descontosPorTipoItem = new HashMap<>();
        descontosPorTipoItem.put("Alimentação", 0.05);
        descontosPorTipoItem.put("Educação", 0.2);
        descontosPorTipoItem.put("Lazer", 0.15);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        double valorDesconto = 0;
        if (seAplica(pedido)) {
            for (Item item : pedido.getItens()) {
                if (descontosPorTipoItem.containsKey(item.getTipo())) {
                    valorDesconto += pedido.getTaxaEntrega() * descontosPorTipoItem.get(item.getTipo());
                }
            }
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por Item", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for (Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo())) {
                return true;
            }
        }
        return false;
    }
}
