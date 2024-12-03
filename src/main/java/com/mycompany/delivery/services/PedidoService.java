/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery.services;

import com.mycompany.delivery.models.RegistroOperacao;
import com.mycompany.delivery.models.Pedido;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author tetzner
 */
public class PedidoService {
    
    
    public static double calcularValorTotalPedido(Pedido pedido) {
        
        double valorTotal = pedido.getValorTotalPedido();
        
        String NOME_DO_METODO = "getValorTotalPedido";
        String nomeOperacao = "Calculo do valor total do pedido (" + NOME_DO_METODO + ")";
        LogService.registrar(new RegistroOperacao(UsuarioLogadoService.getNomeUsuario(), LocalDate.now(), LocalTime.now(), pedido.getCodPedido(),nomeOperacao, pedido.getCliente().getNome()));
        return valorTotal;
        
        
    }
    
}
