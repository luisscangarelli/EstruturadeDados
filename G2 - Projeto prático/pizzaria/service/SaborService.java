package service;

import java.util.HashSet;
import java.util.Set;

public class SaborService {
    private Set<String> sabores;

    public SaborService() {
        this.sabores = new HashSet<>();
        inicializarSabores();
    }

    private void inicializarSabores() {
        sabores.add("Calabresa");
        sabores.add("Mussarela");
        sabores.add("Portuguesa");
        sabores.add("Frango com Catupiry");
        sabores.add("Quatro Queijos");
        sabores.add("Margherita");
        sabores.add("Pepperoni");
        sabores.add("Vegetariana");
    }

    public boolean adicionarSabor(String sabor) {
        boolean adicionado = sabores.add(sabor);
        if (adicionado) {
            System.out.println("✓ Sabor '" + sabor + "' adicionado");
        } else {
            System.out.println("✗ Sabor '" + sabor + "' já existe no cardápio.");
        }
        return adicionado;
    }

    public boolean removerSabor(String sabor) {
        boolean removido = sabores.remove(sabor);
        if (removido) {
            System.out.println("✓ Sabor '" + sabor + "' removido");
        } else {
            System.out.println("✗ Sabor '" + sabor + "' não encontrado.");
        }
        return removido;
    }

    public void listarSabores() {
        System.out.println("\n=== CARDÁPIO DE SABORES ===");
        if (sabores.isEmpty()) {
            System.out.println("Nenhum sabor cadastrado.");
        } else {
            int i = 1;
            for (String sabor : sabores) {
                System.out.println(i++ + ". " + sabor);
            }
        }
        System.out.println("Total de sabores: " + sabores.size());
    }

    public boolean verificarSabor(String sabor) {
        return sabores.contains(sabor);
    }

    public Set<String> getSabores() {
        return new HashSet<>(sabores);
    }
}
