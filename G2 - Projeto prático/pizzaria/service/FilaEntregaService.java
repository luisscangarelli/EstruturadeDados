package service;

import model.Pedido;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Tarefa 3: Fila de Entregas usando Queue (LinkedList)
 */
public class FilaEntregaService {
    private Queue<Pedido> filaEntregas;

    public FilaEntregaService() {
        this.filaEntregas = new LinkedList<>();
    }

    public void adicionarNaFila(Pedido pedido) {
        filaEntregas.offer(pedido);
        System.out.println("✓ Pedido #" + pedido.getNumero() + " adicionado à fila de entregas!");
    }

    public Pedido entregarProximo() {
        Pedido pedido = filaEntregas.poll();
        if (pedido != null) {
            System.out.println("✓ Pedido #" + pedido.getNumero() + " entregue!");
            return pedido;
        } else {
            System.out.println("✗ Fila de entregas vazia!");
            return null;
        }
    }

    public Pedido consultarProximo() {
        Pedido pedido = filaEntregas.peek();
        if (pedido != null) {
            System.out.println("→ Próximo da fila: " + pedido);
            return pedido;
        } else {
            System.out.println("✗ Fila de entregas vazia!");
            return null;
        }
    }

    public boolean filaVazia() {
        return filaEntregas.isEmpty();
    }

    public void listarFila() {
        System.out.println("\n=== FILA DE ENTREGAS ===");
        if (filaEntregas.isEmpty()) {
            System.out.println("Fila vazia.");
        } else {
            int posicao = 1;
            for (Pedido pedido : filaEntregas) {
                System.out.println(posicao++ + ". " + pedido);
            }
        }
        System.out.println("Total na fila: " + filaEntregas.size());
    }

    public int tamanhoFila() {
        return filaEntregas.size();
    }
}
