package bd.dbos;


public class ListaDeMusicas<Musica> {
    private class No {
        private Musica item;
        private No proximo;

        public No(Musica item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }

        public Musica getItem() {
            return this.item;
        }

        public No getProximo() {
            return this.proximo;
        }

        public void setItem(Musica item) {
            this.item = item;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    } // fim da classe No

    private No primeiro, ultimo;
    private int tamanho;

    public ListaDeMusicas() throws Exception {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    // enqueue
    public void insereItem(Musica item) throws Exception {
        if (item == null)
            throw new Exception("Valor ausente");

        // guarda o atual ultimo da fila, antes da insercao (sera o penultimo)
        No penultimo = this.ultimo;

        // insere o novo item como ultimo da fila, com proximo null
        this.ultimo = new No (item, null);

        if(this.isVazia())
            // se a fila estiver vazia, atribui o ultimo ao primeiro também
            this.primeiro = this.ultimo;
        else
            // senão estiver vazia, define o próximo do penultimo como o ultimo
            penultimo.setProximo(this.ultimo);

        this.tamanho++;
    }

    // dequeue
    public void removeItem() throws Exception {
        if (this.isVazia())
            throw new Exception("Nada guardado");

        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;
    }

    // first
    public Musica getItem() throws Exception {
        if (this.isVazia())
            throw new Exception("Nada guardado");

        return this.primeiro.getItem();
    }

    // isEmpty
    public boolean isVazia() {
        return this.primeiro == null;
    }

    // getSize
    public int getTamanho() {
        return this.tamanho;
    }

    public String toString ()
    {
        if (this.primeiro==null /* && this.ultimo==null*/)
            return "Vazia";

        return "Primeiro: "+this.primeiro.getItem();
    }

    // equals compara this e obj
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ListaDeMusicas<Musica> fila = (ListaDeMusicas<Musica>)obj;

        No atualThis =this.primeiro,
           atualFila=fila.primeiro;

        while (atualThis!=null && atualFila!=null)
            if (!atualThis.getItem().equals(atualFila.getItem()))
                return false;

        if (atualThis!=null)
            return false;

        if (atualFila!=null)
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666/*qquer nro natural, menos zero*/;

        No atual=this.primeiro;

        while (atual!=null)
        {
            ret = ret*7/*qquer primo*/ + atual.getItem().hashCode();
            atual = atual.getProximo();
        }

        return ret;
    }

    // construtor de copia
    public ListaDeMusicas (ListaDeMusicas<Musica> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null /* && modelo.ultimo==null */)
            return; // sai do construtor, pq this.primeiro e this.ultimo ja sao null, assim como this.tamanho ja é 0

        this.primeiro = new No (modelo.primeiro.getItem(),null);

        No atualDoThis   = this.primeiro;
        No atualDoModelo = modelo.primeiro.getProximo();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProximo (new No (atualDoModelo.getItem(),null));
            atualDoThis   = atualDoThis.getProximo ();
            atualDoModelo = atualDoModelo.getProximo ();
        }

        this.ultimo  = atualDoThis;
        this.tamanho = modelo.tamanho;
    }

    public Object clone ()
    {
        ListaDeMusicas<Musica> ret=null;

        try
        {
            ret = new ListaDeMusicas (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}