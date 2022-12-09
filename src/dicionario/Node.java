package dicionario;

public class Node {
    private Dicionario key;
    private Node rightChild;
    private Node leftChild;

    Node(Dicionario key) {
        this.key = key;
        leftChild = null;
        rightChild = null;
    }

    public Node(String string) {
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Dicionario getKey() {
        return key;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}