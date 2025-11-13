package service;

import java.util.*;

/**
 * Tarefa 6: Registro de Vendas por Sabor usando HashMap
 */
public class VendasService {
    private Map<String, Integer> vendasPorSabor;

    public VendasService() {
        this.vendasPorSabor = new HashMap<>();
    }

    public void registrarVenda(String sabor) {
        vendasPorSabor.put(sabor, vendasPorSabor.getOrDefault(sabor, 0) + 1);
        System.out.println("✓ Venda de " + sabor + " registrada!");
    }

    public void registrarVenda(String sabor, int quantidade) {
        vendasPorSabor.put(sabor, vendasPorSabor.getOrDefault(sabor, 0) + quantidade);
        System.out.println("✓ " + quantidade + " venda(s) de " + sabor + " registrada(s)!");
    }

    public int consultarVendasPorSabor(String sabor) {
        int vendas = vendasPorSabor.getOrDefault(sabor, 0);
        System.out.println("→ Total de vendas de " + sabor + ": " + vendas);
        return vendas;
    }

    public void exibirRanking() {
        System.out.println("\n=== RANKING DE SABORES MAIS VENDIDOS ===");
        
        if (vendasPorSabor.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        // Converte o Map em Lista para ordenar
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(vendasPorSabor.entrySet());
        
        // Ordena por quantidade (decrescente)
        Collections.sort(ranking, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Ordem decrescente
            }
        });

        // Exibe o ranking
        int posicao = 1;
        for (Map.Entry<String, Integer> entry : ranking) {
            System.out.printf("%d. %s - %d vendas\n", posicao++, entry.getKey(), entry.getValue());
        }
        
        System.out.println("\nTotal de sabores vendidos: " + vendasPorSabor.size());
    }

    public void listarTodosSaboresVendidos() {
        System.out.println("\n=== TODOS OS SABORES VENDIDOS ===");
        if (vendasPorSabor.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Map.Entry<String, Integer> entry : vendasPorSabor.entrySet()) {
                System.out.printf("- %s: %d vendas\n", entry.getKey(), entry.getValue());
            }
        }
    }

    public int totalVendas() {
        int total = 0;
        for (int quantidade : vendasPorSabor.values()) {
            total += quantidade;
        }
        return total;
    }

    public Map<String, Integer> getVendasPorSabor() {
        return new HashMap<>(vendasPorSabor);
    }
}
