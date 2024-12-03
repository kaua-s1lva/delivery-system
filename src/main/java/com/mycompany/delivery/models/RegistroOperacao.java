package com.mycompany.delivery.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroOperacao {
    private final String nomeUsuario;
    private final LocalDate data;
    private final LocalTime hora;
    private final int codPedido;
    private final String nomeOperacao;
    private final String nomeCliente;

    public RegistroOperacao(String nomeUsuario, LocalDate data, LocalTime hora, int codPedido, String nomeOperacao, String nomeCliente) {
        this.nomeUsuario = nomeUsuario;
        this.data = data;
        this.hora = hora;
        this.codPedido = codPedido;
        this.nomeOperacao = nomeOperacao;
        this.nomeCliente = nomeCliente;
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

    @Override
    public String toString() {
        return nomeUsuario + ";" + data.toString() + ";" + hora.toString() + ";" + ";" + codPedido + ";" + nomeOperacao + ";" + nomeCliente;
    } 
}
