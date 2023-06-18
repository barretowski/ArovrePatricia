public class Fila {
    private NoFila inicio;

    public Fila(){
        inicio = null;
    }

    public void enqueue(No info){
        NoFila novo = new NoFila(info);
        if(isEmpty()){
            inicio = novo;
        }else{
            NoFila aux = inicio;
            while(aux.getProx()!=null){
                aux = aux.getProx();
            }
            aux.setProx(novo);
        }
    }

    public No dequeue(){
        if(isEmpty()){
            return null;
        }
        NoFila aux = inicio;
        inicio=inicio.getProx();
        return aux.getInfo();
    }

    public boolean isEmpty() {
        return inicio ==null;
    }

}
