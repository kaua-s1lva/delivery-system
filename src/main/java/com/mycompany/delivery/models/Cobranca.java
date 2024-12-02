package com.mycompany.delivery.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cobranca {
    private String nomeUsuario;
    private LocalDate data;
    private LocalTime hora;
    private int codPedido;
    private String nomeOperacao;
    private String nomeCliente;

    public Cobranca(String nomeUsuario, LocalDate data, LocalTime hora, int codPedido, String nomeOperacao, String nomeCliente) {
        this.nomeUsuario = nomeUsuario;
        this.data = data;
        this.hora = hora;
        this.codPedido = codPedido;
        this.nomeOperacao = nomeOperacao;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Cobranca [nomeUsuario=" + nomeUsuario + ", data=" + data + ", hora=" + hora + ", codPedido=" + codPedido
                + ", nomeOperacao=" + nomeOperacao + ", nomeCliente=" + nomeCliente + "]";
    }
}
