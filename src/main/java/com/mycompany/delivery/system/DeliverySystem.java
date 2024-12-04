package com.mycompany.delivery.system;
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
import com.mycompany.delivery.models.RegistroOperacao;
import com.mycompany.delivery.models.Item;
import com.mycompany.delivery.models.Pedido;
import com.mycompany.delivery.services.CalculadoraDeDescontoTaxaEntregaService;
import com.mycompany.delivery.services.CalculadoraDeDescontoValorPedidoService;
//import com.mycompany.delivery.log.XMLLog;
import com.mycompany.delivery.services.LogService;
import com.mycompany.delivery.services.PedidoService;

public class DeliverySystem {
    public static void main (String[] args) {
        Cliente cliente = new Cliente("Kaua", "Ouro", 3, "rua vitorio albani", "Cidade Maravilhosa", "alegre");

        Item item = new Item("maça", 3, 2.5, "Alimentação");
        Item item2 = new Item("banana", 1, 5, "Educação");

        Pedido pedido = new Pedido(new Date(), cliente, 10.0);
        pedido.adicionarItem(item);
        pedido.adicionarItem(item2);

        CalculadoraDeDescontoTaxaEntregaService calculadora = new CalculadoraDeDescontoTaxaEntregaService();

        calculadora.addFormaDesconto(pedido);

        CalculadoraDeDescontoValorPedidoService calculadoraValorPedido = new CalculadoraDeDescontoValorPedidoService();

        try{
            calculadoraValorPedido.aplicarDesconto(pedido, new FormaDescontoCodCupomValorPedido("DESC10"));
            calculadoraValorPedido.aplicarDesconto(pedido, new FormaDescontoTipoItemValorPedido());
            calculadoraValorPedido.aplicarDesconto(pedido, new FormaDescontoTipoClienteValorPedido());
        } catch (RuntimeException e) {
            System.out.println("Falha: " + e);
        }
        System.out.println(pedido.toString());

        //criação da tabela de Log
        SQLiteDAO.createRegistroTable();
        
        LogService logService = LogService.getInstance();
        logService.setLog(new XMLLog());
        logService.setFormatLog(new FormatXML());
        
     //   PedidoService.calcularValorTotalPedido(pedido);

        System.out.println(SQLiteQuery.retornaRegistros());

        PedidoService.calcularValorTotalPedido(pedido);

        //System.out.println("O calculo final do valor do pedido é: " + pedido.getValorTotalPedido());
    }
}

