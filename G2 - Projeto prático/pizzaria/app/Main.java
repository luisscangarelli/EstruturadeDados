package app;

import model.Pedido;
import service.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Pizzaria Java Delicia ===\n");

        // Inicio
        SaborService saborService = new SaborService();
        PedidoService pedidoService = new PedidoService();
        FilaEntregaService filaEntregaService = new FilaEntregaService();
        PedidoPrioritarioService pedidoPrioritarioService = new PedidoPrioritarioService();
        HistoricoCancelamentoService historicoService = new HistoricoCancelamentoService();
        VendasService vendasService = new VendasService();

        // Cadastro de Sabores
        System.out.println("\n--- Sabores ---");
        saborService.listarSabores();
        saborService.adicionarSabor("Bacon");
        saborService.adicionarSabor("Calabresa"); // vai ignorar
        saborService.listarSabores();

        // Pedidos
        System.out.println("\n--- Pedidos ---");
        Pedido p1 = pedidoService.adicionarPedido("João Silva", "Calabresa", 'G', 45.90, 25, false);
        Pedido p2 = pedidoService.adicionarPedido("Maria Santos", "Mussarela", 'M', 35.50, 20, true);
        Pedido p3 = pedidoService.adicionarPedido("Carlos Oliveira", "Portuguesa", 'G', 48.00, 30, false);
        
        pedidoService.listarPedidos();
        
        System.out.println("\nOrdenando por valor:");
        pedidoService.ordenarPorValor();
        pedidoService.listarPedidos();

        // Fila de Entregas
        System.out.println("\n--- Fila de Entregas ---");
        filaEntregaService.adicionarNaFila(p1);
        filaEntregaService.adicionarNaFila(p3);
        filaEntregaService.listarFila();
        filaEntregaService.entregarProximo();
        filaEntregaService.listarFila();

        // Pedidos Prioritarios
        System.out.println("\n--- Pedidos Prioritarios ---");
        pedidoPrioritarioService.adicionarPedidoPrioritario(p1);
        pedidoPrioritarioService.adicionarPedidoPrioritario(p2);
        pedidoPrioritarioService.listarFilaPrioritaria();

        // Cancelamentos
        System.out.println("\n--- Cancelamentos ---");
        historicoService.cancelarPedido(p3);
        historicoService.listarHistorico();

        // Vendas
        System.out.println("\n--- Vendas ---");
        vendasService.registrarVenda("Calabresa", 15);
        vendasService.registrarVenda("Mussarela", 22);
        vendasService.registrarVenda("Portuguesa", 10);
        vendasService.exibirRanking();
    }
}
