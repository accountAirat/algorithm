package lesson4.Homework.Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(50);
        tree.add(49);
        tree.add(51);
        tree.add(48);
        tree.add(52);

        TreeService ts = new TreeService(tree);
        ts.print();
    }


}
