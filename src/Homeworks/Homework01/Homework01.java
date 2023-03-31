package Homeworks.Homework01;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Homework01 {
    public static void main(String[] args) {
        /*
        Реализовать сортировку подсчетом
        Она заключается в подсчете количества вхождений элементов в массив и восстановление по этой информации.
        [1, 3, 1, 5, 7, 7, 3, 2, 5, 7]
        1 -> 2
        2 -> 1
        3 -> 2
        5 -> 2
        7 -> 3
        [1, 1, 2, 3, 3, 5, 5, 7, 7, 7]
         */

        // New random array
        int[] array = IntStream.generate(() -> ThreadLocalRandom.current().
                nextInt(-10,11)).limit(10).toArray();
        System.out.println(Arrays.toString(array));

        // Sorted array
        System.out.println(Arrays.toString(countSort(array)));
    }
    
    private static int[] countSort(int[] input) {
        // Find min and max. Create count array with amount of elements equal to the range from min to max +1
        int min = Arrays.stream(input).min().getAsInt();
        int max = Arrays.stream(input).max().getAsInt();
        int range = max - min + 1;
        // Create temporary array. The size of array equals to the range from min to max +1
        int[] count = new int[range];
        // Create output array for sorted elements
        int[] output = new int[input.length];

        // Fill count array. Index equals to element of input array;
        // value equals to the count of element of iteration
        for (int i = 0; i < input.length; i++) {
            count[input[i] - min]++;
        }

        // Create cumulative count of occurrences of each element of input array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Fill the output array.
        for (int i = input.length - 1; i >= 0 ; i--) {
            output[count[input[i] - min] - 1] = input[i];
            count[input[i] - min]--;
        }
        return output;
    }
}
