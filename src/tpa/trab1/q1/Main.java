package tpa.trab1.q1;
import java.util.Scanner;

//Ponto de entrada do programa. Cria a lista (ordenada ou não), instancia Alunos, executa operações e imprime resultados para testar o comportamento.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        ListaEncadeada<Aluno> lMatri = new ListaEncadeada<Aluno>(true, new CompararAlunoMatricula());

        System.out.println();
        while(opcao != 0) {
            System.out.println("Escolha uma opção");
            System.out.println("1: Inserir");
            System.out.println("2: Remover");
            System.out.println("3: Pesquisar");
            System.out.println("0: Sair");
            opcao = sc.nextInt();

            sc.nextLine();
            if (opcao == 1) {

                System.out.println("Nome: ");
                String nome = sc.nextLine();

                System.out.println("Matrícula: ");
                int matricula = sc.nextInt();
                lMatri.adicionar(new Aluno(matricula, nome));
            } else if (opcao == 2) {
                System.out.println("Matrícula: ");
                int matricula = sc.nextInt();
                lMatri.remover(new Aluno(matricula, ""));
            } else if (opcao == 3) {
                System.out.println("Matrícula: ");
                int matricula = sc.nextInt();
                lMatri.pesquisar(new Aluno(matricula, ""));
            } else if (opcao == 0) {
                System.out.println("Adeus");
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println("Sua lista está assim: " + lMatri);
        }
    }
}
