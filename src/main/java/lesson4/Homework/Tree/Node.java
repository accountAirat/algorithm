package lesson4.Homework.Tree;

import java.util.Comparator;

public class Node{
    private Integer value;
    private Node left;
    private Node right;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
        return "" + value;
    }

    public int compareTo(Node o) {
        return value.compareTo(o.value);
    }
}
