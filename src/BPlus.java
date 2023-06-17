public class BPlus implements Util{
    private No raiz;
    private Fila fila = new Fila();
    private No noAtual;

    public No getRaiz() {
        return raiz;
    }

    //inserir
    public void inserir(String palavra){
        boolean flag = false;
        No auxNo = raiz;
        int posAtual;
        char letra;
        char auxLetra;
        int i;
        posAtual = palavra.charAt(0)-'a';
        if(raiz == null){
            raiz = new No("", false,null);
            raiz.setvLig(posAtual, new No(palavra,true,null));
        }else{
            if(auxNo.getvLig(posAtual) == null){
                auxNo.setvLig(posAtual, new No(palavra,true,null));
            }else{
                //1° caso: o nó contem uma palavra inteira
                if(auxNo.getvLig(posAtual).isFlag()){
                    i=0;
                    String auxPalavra = auxNo.getvLig(posAtual).getPalavra();
                    //Insere na arvore enquanto tiver letras iguais
                    for(i=0;i<palavra.length() && i<auxPalavra.length() && palavra.charAt(i) == auxPalavra.charAt(i);i++){
                        posAtual = palavra.charAt(i)-'a';
                        auxNo.setvLig(posAtual,new No(palavra.charAt(i)+"",false,null));
                        auxNo = auxNo.getvLig(palavra.charAt(i)-'a');
                    }
                    //Verifica se as palavras se diferenciaram antes de chegar ao fim, e joga o restante para os nós da arvore
                    if(i<palavra.length() && i<auxPalavra.length()){
                        String p1 = palavra.substring(i);
                        String p2 = auxPalavra.substring(i);
                        auxNo.setvLig(p1.charAt(0)-'a', new No(p1,true,null));
                        auxNo.setvLig(p2.charAt(0)-'a', new No(p2, true,null));
                    }else if(i<palavra.length()){
                        String p1 = palavra.substring(i);
                        auxNo.setvLig(p1.charAt(0)-'a', new No(p1,true,null));
                        String p2 = "";
                        auxNo.setvLig(0, new No(p2,true,null));
                    }else{
                        String p2 = auxPalavra.substring(i);
                        auxNo.setvLig(p2.charAt(0)-'a', new No(p2,true,null));
                        String p1 = "";
                        auxNo.setvLig(0, new No(p1,true,null));
                    }
                }else{//2° caso: contem mais de 1 elemento nessa ligação
                    fila.enqueue(palavra);
                    noAtual = auxNo.getvLig(posAtual);
                    percorreArvore();

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

    private void percorreArvore(){
        percorrer(noAtual, "");
    }
    private void percorrer(No noAtual, String palavraMontada){

        if(noAtual == null)
            return;

        palavraMontada = palavraMontada+noAtual.getPalavra();
        if(noAtual.isFlag()){
            fila.enqueue(palavraMontada);
        }

        boolean resp = noAtual.haveChildren();
    }
    private void insereCompleto(String palavra){
        int i=1;
        No auxNo = raiz.getvLig(palavra.charAt(0)-'a');
        for(; i<palavra.length()-1;i++){
            auxNo.setvLig(palavra.charAt(i)-'a', new No(palavra.charAt(i)+"",false,null));
            auxNo = auxNo.getvLig(palavra.charAt(i)-'a');
        }
        auxNo.setvLig(palavra.charAt(i)-'a', new No(palavra.charAt(i)+"",true,null));
    }
}
