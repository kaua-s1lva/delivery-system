package com.mycompany.delivery.models;

public class CupomDescontoValorPedido {
    private final String nomeMetodo;
    private final double valorDesconto;

    public CupomDescontoValorPedido(String nomeMetodo, double valorDesconto) {
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "\nNome do método: " + nomeMetodo + "\nValor do desconto: " + valorDesconto;
    }
}
