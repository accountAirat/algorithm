package lesson2.example;

import java.util.Date;

public class Ex2 {
    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i = i + 10000) {
            int[] array = new int[i];
            for (int j = 0; j < array.length; j++) {
                array[j] = (int) (Math.random() * 10000);
            }
            Date startDate = new Date();
            Ex1.bubleSort(array);
            Date endDate = new Date();
            long bubbleSortDuration = endDate.getTime() - startDate.getTime();

            for (int j = 0; j < array.length; j++) {
                array[j] = (int) (Math.random() * 10000);
            }
            startDate = new Date();
            Ex1.quickSort(array, 0, array.length - 1);
            endDate = new Date();
            long quickSortDuration = endDate.getTime() - startDate.getTime();
            System.out.printf("i: %s, bubble sort duration: %s, quick sort duration: %s%n", i, bubbleSortDuration,
                    quickSortDuration);
        }
    }
}
