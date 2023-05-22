public class Tree implements Util{
    private No raiz;

    public No getRaiz() {
        return raiz;
    }

    //inserir
    private void inserir(String palavra){
        boolean flag = false;
        No auxNo = raiz;
        int pos=0;
        char letra;
        char auxLetra;
        String auxPalavra="";
        if(raiz == null){
            raiz.setvLig(0, new No(palavra,true,null));
        }else{
            for(int i=0; i<palavra.length() && !flag; i++){
                letra = palavra.charAt(i);
                if(auxNo.getPalavra().charAt(letra))
                if(!flag){//não achou
                    //busca posicao
                    pos =1;
                    auxNo.setvLig(pos, new No(palavra,true,null));
                }else if(flag){
                    auxNo.setvLig(pos, new No(palavra,true,null));
                }
            }
        }
    }
    //exibir
    private void exibir(){

    }
    //andar em nivel
    private void andarEmNivel(){

    }
}
