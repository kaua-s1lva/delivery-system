package com.mycompany.delivery.principal;

import java.util.Date;
import com.mycompany.delivery.descontoentrega.services.CalculadoraDeDescontoTaxaEntregaService;
import com.mycompany.delivery.descontopedido.FormaDescontoCodCupomValorPedido;
import com.mycompany.delivery.descontopedido.FormaDescontoTipoClienteValorPedido;
import com.mycompany.delivery.descontopedido.FormaDescontoTipoItemValorPedido;
import com.mycompany.delivery.descontopedido.services.CalculadoraDeDescontoValorPedidoService;
import com.mycompany.delivery.log.services.CalculadoraDeValorTotalPedidoService;
import com.mycompany.delivery.models.Cliente;
import com.mycompany.delivery.models.Item;
import com.mycompany.delivery.models.Pedido;

public class Principal {
    public static void main (String[] args) {
        Cliente cliente = new Cliente("Kaua", "Ouro", 3, "rua vitorio albani", "Cidade Maravilhosa", "Alegre");

        Item item = new Item("maça", 3, 2.5, "Alimentação");
        Item item2 = new Item("banana", 1, 5, "Educação");

        Pedido pedido = new Pedido(new Date(), cliente, 10.0);
        pedido.adicionarItem(item);
        pedido.adicionarItem(item2);

        CalculadoraDeDescontoTaxaEntregaService calculadora = new CalculadoraDeDescontoTaxaEntregaService();

        calculadora.calcularDescontoTaxaEntrega(pedido);

        CalculadoraDeDescontoValorPedidoService calculadoraValorPedido = new CalculadoraDeDescontoValorPedidoService();

        try{
            calculadoraValorPedido.aplicarDesconto(pedido, new FormaDescontoCodCupomValorPedido("DESC10"));
            calculadoraValorPedido.aplicarDesconto(pedido, new FormaDescontoTipoItemValorPedido());
            calculadoraValorPedido.aplicarDesconto(pedido, new FormaDescontoTipoClienteValorPedido());
        } catch (RuntimeException e) {
            System.out.println("Falha: " + e);
        }
        
        System.out.println("Informações do pedido: ");
        
        System.out.println(pedido.toString());
        
        CalculadoraDeValorTotalPedidoService calculadoraDeValorTotalService = new CalculadoraDeValorTotalPedidoService();
        
        calculadoraDeValorTotalService.calcularValorTotalPedido(pedido);
        
        System.out.println("\nO calculo final do valor do pedido é: " + pedido.getValorTotalPedido());
    }
}

