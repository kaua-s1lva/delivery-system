package com.mycompany.delivery.principal;
import java.util.Date;

import com.mycompany.delivery.DAO.SQLiteDAO;
import com.mycompany.delivery.DAO.SQLiteQuery;
import com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoCodCupomValorPedido;
import com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoTipoClienteValorPedido;
import com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoTipoItemValorPedido;
import com.mycompany.delivery.format.FormatJSON;
import com.mycompany.delivery.format.FormatSQL;
import com.mycompany.delivery.format.FormatXML;
import com.mycompany.delivery.log.DBLog;
import com.mycompany.delivery.log.JSONLog;
import com.mycompany.delivery.log.XMLLog;
import com.mycompany.delivery.models.Cliente;
import com.mycompany.delivery.models.Item;
import com.mycompany.delivery.models.Pedido;
import com.mycompany.delivery.services.CalculadoraDeDescontoTaxaEntregaService;
import com.mycompany.delivery.services.CalculadoraDeDescontoValorPedidoService;
import com.mycompany.delivery.services.LogService;
import com.mycompany.delivery.services.PedidoService;

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

        // Criação da tabela de Log
        SQLiteDAO.createRegistroTable();
        
        // Set tipo de Log e formato de Log
        LogService logService = LogService.getInstance();
        logService.setLog(new XMLLog());
        logService.setFormatLog(new FormatXML());
        
       // System.out.println(SQLiteQuery.retornaRegistros());
        
        System.out.println("Informações do pedido: ");
        
        System.out.println(pedido.toString());
        
        double valorTotal = PedidoService.calcularValorTotalPedido(pedido);
        
        System.out.println("\nO calculo final do valor do pedido é: " + valorTotal);
    }
}

