import java.io.FileInputStream;
import java.util.Scanner;

//Ponto de entrada do programa. Cria a lista (ordenada ou não), instancia Alunos, executa operações e imprime resultados para testar o comportamento.
public class Main {
    public static void main(String[] args) {
//        ListaEncadeada<Aluno> lMatri = new ListaEncadeada<Aluno>(true, new CompararAlunoMatricula());
//        Aluno a1 = new Aluno("Ze",1);
//        Aluno a2 = new Aluno("Ma",2);
//        lMatri.adicionar(a1);
//        lMatri.adicionar(a2);

        // Lendo os dados do arquivo
        CarregaDadosArquivo minhaLista = new CarregaDadosArquivo("entrada10.txt", true, new CompararAlunoMatricula());
        ListaEncadeada<Aluno> lMatri = minhaLista.getLista();

        System.out.println(lMatri);

    }
}

