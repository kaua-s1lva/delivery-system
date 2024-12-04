package com.mycompany.delivery.models;

public class Item {
    private final String nome;
    private final int quantidade;
    private final double valorUnitario;
    private final String tipo;

    public Item (String nome, int quantidade, double valorUnitario, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public double getValorTotal() {
        return quantidade * valorUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString () {
        return "nome: " + nome + "\nquantidade: " + quantidade + "\nvalor unitário: " + valorUnitario + "tipo: " + tipo;
    }
}
