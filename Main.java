import java.util.Scanner;

public class Main
{
	static Restaurante restaurante = new Restaurante();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		while (true) {
			int input;
			String[] itensMenu = new String[6]; //Itens do menu
			itensMenu[0] = new String("Cardapio");
			itensMenu[1] = new String("Funcionários");
			itensMenu[2] = new String("Ingredientes");
			itensMenu[3] = new String("Embalagens");
			itensMenu[4] = new String("Formas de Pagamento");
			itensMenu[5] = new String("Sair");

			limparTermial();
			System.out.format("======================== Restaurante ========================");
			input = Menu.menu(itensMenu);

			if (input == 5) break;

			switch (input) { 
				case 0:
					break;
				case 1:
					Menu.menuFuncionarios(restaurante);
					break;
				case 2:
					Menu.menuIngredientes(restaurante);
					break;
				case 3:
					Menu.menuEmbalagens(restaurante);
					break;
				case 4:
					Menu.menuFormasDePagamento(restaurante);
					break;
			}
		}
	}

	public static void limparTermial() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
}
