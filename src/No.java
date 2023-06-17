public class No implements Util{
    private String palavra;
    private boolean flag;
    private No vLig[];

    public No(String palavra, boolean flag, No[] vLig) {
        this.palavra = palavra;
        this.flag = flag;
        this.vLig = new No[N];
    }

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

}
