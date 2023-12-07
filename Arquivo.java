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
                bw.write(((Prato) item).getListaIngredientes().get(i));
            }

            bw.close();

        } else if (item instanceof Sobremesa) {



        } else if (item instanceof Bebida) {



        }
    }
}
