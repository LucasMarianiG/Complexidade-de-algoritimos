public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Aluno> lMatri = new ListaEncadeada<Aluno>(true, new CompararAlunoMatricula());
        Aluno a1 = new Aluno ("Ze",1);
        Aluno a2 = new Aluno ("Ma",2);

        lMatri.adicionar(a1);
        lMatri.adicionar(a2);
        System.out.println(lMatri);

    }
}