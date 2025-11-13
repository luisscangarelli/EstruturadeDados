
    // ==================== EXERCÍCIO 1 ====================
    // Criar e manipular uma LinkedList 
        LinkedList<String> alunos = new LinkedList<>();
        
        // a) Adicionar 5 nomes
        alunos.add("Carlos");
        alunos.add("Maria");
        alunos.add("João");
        alunos.add("Ana");
        alunos.add("Pedro");
        
        System.out.println("Lista original: " + alunos);
        
        // b) Remover o primeiro nome da lista
        String removido = alunos.removeFirst();
        System.out.println("Primeiro nome removido: " + removido);
        System.out.println("Lista após remoção: " + alunos);
        
        // c) Exibir o último nome
        System.out.println("Último nome: " + alunos.getLast());,
        
        // d) Exibir todos os nomes usando for-each
        System.out.println("Todos os nomes:");
        for (String aluno : alunos) {
            System.out.println("  - " + aluno);
        }
        System.out.println();
    }

    // ==================== EXERCÍCIO 1.2 ====================
    // Inserção em posições específicas
    
    public static void exercicio1_2() {
        System.out.println("=== EXERCÍCIO 1.2 ===");
        
        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        
        System.out.println("Lista original: " + numeros);
        
        // a) Insira o valor 5 no início
        numeros.addFirst(5);
        System.out.println("Após inserir 5 no início: " + numeros);
        
        // b) Insira o valor 60 no final
        numeros.addLast(60);
        System.out.println("Após inserir 60 no final: " + numeros);
        
        // c) Insira o valor 25 na posição 3
        numeros.add(3, 25);
        System.out.println("Após inserir 25 na posição 3: " + numeros);
        
        // d) Exiba a lista final
        System.out.println("Lista final: " + numeros);
        System.out.println();
    }

    // ==================== EXERCÍCIO 1.3 ====================
    // Remover elementos específicos
    
    public static void exercicio1_3() {
        System.out.println("=== EXERCÍCIO 1.3 ===");
        
        LinkedList<String> linguagens = new LinkedList<>();
        
        // 1. Adicione os elementos
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("C++");
        linguagens.add("Java");
        linguagens.add("Go");
        
        System.out.println("Lista original: " + linguagens);
        
        // 2. Remova apenas a primeira ocorrência de "Java"
        linguagens.remove("Java");
        System.out.println("Após remover primeira ocorrência de Java: " + linguagens);
        
        // 3. Remova o elemento "C++"
        linguagens.remove("C++");
        System.out.println("Após remover C++: " + linguagens);
        
        // 4. Exiba o resultado
        System.out.println("Lista final: " + linguagens);
        System.out.println();
    }

    // ==================== EXERCÍCIO 2.1 ====================
    // Simulação simples de fila de atendimento
    
    public static void exercicio2_1() {
        System.out.println("=== EXERCÍCIO 2.1 ===");
        
        Queue<String> fila = new LinkedList<>();
        
        // a) Adicione 4 pessoas à fila
        fila.offer("João");
        fila.offer("Maria");
        fila.offer("Carlos");
        fila.offer("Ana");
        
        System.out.println("Fila inicial: " + fila);
        
        // b) Mostre quem é o próximo da fila (peek)
        System.out.println("Próximo da fila: " + fila.peek());
        
        // c) Atenda 2 pessoas usando poll()
        System.out.println("Atendendo: " + fila.poll());
        System.out.println("Atendendo: " + fila.poll());
        
        // d) Exiba a fila restante
        System.out.println("Fila restante: " + fila);
        System.out.println();
    }

    // ==================== EXERCÍCIO 2.2 ====================
    // Controle de pedidos
    
    public static void exercicio2_2() {
        System.out.println("=== EXERCÍCIO 2.2 ===");
        
        Queue<String> pedidos = new LinkedList<>();
        
        // Criar fila inicial
        pedidos.offer("Pedido #1");
        pedidos.offer("Pedido #2");
        pedidos.offer("Pedido #3");
        
        System.out.println("Fila inicial: " + pedidos);
        
        // a) Adicione o "Pedido #4"
        pedidos.offer("Pedido #4");
        System.out.println("Após adicionar Pedido #4: " + pedidos);
        
        // b) Atenda dois pedidos
        System.out.println("Atendendo: " + pedidos.poll());
        System.out.println("Atendendo: " + pedidos.poll());
        
        // c) Mostre o tamanho da fila
        System.out.println("Tamanho da fila: " + pedidos.size());
        
        // d) Informe se a fila está vazia
        System.out.println("A fila está vazia? " + pedidos.isEmpty());
        System.out.println("Fila atual: " + pedidos);
        System.out.println();
    }

    // ==================== EXERCÍCIO 2.3 ====================
    // Verificação de prioridade simples
    
    public static void exercicio2_3() {
        System.out.println("=== EXERCÍCIO 2.3 ===");
        
        Queue<String> pacientes = new LinkedList<>();
        
        // Criar fila inicial
        pacientes.offer("Lucas");
        pacientes.offer("Bruna");
        pacientes.offer("José");
        pacientes.offer("Ana");
        
        System.out.println("Fila inicial: " + pacientes);
        
        // a) Adicionar "Maria" no final
        pacientes.offer("Maria");
        System.out.println("Após adicionar Maria: " + pacientes);
        
        // b) Atender 3 pacientes com poll()
        System.out.println("Atendendo: " + pacientes.poll());
        System.out.println("Atendendo: " + pacientes.poll());
        System.out.println("Atendendo: " + pacientes.poll());
        
        // c) Mostrar quem será o próximo a ser atendido
        System.out.println("Próximo a ser atendido: " + pacientes.peek());
        
        // d) Exibir os pacientes restantes
        System.out.println("Pacientes restantes: " + pacientes);
        System.out.println();
    }

    // ==================== EXERCÍCIO 3.1 ====================
    // Pilha de navegação (simples)
    
    public static void exercicio3_1() {
        System.out.println("=== EXERCÍCIO 3.1 ===");
        
        Stack<String> pilha = new Stack<>();
        
        // a) Empilhe as páginas
        pilha.push("Home");
        pilha.push("Produtos");
        pilha.push("Carrinho");
        pilha.push("Pagamento");
        
        System.out.println("Pilha de páginas: " + pilha);
        
        // b) Mostre a página atual (peek())
        System.out.println("Página atual: " + pilha.peek());
        
        // c) Volte duas páginas usando pop()
        System.out.println("Voltando de: " + pilha.pop());
        System.out.println("Voltando de: " + pilha.pop());
        
        // d) Exiba a pilha final
        System.out.println("Pilha final: " + pilha);
        System.out.println("Página atual: " + pilha.peek());
        System.out.println();
    }

    // ==================== EXERCÍCIO 3.2 ====================
    // Pilha de números
    
    public static void exercicio3_2() {
        System.out.println("=== EXERCÍCIO 3.2 ===");
        
        Stack<Integer> pilha = new Stack<>();
        
        // 1. Empilhe os números
        pilha.push(2);
        pilha.push(4);
        pilha.push(6);
        pilha.push(8);
        pilha.push(10);
        
        System.out.println("Pilha inicial: " + pilha);
        System.out.println("Tamanho inicial: " + pilha.size());
        
        // 2. Desempilhe até sobrar apenas dois elementos
        while (pilha.size() > 2) {
            System.out.println("Desempilhando: " + pilha.pop());
        }
        
        // 3. Mostre o elemento do topo
        System.out.println("Elemento do topo: " + pilha.peek());
        
        // 4. Mostre o tamanho da pilha
        System.out.println("Tamanho final: " + pilha.size());
        System.out.println("Pilha final: " + pilha);
        System.out.println();
    }

    // ==================== EXERCÍCIO 3.3 ====================
    // Verificação de sequência invertida
    
    public static void exercicio3_3() {
        System.out.println("=== EXERCÍCIO 3.3 ===");
        
        int[] array = {7, 14, 21, 28};
        Stack<Integer> pilha = new Stack<>();
        
        System.out.println("Array original:");
        System.out.print("[ ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        
        // a) Empilhar todos os elementos
        for (int num : array) {
            pilha.push(num);
        }
        
        System.out.println("Pilha após empilhar: " + pilha);
        
        // b) Desempilhar (exibir cada remoção)
        System.out.println("\nDesempilhando elementos:");
        while (!pilha.isEmpty()) {
            System.out.println("  Removido: " + pilha.pop());
        }
        
        // c) Verificar que a ordem agora é invertida
        System.out.println("\nObservação: A ordem de remoção é inversa à ordem original!");
        System.out.println();
    }

    // ==================== EXERCÍCIO 4.1 ====================
    // Sistema de edição de texto com desfazer (undo)
    
    public static void exercicio4_1() {
        System.out.println("=== EXERCÍCIO 4.1 ===");
        
        Stack<String> operacoes = new Stack<>();
        
        // a) Simule as operações
        operacoes.push("Digitar A");
        operacoes.push("Digitar B");
        operacoes.push("Digitar C");
        
        System.out.println("Operações realizadas: " + operacoes);
        
        // b) Realize 1 operação "desfazer" usando pop()
        String desfeito = operacoes.pop();
        System.out.println("Operação desfeita: " + desfeito);
        
        // c) Exiba o que ainda está na pilha
        System.out.println("Operações restantes: " + operacoes);
        System.out.println("Última operação mantida: " + operacoes.peek());
        System.out.println();
    }

    // ==================== EXERCÍCIO 4.2 ====================
    // Controle de ônibus com duas estruturas
    
    public static void exercicio4_2() {
        System.out.println("=== EXERCÍCIO 4.2 ===");
        
        // Fila para pessoas
        Queue<String> filaPessoas = new LinkedList<>();
        filaPessoas.offer("Pessoa 1");
        filaPessoas.offer("Pessoa 2");
        filaPessoas.offer("Pessoa 3");
        
        // Pilha para malas
        Stack<String> pilhaMalas = new Stack<>();
        pilhaMalas.push("Mala A");
        pilhaMalas.push("Mala B");
        pilhaMalas.push("Mala C");
        
        System.out.println("Situação inicial:");
        System.out.println("  Fila de pessoas: " + filaPessoas);
        System.out.println("  Pilha de malas: " + pilhaMalas);
        
        // a) Atender 2 pessoas
        System.out.println("\nAtendendo pessoas:");
        System.out.println("  Entrando: " + filaPessoas.poll());
        System.out.println("  Entrando: " + filaPessoas.poll());
        
        // b) Guardar 2 malas
        System.out.println("\nGuardando malas:");
        System.out.println("  Guardada: " + pilhaMalas.pop());
        System.out.println("  Guardada: " + pilhaMalas.pop());
        
        // c) Exibir situação da fila e da pilha
        System.out.println("\nSituação final:");
        System.out.println("  Fila de pessoas restante: " + filaPessoas);
        System.out.println("  Pilha de malas restante: " + pilhaMalas);
        System.out.println();
    }

    // ==================== EXERCÍCIO 4.3 ====================
    // Armazenamento híbrido com LinkedList
    
    public static void exercicio4_3() {
        System.out.println("=== EXERCÍCIO 4.3 ===");
        
        LinkedList<Integer> lista = new LinkedList<>();
        
        System.out.println("Lista inicial: " + lista);
        
        // a) addFirst(10)
        lista.addFirst(10);
        System.out.println("Após addFirst(10): " + lista);
        
        // b) addLast(20)
        lista.addLast(20);
        System.out.println("Após addLast(20): " + lista);
        
        // c) push(30)
        lista.push(30);
        System.out.println("Após push(30): " + lista);
        
        // d) pop()
        Integer removido = lista.pop();
        System.out.println("Após pop() - removido: " + removido);
        
        // e) Exiba a lista final
        System.out.println("Lista final: " + lista);
        
        System.out.println("\nObservação:");
        System.out.println("  - addFirst() e push() adicionam no início");
        System.out.println("  - addLast() adiciona no final");
        System.out.println("  - pop() remove do início");
        System.out.println();
    }
    }
}
