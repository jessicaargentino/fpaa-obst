package dicionario;

import java.util.Map.Entry;

public class OptimalBinarySearchTree {
    private String[] keys;
    private double[][] expectedCosts;
    private double[][] weights;
    private int[][] roots;
    private Node root;
    private int[] original;
    private int[] otima;
    private int n;

    public OptimalBinarySearchTree(AVL arvore) {
        keys = new String[arvore.getDicionario().size()];
        original = new int[arvore.getDicionario().size()];
        otima = new int[arvore.getDicionario().size()];

        for (Entry<String, Integer> e : arvore.getDicionario().entrySet()) {
            keys[n] = e.getKey();
            otima[n] = e.getValue();
            original[n] = 1;
            n++;
        }

        expectedCosts = new double[n + 1][n];
        weights = new double[n + 1][n];
        roots = new int[n + 1][n];
        OptimalBST(original, otima, n);
        this.root = arvore.getRaiz();
    }

    private void OptimalBST(int[] p, int[] q, int n) {
        for (int i = 1; i < (n + 1); i++) {
            expectedCosts[i][i - 1] = q[i - 1];
            weights[i][i - 1] = q[i - 1];
        }

        for (int l = 1; l < n; l++) {
            for (int i = 1; i < (n - l + 1); i++) {
                int j = i + l - 1;
                expectedCosts[i][j] = Integer.MAX_VALUE;
                weights[i][j] = weights[i][(j - 1)] + p[j] + q[j];

                for (int r = i; r < j + 1; r++) {
                    double t = expectedCosts[i][(r - 1)] + expectedCosts[(r + 1)][j] + weights[i][j];
                    if (t < expectedCosts[i][j]) {
                        expectedCosts[i][j] = t;
                        roots[i][j] = r;
                    }
                }
            }
        }
    }

    public String[] getKeys() {
        return keys;
    }

    public double[][] getExpectedCosts() {
        return expectedCosts;
    }

    public double[][] getWeights() {
        return weights;
    }

    public int[][] getRoots() {
        return roots;
    }

    public int[] getOtima() {
        return otima;
    }

    public void inOrder() {
        inOrderUtil(root);
    }

    private void inOrderUtil(Node treeNode) {

        if (treeNode != null) {

            inOrderUtil(treeNode.getLeftChild());

            System.out.println("\nNó atual: " + treeNode.getKey().getPalavra()
                    + "\n-----------------------------------------------\n");

            if (treeNode.getLeftChild() != null) {
                System.out.printf("\tfilho esquerdo de %s é %s\n", treeNode.getKey().getPalavra(),
                        treeNode.getLeftChild().getKey().getPalavra());
            } else {
                System.out.printf("\tfilho esquerdo de %s é NULL\n", treeNode.getKey().getPalavra());
            }

            if (treeNode.getRightChild() != null) {
                System.out.printf("\tfilho direito de %s é %s\n", treeNode.getKey().getPalavra(),
                        treeNode.getRightChild().getKey().getPalavra());
            } else {
                System.out.printf("\tfilho direito de %s é NULL\n", treeNode.getKey().getPalavra());
            }

            inOrderUtil(treeNode.getRightChild());
        }
    }
}
