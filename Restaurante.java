import java.util.ArrayList;

import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.Prato;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;
import ClassesPedido.Pedido;
import ClassesFuncionario.Funcionario;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Garcom;

public class Restaurante {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Item> cardapio;
    private ArrayList<String> ingregientes;
    private ArrayList<Pedido> registroDePedidos;
    private ArrayList<String> tiposDeEmbalagem;
    private ArrayList<String> formasDePagameto;
    
    //Construtor
    public Restaurante() {
        funcionarios = new ArrayList<Funcionario>();
        cardapio = new ArrayList<Item>();
        ingregientes = new ArrayList<String>();
        registroDePedidos = new ArrayList<Pedido>();
        tiposDeEmbalagem = new ArrayList<String>();
        formasDePagameto = new ArrayList<String>();
    }

    //Métodos GET
    public ArrayList<Funcionario> getFuncionarios() {
        return new ArrayList<Funcionario>(funcionarios);
    }

    public ArrayList<Item> getCardapio() {
        return new ArrayList<Item>(cardapio);
    }

    public ArrayList<String> getIngredientes() {
        return new ArrayList<String>(ingregientes);
    }

    public ArrayList<Pedido> getRegistroDePedidos() {
        return new ArrayList<Pedido>(registroDePedidos);
    }

    public ArrayList<String> getTiposDeEmbalagem() {
        return new ArrayList<String>(tiposDeEmbalagem);
    }

    public ArrayList<String> getFormasDePagamento() {
        return new ArrayList<String>(formasDePagameto);
    }
 
    //Métodos SET
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario instanceof Cozinheiro) {
            funcionarios.add((Cozinheiro) funcionario);
        } else if (funcionario instanceof Garcom) {
            funcionarios.add((Garcom) funcionario);
        }
    }

    public void cadastrarItem(Item item) {
        if (item instanceof Bebida) {
            cardapio.add((Bebida) item);
        }
        else if (item instanceof PratoPrincipal) {
            cardapio.add((PratoPrincipal) item);
        }
        else if (item instanceof Sobremesa) {
            cardapio.add((Sobremesa) item);
        }
        else {
            cardapio.add(item);
        } 
    }

    public void cadastrarIngrediente(String ingrediente) {
        ingregientes.add(ingrediente);
    }

    public void cadastrarPedido(Pedido pedido) {
        registroDePedidos.add(pedido);
    }
    
    public void cadastrarEmbalagem(String embalagem) {
        tiposDeEmbalagem.add(embalagem);
    }

    public void cadastrarFormaDePagamento(String forma) {
        formasDePagameto.add(forma);
    }

    //Outros métodos
    public void mostrarCardapio() {
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println("Nome: " + cardapio.get(i).getNome());
            System.out.println("Código: " + cardapio.get(i).getCodigo());
            System.out.println("Preço unitário: " + cardapio.get(i).getPrecoUnitario() + " R$");
            System.out.println("Preço de custo: " + cardapio.get(i).getPrecoCusto() + " R$");

            if (cardapio.get(i) instanceof Bebida) {
                System.out.println("Tamanho: " + ((Bebida) cardapio.get(i)).getTamanhoEmbalagem() + " ml");
                System.out.println("Tipo de embalagem: " + ((Bebida) cardapio.get(i)).getTipoEmbalagem());
            } else if (cardapio.get(i) instanceof Prato) {
                System.out.println("Descrição: " + ((Prato) cardapio.get(i)).getDescricaoPrato());
                System.out.println("Ingredientes: " + ((Prato) cardapio.get(i)).getListaIngredientes());
                System.out.println("Tempo de preparo: " + ((Prato) cardapio.get(i)).getTempoPreparo() + " min");
                System.out.println("Valor pago ao Cozinheiro: " + ((Prato) cardapio.get(i)).getValorPagoCozinheiro() + " R$");

                if (cardapio.get(i) instanceof Sobremesa) {
                    System.out.println("Calorias: " + ((Sobremesa) cardapio.get(i)).getNumeroCalorias() + " kcal");
                }
            } 
            

            System.out.println("");
            // System.out.println(null);
            // System.out.println(null);
            // System.out.println(null);
        }
    }

    public void mostrarIngredientes() {
        for (int i = 0; i < ingregientes.size(); i++) {
            System.out.println(" - " + ingregientes.get(i));
        }
    }

    public void mostrarEmbalagens() {
        for (int i = 0; i < tiposDeEmbalagem.size(); i++) {
            System.out.println(" - " + tiposDeEmbalagem.get(i));
        }
    }

    public void mostrarFormasDePagamento() {
        for (int i = 0; i < formasDePagameto.size(); i++) {
            System.out.println(" - " + formasDePagameto.get(i));
        }
    }

    public void mostrarFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {

                System.out.format("Nome................: %s", funcionarios.get(i).getNome());

            if (funcionarios.get(i) instanceof Cozinheiro) {

                System.out.format("\nCargo...............: Cozinheiro");

            } else if (funcionarios.get(i) instanceof Garcom) {

                System.out.format("\nCargo...............: garçom");
                System.out.format("\nSalário base........: %.2f", ((Garcom) funcionarios.get(i)).getSalarioBase());
                System.out.format("\nDia de folga........: %s", ((Garcom) funcionarios.get(i)).getDiaFolga());
            
            }

            System.out.format("\nCPF.................: %s", funcionarios.get(i).getCPF());
            System.out.format("\nRG..................: %s", funcionarios.get(i).getRG());
            System.out.format("\nEstado civil........: %s", funcionarios.get(i).getEstadoCivil());
            System.out.format("\nEndereço............: %s", funcionarios.get(i).getEndereco());
            System.out.format("\nCarteira de trabalho: %s", funcionarios.get(i).getCarteiraTrabalho());
            System.out.format("\nData de admissão....: %02d/%02d/%d \n\n", funcionarios.get(i).getData().getDia(), funcionarios.get(i).getData().getMes(), funcionarios.get(i).getData().getAno());
        }
    }
}
 