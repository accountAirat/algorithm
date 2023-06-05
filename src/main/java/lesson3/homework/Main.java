package lesson3.homework;

import java.util.Random;

public class Main {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll = generatorRandom(10,10,100);
        System.out.println(ll);
        // Метод разворота связного списка
        ll.revert();
        System.out.println(ll);
        //Вывод n-го числа с конца односвязного списка, предварительно не узнавая его размер(за 1 цикл while) : )
        System.out.println(ll.index(2));
    }
    public static LinkedList generatorRandom(int size, int minValue, int maxValur) {
        LinkedList result = new LinkedList();
        for (int i = 0; i < size; i++) {
            result.add(rand.nextInt(minValue, maxValur));
        }
        return result;
    }
}


