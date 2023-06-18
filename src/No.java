public class No implements Util{
    private String palavra;
    private boolean flag;
    private No vLig[];

    private int nivel;

    public No(String palavra, boolean flag, No[] vLig) {
        this.palavra = palavra;
        this.flag = flag;
        this.vLig = new No[N];
    }
    public No(){}

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public No getvLig(int p) {
        return vLig[p];
    }

    public void setvLig(int p, No lig) {
        this.vLig[p] = lig;
    }

    public boolean haveChildren(){
        return this.vLig != null;
    }

    public int contChildren(){
        return this.vLig.length;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
