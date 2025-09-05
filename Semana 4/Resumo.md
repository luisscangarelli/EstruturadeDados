# Análise Detalhada dos Projetos Java de Ordenação

## Introdução

Este documento apresenta uma análise detalhada de três projetos Java que implementam diferentes algoritmos de ordenação usando o método Bubble Sort. Os projetos demonstram conceitos fundamentais de programação, desde estruturas simples até arquiteturas mais organizadas seguindo princípios de orientação a objetos.

## Projeto 1: OrdenarNumeros.java

### Visão Geral
O primeiro projeto é uma aplicação simples que ordena 10 números inteiros em ordem crescente utilizando o algoritmo Bubble Sort. Toda a lógica está concentrada em um único arquivo e método.

### Análise do Método Principal (main)

#### **Inicialização e Entrada de Dados**
```java
Scanner scanner = new Scanner(System.in);
int[] numeros = new int[10];
```
O método inicia criando um objeto Scanner para capturar entrada do usuário e um array de inteiros com capacidade para 10 elementos.

#### **Coleta de Dados**
```java
for (int i = 0; i < numeros.length; i++) {
    numeros[i] = scanner.nextInt();
}
```
Este loop percorre o array solicitando ao usuário que digite 10 números inteiros, armazenando cada valor na posição correspondente do array.

#### **Algoritmo de Ordenação (Bubble Sort)**
```java
for (int i = 0; i < numeros.length - 1; i++) {
    for (int j = 0; j < numeros.length - i - 1; j++) {
        if (numeros[j] > numeros[j + 1]) {
            int temp = numeros[j];
            numeros[j] = numeros[j + 1];
            numeros[j + 1] = temp;
        }
    }
}
```
O Bubble Sort implementado utiliza dois loops aninhados:
- **Loop externo (i)**: Controla o número de passadas pelo array
- **Loop interno (j)**: Compara elementos adjacentes
- **Condição de troca**: Quando `numeros[j] > numeros[j + 1]`, os elementos são trocados
- **Otimização**: `numeros.length - i - 1` reduz comparações desnecessárias a cada passada

#### **Exibição dos Resultados**
```java
for (int numero : numeros) {
    System.out.print(numero + " ");
}
```
Utiliza um enhanced for loop para exibir os números ordenados.

### Características do Projeto
- **Estrutura**: Monolítica, tudo em um método
- **Complexidade**: O(n²) devido ao Bubble Sort
- **Funcionalidade**: Ordenação crescente de números inteiros

---

## Projeto 2: OrdenaProdutos.java

### Visão Geral
Este projeto ordena produtos por preço em ordem decrescente, mantendo a associação entre nome e preço através de manipulação sincronizada de dois arrays.

### Análise Detalhada dos Métodos

#### **Inicialização de Estruturas**
```java
String[] nomes = new String[10];
double[] precos = new double[10];
```
Utiliza dois arrays paralelos para armazenar nomes (String) e preços (double) dos produtos.

#### **Coleta de Dados dos Produtos**
```java
for (int i = 0; i < 10; i++) {
    System.out.print("Nome do produto " + (i + 1) + ": ");
    nomes[i] = scanner.nextLine();
    System.out.print("Preço do produto " + (i + 1) + ": ");
    precos[i] = scanner.nextDouble();
    scanner.nextLine(); // Consumir a quebra de linha
}
```
**Funcionamento do loop de entrada:**
- Solicita o nome do produto usando `nextLine()` para capturar strings com espaços
- Solicita o preço usando `nextDouble()`
- **Linha crítica**: `scanner.nextLine()` consume a quebra de linha deixada pelo `nextDouble()`, evitando problemas na próxima iteração

#### **Algoritmo de Ordenação Decrescente**
```java
for (int i = 0; i < precos.length - 1; i++) {
    for (int j = 0; j < precos.length - i - 1; j++) {
        if (precos[j] < precos[j + 1]) {  // Ordem decrescente
            // Troca preços
            double tempPreco = precos[j];
            precos[j] = precos[j + 1];
            precos[j + 1] = tempPreco;
            // Troca nomes para manter a associação
            String tempNome = nomes[j];
            nomes[j] = nomes[j + 1];
            nomes[j + 1] = tempNome;
        }
    }
}
```

**Características especiais:**
- **Condição invertida**: `precos[j] < precos[j + 1]` para ordem decrescente
- **Sincronização de arrays**: Quando preços são trocados, os nomes correspondentes também são trocados
- **Manutenção de integridade**: Garante que cada produto mantenha seu nome associado ao preço correto

#### **Exibição Formatada**
```java
for (int i = 0; i < 10; i++) {
    System.out.println(nomes[i] + " - R$ " + String.format("%.2f", precos[i]));
}
```
Utiliza `String.format("%.2f", precos[i])` para formatar preços com duas casas decimais.

### Desafios e Soluções
- **Arrays paralelos**: Mantém sincronização entre dados relacionados
- **Formatação**: Apresenta valores monetários de forma padronizada
- **Buffer do Scanner**: Trata adequadamente a limpeza do buffer de entrada

---

## Projeto 3: Sistema de Pessoas (Arquitetura MVC)

### Visão Geral
Este projeto implementa uma arquitetura mais robusta seguindo o padrão MVC (Model-View-Controller), dividido em três componentes: Domínio (Pessoa.java), Controle (ControlePessoas.java) e Principal.

### Análise da Classe Domínio: Pessoa.java

