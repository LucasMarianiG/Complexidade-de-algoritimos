# Trabalho de Análise de Desempenho em Java

Este projeto foi desenvolvido para a disciplina de **Estruturas de Dados**, focando na implementação e análise de desempenho de diferentes estruturas, como **`ArrayList`** e **`LinkedList`**. O objetivo é comparar a eficiência de operações de inserção e busca em pontos específicos (início, meio e fim) dessas listas.

---

## Estrutura do Projeto

O diretório `src` contém as classes principais do projeto, organizadas da seguinte forma:

* **`Aluno.java`**: Representa a estrutura de dados de um aluno, contendo sua **matrícula** (`int`) e **nome** (`String`).
* **`CompararAlunoMatricula.java`**: Implementa a interface `Comparator` para permitir a comparação de objetos `Aluno` com base em sua matrícula.
* **`ControllerArquivo.java`**: Centraliza a lógica de processamento de arquivos. Responsável por ler dados de alunos de um arquivo, carregá-los em um `ArrayList` e um `LinkedList`, e realizar operações como:
    * Inserção de novos alunos (no início, meio e fim).
    * Busca por alunos (no início, meio e fim).
* **`GeradorArquivosBalanceados.java`**: Classe utilitária, originalmente criada pelo Professor Victorio Carvalho. Ela gera um arquivo com uma lista de alunos aleatórios, utilizando listas de nomes e sobrenomes predefinidas para criar dados de teste. As matrículas são geradas de forma aleatória.
* **`ListaEncadeada.java`**: Implementação de uma **lista encadeada genérica**, similar à funcionalidade da classe `LinkedList` do Java.
* **`Main.java`**: Ponto de entrada principal para testar e executar a classe `ListaEncadeada` que foi desenvolvida.
* **`MainArquivo.java`**: Ponto de entrada para executar o processamento de dados e as análises de desempenho implementadas na classe `ControllerArquivo`.
* **`No.java`**: Classe genérica que representa um **nó** da `ListaEncadeada`, contendo o dado do aluno e a referência para o próximo nó.

---

## Como Executar

Primeiramente, gere um arquivo de dados rodando a classe `GeradorArquivosBalanceados`. Para configurar a quantidade de itens no arquivo a ser gerado, basta alterar a variável **`NUM_REGISTROS`** para o número inteiro que desejar.

E finalmente, para rodar o projeto e analisar o desempenho das operações de arquivo, execute a classe **`MainArquivo.java`**. Se você quiser testar a funcionalidade da lista encadeada customizada, execute a classe **`Main.java`**.

---