import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.Prato;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;


public class Arquivo {
    static void cadastrarItem(Item item) throws IOException {
        if (item instanceof PratoPrincipal) {

            FileWriter fw = new FileWriter("arquivos/itens/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("PratoPrincipal");
            bw.newLine();

            bw.write(item.getNome());
            bw.newLine();

            bw.write(item.getCodigo());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");

            bw.write(formato.format(item.getPrecoUnitario()));
            bw.newLine();

            bw.write(formato.format(item.getPrecoCusto()));
            bw.newLine();

            bw.write(((Prato) item).getDescricaoPrato());
            bw.newLine();

            bw.write(formato.format(((Prato) item).getTempoPreparo()));
            bw.newLine();

            bw.write(formato.format(((Prato) item).getValorPagoCozinheiro()));
            bw.newLine();

            for (int i = 0; i < ((Prato) item).getListaIngredientes().size(); i++) {
                bw.write(((Prato) item).getListaIngredientes().get(i) + ";");
            }

            bw.close();

        } else if (item instanceof Sobremesa) {

        FileWriter fw = new FileWriter("arquivos/itens/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Sobremesa");
            bw.newLine();
            
            bw.write(item.getNome());
            bw.newLine();

            bw.write(item.getCodigo());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");

            bw.write(formato.format(item.getPrecoUnitario()));
            bw.newLine();

            bw.write(formato.format(item.getPrecoCusto()));
            bw.newLine();

            bw.write(((Prato) item).getDescricaoPrato());
            bw.newLine();

            bw.write(formato.format(((Prato) item).getTempoPreparo()));
            bw.newLine();

            bw.write(formato.format(((Prato) item).getValorPagoCozinheiro()));
            bw.newLine();
            
            bw.write(formato.format(((Sobremesa) item).getNumeroCalorias()));
            bw.newLine();

            for (int i = 0; i < ((Prato) item).getListaIngredientes().size(); i++) {
                bw.write(((Prato) item).getListaIngredientes().get(i) + ";");
            }

            bw.close();

        } else if (item instanceof Bebida) {

            FileWriter fw = new FileWriter("arquivos/itens/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Bebida");
            bw.newLine();
            
            bw.write(item.getNome());
            bw.newLine();

            bw.write(item.getCodigo());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");

            bw.write(formato.format(item.getPrecoUnitario()));
            bw.newLine();

            bw.write(formato.format(item.getPrecoCusto()));
            bw.newLine();
            
            bw.write(formato.format(((Bebida) item).getTamanhoEmbalagem()));
            bw.newLine();
            
            bw.write(((Bebida) item).getTipoEmabalagem());
            bw.newLine()
            
            for (int i = 0; i < ((Prato) item).getListaIngredientes().size(); i++) {
                bw.write(((Prato) item).getListaIngredientes().get(i) + ";");
            }

            bw.close();

        }
        
    }
    static void cadastrarFuncionarios(Funcionario funcionario) throws IOException {
        if (funcionario instanceof Cozinheiro) {

            FileWriter fw = new FileWriter("arquivos/funcionarios/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Cozinheiro");
            bw.newLine();
            
            bw.write(funcionario.getNome());
            bw.newLine();

            bw.write(funcionario.getCPF());
            bw.newLine();

            bw.write(funcionario.getRG());
            bw.newLine();
            
            bw.write(funcionario.getEstadoCivil());
            bw.newLine();
            
            bw.write(funcionario.getEndereco());
            bw.newLine();
            
            bw.write(funcionario.getCarteiraTrabalho());
            bw.newLine();
            
            bw.write(funcionario.getData().getDia() + "-" + funcionario.getData().getMes() + "-" + funcionario.getData().getAno());
            bw.newLine();
            
            for (int i = 0; i < ((Cozinheiro) funcionario).getPratosCozinheiro().size(); i++) {
                bw.write(((Cozinheiro) funcionario).getPratosCozinheiro().get(i).getNome() + ";");
            }

            bw.close();

        }else if(funcionario instanceof Garcom) {
            FileWriter fw = new FileWriter("arquivos/funcionarios/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Garcom");
            bw.newLine();
            
            bw.write(funcionario.getNome());
            bw.newLine();

            bw.write(funcionario.getCPF());
            bw.newLine();

            bw.write(funcionario.getRG());
            bw.newLine();
            
            bw.write(funcionario.getEstadoCivil());
            bw.newLine();
            
            bw.write(funcionario.getEndereco());
            bw.newLine();
            
            bw.write(funcionario.getCarteiraTrabalho());
            bw.newLine();
            
            bw.write(funcionario.getData(dia/mes/ano));
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");
            
            bw.write(formato.format(((Garcom) funcionario).getSalarioBase()));
            bw.newLine();
            
            bw.write(((Garcom) funcionario).getDiaFolga());
            bw.newLine()
            
            bw.close();
        }
    }
    
    static void cadastrarIgredientes(ArrayList<String> igredientes) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/igredientes.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < igredientes.size(); i++) {
            bw.write(igredientes.get(i));
            bw.newLine();
        }
        
        bw.close();
        
    }
    
    static void cadastrarTiposDeEmbalagem(ArrayList<String> tipos) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/tiposDeEmbalagem.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < tipos.size(); i++) {
            bw.write(tipos.get(i));
            bw.newLine();
        }
        
        bw.close();
        
    }
    
    static void cadastrarFormasDePagameto(ArrayList<String> formas) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/formasDePagameto.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < formas.size(); i++) {
            bw.write(formas.get(i));
            bw.newLine();
        }
        
        bw.close();
        
    }
    
    static void cadastrarRegistroDePedidos(Pedido pedido) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/registroDePedidos.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(pedido.getData().getDia() + "-" + pedido.getData().getMes() + "-" + pedido.getData().getAno() );
        bw.newLine();
        
        bw.write(pedido.getHoraRegistro().getHoras() + ":" + pedido.getHoraRegistro().getMinutos() + ":" + pedido.getHoraRegistro().getSegundos());
        bw.newLine();
        
        bw.write(pedido.getHoraPagamento().getHoras() + ":" + pedido.getHoraPagamento().getMinutos() + ":" + pedido.getHoraPagamento().getSegundos());
        bw.newLine();
        
        bw.write(pedido.getFormaDePagamento());
        bw.newLine();
        
        DecimalFormat formato = new DecimalFormat("#.##");

        bw.write(formato.format(pedido.getValorTotal()));
        bw.newLine();
        
        bw.write((pedido.getCozinheiro().getNome());
        bw.newLine();
            
        bw.write(pedido.getGarcom().getNome());
        bw.newLine();
        
        for(int i = 0; i < pedido.getConjuntoItens().size(); i++) {
            bw.write(pedido.getConjuntoItens().get(i).getItem().getNome() + "-" + pedido.getConjuntoItens().get(i).getQtd() + ";");
        }
        
        bw.close();
    }
    
}
