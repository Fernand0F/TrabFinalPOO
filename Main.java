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

			limparTermial();
			System.out.format("======================== Restaurante ========================");
			input = Menu.menu(itensMenu);

			if (input == 4) break;

			switch (input) { 
				case 0:
					break;
				case 1:
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