#### **Estrutura da Classe**
```java
public class Pessoa {
    private String nome;
    private int idade;
    private double altura;
}
```
**Encapsulamento**: Todos os atributos são privados, seguindo boas práticas de orientação a objetos.

#### **Construtor**
```java
public Pessoa(String nome, int idade, double altura) {
    this.nome = nome;
    this.idade = idade;
    this.altura = altura;
}
```
Inicializa todos os atributos através de parâmetros, garantindo que objetos Pessoa sejam criados com dados completos.

#### **Métodos Getters**
```java
public String getNome() { return nome; }
public int getIdade() { return idade; }
public double getAltura() { return altura; }
```
Fornecem acesso controlado aos atributos privados.

#### **Método toString()**
```java
@Override
public String toString() {
    return String.format("Nome: %s | Idade: %d | Altura: %.2f m", nome, idade, altura);
}
```
Sobrescreve o método toString() da classe Object para fornecer uma representação textual formatada do objeto.

### Análise da Classe Controle: ControlePessoas.java

#### **Atributos e Construtor**
```java
private Pessoa[] pessoas;
private Scanner scanner;

public ControlePessoas() {
    pessoas = new Pessoa[5];
    scanner = new Scanner(System.in);
}
```
Inicializa um array para 5 pessoas e um Scanner para entrada de dados.

#### **Método cadastrarPessoas()**
```java
public void cadastrarPessoas() {
    for (int i = 0; i < pessoas.length; i++) {
        // Coleta dados
        pessoas[i] = new Pessoa(nome, idade, altura);
    }
}
```
**Funcionalidade:**
- Percorre o array de pessoas
- Coleta nome, idade e altura para cada pessoa
- Cria objetos Pessoa e os armazena no array
- Utiliza `scanner.nextLine()` após `nextInt()` e `nextDouble()` para limpar o buffer

#### **Método exibirMenu()**
```java
public void exibirMenu() {
    // Apresenta opções de ordenação
    int opcao = scanner.nextInt();
    switch (opcao) {
        case 1: ordenarPorNome(); break;
        case 2: ordenarPorIdade(); break;
        case 3: ordenarPorAltura(); break;
    }
    listarPessoas();
}
```
**Responsabilidades:**
- Apresenta menu de opções ao usuário
- Captura a escolha do usuário
- Chama o método de ordenação apropriado
- Exibe os resultados ordenados

#### **Métodos de Ordenação**

##### **ordenarPorNome()**
```java
if (pessoas[j].getNome().compareToIgnoreCase(pessoas[j + 1].getNome()) > 0) {
    // Troca objetos
}
```
- Utiliza `compareToIgnoreCase()` para ordenação alfabética case-insensitive
- Retorna valor positivo quando o primeiro nome é lexicograficamente maior

##### **ordenarPorIdade()**
```java
if (pessoas[j].getIdade() > pessoas[j + 1].getIdade()) {
    // Troca objetos
}
```
- Compara idades numericamente
- Ordena do menor para o maior

##### **ordenarPorAltura()**
```java
if (pessoas[j].getAltura() > pessoas[j + 1].getAltura()) {
    // Troca objetos
}
```
- Compara alturas (valores double)
- Ordena da menor para a maior altura

#### **Método listarPessoas()**
```java
private void listarPessoas() {
    for (Pessoa p : pessoas) {
        System.out.println(p);
    }
}
```
Utiliza enhanced for loop e aproveita o método `toString()` da classe Pessoa para exibição formatada.

### Análise da Classe Principal

```java
public class Principal {
    public static void main(String[] args) {
        ControlePessoas controle = new ControlePessoas();
        controle.cadastrarPessoas();
        controle.exibirMenu();
    }
}
```
**Responsabilidades:**
- Instancia o controlador
- Inicia o fluxo de cadastro
- Chama o menu de ordenação

## Comparação e Análise Arquitetural

### Evolução da Complexidade

1. **Projeto 1**: Estrutura monolítica, ideal para problemas simples
2. **Projeto 2**: Introduz complexidade de dados relacionados
3. **Projeto 3**: Implementa separação de responsabilidades e orientação a objetos

### Vantagens da Arquitetura MVC (Projeto 3)

- **Separação de responsabilidades**: Cada classe tem uma função específica
- **Reutilização**: A classe Pessoa pode ser usada em outros contextos
- **Manutenibilidade**: Alterações em uma camada não afetam as outras
- **Escalabilidade**: Facilita expansão do sistema
- **Testabilidade**: Métodos podem ser testados independentemente

### Algoritmo Bubble Sort - Análise Comum

Todos os projetos utilizam o Bubble Sort
- **Vantagem**: Simplicidade de implementação
- **Desvantagem**: Ineficiência para grandes conjuntos de dados
- **Estabilidade**: Mantém a ordem relativa de elementos iguais
- **Adaptação**: Facilmente modificável para diferentes critérios de ordenação

## 💡 Conceitos Demonstrados

- **Algoritmo Bubble Sort**: Implementação em diferentes contextos
- **Arrays e Collections**: Manipulação de estruturas de dados
- **Scanner**: Entrada de dados do usuário
- **String Manipulation**: Formatação e comparação
- **Orientação a Objetos**: Encapsulamento, métodos, construtores
- **Arquitetura MVC**: Separação de responsabilidades
- **Clean Code**: Evolução de código monolítico para modular

---
⭐ Se este projeto te ajudou, considere dar uma estrela!
