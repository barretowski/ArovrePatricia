public class NoFila{
    private NoFila prox;
    private No info;

    public NoFila(NoFila prox, No info) {
        this.prox = prox;
        this.info = info;
    }

    public NoFila(No info){
        this.info=info;
        this.prox=null;
    }

    public No getInfo(){
        return this.info;
    }

    public void setInfo(No info){
        this.info = info;
    }

    public NoFila getProx(){
        return this.prox;
    }

    public void setProx(NoFila prox){
        this.prox=prox;
    }

}
