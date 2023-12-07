// import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;

import ClassesAuxiliares.Data;
import ClassesAuxiliares.Hora;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Funcionario;
import ClassesFuncionario.Garcom;
import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;
import ClassesPedido.Pedido;
import ClassesPedido.PedidoItem;

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
	}

	public static void limparTermial() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
}
