import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static void exibirMenu(Scanner scanner) {

        int opcao = 0;

        do {


            try {
                System.out.println("==================================");
                System.out.println("  Sistema de Estrutura de Dados   ");
                System.out.println("==================================");
                System.out.println(" 1 - Vetor");
                System.out.println(" 2 - Listas");
                System.out.println(" 3 - Lista Empilhada");
                System.out.println(" 4 - Lista Duplamente Encadeada");
                System.out.println(" 5 - Pilha");
                System.out.println(" 0 - Sair");
                System.out.println(" ");

                System.out.print(" Escolha: ");
                opcao = scanner.nextInt();

                if (opcao < 0 || opcao > 5) {
                    System.out.println("Valor invalido! Tente Novamente! ");
                    continue;
                }

                if (opcao != 0) {
                    escolhaMenu(opcao, scanner);
                }

            } catch (InputMismatchException e) {
                System.out.println("Valor invalido! Tente Novamente!");
                scanner.nextLine();

            }


        } while (opcao != 0);


        escolhaMenu(opcao, scanner);

    }


    public static void escolhaMenu(int opcao, Scanner scanner) {


        switch (opcao) {

            case 1:
                Vetor.adicionarNotas(scanner);
                break;


            case 2:
                Lista.menuLista(scanner);
                break;

            case 3:

            case 4:

            case 5:


        }

    }


}

