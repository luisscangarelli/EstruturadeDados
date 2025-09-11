# Análise dos Projetos Java

## Projeto 1: OrdenarNumeros.java

Este é o projeto mais simples dos três. Ele ordena 10 números inteiros que o usuário digita.

**Como funciona:**

O programa começa criando um Scanner para ler dados do usuário e um array de 10 posições para guardar os números. Depois pede para o usuário digitar 10 números usando um for simples.

A ordenação é feita com bubble sort - um algoritmo que compara números vizinhos e os troca de lugar se estiverem fora de ordem. O programa usa dois for aninhados: o externo controla quantas vezes vai passar pelo array, e o interno faz as comparações. Quando `numeros[j] > numeros[j + 1]`, os números trocam de posição usando uma variável temporária.

Por fim, mostra os números ordenados usando um for each.

## Projeto 2: OrdenaProdutos.java  

Este projeto é mais complexo porque trabalha com produtos que têm nome e preço, e precisa manter os dois dados sempre juntos.

**Como funciona:**

O programa cria dois arrays: um para nomes (String) e outro para preços (double). No loop de entrada, pede o nome do produto com `nextLine()` e o preço com `nextDouble()`. Tem uma linha importante `scanner.nextLine()` depois do `nextDouble()` - isso serve para "limpar" o buffer e evitar problemas na próxima leitura.

A ordenação também usa bubble sort, mas agora ordena por preço do maior para o menor (decrescente). A diferença está na condição: `precos[j] < precos[j + 1]`. Quando troca os preços, também troca os nomes na mesma posição para não perder a associação entre produto e preço.

Na hora de mostrar os resultados, usa `String.format("%.2f", precos[i])` para mostrar o preço com duas casas decimais.

## Projeto 3: Sistema de Pessoas (dividido em classes)

Este projeto é mais organizado e usa orientação a objetos, dividido em três arquivos.

### Classe Pessoa (domínio)

É uma classe simples que representa uma pessoa com nome, idade e altura. Os atributos são privados (encapsulamento) e só podem ser acessados pelos métodos get.

**Métodos:**
- **Construtor**: recebe nome, idade e altura e inicializa os atributos
- **getNome(), getIdade(), getAltura()**: métodos get que retornam os valores dos atributos
- **toString()**: método que retorna uma string formatada com os dados da pessoa

### Classe ControlePessoas (controle)

Esta classe controla toda a lógica do programa.

**Atributos:**
- Array de 5 pessoas
- Scanner para entrada de dados

**Métodos principais:**

**cadastrarPessoas()**: Faz um loop pedindo dados de 5 pessoas. Para cada uma, pega nome, idade e altura, e cria um objeto Pessoa guardando no array.

**exibirMenu()**: Mostra um menu com 3 opções de ordenação, lê a escolha do usuário e chama o método correspondente. Depois chama `listarPessoas()` para mostrar o resultado.

**ordenarPorNome()**: Usa bubble sort comparando nomes com `compareToIgnoreCase()` - este método compara strings ignorando maiúsculas e minúsculas. Quando retorna valor positivo, significa que o primeiro nome vem depois alfabeticamente.

**ordenarPorIdade()**: Bubble sort simples comparando idades numericamente.

**ordenarPorAltura()**: Bubble sort comparando alturas (números decimais).

**listarPessoas()**: Percorre o array de pessoas e imprime cada uma. Como chama `System.out.println(p)`, automaticamente usa o método `toString()` da classe Pessoa.

### Classe Principal

Tem apenas o método main que cria um objeto ControlePessoas e chama os métodos para cadastrar e mostrar o menu.

## Comparação dos três projetos

O primeiro projeto resolve tudo no main - é simples mas não muito organizado. O segundo projeto continua simples mas já trabalha com dados relacionados (nome e preço do produto). O terceiro projeto é mais profissional, usando classes e separando as responsabilidades - a classe Pessoa cuida dos dados, ControlePessoas cuida da lógica, e Principal só inicia o programa.

Todos usam o mesmo algoritmo de ordenação (bubble sort) mas aplicado de formas diferentes: números simples, produtos com dois dados, e objetos com três atributos e múltiplas formas de ordenação.
