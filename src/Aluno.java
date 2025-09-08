// Modelo de dados usado nos testes. Guarda nome e matrícula, define toString() (para imprimir) e equals() (igualdade por matrícula). Serve de elemento armazenado na lista
public class Aluno {
    private String nome;
    private int matricula;

    public Aluno(String nom, int mat) {
        this.nome = nom;
        this.matricula = mat;
    }



    @Override
    public String toString() {
        return Integer.toString(matricula) + " - " + nome;
    }

    @Override
    public boolean equals(Object a) {
        if(a instanceof Aluno)
            return this.matricula==((Aluno) a).matricula;
        else
            return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}