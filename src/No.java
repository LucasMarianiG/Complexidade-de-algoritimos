// Nó genérico da lista encadeada. Armazena o valor (T) e a referência para o próximo nó (prox). É o bloco básico que compõe a estrutura da lista.
public class No<T> {
    private T valor;
    private No<T> prox;

    public No(T valor) {
        this.setValor(valor);
        this.setProx(null);
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }

}