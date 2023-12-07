// import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;

import ClassesFuncionario.Funcionario;
import ClassesItem.Item;
import ClassesPedido.Pedido;

public class Main
{
	public static void main(String[] args) {
		ArrayList<String> ing = Arquivo.lerRecursos("arquivos/recursos/ingredientes.txt");
		ArrayList<String> emb = Arquivo.lerRecursos("arquivos/recursos/tiposDeEmbalagem.txt");
		ArrayList<String> pag = Arquivo.lerRecursos("arquivos/recursos/formasDePagamento.txt");
		ArrayList<Item> items = Arquivo.lerDirItens("arquivos/itens");

		Restaurante restaurante = new Restaurante();

		restaurante.setIng(ing);
		restaurante.setEmb(emb);
		restaurante.setPag(pag);
		restaurante.setItens(items);

		ArrayList<Funcionario> func = Arquivo.lerDirFuncionarios(restaurante, "arquivos/funcionarios");
		restaurante.setFunc(func);

		ArrayList<Pedido> ped = Arquivo.lerDirPedidos(restaurante, "arquivos/pedidos");
		restaurante.setRegPed(ped);		
		
		while (true) {
			int input;
			String[] itensMenu = new String[5]; //Itens do menu
			itensMenu[0] = new String("Pedidos");
			itensMenu[1] = new String("Cardapio");
			itensMenu[2] = new String("Funcionários");
			itensMenu[3] = new String("Recursos");
			itensMenu[4] = new String("Sair");

			input = Menu.menu(itensMenu, "Restaurante");

			if (input == 4) break;

			switch (input) { 
				case 0:
					Menu.menuPedidos(restaurante);
					break;
				case 1:
					Menu.menuCardapio(restaurante);
					break;
				case 2:
					Menu.menuFuncionarios(restaurante);
					break;
				case 3:
					Menu.menuRecursos(restaurante);
					break;
			}
		}	
		
		try {
			Arquivo.cadastrarIgredientes(restaurante.getIngredientes());
			Arquivo.cadastrarFormasDePagameto(restaurante.getFormasDePagamento());
			Arquivo.cadastrarTiposDeEmbalagem(restaurante.getTiposDeEmbalagem());
			for (int i = 0; i < restaurante.getFuncionarios().size(); i++) {
				Arquivo.cadastrarFuncionario(restaurante.getFuncionarios().get(i));
			}
			for (int i = 0; i < restaurante.getCardapio().size(); i++) {
				Arquivo.cadastrarItem(restaurante.getCardapio().get(i));
			}
			for (int i = 0; i < restaurante.getRegistroDePedidos().size(); i++) {
				Arquivo.cadastrarRegistroDePedido(restaurante.getRegistroDePedidos().get(i), Integer.toString(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void limparTermial() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
}
