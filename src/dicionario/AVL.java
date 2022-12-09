package dicionario;

import java.util.HashMap;
import java.util.Map;

public class AVL {
    private Map<String, Integer> dicionario = new HashMap<>();
    private Node raiz;

    public void inserir(Dicionario palavra) throws Exception {
        this.raiz = insert(this.raiz, palavra);
    }

    private Node insert(Node raiz, Dicionario palavra) throws Exception {
        dicionario.put(palavra.getPalavra(), 1);

        if (raiz == null) {
            raiz = new Node(palavra);
        } else if (palavra.getPalavra().equals(raiz.getKey().getPalavra())) {
            throw new Exception("\npalavra já adicionada!\n");
        } else if (palavra.getPalavra().compareToIgnoreCase(raiz.getKey().getPalavra()) < 0) {
            raiz.setLeftChild(insert(raiz.getLeftChild(), palavra));
        } else {
            raiz.setRightChild(insert(raiz.getRightChild(), palavra));
        }

        return raiz;
    }

    public String pesquisar(String chave) {
        return pesquisar(this.raiz, chave);
    }

    private String pesquisar(Node raiz, String chave) {
        if (raiz == null) {
            return null;
        } else if (chave.equals(raiz.getKey().getPalavra())) {
            if (dicionario.containsKey(chave)) {
                dicionario.put(chave, dicionario.get(chave) + 1);
                System.out.println("\npalavra encontrada!\n");
            }
            return raiz.getKey().getPalavra();
        } else if (chave.compareToIgnoreCase(raiz.getKey().getPalavra()) > 0) {
            return pesquisar(raiz.getRightChild(), chave);
        } else {
            return pesquisar(raiz.getLeftChild(), chave);
        }
    }

    public Map<String, Integer> getDicionario() {
        return dicionario;
    }

    public Node getRaiz() {
        return raiz;
    }
}
