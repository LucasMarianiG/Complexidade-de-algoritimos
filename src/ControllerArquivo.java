import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    private Aluno aluno = null;

    public ControllerArquivo(String filename) {
        this.filename = filename;
        this.listaArray = new ArrayList<>();
        this.listaEncadeada = new LinkedList<>();
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

    private int lerQuantidadeRegistro(BufferedReader buff) throws IOException, NumberFormatException {
        String linha = this.lerLinha(buff);
        return Integer.parseInt(linha);
    }

    public void carregaListaArray() throws OutOfMemoryError {
        try {
            System.out.println("### Iniciando a leitura do arquivo e salvando os dados num ArrayList...");

            // Declarando variáveis para ler o arquivo
            FileReader file = new FileReader(this.filename);
            BufferedReader buff = new BufferedReader(file);
            String linha;
            int qtdRegistros = this.lerQuantidadeRegistro(buff);

            // Pegando o tempo de início
            this.tempoInicial = this.lerTempoDoSistema();

            for (int i = 0; i < qtdRegistros; i++) {
                linha = buff.readLine();
                String[] dados = linha.split(";");
                this.listaArray.add(new Aluno(Integer.parseInt(dados[0]), dados[1]));
            }

            this.tempoFinal = this.lerTempoDoSistema();
            this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
            System.out.println("Tempo de carregamento do ArrayList em milissegundos: " + this.tempoExecucao);

            buff.close();
        } catch (FileNotFoundException error) {
            System.out.println("Erro: Arquivo não encontrado");
        } catch (IOException error) {
            System.out.println("Erro: Tivemos um problema ao ler os dados do arquivo");
        } catch (NumberFormatException error) {
            System.out.println("Erro: Tivemos um problema ao converter uma das informações do arquivo para o valor numérico");
        } finally {
            System.out.println("...Finalizamos a leitura do arquivo.\n");
        }
    }

    public void carregaListaEncadeada() throws OutOfMemoryError {
        try {
            System.out.println("### Iniciando a leitura do arquivo e salvando os dados num LinkedList...");

            // Declarando variáveis para ler o arquivo
            FileReader file = new FileReader(this.filename);
            BufferedReader buff = new BufferedReader(file);
            String linha;
            int qtdRegistros = this.lerQuantidadeRegistro(buff);

            // Pegando o tempo de início
            this.tempoInicial = this.lerTempoDoSistema();

            for (int i = 0; i < qtdRegistros; i++) {
                linha = buff.readLine();
                String[] dados = linha.split(";");
                this.listaEncadeada.add(new Aluno(Integer.parseInt(dados[0]), dados[1]));
            }

            this.tempoFinal = this.lerTempoDoSistema();
            this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
            System.out.println("Tempo de carregamento do LinkedList em milissegundos: " + this.tempoExecucao);

            buff.close();
        } catch (FileNotFoundException error) {
            System.out.println("Erro: Arquivo não encontrado");
        } catch (IOException error) {
            System.out.println("Erro: Tivemos um problema ao ler os dados do arquivo");
        } catch (NumberFormatException error) {
            System.out.println("Erro: Tivemos um problema ao converter uma das informações do arquivo para o valor numérico");
        } finally {
            System.out.println("...Finalizamos a leitura do arquivo.\n");
        }
    }

    public void insereNoFinal(Aluno a) {
        // Pegando o tempo de inserção no ArrayList
        this.tempoInicial = this.lerTempoDoSistema();
        this.listaArray.addLast(a);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no final da lista array em milissegundos: " + this.tempoExecucao);

        // Pegando o tempo de inserção no LinkedList
        this.tempoInicial = this.lerTempoDoSistema();
        this.listaEncadeada.addLast(a);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no final da lista encadeada em milissegundos: " + this.tempoExecucao + "\n");
    }

    public void insereNoInicio(Aluno a) {
        // Pegando o tempo de inserção no ArrayList
        this.tempoInicial = this.lerTempoDoSistema();
        this.listaArray.addFirst(a);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no início da lista array em milissegundos: " + this.tempoExecucao);

        // Pegando o tempo de inserção no LinkedList
        this.tempoInicial = this.lerTempoDoSistema();
        this.listaEncadeada.addFirst(a);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no início da lista encadeada em milissegundos: " + this.tempoExecucao + "\n");
    }

    public void insereNoMeio(Aluno a) {
        // Pegando o tempo de inserção no ArrayList
        this.tempoInicial = this.lerTempoDoSistema();
        this.listaArray.add(this.listaArray.size() / 2, a);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no meio da lista array em milissegundos: " + this.tempoExecucao);

        // Pegando o tempo de inserção no LinkedList
        this.tempoInicial = this.lerTempoDoSistema();
        this.listaEncadeada.add(this.listaEncadeada.size() / 2, a);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de inserção no meio da lista encadeada em milissegundos: " + this.tempoExecucao + "\n");
    }

    public void buscaUltimoElemento() {
        // Pegando o tempo de busca no ArrayList
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = this.listaArray.getLast();
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do último elemento da lista array em milissegundos: " + this.tempoExecucao);

        // Pegando o tempo de busca no LinkedList
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = this.listaEncadeada.getLast();
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do último elemento da lista encadeada em milissegundos: " + this.tempoExecucao + "\n");
    }

    public void buscaPenultimoElemento() {
        // Pegando o tempo de busca no ArrayList
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = this.listaArray.get(this.listaArray.size() - 2);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do penúltimo elemento da lista array em milissegundos: " + this.tempoExecucao);

        // Pegando o tempo de busca no LinkedList
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = this.listaEncadeada.get(this.listaEncadeada.size() - 2);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do penúltimo elemento da lista encadeada em milissegundos: " + this.tempoExecucao + "\n");
    }

    public void buscaElementoDoMeio() {
        // Pegando o tempo de busca no ArrayList
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = this.listaArray.get(this.listaArray.size() / 2);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do elemento do meio da lista array em milissegundos: " + this.tempoExecucao);

        // Pegando o tempo de busca no LinkedList
        this.tempoInicial = this.lerTempoDoSistema();
        this.aluno = this.listaEncadeada.get(this.listaEncadeada.size() / 2);
        this.tempoFinal = this.lerTempoDoSistema();
        this.tempoExecucao = this.calcularTempoExecusaoEmSegundos();
        System.out.println("Tempo de busca do elemento do meio da lista encadeada em milissegundos: " + this.tempoExecucao + "\n");
    }
}
