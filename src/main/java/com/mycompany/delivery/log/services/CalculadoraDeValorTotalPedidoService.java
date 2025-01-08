/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery.log.services;

import com.mycompany.delivery.services.UsuarioLogadoService;
import com.mycompany.delivery.log.models.RegistroOperacao;
import com.mycompany.delivery.models.Pedido;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author tetzner
 */
public class CalculadoraDeValorTotalPedidoService {

    public static double calcularValorTotalPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        
        double valorTotal = pedido.getValorTotalPedido();
        
        String NOME_DO_METODO = "getValorTotalPedido";
        String nomeOperacao = "Calculo do valor total do pedido (" + NOME_DO_METODO + ")";
        LogService.registrarLog(new RegistroOperacao(UsuarioLogadoService.getNomeUsuario(), LocalDate.now(), LocalTime.now(), pedido.getCodPedido(),nomeOperacao, pedido.getCliente().getNome()));
        return valorTotal;  
        
    }
    
}
