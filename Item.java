public class Item {
    private String nome;
    private String codigo;
    private double precoUnitario;
    private double precoCusto;

    public Item(String nome, String codigo, double precoUnitario, double precoCusto) {
        this.nome = nome;
        this.codigo = codigo;

        if (precoCusto < 0) {
            this.precoCusto = 0;
        }
        else {
            this.precoCusto = precoCusto;
        }

        if (precoUnitario < this.precoCusto) {
            this.precoUnitario = this.precoCusto;
        }
        else {
            this.precoUnitario = precoUnitario;
        }        
    }

    public Item (Item item) {
        this.nome = item.getNome();
        this.codigo = item.getCodigo();
        this.precoUnitario = item.getPrecoUnitario();
        this.precoCusto = item.getPrecoCusto();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome +
                "\nCodigo: " + codigo +
                "\nPreco Unitario: " + precoUnitario +
                "\nPreco de Custo: " + precoCusto);
    }
}