public class Main extends BPlus{
    public static void main(String[] args) {
        BPlus bplus = new BPlus();
        bplus.inserir("cadeira");
        bplus.inserir("cadeado");
        bplus.inserir("bolsa");
        bplus.inserir("sapato");
        bplus.inserir("sandalia");
        bplus.inserir("barril");
        bplus.inserir("relogio");
        bplus.inserir("repelente");
        bplus.inserir("zebra");
        bplus.inserir("carro");
        bplus.inserir("onibus");

        System.out.println("Palavras contidas na árvore:");
        bplus.exibir();
        System.out.println("\nExibição por nivel:");
        bplus.exibeNiveis();
    }
}
