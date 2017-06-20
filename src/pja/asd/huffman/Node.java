package pja.asd.huffman;

public class Node implements Comparable<Node> {
    private String text;
    private int weight;
    private Node left;
    private Node right;

    public Node() {}

    public Node(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    public Node(String text, int weight, Node left, Node right) {
        this.text = text;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{text=" + text + ", weight=" + weight + ", left=" + left + ", right=" + right + "}";
    }

    @Override
    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}
