package lesson2.homework;

import java.util.Arrays;
import java.util.Random;

public class Hw1 {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        int[] array = generatorRandom(10, 1, 15);
        printArray(array);
        sort(array);
        printArray(array);
    }

    public static void sort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapsort(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapsort(array, i, 0);
        }

    }

    public static void heapsort(int[] array, int heapSize, int upperIndex) {
        int upper = upperIndex;
        int left = 2 * upperIndex + 1;
        int right = 2 * upperIndex + 2;

        if (left < heapSize && array[left] > array[upper]) {
            upper = left;
        }
        if (right < heapSize && array[right] > array[upper]) {
            upper = right;
        }
        if (upper != upperIndex) {
            int temp = array[upperIndex];
            array[upperIndex] = array[upper];
            array[upper] = temp;

            heapsort(array, heapSize, upper);
        }
    }

    public static int[] generatorRandom(int size, int minValue, int maxValur) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(minValue, maxValur);
        }
        return result;
    }

    public static void printArray(int[] toPrint) {
        for (int element :
                toPrint) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
