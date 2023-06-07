package lesson4.HW;

import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {

        final  RedBlackTree tree = new RedBlackTree();
        for (int i = 0; i < 5; i++) {
            tree.add(i);
        }
        tree.print();

    }
}
