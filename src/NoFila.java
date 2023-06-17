public class NoFila{
    private NoFila prox;
    private String info;

    public NoFila(NoFila prox, String info) {
        this.prox = prox;
        this.info = info;
    }

    public NoFila(String info){
        this.info=info;
        this.prox=null;
    }

    public String getInfo(){
        return this.info;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public NoFila getProx(){
        return this.prox;
    }

    public void setProx(NoFila prox){
        this.prox=prox;
    }

}
