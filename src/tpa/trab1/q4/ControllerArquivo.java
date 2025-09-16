package tpa.trab1.q4;

import tpa.trab1.q1.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControllerArquivo {
    private final List<Aluno> listaArray;
    private final List<Aluno> listaEncadeada;
    private final String filename;
    private long tempoInicial = 0, tempoFinal = 0, tempoExecucao = 0;
    private Aluno aluno;

    public ControllerArquivo(String filename) {
        this.filename = filename;
        this.listaArray = new ArrayList<>();
        this.listaEncadeada = new LinkedList<>();
        this.aluno = new Aluno(-1, "Fulano da Silva");
    }

    public void processaArquivoParaListaArray() throws OutOfMemoryError, IOException {
        System.out.println("\n### Iniciando a aplicação para o ArrayList...");
        this.processaDadosArquivo(this.listaArray);

        // Realizando as inserções extra na lista array
        System.out.println("Inserções");
        this.insereNoFinal(this.listaArray);
        this.insereNoMeio(this.listaArray);
        this.insereNoInicio(this.listaArray);

        // Realizando as buscas na lista array
        System.out.println("Buscas");
        this.buscaElementoDoMeio(this.listaArray);
        this.buscaUltimoElemento(this.listaArray);
        this.buscaPenultimoElemento(this.listaArray);

        System.out.println("... Finalizado a aplicação para o ArrayList.");
    }

    public void processaArquivoParaListaEncadeada() throws OutOfMemoryError, IOException {
        System.out.println("\n### Iniciando a aplicação para o LinkedList...");
        this.processaDadosArquivo(this.listaEncadeada);

        // Realizando as inserções extra na lista array
        System.out.println("Inserções");
        this.insereNoInicio(this.listaEncadeada);
        this.insereNoMeio(this.listaEncadeada);
        this.insereNoFinal(this.listaEncadeada);

        // Realizando as buscas na lista array
        System.out.println("Buscas");
        this.buscaElementoDoMeio(this.listaEncadeada);
        this.buscaPenultimoElemento(this.listaEncadeada);
        this.buscaUltimoElemento(this.listaEncadeada);

        System.out.println("... Finalizado a aplicação para o LinkedList.");
    }

    private long lerTempoDoSistema() {
        return System.currentTimeMillis();
    }

    private long calcularTempoExecusaoEmSegundos() {
        return this.tempoFinal - this.tempoInicial;
    }

    private String lerLinha(BufferedReader buff) throws IOException {
        return buff.readLine();
    }

    private int lerQuantidadeRegistro(BufferedReader buff) throws NumberFormatException, IOException {
        String linha = this.lerLinha(buff);
        return Integer.parseInt(linha);
    }

    private void processaDadosArquivo(List<Aluno> lista) throws IOException, OutOfMemoryError {
        System.out.println("Iniciando a leitura do arquivo e salvando os dados na lista");

        // Declarando variáveis para ler o arquivo
        FileReader file = new FileReader(this.filename);
        BufferedReader buff = new BufferedReader(file);
        String linha;
        int qtdRegistros = this.lerQuantidadeRegistro(buff);

        System.out.println("Carregando " + qtdRegistros + " registros na lista.");

        // Pegando o tempo de início de processamento do arquivo e salvando os dados na lista
        this.tempoInicial = this.lerTempoDoSistema();

        for (int i = 0; i < qtdRegistros; i++) {
            linha = buff.readLine();
            String[] dados = linha.split(";");
            lista.add(new Aluno(Integer.parseInt(dados[0]), dados[1]));
        }

        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de carregamento do ArrayList em milissegundos: " + this.tempoExecucao);

        // Fechando arquivo
        buff.close();
    }

    private void insereNoFinal(List<Aluno> lista) {
        // Pegando o tempo de inserção no final da lista
        this.tempoInicial = this.lerTempoDoSistema();
        lista.addLast(this.aluno);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no final da lista em milissegundos: " + this.tempoExecucao);
    }

    private void insereNoMeio(List<Aluno> lista) {
        // Pegando o tempo de inserção no meio da lista
        this.tempoInicial = this.lerTempoDoSistema();
        lista.add(lista.size() / 2, this.aluno);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no meio da lista em milissegundos: " + this.tempoExecucao);
    }

    private void insereNoInicio(List<Aluno> lista) {
        // Pegando o tempo de inserção no inicio da lista
        this.tempoInicial = this.lerTempoDoSistema();
        lista.addFirst(this.aluno);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no início da lista em milissegundos: " + this.tempoExecucao);
    }

    private void buscaElementoDoMeio(List<Aluno> lista) {
        // Pegando o tempo de busca do elemente do meio da lista
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = lista.get(lista.size() / 2);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do elemento do meio da lista em milissegundos: " + this.tempoExecucao);
    }

    private void buscaUltimoElemento(List<Aluno> lista) {
        // Pegando o tempo de busca do último elemento da lista
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = lista.getLast();
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do último elemento da lista em milissegundos: " + this.tempoExecucao);
    }

    private void buscaPenultimoElemento(List<Aluno> lista) {
        // Pegando o tempo de busca do penúltimo elemente da lista
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = lista.get(lista.size() - 2);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do penúltimo elemento da lista em milissegundos: " + this.tempoExecucao);
    }
}
