public class PedidoItem {
    private Item item;
    private int qtd;
    
    //Construtor
    public PedidoItem(Item item, int qtd) {
        this.item = new Item(item);
        this.qtd = qtd;
    }

    //Métodos GET
    public Item getItem() {
        return new Item(this.item);
    }

    public int getQtd() {
        return this.qtd;
    }

    public double getPreco() {
        return (double) qtd * item.getPrecoUnitario();
    }

    public double getPrecoCusto() {
        return (double) qtd * item.getPrecoCusto();
    }
    
    //Métodos SET
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setItem(Item item) {
        this.item  = new Item(item);
    }
}
