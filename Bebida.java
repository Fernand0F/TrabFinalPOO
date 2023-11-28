public class Bebida extends Item {
    private double tamanhoEmbalagem;
    private String tipoEmbalagem;

    public Bebida(String nome, String codigo, double precoUnitario, double precoCusto,
                  double tamanhoEmbalagem, String tipoEmbalagem) {
        super(nome, codigo, precoUnitario, precoCusto);
        this.tamanhoEmbalagem = tamanhoEmbalagem;
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public double getTamanhoEmbalagem() {
        return tamanhoEmbalagem;
    }

    public void setTamanhoEmbalagem(double tamanhoEmbalagem) {
        this.tamanhoEmbalagem = tamanhoEmbalagem;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }
    
    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tamanho da Embalagem: " + tamanhoEmbalagem +
                "\nTipo de Embalagem: " + tipoEmbalagem);
    }
}