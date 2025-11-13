package service;

import model.Pedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidosAbertos;
    private int proximoNumero;

    public PedidoService() {
        this.pedidosAbertos = new ArrayList<>();
        this.proximoNumero = 1;
    }

    public Pedido adicionarPedido(String cliente, String sabor, char tamanho, double valor, int tempoPreparo, boolean vip) {
        Pedido pedido = new Pedido(proximoNumero++, cliente, sabor, tamanho, valor, tempoPreparo, vip);
        pedidosAbertos.add(pedido);
        System.out.println("✓ Pedido #" + pedido.getNumero() + " adicionado");
        return pedido;
    }

    public void listarPedidos() {
        System.out.println("\n=== PEDIDOS ABERTOS ===");
        if (pedidosAbertos.isEmpty()) {
            System.out.println("Nenhum pedido em aberto.");
        } else {
            for (Pedido pedido : pedidosAbertos) {
                System.out.println(pedido);
            }
        }
        System.out.println("Total de pedidos: " + pedidosAbertos.size());
    }

    public Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido pedido : pedidosAbertos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public void ordenarPorValor() {
        Collections.sort(pedidosAbertos, new Comparator<Pedido>() {
            @Override
            public int compare(Pedido p1, Pedido p2) {
                return Double.compare(p1.getValor(), p2.getValor());
            }
        });
        System.out.println("✓ Pedidos ordenados por valor!");
    }

    public void ordenarPorCliente() {
        Collections.sort(pedidosAbertos, new Comparator<Pedido>() {
            @Override
            public int compare(Pedido p1, Pedido p2) {
                return p1.getCliente().compareToIgnoreCase(p2.getCliente());
            }
        });
        System.out.println("Pedidos ordenados por nome do cliente!");
    }

    public boolean removerPedido(int numero) {
        Pedido pedido = buscarPedidoPorNumero(numero);
        if (pedido != null) {
            pedidosAbertos.remove(pedido);
            System.out.println("✓ Pedido #" + numero + " removido!");
            return true;
        }
        System.out.println("✗ Pedido #" + numero + " não encontrado.");
        return false;
    }

    public List<Pedido> getPedidosAbertos() {
        return new ArrayList<>(pedidosAbertos);
    }

    public int getQuantidadePedidos() {
        return pedidosAbertos.size();
    }
}
