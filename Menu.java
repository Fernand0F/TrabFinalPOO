import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Scanner;

import ClassesAuxiliares.Data;
import ClassesFuncionario.Funcionario;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Garcom;
import ClassesItem.Item;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;

public class Menu {
    public static int menu(String[] itens, String titulo) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int tamanhoLado = (60 - titulo.length()) / 2;
        String linha = "=".repeat(tamanhoLado) + " " + titulo + " " + "=".repeat(tamanhoLado);

        while (true) {
            Main.limparTermial();
            System.out.format(linha);
            for (int i = 0; i < itens.length; i++) {
                System.out.format("\n %d - %s", i, itens[i]);
            }
            System.out.format("\n=============================================================");

            System.out.format("\nOpção: ");

            try {
                input = scanner.nextInt();
            } catch(Exception e) {
                input = -1;
            } 
            if (input >= 0 || input < itens.length) break;
        }
         
        return input;   
    }

    //A fazer
    public static void menuPedidos(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Não tem nada");

        scanner.nextLine();
    }

    //A fazer
    public static void menuCardapio(Restaurante restaurante) {
        String[] itensMenuCardapio = new String[3]; //Itens do menu
        itensMenuCardapio[0] = new String("Ver Itens cadastrados");
        itensMenuCardapio[1] = new String("Cadastrar Item");
        itensMenuCardapio[2] = new String("Voltar");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            int input01 = Menu.menu(itensMenuCardapio, "Cardápio");

            if (input01 == 2) break; //sair do loop

            switch (input01) {
                case 0:
                    System.out.println();
                    if (restaurante.getCardapio().size() == 0) {
                        System.out.println("Nenhum item cadastrado");
                    } else {
                        restaurante.mostrarCardapio();
                    }

                    scanner.nextLine();
                    break;

                case 1:
                    cadastrarItem(restaurante);
                    break;
            }
        }
    }

    private static void cadastrarItem(Restaurante restaurante) {
        String[] itensMenuCadastroItem = new String[4]; //Itens do menu
        itensMenuCadastroItem[0] = new String("Cadastrar Prato Principal");
        itensMenuCadastroItem[1] = new String("Cadastrar Sobremesa");
        itensMenuCadastroItem[2] = new String("Cadastrar bebida");
        itensMenuCadastroItem[3] = new String("Voltar");


        while (true) {
            Main.limparTermial();

            int input01 = Menu.menu(itensMenuCadastroItem, "Cadastrar Item");

            if (input01 == 3) break;

            switch (input01) {
                case 0:
                    cadastrarPratoPrincial(restaurante);
                    break;
                case 1:
                    cadastrarSobremesa(restaurante);
                    break;
                case 2:
                    cadastrarBebida(restaurante);
                    break;
            }
        }
    }

    private static void cadastrarPratoPrincial(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        if (restaurante.getIngredientes().size() == 0) {

            System.out.println("Nenhum ingrediente cadastrado!");
            scanner.nextLine();

        } else {

            System.out.format("Nome do prato: ");
            String nome = scanner.nextLine();

            String codigo;
            while (true) {
                System.out.format("Código do prato [AA000]: ");
                codigo = scanner.nextLine();
                if (Item.validarCodigo(codigo)) {
                    break;
                } else {
                    System.out.format("\nCódigo inválido!\n\n");
                }
            }
            
            System.out.format("Decrição do prato: ");
            String descricao = scanner.nextLine();
            System.out.format("Preço unitário: ");
            double precoUnitario = scanner.nextDouble();
            System.out.format("Preço de custo: ");
            double precoCusto = scanner.nextDouble();
            System.out.format("Tempo de preparo: ");
            double tempoDePreparo = scanner.nextDouble();
            System.out.format("Valor pago ao cozinheiro: ");
            double valorPagoCozinheiro = scanner.nextDouble();

            ArrayList<String> listaIngredientes = new ArrayList<String>();
            ArrayList<String> intensMenuIng = new ArrayList<String>(restaurante.getIngredientes());
            intensMenuIng.add("Continuar");

            while (true) {
                Main.limparTermial();
            
                System.out.format("================== Ingredientes Adicionados =================\n");
                for (int i = 0; i < listaIngredientes.size(); i++) {
                    System.out.println(" - " + listaIngredientes.get(i));
                }
                System.out.format("\n=================== Adicionar Ingredientes ==================");
                
                for (int i = 0; i < intensMenuIng.size(); i++) {
                    System.out.format("\n %d - %s", i, intensMenuIng.get(i));
                }
                System.out.format("\n=============================================================");
                System.out.println("Opção: ");

                int input02 = scanner.nextInt();

                if (input02 == intensMenuIng.size()-1) break;
                else {
                    listaIngredientes.add(intensMenuIng.get(input02));
                }
            }

            listaIngredientes = listaIngredientes.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

            PratoPrincipal prato = new PratoPrincipal(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricao, tempoDePreparo, valorPagoCozinheiro);
            restaurante.cadastrarItem(prato);
            System.out.println("Prato cadastrado");
            scanner.nextLine();

        }
        
    }

    private static void cadastrarSobremesa(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);
        
        if (restaurante.getIngredientes().size() == 0) {

            System.out.println("Nenhum ingrediente cadastrado!");
            scanner.nextLine();

        } else {

            System.out.format("Nome do prato: ");
            String nome = scanner.nextLine();

            String codigo;
            while (true) {
                System.out.format("Código do prato [AA000]: ");
                codigo = scanner.nextLine();
                if (Item.validarCodigo(codigo)) {
                    break;
                } else {
                    System.out.format("\nCódigo inválido!\n\n");
                }
            }
            
            System.out.format("Decrição do prato: ");
            String descricao = scanner.nextLine();
            System.out.format("Número de calorias: ");
            double calorias = scanner.nextDouble();
            System.out.format("Preço unitário: ");
            double precoUnitario = scanner.nextDouble();
            System.out.format("Preço de custo: ");
            double precoCusto = scanner.nextDouble();
            System.out.format("Tempo de preparo: ");
            double tempoDePreparo = scanner.nextDouble();
            System.out.format("Valor pago ao cozinheiro: ");
            double valorPagoCozinheiro = scanner.nextDouble();

            ArrayList<String> listaIngredientes = new ArrayList<String>();
            ArrayList<String> intensMenuIng = new ArrayList<String>(restaurante.getIngredientes());
            intensMenuIng.add("Continuar");

            while (true) {
                Main.limparTermial();
            
                System.out.format("================== Ingredientes Adicionados =================\n");
                for (int i = 0; i < listaIngredientes.size(); i++) {
                    System.out.println(" - " + listaIngredientes.get(i));
                }
                System.out.format("\n=================== Adicionar Ingredientes ==================");
                
                for (int i = 0; i < intensMenuIng.size(); i++) {
                    System.out.format("\n %d - %s", i, intensMenuIng.get(i));
                }
                System.out.format("\n=============================================================");
                System.out.println("Opção: ");

                int input02 = scanner.nextInt();

                if (input02 == intensMenuIng.size()-1) break;
                else {
                    listaIngredientes.add(intensMenuIng.get(input02));
                }
            }

            listaIngredientes = listaIngredientes.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

            Sobremesa prato = new Sobremesa(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricao, tempoDePreparo, valorPagoCozinheiro, calorias);
            restaurante.cadastrarItem(prato);
            System.out.println("Prato cadastrado");
            scanner.nextLine();

        }
    }

    private static void cadastrarBebida(Restaurante restaurante) {
        
    }

    public static void menuFuncionarios(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuFuncionarios = new String[3]; //Itens do menu
        itensMenuFuncionarios[0] = new String("Ver Funcionários Cadastrados");
        itensMenuFuncionarios[1] = new String("Cadastrar Funcionário");
        itensMenuFuncionarios[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuFuncionarios, "Funcionário");
            
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
                    menuCadastroFuncionarios(restaurante);
                    break;
            }
        }
    }

    private static void menuCadastroFuncionarios(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] menuTipoFuncionario = new String[2];
        menuTipoFuncionario[0] = new String("Cozinheiro");
        menuTipoFuncionario[1] = new String("Garçom");

        int input01 = Menu.menu(menuTipoFuncionario, "Cadastrar Funcionário");

        System.out.format("=============================================================");
        System.out.format("\nNome: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.format("CPF: ");
            cpf = scanner.nextLine();

            if (Funcionario.validarCPF(cpf)) {
                break;
            }
            else {
                System.out.format("\nCPF inválido!\n\n");
            }
        }
        
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

        if (input01 == 0) { //Cozinheiro
            restaurante.cadastrarFuncionario(new Cozinheiro(nome, cpf, rg, ec, end, ct, new Data(dia,mes,ano)));
        } else if (input01 == 1) { //garçom
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

            // MUDAR
            System.out.format("Dia de Folga: ");
            System.out.format("\n=============================================================");
            for (int i = 0; i < 7; i++) {
                System.out.format("\n %d - %s", i, menuDiaFolga[i]);
            }
            System.out.format("\n=============================================================");
            System.out.println("\nOpção: ");
            int inputDiaFolga = scanner.nextInt();

            restaurante.cadastrarFuncionario(new Garcom(nome, cpf, rg, ec, end, ct, new Data(dia,mes,ano), sb, menuDiaFolga[inputDiaFolga]));
        }
    }

    public static void menuRecursos(Restaurante restaurante) {
        String[] itensMenuRecursos = new String[4];
        itensMenuRecursos[0] = new String("Ingredientes");
        itensMenuRecursos[1] = new String("Embalagens");
        itensMenuRecursos[2] = new String("Formas de Pagamento");
        itensMenuRecursos[3] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuRecursos, "Recursos");

            if (input01 == 3) break;

            switch (input01) {
                case 0:
                    menuIngredientes(restaurante);
                    break;
            
                case 1:
                    menuEmbalagens(restaurante);
                    break;
                
                case 2:
                    menuFormasDePagamento(restaurante);
                    break;
            }
        }
    }

    private static void menuIngredientes(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuIngredintes = new String[3]; //Itens do menu
        itensMenuIngredintes[0] = new String("Ver Ingredientes Cadastrados");
        itensMenuIngredintes[1] = new String("Cadastrar Ingrediente");
        itensMenuIngredintes[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuIngredintes, "Ingredientes");
            
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
                    System.out.println("Ingrediente cadastrado");
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void menuEmbalagens(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuEmbalagens = new String[3]; //Itens do menu
        itensMenuEmbalagens[0] = new String("Ver Embalagens Cadastradas");
        itensMenuEmbalagens[1] = new String("Cadastrar Embalagem");
        itensMenuEmbalagens[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuEmbalagens, "Embalagens");
            
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
                    System.out.println("Embalagem cadastrada");
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void menuFormasDePagamento(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuPagmento = new String[3]; //Itens do menu
        itensMenuPagmento[0] = new String("Ver Formas de Pagamento Cadastradas");
        itensMenuPagmento[1] = new String("Cadastrar Forma de Pagamento");
        itensMenuPagmento[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuPagmento, "Pagamento");
            
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
                    System.out.println("Forama de pagamento cadastrada");
                    scanner.nextLine();
                    break;
            }
        }
    }
}
