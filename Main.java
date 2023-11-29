import java.util.Scanner;

public class Main
{
	static Restaurante restaurante = new Restaurante();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		while (true) {
			int input;
			String[] itensMenu = new String[4]; //Itens do menu
			itensMenu[0] = new String("Cardapio");
			itensMenu[1] = new String("Funcionários");
			itensMenu[2] = new String("Recursos");
			itensMenu[3] = new String("Sair");

			limparTermial();
			System.out.format("======================== Restaurante ========================");
			input = Menu.menu(itensMenu);

			if (input == 3) break;

			switch (input) { 
				case 0:
					break;
				case 1:
					Menu.menuFuncionarios(restaurante);
					break;
				case 2:
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
