package com.mycompany.delivery.system;
import java.util.Date;

import com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoCodCupomValorPedido;
import com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoTipoClienteValorPedido;
import com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoTipoItemValorPedido;
import com.mycompany.delivery.models.Cliente;
import com.mycompany.delivery.models.Cobranca;
import com.mycompany.delivery.models.Item;
import com.mycompany.delivery.models.Pedido;
import com.mycompany.delivery.services.CalculadoraDeDescontoTaxaEntregaService;
import com.mycompany.delivery.services.CalculadoraDeDescontoValorPedidoService;
import com.mycompany.delivery.tiposLog.XMLLog;

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
        //System.out.println("O calculo final do valor do pedido é: " + pedido.getValorTotalPedido());

        //Cobranca cobranca = new Cobranca(UsuarioLogadoService.getNomeUsuario(), LocalDate.now(), LocalTime.now(), pedido.getCodPedido(), "Calculo de valor total", pedido.getCliente().getNome());
        //RegistradoraLogService reg = new RegistradoraLogService();

        //reg.registrar(cobranca, new XMLLog());
/*
        Cobranca cobranca = new Cobranca();

        cobranca.registrarCobranca(pedido, new XMLLog());
        registrarCobranca() {
            pedido.getValorTotalPedido();
            obter as informações do registro
*/
    }
}

