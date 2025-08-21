package controle;
import dominio.VendaProduto;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ControleVendaArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        
        VendaProduto[] vendas = new VendaProduto[5];
        int opcao;
        
        do {
            // Menu de opções
            System.out.println("\n=== SISTEMA DE VENDAS ===");
            System.out.println("1 - Cadastrar vendas");
            System.out.println("2 - Listar vendas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    cadastrarVendas(vendas, sc);
                    break;
                case 2:
                    listarVendas(vendas, df);
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
        
        sc.close();
    }
    
    // 5 vendas
    public static void cadastrarVendas(VendaProduto[] vendas, Scanner sc) {
        System.out.println("\n=== CADASTRO DE VENDAS ===");
        
        for (int i = 0; i < vendas.length; i++) {
            System.out.println("\nCadastro da venda " + (i + 1) + ":");
            
            System.out.print("Digite o número da venda: ");
            int numero = sc.nextInt();
            
            System.out.print("Digite a quantidade de produtos: ");
            int quantidade = sc.nextInt();
            
            System.out.print("Digite o valor unitário do produto: ");
            double valorUnitario = sc.nextDouble();
            
            vendas[i] = new VendaProduto(numero, quantidade, valorUnitario);
        }
        
        System.out.println("\nVendas foram cadastradas com sucesso!");
    }
    
    public static void listarVendas(VendaProduto[] vendas, DecimalFormat df) {
        System.out.println("\n=== LISTA DE VENDAS ===");
        
        // vendas cadastradas
        boolean temVendas = false;
        for (VendaProduto venda : vendas) {
            if (venda != null) {
                temVendas = true;
                break;
            }
        }
        
        if (!temVendas) {
            System.out.println("Nenhuma venda cadastrada ainda!");
            return;
        }
        
        double totalGeral = 0;
        
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null) {
                System.out.println("\n--- Venda " + (i + 1) + " ---");
                System.out.println("Número da venda: " + vendas[i].getNumero());
                System.out.println("Quantidade de produtos: " + vendas[i].getQuantidade());
                System.out.println("Valor unitário: R$ " + df.format(vendas[i].getValorUnitario()));
                System.out.println("Valor total: R$ " + df.format(vendas[i].valorPagar()));
                
                totalGeral += vendas[i].valorPagar();
            }
        }
        
        System.out.println("\n" + "=".repeat(30));
        System.out.println("TOTAL GERAL DE VENDAS: R$ " + df.format(totalGeral));
        System.out.println("=".repeat(30));
    }
}
