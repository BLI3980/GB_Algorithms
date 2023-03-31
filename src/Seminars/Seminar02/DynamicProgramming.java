package Seminars.Seminar02;

import java.util.concurrent.ThreadLocalRandom;

public class DynamicProgramming {
    public static void main(String[] args) {
        // =========================================================================================
        // Problem 1. There is a map. We are in the left upper corner of it. We can move either right or down
        // by one position at a time.
        // Task: calculate the amount of ways to reach the right lower corner of the map.
        // Input data is n and m for rows and columns

        /*
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
        [x] [x] [x] [x] [x] [x] [x] [x] [x] [x]
         */

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print("[x] ");
//            }
//            System.out.println();
//        }

//        System.out.println(findWaysCount(2, 2)); // n = 2; m = 2 -> 2
//        System.out.println(findWaysCount(2, 3)); // n = 2; m = 3 -> 3
//        System.out.println(findWaysCount(2, 4)); // n = 2; m = 4 -> 4
//        System.out.println(findWaysCount(3, 3)); // n = 3; m = 3 -> 6
//        System.out.println(findWaysCount(4, 4)); // n = 4; m = 4 -> 20
        // =========================================================================================
        // Problem 2. There is a map with gold in each position. We are in the left upper corner of it.
        // We can move either right or down by one position at a time.
        // Task: find a route which will give us the high amount of gold
        // Input data is n and m for rows and columns

        /*
        [ 4] [-2] [ 3] [ 6] [ 2] [-5] [ 6] [ 5] [ 4] [ 7]
        [-4] [-1] [-7] [-4] [-6] [ 7] [ 8] [ 2] [ 9] [-7]
        [-5] [-3] [ 1] [ 8] [ 0] [-3] [-4] [-9] [-4] [ 9]
        [ 7] [-5] [-9] [-4] [ 3] [-8] [-1] [-2] [ 1] [ 8]
        [ 8] [-2] [ 6] [ 4] [-7] [ 1] [ 3] [-3] [-2] [-3]
        [-3] [ 2] [ 2] [-8] [ 5] [ 0] [ 3] [ 1] [-1] [-3]
        [ 3] [-9] [-8] [-8] [ 4] [-8] [ 9] [-4] [-3] [-1]
        [-7] [ 7] [-7] [ 0] [ 7] [-4] [ 3] [ 2] [-7] [-6]
        [-6] [-4] [ 4] [-5] [-3] [-7] [ 3] [ 2] [ 0] [-5]
        [-6] [ 3] [ 2] [ 8] [ 0] [ 4] [-2] [-3] [-8] [ 6]
         */

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                int random = ThreadLocalRandom.current().nextInt(-9, 10);
////                String output = random >= 0 ? "[ " + random + "] " : "[" + random + "] ";
////                System.out.print(output);
//                // or
//                System.out.print(random >= 0 ? "[ " + random + "] " : "[" + random + "] ");
//            }
//            System.out.println();
//
//        }
        // initial array
        int n = 4;
        int m = 4;
        int[][] array = new int[n][m];

        // fill array with random numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int random = ThreadLocalRandom.current().nextInt(-9, 10);
//                String output = random >= 0 ? "[ " + random + "] " : "[" + random + "] ";
//                System.out.print(output);
                // or
                array[i][j] = random;
                System.out.print(random >= 0 ? "[ " + random + "] " : "[" + random + "] ");
            }
            System.out.println();

        }
        // new array with sums at each position
        System.out.println();
        int[][] sumArray = routeSums(array);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int output = sumArray[i][j];
                System.out.print(sumArray[i][j] >= 0 ? "[ " + sumArray[i][j] + "] "
                        : "[" + sumArray[i][j] + "] ");
            }
            System.out.println();

        }
        // result of the maximum amount of gold which could be gotten
        System.out.println();
        System.out.println(findBestWay(array));


    }

    static int findWaysCount(int n, int m) {
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    array[i][j] = 1;
                    continue;
                }
                array[i][j] = array[i][j - 1] + array[i - 1][j];
            }
        }
        return array[n - 1][m - 1];
    }

    static int findBestWay(int[][] map) {
        int n = map[0].length;
        int m = map[1].length;
        int[][] array = new int[n][n];
        array[0][0] = map[0][0];
        int sum = 0;
        int add = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    array[i][j] = array[i][j - 1] + map[i][j];
                    continue;
                } else if (j == 0){
                    array[i][j] = array[i - 1][j] + map[i][j];
                    continue;
                }
                array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]) + map[i][j];
            }
        }
        return array[n - 1][m - 1];
    }
    static int[][] routeSums(int[][] map) {
        int n = map[0].length;
        int m = map[1].length;
        int[][] array = new int[n][n];
        array[0][0] = map[0][0];
        int sum = 0;
        int add = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    array[i][j] = array[i][j - 1] + map[i][j];
                    continue;
                } else if (j == 0){
                    array[i][j] = array[i - 1][j] + map[i][j];
                    continue;
                }
                array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]) + map[i][j];
            }
        }
        return array;
    }

}
