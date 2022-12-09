package dicionario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 1;

        AVL dicionario = new AVL();

        try {
            while (option >= 1 && option < 4) {
                System.out.println("DICIONÁRIO - FPAA #2ND TRAB");
                System.out.println("(1) - inserir palavra");
                System.out.println("(2) - buscar palavra");
                System.out.println("(3) - visualizar árvore de palavras mais buscadas");
                System.out.println("(4) - sair");
                System.out.print("escolha: ");
                option = in.nextInt();

                directOption(option, in, dicionario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        in.close();

    }

    static void directOption(int option, Scanner in, AVL arvore)
            throws Exception {
        in.nextLine();
        switch (option) {
            case 1:
                System.out.print("digite a palavra a ser inserida: ");
                String p = in.nextLine();
                arvore.inserir(new Dicionario(p));
                break;
            case 2:
                System.out.print("Digite a palavra a ser buscada: ");
                String palavra = in.nextLine();
                arvore.pesquisar(palavra);
                break;
            case 3:
                printResults(arvore);
                break;
            case 4:
                System.out.println("obrigada por utilizar!");
                break;

            default:
                System.out.println("opção inválida!");
                break;
        }
    }

    public static void printResults(AVL arvore) {
        OptimalBinarySearchTree obst = new OptimalBinarySearchTree(arvore);
        System.out.println("\nChaves e frequências da árvore \n-------------------------------");
        String[] keys = obst.getKeys();
        int[] frequencia = obst.getOtima();
        for (int i = 0; i < keys.length; i++) {
            System.out.printf("%s(%d)\n", keys[i], frequencia[i]);
        }
        obst.inOrder();
        System.out.println("\n");
    }
}
