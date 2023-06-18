public class BPlus implements Util{
    private No raiz;
    Fila f = new Fila();
    Fila fAux = new Fila();
    public No getRaiz() {
        return raiz;
    }
    public  No auxNo = raiz;
    //inserir
    public void inserir(String palavra){
        boolean flag = false;

        int posAtual;
        char letra;
        char auxLetra;
        int i;
        posAtual = palavra.charAt(0)-'a';
        auxNo = raiz;
        if(raiz == null){
            auxNo = raiz = new No("", false,null);
            raiz.setvLig(posAtual, new No(palavra,true,null));
        }else{
            if(auxNo.getvLig(posAtual) == null){
                auxNo.setvLig(posAtual, new No(palavra,true,null));
            }else{
                //1° caso: o nó contem uma palavra inteira
                if(auxNo.getvLig(posAtual).isFlag()){
                    i=0;
                    String auxPalavra = auxNo.getvLig(posAtual).getPalavra();
                    String palavraConcatenada = "";
                    //Insere na arvore enquanto tiver letras iguais
                    for(i=0;i<palavra.length() && i<auxPalavra.length() && palavra.charAt(i) == auxPalavra.charAt(i);i++){
                        palavraConcatenada = palavraConcatenada+""+palavra.charAt(i);
                    }
                    auxNo.setvLig(posAtual,new No(palavraConcatenada,false,null));
                    auxNo = auxNo.getvLig(posAtual);
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
                    No auxPercorre = auxNo;
                    auxPercorre = auxNo.getvLig(posAtual);
                    percorreArvore(palavra, auxPercorre);
                }
            }
        }
    }
    //exibir
    public void exibir(){
        String palavraAtual = "";
        printTree(getRaiz(), palavraAtual);
    }
    private void printTree(No no, String palavraAtual){
        if (no == null) {
            return;
        }
        palavraAtual = palavraAtual+no.getPalavra();

        if (no.getPalavra() != null && no.isFlag()) {
            System.out.println(palavraAtual);
        }

        for (int i=0; i<26;i++) {
            printTree(no.getvLig(i), palavraAtual);
        }
    }
    //andar em nivel
    public void exibeNiveis() {
        No aux = raiz;
        fAux.enqueue(aux);
        int nivelAtual = 1;
        while (!fAux.isEmpty()) {
            aux = fAux.dequeue();
            if(aux.getPalavra()!=""){
                if(nivelAtual < aux.getNivel()){
                    nivelAtual++;
                    System.out.print("\n");
                }
                System.out.print(" "+aux.getPalavra());
            }
            for (int i = 0; i < N; i++) {
                if (aux.getvLig(i) != null) {
                    aux.getvLig(i).setNivel(aux.getNivel()+1);
                    fAux.enqueue(aux.getvLig(i));
                    f.enqueue(aux.getvLig(i));
                }
            }
        }
    }

    private void percorreArvore(String palavra, No auxPercorre){
        int i=0;
        String palavraConcatenada = "";
        String palavraNo = auxPercorre.getPalavra();
        String novaPalavra ="";
        for(; i<palavraNo.length() && i<palavra.length() && palavra.charAt(i) == palavraNo.charAt(i);i++){
            palavraConcatenada = palavraConcatenada+""+palavra.charAt(i);
        }
        auxPercorre.setFlag(false);
        if(i<palavraNo.length()){
            novaPalavra = novaPalavra+""+palavra.substring(i);
            String restante = palavraNo.substring(i);
            auxPercorre.setPalavra(restante);
            No antigoNo = auxPercorre;
            auxNo.setvLig(palavraConcatenada.charAt(0)-'a',new No(palavraConcatenada,false,null));
            auxPercorre = auxNo.getvLig(palavraConcatenada.charAt(0)-'a');
            auxPercorre.setvLig(novaPalavra.charAt(0)-'a',new No(novaPalavra,true,null));
            auxPercorre.setvLig(restante.charAt(0)-'a',antigoNo);
            //remanejaFilhos(auxPercorre, restante, palavraConcatenada, novaPalavra);
        }else{
            palavraConcatenada = palavra.substring(i);
            auxPercorre.setvLig(palavra.charAt(i)-'a',new No(palavraConcatenada,true,null));
        }
    }

    public void remanejaFilhos(No auxPercorre, String restante, String comeco, String novaPalavra){

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
