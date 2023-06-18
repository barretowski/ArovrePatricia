public class Main extends BPlus{
    public static void main(String[] args) {
        BPlus bplus = new BPlus();
        bplus.inserir("cadeira");
        bplus.inserir("cadeado");
        bplus.inserir("bolsa");
        bplus.inserir("sapato");
        bplus.inserir("sandalia");
        bplus.inserir("barril");

        System.out.println("Palavras contidas na árvore:");
        bplus.exibir();
        System.out.println("\nExibição por nivel:");
        bplus.exibeNiveis();
    }
}
