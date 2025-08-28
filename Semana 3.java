# Exercícios de Arrays - Estrutura de Dados em Java

    /**
     * Exercício 1:
     */
    public static void exercicio1() {
  
        int[] numeros = new int[20];
        Scanner scanner = new Scanner(System.in);
        int pares = 0, impares = 0;
        
        System.out.println("Digite 20 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
            
            // Verifica se é par ou ímpar
            if (numeros[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
      
        System.out.println("\nResultado:");
        System.out.println("Números pares: " + pares);
        System.out.println("Números ímpares: " + impares);
        
        System.out.print("Pares encontrados: ");
        for (int num : numeros) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.print("\nÍmpares encontrados: ");
        for (int num : numeros) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    
    /**
     * Exercício 2:
     */
    public static void exercicio2() {       
        int[] numeros = new int[10];
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        System.out.print("\nDigite o número que deseja buscar: ");
        int numeroBuscado = scanner.nextInt();
        
        boolean encontrado = false;
        System.out.println("\nResultado da busca:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBuscado) {
                System.out.println("Número " + numeroBuscado + " encontrado na posição " + i);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("Número " + numeroBuscado + " não foi encontrado no array.");
        }
        
        System.out.print("Array completo: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    /**
     * Exercício 3: 
     */
    public static void exercicio3() { 
        String[] nomes = new String[10];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite 10 nomes:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }
        
        System.out.println("\nArray original:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Posição " + i + ": " + nomes[i]);
        }
        
        System.out.print("\nDigite o nome que deseja remover: ");
        String nomeParaRemover = scanner.nextLine();
        
        boolean removido = false;
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equalsIgnoreCase(nomeParaRemover)) {
                nomes[i] = "---";
                removido = true;
                System.out.println("Nome removido da posição " + i);
            }
        }
        
        if (!removido) {
            System.out.println("Nome '" + nomeParaRemover + "' não foi encontrado no array.");
        }
        
        System.out.println("\nArray após remoção:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Posição " + i + ": " + nomes[i]);
        }
    }
    
    /**
     * Exercício 4: 
     */
    public static void exercicio4() {        
        int[] numeros = new int[10];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        System.out.print("\nArray: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("\nContagem de ocorrências:");
        boolean[] jaContado = new boolean[numeros.length];
        
        for (int i = 0; i < numeros.length; i++) {
            if (!jaContado[i]) {
                int contador = 1;
                
                for (int j = i + 1; j < numeros.length; j++) {
                    if (numeros[i] == numeros[j]) {
                        contador++;
                        jaContado[j] = true;
                    }
                }
                
                System.out.println("Número " + numeros[i] + " aparece " + contador + " vez(es)");
                jaContado[i] = true;
            }
        }
    }
    
    /**
     * Exercício 5: 
     */
    public static void exercicio5() {        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Quantos números deseja ordenar? ");
        int tamanho = scanner.nextInt();
        
        int[] numeros = new int[tamanho];
        
        System.out.println("Digite " + tamanho + " números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        System.out.print("\nArray original: ");
        imprimirArray(numeros);
        
        System.out.println("\nProcesso de ordenação (Bubble Sort):");
        bubbleSort(numeros);
        
        System.out.print("\nArray ordenado: ");
        imprimirArray(numeros);
    }
    
    /**
     * Bubble Sort
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;
        int passada = 1;
        
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            System.out.println("Passada " + passada + ":");
            
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  Comparando " + arr[j] + " com " + arr[j + 1] + ": ");
                
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                    System.out.println("Trocou! Array: " + arrayToString(arr));
                } else {
                    System.out.println("Não trocou. Array: " + arrayToString(arr));
                }
            }
            
            if (!trocou) {
                System.out.println("Nenhuma troca foi feita. Array já está ordenado!");
                break;
            }
            
            passada++;
        }
    }
    
