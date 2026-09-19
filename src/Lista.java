import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Lista {

    public static void menuLista(Scanner scanner) {

        int opcao = 0;
        ArrayList<String> produtos = new ArrayList<>(List.of("Pipoca", "Bala", "Pirulito"));


        do {


            try {
                System.out.println("==================================");
                System.out.println("     Lista - Lista de Compras     ");
                System.out.println("==================================");
                System.out.println(" 1 - Adcionar Produto");
                System.out.println(" 2 - remover Produto");
                System.out.println(" 3 - Mostrar Proudtos");
                System.out.println(" 4 - Procurar Produtos");
                System.out.println(" 0 - Voltar");
                System.out.println(" ");

                System.out.print(" Escolha: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao < 0 || opcao > 4) {
                    System.out.println("Valor invalido! Tente Novamente! ");
                    System.out.println(" ");
                    continue;
                }

                if (opcao != 0) {
                    escolhaMenuProduto(opcao, scanner, produtos);
                }

            } catch (InputMismatchException e) {
                System.out.println("Valor invalido! Tente Novamente!");
                scanner.nextLine();

            }


        } while (opcao != 0);

    }


    public static void escolhaMenuProduto(int opcao, Scanner scanner, ArrayList<String> produtos) {

        switch (opcao) {

            case 1:
                Lista.adcionarProdutos(scanner, produtos);
                break;


            case 2:
                Lista.removerProduto(scanner, produtos);
                break;

            case 3:
                Lista.verProdutos(produtos);
                break;

            case 4:
                Lista.encontrarProduto(scanner, produtos);
                break;


        }


    }


    public static void adcionarProdutos(Scanner scanner, ArrayList<String> produtos) {

        boolean continuarAddProd = true;

        while (continuarAddProd) {

            String addProd;

            while (true) {
                System.out.println("Digite o nome do produto que deseja adcionar: ");
                addProd = scanner.nextLine();
                if (produtos.contains(addProd)) {
                    System.out.println("Esse produto já existe na lista! Tente novamnte!");
                    System.out.println(" ");
                } else {
                    break;
                }
            }

            produtos.add(addProd);
            System.out.println("Produto Adcionado! ");


            boolean escolhaValida = false;
            while (!escolhaValida) {
                try {
                    System.out.println(" [1] Adcionar mais produtos ");
                    System.out.println(" [2] Voltar ao menu");
                    System.out.println(" escolha: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha == 1 || escolha == 2) {
                        escolhaValida = true;
                        continuarAddProd = (escolha == 1);
                    } else {
                        System.out.println("Valor Invalido! Tente novamente!");
                    }


                } catch (InputMismatchException e) {
                    System.out.println("Valor Invalido! Tente novamente!");
                    scanner.nextLine();
                }


            }


        }
    }

    public static void verProdutos(ArrayList<String> produtos) {

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + " - " + produtos.get(i));
        }
        System.out.println(" ");
    }

    public static void removerProduto(Scanner scanner, ArrayList<String> produtos) {

        if (produtos.size() == 0) {
            System.out.println("Não tem produtos Cadastrados!");
            return;
        }

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + " - " + produtos.get(i));
        }


        System.out.println(" ");
        System.out.println("Qual Produto deseja Remover? ");

        String produtoRemover = scanner.nextLine();

        try {
            int id = Integer.parseInt(produtoRemover);

            if (id >= 1 && id <= produtos.size()) {
                String produtoRemovido = produtos.remove(id - 1);
                System.out.println("O Produto: " + produtoRemovido + " Foi removido com sucesso!");
            } else {
                System.out.println("Numero invalido! Não existe produto com esse ID!");
            }

        } catch (NumberFormatException e) {

            boolean removido = false;

            for (String produto : produtos) {
                if (produto.equalsIgnoreCase(produtoRemover)) {
                    produtos.remove(produto);
                    removido = true;
                    break;
                }
            }

            if (removido) {
                System.out.println("Produto " + produtoRemover + " removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado na lista!");
            }


        }

    }


    public static void encontrarProduto(Scanner scanner, ArrayList<String> produtos) {

        System.out.println("Digite o Produto que deseja encontrar: ");
        String encontar = scanner.nextLine();

        boolean encontrado = false;

        for(int i = 0; i <produtos.size();i++){
            if (produtos.get(i).equalsIgnoreCase(encontar)){
                System.out.println((i + 1) + " - " + produtos.get(i));
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println(" produto nao encontrado ");
        }

    }
}




