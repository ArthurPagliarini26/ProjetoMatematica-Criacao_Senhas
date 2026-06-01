package Analise_de_Senhas;

import java.util.Scanner;

public class Arranjo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("   GERADOR DE SENHAS - ARRANJOS C/ REPETIÇÃO");
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
            System.out.print("\nEscolha uma opção (1 a 4): ");
            opcao = scanner.nextInt();

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao < 1 || opcao > 4);

        int n = 0;
        String descricao = "";

        switch (opcao) {
            case 1 -> { n = 10; descricao = "somente números (0-9)"; }
            case 2 -> { n = 26; descricao = "somente letras (a-z)"; }
            case 3 -> { n = 36; descricao = "letras + números"; }
            case 4 -> { n = 48; descricao = "letras + números + símbolos"; }
        }

        System.out.print("\nQual o tamanho da senha que deseja criar? ");
        int p = scanner.nextInt();

        if (p <= 0) {
            System.out.println("\nErro: o tamanho da senha deve ser maior que zero.");
            return;
        }

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

        if (resultado < 1_000) {
            System.out.println("Nível de segurança: ⚠ MUITO FRACA");
        } else if (resultado < 1_000_000) {
            System.out.println("Nível de segurança: 🔓 FRACA");
        } else if (resultado < 1_000_000_000) {
            System.out.println("Nível de segurança: 🔒 MODERADA");
        } else {
            System.out.println("Nível de segurança: 🛡 FORTE");
        }

        System.out.println("============================================");

        scanner.close();
    }
}