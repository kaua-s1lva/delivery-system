package src.system;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import src.main.java.com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoCodCupomValorPedido;
import src.main.java.com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoTipoClienteValorPedido;
import src.main.java.com.mycompany.delivery.formasDescontoValorPedido.FormaDescontoTipoItemValorPedido;
import src.main.java.com.mycompany.delivery.models.Cliente;
import src.main.java.com.mycompany.delivery.models.Cobranca;
import src.main.java.com.mycompany.delivery.models.Item;
import src.main.java.com.mycompany.delivery.models.Pedido;
import src.main.java.com.mycompany.delivery.services.CalculadoraDeDescontoTaxaEntregaService;
import src.main.java.com.mycompany.delivery.services.CalculadoraDeDescontoValorPedidoService;
import src.main.java.com.mycompany.delivery.services.RegistradoraLogService;
import src.main.java.com.mycompany.delivery.services.UsuarioLogadoService;
import src.main.java.com.mycompany.delivery.tiposLog.XMLLog;

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
        System.out.println("O calculo final do valor do pedido é: " + pedido.getValorTotalPedido());

        Cobranca cobranca = new Cobranca(UsuarioLogadoService.getNomeUsuario(), LocalDate.now(), LocalTime.now(), pedido.getCodPedido(), "Calculo de valor total", pedido.getCliente().getNome());
        RegistradoraLogService reg = new RegistradoraLogService();

        reg.registrar(cobranca, new XMLLog());
    }
}
