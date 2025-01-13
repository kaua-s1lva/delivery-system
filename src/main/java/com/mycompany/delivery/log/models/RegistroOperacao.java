package com.mycompany.delivery.log.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroOperacao {
    private final String nomeUsuario;
    private final LocalDate data;
    private final LocalTime hora;
    private final int codPedido;
    private final String nomeOperacao;
    private final String nomeCliente;
    private final double valorTotalPedido;

    public RegistroOperacao(String nomeUsuario, LocalDate data, LocalTime hora, int codPedido, String nomeOperacao, String nomeCliente, double valorTotalPedido) {
        this.nomeUsuario = nomeUsuario;
        this.data = data;
        this.hora = hora;
        this.codPedido = codPedido;
        this.nomeOperacao = nomeOperacao;
        this.nomeCliente = nomeCliente;
        this.valorTotalPedido = valorTotalPedido;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    @Override
    public String toString() {
        return "Registro do calculo do valor total do pedido: " + "nomeUsuario = " + nomeUsuario + ", data = " + data + ", hora = " + hora + ", codPedido = " + codPedido + ", nomeOperacao = " + nomeOperacao + ", nomeCliente = " + nomeCliente + ", valorTotalPedido = " + valorTotalPedido;
    }

}
