import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class OptimalTree {

    static int optimalSearchTree(String keys[], int freq[], int n) {

        int cost[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L + 1; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                int off_set_sum = sum(freq, i, j);

                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + off_set_sum;
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }

    static void display(String[] keys, int[] freq) {
        System.out.println("Palavras e frequência: ");
        for (int i = 0; i < keys.length; i++) {
                System.out.print(keys[i] + "(" + freq[i] + ")" + " ");
            
		}

        System.out.println("");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String path = "";
        Map<String, Integer> dicionario = new HashMap<>();

        System.out.println("*** ÁRVORE BINÁRIA DE BUSCA ÓTIMA ***\n");
        System.out.print("Digite o nome do arquivo (O mesmo deve estar no disco C:/ e possuir extensão .txt): ");
        path = in.nextLine();
        System.out.println();

        in.close();

        try (Scanner input = new Scanner(new File(String.format("C:\\%s.txt", path)))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] content = line.split("\n");

                for (int i = 0; i < content.length; i++) {
                    if (dicionario.containsKey(content[i])) {
                        dicionario.put(content[i], dicionario.get(content[i]) + 1);
                    } else {
                        dicionario.put(content[i], 1);
                    }
                }
            }

            String[] keys = new String[dicionario.size()];
            int[] freq = new int[dicionario.size()];
            int n = 0;

            for (Entry<String, Integer> e : dicionario.entrySet()) {
                keys[n] = e.getKey();
                freq[n] = e.getValue();
                n++;
            }

            display(keys, freq);
            System.out.println();

            System.out.println("O custo do BST ideal é: "
                    + optimalSearchTree(keys, freq, n));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

// This code is contributed by Sumit Ghosh - BY GEEKS FOR GEEKS:
// https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
// (Com adaptações do grupo)
