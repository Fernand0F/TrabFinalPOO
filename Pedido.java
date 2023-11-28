import java.util.ArrayList;
import ClassesAuxiliares.Data;
import ClassesAuxiliares.Hora;

public class Pedido {
    private ArrayList<PedidoItem> conjuntoItens;
    private Data dataDoPedido;
    private Hora horaRegistro;
    private Hora horaPagamento;
    private String formaDePagamento;
    private double valorTotal;
    // private Cozinheiro cozinheiro;
    // private Garcom garcom;

    //Construtor
    public Pedido(ArrayList<PedidoItem> conjuntoItens, Data dataDoPedido, Hora horaRegistro, Hora horaPagamento, String formaDePagamento) {
        this.conjuntoItens = new ArrayList<>(conjuntoItens);
        this.dataDoPedido = new Data(dataDoPedido);
        this.horaRegistro = new Hora(horaRegistro);
        this.horaPagamento = new Hora(horaPagamento);
        this.formaDePagamento = new String(formaDePagamento);

        double total = 0;
        for (int i = 0; i < conjuntoItens.size(); i++) {
            total += this.conjuntoItens.get(i).getPreco();
        }
        this.valorTotal = total;
    }

    public Pedido(Pedido pedido) {
        this.conjuntoItens = pedido.getConjuntoItens();
        this.dataDoPedido = pedido.getData();
        this.horaRegistro = pedido.getHoraRegistro();
        this.horaPagamento = pedido.getHoraPagamento();
        this.formaDePagamento = pedido.getFormaDePagamento();

        double total = 0;
        for (int i = 0; i < conjuntoItens.size(); i++) {
            total += this.conjuntoItens.get(i).getPreco();
        }
        this.valorTotal = total;
    }

    //Métodos GET
    public ArrayList<PedidoItem> getConjuntoItens() {
        return new ArrayList<>(this.conjuntoItens);
    }

    public Data getData() {
        return new Data(this.dataDoPedido);
    }

    public Hora getHoraRegistro() {
        return new Hora(this.horaRegistro);
    }

    public Hora getHoraPagamento() {
        return new Hora(this.horaPagamento);
    }

    public String getFormaDePagamento() {
        return new String(this.formaDePagamento);
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    //Métodos SET
    public void setConjuntoItens(ArrayList<PedidoItem> conjunItems) {
        this.conjuntoItens = new ArrayList<>(conjuntoItens);

        double total = 0;
        for (int i = 0; i < conjuntoItens.size(); i++) {
            total += this.conjuntoItens.get(i).getPreco();
        }
        this.valorTotal = total;
    }

    public void setDataDoPedido(int dia, int mes, int ano) {
        this.dataDoPedido = new Data(dia, mes, ano);
    }

    public void setDataDoPedido(Data data) {
        this.dataDoPedido = new Data(data);
    }

    public void setHoraRegistro(int horas, int minutos, int segundos) {
        this.horaRegistro = new Hora(horas, minutos, segundos);
    }

    public void setHoraRegistro(int horas, int minutos) {
        this.horaRegistro = new Hora(horas, minutos);
    }
    
    public void setHoraRegistro(Hora hora) {
        this.horaRegistro = new Hora(hora);
    }

    public void setHoraPagamento(int horas, int minutos, int segundos) {
        this.horaPagamento = new Hora(horas, minutos, segundos);
    }

    public void setHoraPagamento(int horas, int minutos) {
        this.horaPagamento = new Hora(horas, minutos);
    }
    
    public void setHoraPagamento(Hora hora) {
        this.horaPagamento = new Hora(hora);
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = new String(formaDePagamento);
    }

    //Outros métodos
    public void addItem(Item item, int qtd) {
        conjuntoItens.add(new PedidoItem(item, qtd));
    }

    //**Adiconar Cozinheiro e Garçom ao construtor
    //**Criar métodos GET/SET para Cozinheiro e Garçom
}
