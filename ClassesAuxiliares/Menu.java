package ClassesAuxiliares;

import java.util.Scanner;

public class Menu {
    public static int menu(String[] itens) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;

        for (int i = 0; i < itens.length; i++) {
            System.out.format("\n %d - %s", i, itens[i]);
        }
        System.out.format("\n=============================================================");

        System.out.format("\nOpção: ");


        input = scanner.nextInt();

        return input;
    }
}
