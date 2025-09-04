import java.util.Comparator;

public class ListaEncadeada<T> {

    private No<T> prim, ult;
    private int quant;
    private final boolean ordenada;
    private final Comparator<T> cmp;

    public ListaEncadeada(boolean ehOrdenada, Comparator<T> comp) {
        this.prim = this.ult = null;
        this.quant = 0;
        this.ordenada = ehOrdenada;
        this.cmp = comp;

    }


    public void adicionar(T novoValor) {
        if (!this.ordenada)
            addForaOrd(novoValor);
        else
            addEmOrd(novoValor);
    }

    public void addForaOrd(T novoValor) {
        No<T> novo = new No<T>(novoValor);
        if (this.prim == null){
            this.prim = novo;
        }
        else {
            this.ult.setProx(novo);
        }
        this.ult = novo;
        this.quant++;
    }

    public void addEmOrd(T novoValor) {
        No<T> novo = new No<T>(novoValor);
        No<T> atual, ant;
        atual = this.prim;
        ant = null;

        if (this.prim == null) {
            this.prim = this.ult = novo;
        }
        else {
            while (atual != null && cmp.compare(atual.getValor(), novoValor) < 0) {
                ant = atual;
                atual = atual.getProx();
            }

            if (ant == null) {
                novo.setProx(this.prim);
                this.prim = novo;
            }
            else if (atual == null){
                this.ult.setProx(novo);
                this.ult = novo;
            }
            else {
                ant.setProx(novo);
                novo.setProx(atual);
            }
        }
        this.quant++;

    }

    public boolean ContemElemento(T valor) {
        No<T> aux = this.prim;
        while (aux != null) {
            if (cmp.compare(aux.getValor(), valor) == 0) {
                return true;
            }

            if (this.ordenada && cmp.compare(aux.getValor(), valor) > 0) {
                return false;
            }
            aux = aux.getProx();
        }
        return false;
    }


    public boolean remover(T valor) {
        No<T> aux = this.prim;
        No<T> ant = null;

        while (aux != null) {
            if (cmp.compare(aux.getValor(), valor) == 0) {
                if (aux == this.prim){
                    this.prim = this.prim.getProx();
                    if (aux == this.ult)
                        this.ult = null;
                }
                else {
                    ant.setProx(aux.getProx());
                    if (aux==this.ult)
                        this.ult = ant;
                }
                this.quant--;
                return true;
            }
            else if (this.ordenada && cmp.compare(aux.getValor(), valor) > 0) {
                return false;
            }
            ant = aux;
            aux = aux.getProx();
        }
        return false;
    }

    @Override
    public String toString() {
        No<T> aux = this.prim;
        String s = "[";
        while (aux != null) {
            s += aux.getValor();
            if (aux != this.ult)
                s+= ",";
            aux = aux.getProx();

        }
        return (s + "]");
    }
}