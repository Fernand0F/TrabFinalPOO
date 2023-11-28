public abstract class Prato extends Item {
    private String listaIngredientes;
    private String descricaoPrato;
    private double tempoPreparo;
    private static double valorPagoCozinheiro;

    public Prato(String nome, String codigo, double precoUnitario, double precoCusto,
                 String listaIngredientes, String descricaoPrato, double tempoPreparo) {
        super(nome, codigo, precoUnitario, precoCusto);
        this.listaIngredientes = listaIngredientes;
        this.descricaoPrato = descricaoPrato;
        this.tempoPreparo = tempoPreparo;
    }

    public String getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(String listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public double getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(double tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public static double getValorPagoCozinheiro() {
        return valorPagoCozinheiro;
    }

    public static void setValorPagoCozinheiro(double valorPagoCozinheiro) {
        Prato.valorPagoCozinheiro = valorPagoCozinheiro;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Ingredientes: " + listaIngredientes +
                "\nDescrição do prato: " + descricaoPrato +
                "\nTempo de Preparo: " + tempoPreparo +
                "\nValor Pago ao Cozinheiro: " + valorPagoCozinheiro);
    }
}