package tpa.trab1.q1;

//Ponto de entrada do programa. Cria a lista (ordenada ou não), instancia Alunos, executa operações e imprime resultados para testar o comportamento.
public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Aluno> lMatri = new ListaEncadeada<Aluno>(true, new CompararAlunoMatricula());
        Aluno a1 = new Aluno(1, "Ze");
        Aluno a2 = new Aluno(2, "Ma");

        lMatri.adicionar(a1);
        lMatri.adicionar(a2);
        System.out.println(lMatri);

    }
}
