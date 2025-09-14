package tpa.trab1.q4;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Preparando o programa para a leitura do arquivo
            ControllerArquivo controller = new ControllerArquivo("entrada60000000.txt");

            // Carregando os dados do arquivo nas listas
            controller.processaArquivoParaListaArray();

            // Processa o arquivo de entrada e executa as operações programadas na lista encadeada
            controller.processaArquivoParaListaEncadeada();
        } catch (OutOfMemoryError error) {
            System.out.println("XXXX ERROR XXXX");
            System.out.println("Capturamos um erro no programa");
            System.out.println("Não foi possível alocar mais espaço para para o programa");
            System.out.println("XXXXXXXXXXXXXXX");
        } catch (FileNotFoundException error) {
            System.out.println("Erro: Arquivo não encontrado");
        } catch (IOException error) {
            System.out.println("Erro: Tivemos um problema ao ler os dados do arquivo");
        } catch (NumberFormatException error) {
            System.out.println("Erro: Tivemos um problema ao converter uma das informações do arquivo para o valor numérico");
        }
    }
}

