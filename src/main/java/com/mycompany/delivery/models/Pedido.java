package src.main.java.com.mycompany.delivery.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private Cliente cliente;
    private ArrayList<Item> itens = new ArrayList<>();
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private List<CupomDescontoValorPedido> cuponsDescontoValorPedido;

    public Pedido (Date data, Cliente cliente, double taxaEntrega) {
        this.cliente = cliente;
        this.taxaEntrega = taxaEntrega;
        cuponsDescontoEntrega = new ArrayList<>();
        cuponsDescontoValorPedido = new ArrayList<>();
    }

    public void adicionarItem (Item item) {
        itens.add(item);
    }

    public double getValorPedido() {
        double valorTotal = getTaxaEntregaComDesconto();
        for (int i=0; i<itens.size(); i++) {
            valorTotal += itens.get(i).getValorTotal();
        }
        return valorTotal;
    }

    public double getValorTotalPedido() {
        return getValorPedido() - getDescontoConcedidoValorPedido();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public double getTaxaEntregaComDesconto() {
        return taxaEntrega - this.getDescontoConcedidoTaxaEntrega();
    }

    public void aplicarDesconto(CupomDescontoEntrega cupom) {
        cuponsDescontoEntrega.add(cupom);
    }

    public void aplicarDescontoValorPedido(CupomDescontoValorPedido cupom) {
        cuponsDescontoValorPedido.add(cupom);
    }

    public double getDescontoConcedidoTaxaEntrega() {
        double descontoTotal = 0;
        for (CupomDescontoEntrega cupom : cuponsDescontoEntrega) {
            descontoTotal += cupom.getValorDesconto();
        }
        if (descontoTotal > this.getTaxaEntrega()) return this.getTaxaEntrega();
        return descontoTotal;
    }

    public double getDescontoConcedidoValorPedido() {
        double descontoTotal = 0;
        for (CupomDescontoValorPedido cupom : cuponsDescontoValorPedido) {
            descontoTotal += cupom.getValorDesconto();
        }
        return descontoTotal;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return Collections.unmodifiableList(this.cuponsDescontoEntrega);
    }

    public List<CupomDescontoValorPedido> getCuponsDescontoValorPedido() {
        return Collections.unmodifiableList(this.cuponsDescontoValorPedido);
    }

    public void setCuponsDescontoEntrega(CupomDescontoEntrega cupom) {
        this.cuponsDescontoEntrega.add(cupom);
    }

    @Override
    public String toString() {
        return "\nTaxa de entrega: " + taxaEntrega + 
        "\nNome do cliente: " + cliente.getNome() + 
        "\nDesconto concedido para taxa de entrega: " + this.getDescontoConcedidoTaxaEntrega() + 
        "\nDesconto concedido para valor do pedido: " + this.getDescontoConcedidoValorPedido() + 
        "\nValor total do pedido: " + this.getValorTotalPedido() + 
        "\nValor Pedido desconto: " + this.cuponsDescontoValorPedido;
    }
}