public class MainArquivo {
    public static void main(String[] args) {
        try {
            // Preparando o programa para a leitura do arquivo
            ControllerArquivo controller = new ControllerArquivo("entrada50000000.txt");

            // Carregando os dados do arquivo nas listas
            controller.carregaListaArray();
            controller.carregaListaEncadeada();

            // Criando objetos do tipo Aluno
            Aluno aluno1 = new Aluno(-1, "Beltrano Silva");
            Aluno aluno2 = new Aluno(-2, "Ciclano Silva");
            Aluno aluno3 = new Aluno(-3, "Fulano Silva");

            // Realizando as inserções extra nas listas
            controller.insereNoFinal(aluno1);
            controller.insereNoMeio(aluno3);
            controller.insereNoInicio(aluno2);

            // Realizando as buscas nas listas
            controller.buscaElementoDoMeio();
            controller.buscaUltimoElemento();
            controller.buscaPenultimoElemento();
        } catch (OutOfMemoryError error) {
            System.out.println("XXXX ERROR XXXX");
            System.out.println("Capturamos um erro no programa");
            System.out.println("Não foi possível alocar mais espaço para para o programa");
            System.out.println("XXXXXXXXXXXXXXX");
        }
    }
}

