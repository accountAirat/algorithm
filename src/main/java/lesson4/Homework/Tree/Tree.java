package lesson4.Homework.Tree;

public class Tree {
    private Node root;

    @Override
    public String toString() {
        String str = "";
        return toString(root, str);
    }

    private  String toString(Node curentNode, String str) {
        if (curentNode != null) {
            str += curentNode.getValue().toString() + " ";
            str = toString(curentNode.getLeft(), str);
            str = toString(curentNode.getRight(), str);
        }
        return str;

    }

    public Node getRoot() {
        return root;
    }


    /**
     * Решение рекурсией
     * @param value
     * @return
     */
    public boolean contains(Integer value) {
        if (root == null){
            return false;
        }
        return contains(root, value);
    }

    private boolean contains(Node node, Integer value) {
        if (node.getValue().equals(value)){
            return true;
        } else {
            if (node.getValue().equals(value)){
                return contains(node.getLeft(), value);
            } else {
                return contains(node.getRight(), value);
            }
        }
    }

    public boolean add(Integer value) {
        Node node = new Node();
        node.setValue(value);
        if (root == null) {
            root = node;
            return true;
        }
        return add(node, root);
    }

    private boolean add(Node newNode, Node topNode) {
        if (newNode.compareTo(topNode) >= 0){
            if (topNode.getLeft() == null) {
                topNode.setLeft(newNode);
                return true;
            } else {
                return add(newNode, topNode.getLeft());
            }
        } else {
            if (topNode.getRight() == null) {
                topNode.setRight(newNode);
            } else {
                return add(newNode, topNode.getRight());
            }
        }
        return false;
    }
}
