package service;

import model.Pedido;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PedidoPrioritarioService {
    private PriorityQueue<Pedido> filaPrioritaria;

    public PedidoPrioritarioService() {
        this.filaPrioritaria = new PriorityQueue<>(new Comparator<Pedido>() {
            public int compare(Pedido p1, Pedido p2) {
                if (p1.isVip() && !p2.isVip()) {
                    return -1;
                } else if (!p1.isVip() && p2.isVip()) {
                    return 1;
                }
                return Integer.compare(p1.getTempoPreparo(), p2.getTempoPreparo());
            }
        });
    }
    public void adicionarPedidoPrioritario(Pedido pedido) {
        filaPrioritaria.offer(pedido);
        System.out.println("✓ Pedido #" + pedido.getNumero() + " adicionado à fila prioritária!");
    }

    public Pedido atenderProximo() {
        Pedido pedido = filaPrioritaria.poll();
        if (pedido != null) {
            System.out.println("✓ Atendendo pedido prioritário #" + pedido.getNumero());
            return pedido;
        } else {
            System.out.println("✗ Fila prioritária vazia!");
            return null;
        }
    }

    public Pedido consultarProximo() {
        Pedido pedido = filaPrioritaria.peek();
        if (pedido != null) {
            System.out.println("→ Próximo prioritário: " + pedido);
            return pedido;
        } else {
            System.out.println("✗ Fila prioritária vazia!");
            return null;
        }
    }

    public void listarFilaPrioritaria() {
        System.out.println("\n=== FILA PRIORITÁRIA ===");
        if (filaPrioritaria.isEmpty()) {
            System.out.println("Fila vazia.");
        } else {
            // Cria cópia para não alterar a fila original
            PriorityQueue<Pedido> copia = new PriorityQueue<>(filaPrioritaria);
            int posicao = 1;
            while (!copia.isEmpty()) {
                System.out.println(posicao++ + ". " + copia.poll());
            }
        }
        System.out.println("Total na fila prioritária: " + filaPrioritaria.size());
    }

    public int tamanhoFila() {
        return filaPrioritaria.size();
    }
}
