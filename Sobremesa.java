public class Sobremesa extends Prato {
    private double numeroCalorias;

    public Sobremesa(String nome, String codigo, double precoUnitario, double precoCusto,
                     String listaIngredientes, String descricaoPrato, double tempoPreparo, double numeroCalorias) {
        super(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricaoPrato, tempoPreparo);
        this.numeroCalorias = numeroCalorias;
    }

    public double getNumeroCalorias() {
        return numeroCalorias;
    }

    public void setNumeroCalorias(double numeroCalorias) {
        this.numeroCalorias = numeroCalorias;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Quantidade de Calorias: " + numeroCalorias);
    }
}