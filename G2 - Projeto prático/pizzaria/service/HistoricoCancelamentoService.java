package service;

import model.Pedido;
import java.util.Stack;

public class HistoricoCancelamentoService {
    private Stack<Pedido> historicoCancelamentos;

    public HistoricoCancelamentoService() {
        this.historicoCancelamentos = new Stack<>();
    }

    public void cancelarPedido(Pedido pedido) {
        historicoCancelamentos.push(pedido);
        System.out.println("✓ Pedido #" + pedido.getNumero() + " cancelado e adicionado");
    }

    public Pedido recuperarUltimoCancelamento() {
        if (!historicoCancelamentos.isEmpty()) {
            Pedido pedido = historicoCancelamentos.pop();
            System.out.println("✓ Último cancelamento recuperado: Pedido #" + pedido.getNumero());
            return pedido;
        } else {
            System.out.println("✗ Nenhum cancelamento");
            return null;
        }
    }

    public Pedido visualizarUltimoCancelamento() {
        if (!historicoCancelamentos.isEmpty()) {
            Pedido pedido = historicoCancelamentos.peek();
            System.out.println("→ Último cancelamento: " + pedido);
            return pedido;
        } else {
            System.out.println("✗ Nenhum cancelamento no histórico!");
            return null;
        }
    }

    public void listarHistorico() {
        System.out.println("\n=== HISTÓRICO DE CANCELAMENTOS ===");
        if (historicoCancelamentos.isEmpty()) {
            System.out.println("Nenhum cancelamento registrado.");
        } else {
            // Mostra do mais recente para o mais antigo
            for (int i = historicoCancelamentos.size() - 1; i >= 0; i--) {
                System.out.println((historicoCancelamentos.size() - i) + ". " + historicoCancelamentos.get(i));
            }
        }
        System.out.println("Total de cancelamentos: " + historicoCancelamentos.size());
    }

    public int totalCancelamentos() {
        return historicoCancelamentos.size();
    }

    public boolean historicoVazio() {
        return historicoCancelamentos.isEmpty();
    }
}
