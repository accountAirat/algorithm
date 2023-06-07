package lesson4.HW;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.B;
            return result;
        } else {
            root = new Node();
            root.color = Color.B;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.R;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.R;
                    node.rightChild.value = value;
                    return true;
                }

            }
        }
    }

    public void print(){
        System.out.println(root.toString());
        List<Node> rootList= new ArrayList<>();
        rootList.add(root);
        print(rootList,1);
    }
    private void print(List<Node> curlevel, Integer level){
        String result="";
        level++;
        List<Node> nodes = new ArrayList<>();
        nodes.addAll(curlevel);
        List<Node> children = new ArrayList<>();
        for (Node node : nodes) {
            if (node.leftChild != null) {
                children.add(node.leftChild);
                result+=node.leftChild.toString();
                result+=" ";
            }
            if (node.rightChild != null) {
                children.add(node.rightChild);
                result+=node.rightChild.toString();
                result+=" ";
            }
        }
        if (!children.isEmpty()){
            System.out.println(result);
            print(children,level);
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.R &&
                    (result.leftChild == null || result.leftChild.color == Color.B)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.R &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.R) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.R &&
                    result.rightChild != null && result.rightChild.color == Color.R) {
                needRebalance = true;
                result = colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.R;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.R;
        return leftChild;
    }

    private Node colorSwap(Node node) {
        node.rightChild.color = Color.B;
        node.leftChild.color = Color.B;
        node.color = Color.R;
        return node;
    }

    private class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color {
        R, B
    }
}
