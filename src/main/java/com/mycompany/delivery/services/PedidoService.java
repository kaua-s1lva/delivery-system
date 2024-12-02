package src.main.java.com.mycompany.delivery.services;

import src.main.java.com.mycompany.delivery.interfaces.ILog;
import src.main.java.com.mycompany.delivery.models.Cobranca;
import java.time.LocalDate;
import java.time.LocalTime;
import src.main.java.com.mycompany.delivery.models.Pedido;
import src.main.java.com.mycompany.delivery.services.UsuarioLogadoService;

public class PedidoService {
    private ILog log;
    
    public PedidoService(ILog log){
        if(log == null) throw new IllegalArgumentException("Escolha do metodo de log invalida ");
        this.log = log;
    }
    
    public double calcularValorTotalPedido(Pedido pedido){
        double valorTotal = pedido.getValorTotalPedido();
        
        String NOME_DO_METODO = "getValorTotalPedido";
        String nomeOperacao = "Calculo do valor total do pedido (" + NOME_DO_METODO + ")";
        registrarLog(new Cobranca(UsuarioLogadoService.getNomeUsuario(), LocalDate.now(), LocalTime.now(), pedido.getCodPedido(),nomeOperacao, pedido.getCliente().getNome()));
        
        return valorTotal;
    }
    
    private void registrarLog(Cobranca cobranca) {
        log.escreverMensagem(cobranca.toString());
    }
}
