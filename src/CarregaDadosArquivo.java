import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class CarregaDadosArquivo {
    private Scanner input;
    private ListaEncadeada<Aluno> lista;

    public CarregaDadosArquivo(String filename, boolean ehOrdenada, Comparator<Aluno> comp) {
        try {
            System.out.println("Iniciando a leitura do arquivo...\n");

            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            String linha;
            int qtdRegistros = this.lerQuantidadeRegistro(buff);
            this.lista = new ListaEncadeada<Aluno>(ehOrdenada, comp);

            for (int i = 0; i < qtdRegistros; i++) {
                linha = buff.readLine();
                String[] dados = linha.split(";");
                this.lista.adicionar(new Aluno(dados[0], Integer.parseInt(dados[1])));
            }

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

    public ListaEncadeada<Aluno> getLista() {
        return this.lista;
    }

    private String lerLinha(BufferedReader buff) throws IOException {
        return buff.readLine();
    }

    private int lerQuantidadeRegistro(BufferedReader buff) throws IOException, NumberFormatException {
        String linha = this.lerLinha(buff);
        return Integer.parseInt(linha);
    }
}
