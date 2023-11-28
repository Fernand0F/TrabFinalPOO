import java.util.ArrayList;

import ClassesAuxiliares.Data;
import ClassesAuxiliares.Hora;

public class Restaurante {
    //private ArrayList<Funcionario> funcionarios;
    private ArrayList<Item> cardapio;
    private ArrayList<String> ingregientes;
    private ArrayList<Pedido> registroDePedidos;

    //Construtor


    //Métodos GET


    //Métodos SET


    //Outros métodos
    public void cadastrarIngrediente(String ingrediente) {
        ingregientes.add(ingrediente);
    }

    public void cadastrarPedido(ArrayList<PedidoItem> conjuntoItens, Data dataDoPedido, Hora horaRegistro, Hora horaPagamento, String formaDePagamento) {
        registroDePedidos.add(new Pedido(conjuntoItens, dataDoPedido, horaRegistro, horaPagamento, formaDePagamento));
    }

    public void cadastrarPedido(Pedido pedido) {
        registroDePedidos.add(new Pedido(pedido));
    }
}
