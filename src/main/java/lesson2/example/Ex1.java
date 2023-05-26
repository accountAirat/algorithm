package lesson2.example;

import java.util.Arrays;
import java.util.Random;

public class Ex1 {

    private static final Random rand = new Random();

    public static void main(String[] args) {
        int[] array = generatorRandom(10,1,15);
        int value = 10;
        Arrays.sort(array);
        printArray(array);
        System.out.printf("Value = %d Index = %d", value, binSearch(array, value));
    }

    public static int[] bubleSort(int[] unsorted) {
        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 0; j < unsorted.length - 1; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }
        return unsorted;
    }

    public static int[] directSort(int[] unsorted) {
        for (int i = 0; i < unsorted.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[j] < unsorted[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int temp = unsorted[i];
                unsorted[i] = unsorted[minPos];
                unsorted[minPos] = temp;
            }

        }
        return unsorted;
    }

    public static int[] insertSort(int[] unsorted) {
        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = i + 1; j < unsorted.length - 1; j++) {
                if (unsorted[j] < unsorted[i]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[i];
                    unsorted[i] = temp;
                }
            }
        }
        return unsorted;
    }

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array не отсортированный массив
     * @param startPos позиция начала
     * @param endPos позиция конца
     */
    public static void quickSort(int[] array, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = array[(startPos + endPos) / 2];
        do {
            while (array[leftPos] < pivot){
                leftPos++;
            }
            while (array[rightPos] > pivot){
                rightPos--;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);
        if (leftPos < endPos) {
            quickSort(array, leftPos, endPos);
        }
        if (rightPos > startPos) {
            quickSort(array, startPos, rightPos);
        }
    }

    public static int binSearch(int[] array, int value) {
        return binSearch(array, 0 , array.length -1, value);
    }

    public static int binSearch(int[] array, int start, int end, int value) {
        if (end < start) {
            return -1;
        }
        int pivot = (start + end) / 2;
        if (array[pivot] > value) {
            return binSearch(array, start, pivot - 1, value);
        } else if (array[pivot] < value) {
            return binSearch(array, pivot + 1, end, value);
        } else{
            return pivot;
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