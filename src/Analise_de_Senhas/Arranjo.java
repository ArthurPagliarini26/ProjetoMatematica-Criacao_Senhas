package Analise_de_Senhas;

import java.util.Scanner;

public class Arranjo {

    public static void main(String[] args) {

        /*
        Esse é o código feito pela dupla, ele contém a lógica do nosso trabalho.
        Para gerar o código html pegamos essa lógica e jogamos na IA e ela replicou a mesma lógica em javaScript
        para você ter um entendimento melhor do nosso trabalho
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("   GERADOR DE SENHAS - ARRANJOS COM REPETIÇÃO");
        System.out.println("============================================");

        System.out.print("\nQual é o seu nome? ");
        String nome = scanner.nextLine();

        System.out.println("\nOlá, " + nome + "! Vamos calcular quantas senhas você pode criar.");

        int opcao;

        do {
            System.out.println("\nQue tipo de caracteres sua senha vai usar?");
            System.out.println("1 - Somente números        (0 a 9)         → 10 caracteres disponíveis");
            System.out.println("2 - Somente letras         (a a z)         → 26 caracteres disponíveis");
            System.out.println("3 - Letras + números       (a-z e 0-9)     → 36 caracteres disponíveis");
            System.out.println("4 - Letras + núm. + símb.  (!@#$ etc.)     → 48 caracteres disponíveis");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao < 0 || opcao > 4);

        if (opcao == 0) {
            System.out.println("\nPrograma encerrado.");
            scanner.close();
            return;
        }

        int n = 0;
        String descricao = "";

        switch (opcao) {
            case 1 -> {
                n = 10;
                descricao = "somente números (0-9)";
            }
            case 2 -> {
                n = 26;
                descricao = "somente letras (a-z)";
            }
            case 3 -> {
                n = 36;
                descricao = "letras + números";
            }
            case 4 -> {
                n = 48;
                descricao = "letras + números + símbolos";
            }
        }

        int p;

        do {
            System.out.print("\nQual o tamanho da senha que deseja criar? ");
            p = scanner.nextInt();

            if (p <= 0) {
                System.out.println("O tamanho da senha deve ser maior que zero.");
            }

        } while (p <= 0);

        long resultado = (long) Math.pow(n, p);

        System.out.println("\n============================================");
        System.out.println("              RESULTADO");
        System.out.println("============================================");
        System.out.println("Nome         : " + nome);
        System.out.println("Caracteres   : " + descricao);
        System.out.println("Disponíveis  : " + n + " caracteres (n)");
        System.out.println("Tamanho senha: " + p + " dígitos (p)");
        System.out.println("--------------------------------------------");
        System.out.println("Fórmula: AR(n,p) = n^p");
        System.out.println("AR(" + n + "," + p + ") = " + n + "^" + p);
        System.out.println("AR(" + n + "," + p + ") = " + resultado);
        System.out.println("--------------------------------------------");
        System.out.println("Você pode criar " + resultado + " senhas diferentes!");

        if (resultado < 1000) {
            System.out.println("Nível de segurança: MUITO FRACA");
        } else if (resultado < 1000000) {
            System.out.println("Nível de segurança: FRACA");
        } else if (resultado < 1000000000) {
            System.out.println("Nível de segurança: MODERADA");
        } else if (resultado < 2147483647){
            System.out.println("Nível de segurança: FORTE");
        } else {
            System.out.println("Nível de segurança: MUITO FORTE");
        }

        System.out.println("============================================");

        scanner.close();
    }
}