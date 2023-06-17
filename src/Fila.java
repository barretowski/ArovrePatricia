public class Fila {
    private NoFila inicio;

    public Fila(){
        inicio = null;
    }

    public void enqueue(String info){
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

    public String dequeue(){
        if(isEmpty()){
            return null;
        }
        NoFila aux = inicio;
        inicio=inicio.getProx();
        return aux.getInfo();
    }

    private boolean isEmpty() {
        return inicio ==null;
    }

}
