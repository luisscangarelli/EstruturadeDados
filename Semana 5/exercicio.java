  // ==================== EXERCÍCIO 1 ====================
    
    public static void exercicio1() {
        System.out.println("=== EXERCÍCIO 1 ===");
        
        LinkedList<Integer> numeros = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        
        System.out.println("Lista original: " + numeros);
        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            Integer numero = iterator.next();
            if (numero % 2 == 0) {
                iterator.remove();
            }
        }
        
        System.out.println("Lista após remover pares: " + numeros);
        System.out.println();
    }

    // ==================== EXERCÍCIO 2 ====================
    
    static class FilaBanco {
        private LinkedList<String> fila;
        
        public FilaBanco() {
            this.fila = new LinkedList<>();
        }
        
        public void adicionarCliente(String nome) {
            fila.addLast(nome);
            System.out.println(nome + " entrou na fila.");
        }
        
        public String atenderCliente() {
            if (fila.isEmpty()) {
                return "Fila vazia! Nenhum cliente para atender.";
            }
            String cliente = fila.removeFirst();
            return cliente + " foi atendido.";
        }
        
        public String proximoCliente() {
            if (fila.isEmpty()) {
                return "Fila vazia!";
            }
            return "Próximo cliente: " + fila.getFirst();
        }
        
        public void exibirFila() {
            if (fila.isEmpty()) {
                System.out.println("Fila vazia!");
            } else {
                System.out.println("Clientes na fila: " + fila);
            }
        }
        
        public int tamanhoFila() {
            return fila.size();
        }
    }
    
    public static void exercicio2() {
        System.out.println("=== EXERCÍCIO 2 ===");
        
        FilaBanco banco = new FilaBanco();
        banco.adicionarCliente("João Silva");
        banco.adicionarCliente("Maria Santos");
        banco.adicionarCliente("Pedro Oliveira");
        banco.adicionarCliente("Ana Costa");
        
        System.out.println();
        banco.exibirFila();
        System.out.println("Tamanho da fila: " + banco.tamanhoFila());
        
        System.out.println();
        System.out.println(banco.proximoCliente());
        
        System.out.println();
        // Atendendo clientes
        System.out.println(banco.atenderCliente());
        System.out.println(banco.atenderCliente());
        
        System.out.println();
        banco.exibirFila();
        
        System.out.println();
        banco.adicionarCliente("Carlos Mendes");
        banco.exibirFila();
        System.out.println();
    }

    // ==================== EXERCÍCIO 3 ====================
    static class NavegadorWeb {
        private LinkedList<String> historico;
        private LinkedList<String> historicoAvanco;
        private String paginaAtual;
        
        public NavegadorWeb() {
            this.historico = new LinkedList<>();
            this.historicoAvanco = new LinkedList<>();
            this.paginaAtual = null;
        }
        
        public void visitarPagina(String url) {
            if (paginaAtual != null) {
                historico.push(paginaAtual);
            }
            paginaAtual = url;
            historicoAvanco.clear(); // Limpa histórico de avanço ao visitar nova página
            System.out.println("Visitando: " + url);
        }
        
        public void voltar() {
            if (historico.isEmpty()) {
                System.out.println("Não há páginas anteriores!");
                return;
            }
            historicoAvanco.push(paginaAtual);
            paginaAtual = historico.pop();
            System.out.println("Voltando para: " + paginaAtual);
        }
        
        public void avancar() {
            if (historicoAvanco.isEmpty()) {
                System.out.println("Não há páginas para avançar!");
                return;
            }
            historico.push(paginaAtual);
            paginaAtual = historicoAvanco.pop();
            System.out.println("Avançando para: " + paginaAtual);
        }
        public void exibirPaginaAtual() {
            if (paginaAtual == null) {
                System.out.println("Nenhuma página visitada ainda.");
            } else {
                System.out.println("Página atual: " + paginaAtual);
            }
        }
        
        public void exibirHistorico() {
            System.out.println("--- Histórico de Navegação ---");
            System.out.println("Páginas anteriores: " + historico);
            System.out.println("Página atual: " + paginaAtual);
            System.out.println("Páginas para avançar: " + historicoAvanco);
        }
    }
    
    public static void exercicio3() {
        System.out.println("=== EXERCÍCIO 3 ===");
        
        NavegadorWeb navegador = new NavegadorWeb();

        navegador.visitarPagina("www.google.com");
        navegador.visitarPagina("www.youtube.com");
        navegador.visitarPagina("www.github.com");
        navegador.visitarPagina("www.stackoverflow.com");
        
        System.out.println();
        navegador.exibirPaginaAtual();
        
        System.out.println();
        navegador.voltar();
        navegador.voltar();
        
        System.out.println();
        navegador.exibirPaginaAtual();
        
        System.out.println();
        navegador.avancar();
        
        System.out.println();
        navegador.exibirHistorico();
        
        System.out.println();
        navegador.visitarPagina("www.linkedin.com");
        
        System.out.println();
        navegador.exibirHistorico();
        
        System.out.println();
    }

    // ==================== EXERCÍCIO 4 ====================   
    public static void exercicio4() {
        System.out.println("=== EXERCÍCIO 4 ===");
        
        int numeroInsercoes = 100000;
        
        // Teste com ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        long inicioArrayList = System.nanoTime();
        
        for (int i = 0; i < numeroInsercoes; i++) {
            arrayList.add(0, i);
        }
        
        long fimArrayList = System.nanoTime();
        long tempoArrayList = (fimArrayList - inicioArrayList) / 1_000_000; 
        
        LinkedList<Integer> linkedList = new LinkedList<>();
        long inicioLinkedList = System.nanoTime();
        
        for (int i = 0; i < numeroInsercoes; i++) {
            linkedList.addFirst(i); 
        }
        
        long fimLinkedList = System.nanoTime();
        long tempoLinkedList = (fimLinkedList - inicioLinkedList) / 1_000_000; 
        
        System.out.println("Comparação de Desempenho - Inserção no Início");
        System.out.println("Número de inserções: " + numeroInsercoes);
        System.out.println();
        
        System.out.println("ArrayList:");
        System.out.println("  Tempo: " + tempoArrayList + " ms");
        System.out.println("  Complexidade: O(n) - precisa deslocar todos os elementos");
        System.out.println();
        
        System.out.println("LinkedList:");
        System.out.println("  Tempo: " + tempoLinkedList + " ms");
        System.out.println("  Complexidade: O(1) - apenas atualiza referências");
        System.out.println();
        
        if (tempoLinkedList < tempoArrayList) {
            double percentual = ((double)(tempoArrayList - tempoLinkedList) / tempoArrayList) * 100;
            System.out.println("LinkedList foi " + String.format("%.2f", percentual) + "% mais rápida!");
        } else {
            System.out.println("ArrayList foi mais rápida (caso incomum).");
        }
        
        System.out.println();    
    }
///////////////////////////
