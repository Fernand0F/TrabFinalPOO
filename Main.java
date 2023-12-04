import java.util.Scanner;

public class Main
{
	static Restaurante restaurante = new Restaurante();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
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
