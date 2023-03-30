package Seminars.Seminar02;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Sorts {
    public static void main(String[] args) {
//        int[] array = IntStream.generate(() ->
//                ThreadLocalRandom.current().nextInt(100)).limit(20).toArray();
//        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        selectionSort(array);
//        insertionSort(array);
//        System.out.println(Arrays.toString(array));

        // UNSORTED ==============================================================================
        int[] array = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1000))
                .limit(100_000).toArray();

//        Consumer<int[]> consumer = it -> bubbleSort(it);
        // OR
        Consumer<int[]> consumer = new Consumer<int[]>() {
            @Override
            public void accept(int[] it) {
                bubbleSort(it);
            }
        };
        timer("Bubble Sort with random array", array, consumer);                    // 18862
        timer("Selection Sort with random array", array, Sorts::selectionSort); // 5196
        timer("Insertion Sort with random array", array, it -> insertionSort(it));  // 1054

        System.out.println();

        // SORTED =================================================================================
        array = IntStream.range(0, 100_000).toArray();

        timer("Bubble Sort with sorted array", array, Sorts::bubbleSort);       // 0
        timer("Selection Sort with sorted array", array, Sorts::selectionSort); // 4991
        timer("Insertion Sort with sorted array", array, Sorts::insertionSort); // 1

        System.out.println();

        // REVERSE SORTED ========================================================================
        array = IntStream.range(0, 100_000)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::valueOf)
                .toArray();

        timer("Bubble Sort with reverse sorted array", array, Sorts::bubbleSort);       // 6692
        timer("Selection Sort with reverse sorted array", array, Sorts::selectionSort); // 4463
        timer("Insertion Sort with reverse sorted array", array, Sorts::insertionSort); // 2294

        // =========================================================================================

    }

    private static void timer(String algoName, int[] array, Consumer<int[]> algorithm) {
//        int[] copy = Arrays.copyOf(array, array.length);
        long start = System.currentTimeMillis();
        algorithm.accept(Arrays.copyOf(array, array.length));
        long end = System.currentTimeMillis();
        System.out.println(algoName + ": " + (end - start));

    }

    private static long timer(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void bubbleSort(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            boolean sorted = true;
//            for (int j = 0; j < array.length - 1 - i; j++) {
//                if (array[j + 1] < array[j]) {
//                    sorted = false;
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//            if(sorted) {
//                break;
//            }
//        }

        // OPTION 2: without break but with sorted as condition for loop end
        boolean sorted = false;
        for (int i = 0; i < array.length && !sorted; i++) {
            sorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    sorted = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // OPTION 1
//            int min = array[i];
//            int minPosition = i;
//            for (int j = i + 1; j < array.length; j++) {
//                if(array[j] < min){
//                    min = array[j];
//                    minPosition = j;
//                }
//            }
//            if(i != minPosition) {
//                int temp = array[i];
//                array[i] = array[minPosition];
//                array[minPosition] = temp;
//            }

            // OPTION 2
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minPosition]){
                    minPosition = j;
                }
            }
            if(i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    private static void insertionSort(int[] array) {
        // OPTION 1: current position comparing to elements on the left
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while(j > 0 && current < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }

        // OPTION 2: current position comparing to elements on the right
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if(array[i] > array[j]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
    }





}
