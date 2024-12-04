package com.mycompany.delivery.models;

public class Cliente {
    private final String nome;
    private final String tipo;
    private double fidelidade;
    private final String logradouro;
    private final String bairro;
    private final String cidade;

    public Cliente (String nome, String tipo, double fidelidade, String logradouro, String bairro, String cidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setFidelidade(double fidelidade) {
        this.fidelidade = fidelidade;
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\ntipo: " + tipo + "\nfidelidade: " + fidelidade + "\nlogradouro: " + logradouro + "\nbairro: " + bairro + "\ncidade: " + cidade;
    }

}
