import ClassesAuxiliares.Menu;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Garcom;
import ClassesAuxiliares.Data;
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
				case 0: //Menu Itens
					break;
			
				case 1: //Menu Funcionários
					
					while (true) {
						String[] itensMenuFuncionarios = new String[3]; //Itens do menu
						itensMenuFuncionarios[0] = new String("Ver Funcionários Cadastrados");
						itensMenuFuncionarios[1] = new String("Cadastrar Funcionário");
						itensMenuFuncionarios[2] = new String("Voltar");

						limparTermial();
						System.out.format("======================== Funcionário ========================");
						int input01 = Menu.menu(itensMenuFuncionarios);
						
						if (input01 == 2) break; //sair do loop

						switch (input01) {
							case 0:
								System.out.println();
								if (restaurante.getFuncionarios().size() == 0) {
									System.out.println("Nenhum funcionário cadastrado");
								} else {
									restaurante.mostrarFuncionarios();
								}

								scanner.nextLine();
								break;

							case 1:
								String[] menuTipoFuncionario = new String[2];
								menuTipoFuncionario[0] = new String("Cozinheiro");
								menuTipoFuncionario[1] = new String("Garçom");

								System.out.format("\nCadastrar:");
								System.out.format("\n=============================================================");	
								int input02 = Menu.menu(menuTipoFuncionario);

								System.out.format("=============================================================");
								System.out.format("\nNome: ");
								String nome = scanner.nextLine();
								System.out.format("CPF: ");
								String cpf = scanner.nextLine();
								System.out.format("RG: ");
								String rg = scanner.nextLine();
								System.out.format("Estado Civil: ");
								String ec = scanner.nextLine();
								System.out.format("Endereço: ");
								String end = scanner.nextLine();
								System.out.format("Carteira de Trabalho: ");
								String ct = scanner.nextLine();
								
								System.out.format("Data de Adimissão: ");
								System.out.format("\n - Dia: ");
								int dia = scanner.nextInt();
								System.out.format(" - Mes: ");
								int mes = scanner.nextInt();
								System.out.format(" - Ano: ");
								int ano = scanner.nextInt();

								if (input02 == 0) { //Cozinheiro
									restaurante.cadastrarFuncionario(new Cozinheiro(nome, cpf, rg, ec, end, ct, new Data(dia,mes,ano)));
								} else if (input02 == 1) { //garçom
									System.out.format("Salário Base: ");
									double sb = scanner.nextFloat();

									String[] menuDiaFolga = new String[7];
									menuDiaFolga[0] = new String("Domingo");
									menuDiaFolga[1] = new String("Segunda");
									menuDiaFolga[2] = new String("terça");
									menuDiaFolga[3] = new String("Quarta");
									menuDiaFolga[4] = new String("Quinta");
									menuDiaFolga[5] = new String("Sexta");
									menuDiaFolga[6] = new String("Sábado");

									System.out.format("Dia de Folga: ");
									int inputDiaFolga = Menu.menu(menuDiaFolga);

									restaurante.cadastrarFuncionario(new Garcom(nome, cpf, rg, ec, end, ct, new Data(dia,mes,ano), sb, menuDiaFolga[inputDiaFolga]));
								}

								break;
						}
					}

					break;

				case 2: //Menu Ingredientes

					while (true) {
						String[] itensMenuIngredintes = new String[3]; //Itens do menu
						itensMenuIngredintes[0] = new String("Ver Ingredientes Cadastrados");
						itensMenuIngredintes[1] = new String("Cadastrar Ingrediente");
						itensMenuIngredintes[2] = new String("Voltar");

						limparTermial();
						System.out.format("======================= Ingredientes ========================");
						int input01 = Menu.menu(itensMenuIngredintes);
						
						if (input01 == 2) break; //sair do loop

						switch (input01) {
							case 0:
								System.out.println();
								if (restaurante.getIngredientes().size() == 0) {
									System.out.println("Nenhum ingrediente cadastrado");
								} else {
									restaurante.mostrarIngredientes();
								}
								
								scanner.nextLine();
								break;

							case 1:
								System.out.format("\nDigite o nome do ingrediente a ser cadastrado: ");
								String nomeIngrediente = scanner.nextLine();
								restaurante.cadastrarIngrediente(nomeIngrediente);
								break;
						}
					}

					break;

				case 3: //Menu Embalagens

					while (true) {
						String[] itensMenuEmbalagens = new String[3]; //Itens do menu
						itensMenuEmbalagens[0] = new String("Ver Embalagens Cadastradas");
						itensMenuEmbalagens[1] = new String("Cadastrar Embalagem");
						itensMenuEmbalagens[2] = new String("Voltar");

						limparTermial();
						System.out.format("======================== Embalagens =========================");
						int input01 = Menu.menu(itensMenuEmbalagens);
						
						if (input01 == 2) break; //Sair do loop

						switch (input01) {
							case 0:
								System.out.println();
								if (restaurante.getTiposDeEmbalagem().size() == 0) {
									System.out.println("Nenhuma embalagem cadastrada");
								} else {
									restaurante.mostrarEmbalagens();
								}
								
								scanner.nextLine();
								break;

							case 1:
								System.out.format("\nDigite o nome da embalagem a ser cadastrada: ");
								String nomeEmbalagem = scanner.nextLine();
								restaurante.cadastrarEmbalagem(nomeEmbalagem);
								break;
						}
					}

					break;

				case 4: //Menu Formas de Pagamento

					while (true) {
						String[] itensMenuPagmento = new String[3]; //Itens do menu
						itensMenuPagmento[0] = new String("Ver Formas de Pagamento Cadastradas");
						itensMenuPagmento[1] = new String("Cadastrar Forma de Pagamento");
						itensMenuPagmento[2] = new String("Voltar");

						limparTermial();
						System.out.format("========================= Pagamento =========================");
						int input01 = Menu.menu(itensMenuPagmento);
						
						if (input01 == 2) break; //Sair do loop

						switch (input01) {
							case 0:
								System.out.println();
								if (restaurante.getFormasDePagamento().size() == 0) {
									System.out.println("Nenhuma forma de pagamento cadastrada");
								} else {
									restaurante.mostrarFormasDePagamento();
								}
								
								scanner.nextLine();
								break;

							case 1:
								System.out.format("\nDigite o nome da Forma de Pagamento a ser cadastrada: ");
								String nomeForma = scanner.nextLine();
								restaurante.cadastrarFormaDePagamento(nomeForma);
								break;
						}
					}

					break;
			}
		}
	}

	public static void limparTermial() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}

	//System.out.println();
}
