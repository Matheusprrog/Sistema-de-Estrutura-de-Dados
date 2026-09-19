import java.util.InputMismatchException;
import java.util.Scanner;

public class Vetor {

    public static void adicionarNotas(Scanner scanner) {

        double[] notas = new double[5];
        double total = 0.00;

        System.out.println("==============================");
        System.out.println("   Vetor - Nota dos Alunos    ");
        System.out.println("==============================");


        for (int i = 0; i <= 4; i++) {

            try {
                System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
                double valorNota = scanner.nextDouble();
                if (valorNota < 0.00 || valorNota > 10.00) {
                    System.out.println("Valor invalido! Tente Novamente!");
                    System.out.println(" ");
                    i--;
                    continue;
                }
                notas[i] = valorNota;
                total += valorNota;


            } catch (InputMismatchException e) {
                System.out.println("Valor invalido! Tente Novamente!");
                System.out.println(" ");
                scanner.nextLine();
                i--;
                continue;
            }


        }

        exibirSituacao(notas, total);

    }


    public static void exibirSituacao(double[] notas, double total) {

        double media = total / notas.length;

        System.out.println(" ");

        for (int i = 0; i <= 4; i++) {
            System.out.printf("Aluno  %d: %.2f\n", (i + 1), notas[i]);
        }

        System.out.println("");
        System.out.printf("Média da turma: %.2f\n", media);

        String situacao = (media < 6.0) ? "Turma de Recuperação" : "Turma Aprovada";
        System.out.println(situacao);

    }


}
