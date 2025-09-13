package tpa.trab1.q1;

import java.util.Comparator;

// Implementa Comparator<Aluno> para definir a ordem dos alunos pela matrícula (ordenação crescente). É a “regra de comparação” usada pela lista ordenada.
public class CompararAlunoMatricula implements Comparator<Aluno> {
    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Integer.compare(o1.getMatricula(), o2.getMatricula());
    }
}