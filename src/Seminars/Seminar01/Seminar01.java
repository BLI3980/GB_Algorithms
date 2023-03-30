package Seminars.Seminar01;

import java.math.BigInteger;

public class Seminar01 {
    public static void main(String[] args) {
        //============================================
//        int [][] array = new int[8][8];
        // 1 0 0 0 0 0 0 0
        // 0 1 0 0 0 0 0 0
        // 0 0 1 0 0 0 0 0
        // 0 0 0 1 0 0 0 0
        // 0 0 0 0 1 0 0 0
        // 0 0 0 0 0 1 0 0
        // 0 0 0 0 0 0 1 0
        // 0 0 0 0 0 0 0 1
        // ===== O(n^2) - quadratic time complexity

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                if (i == j) {
//                    array[i][j] = 1;
//                }
//                System.out.print(array[i][j]);
//            }
//            System.out.println("\n");
//
//        }
        // ===== O(n) - linear time complexity
//        for (int i = 0; i < array.length; i++) {
//            array[i][i] = 1;
//        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                System.out.print(array[i][j]);
//            }
//            System.out.println("\n");
//        }


//        timerFactorial(10);
//        timerFactorial(100);
//        timerFactorial(1000);


//        logComlexityExample();

        // Frog jumps:
        System.out.println(frogJumps1(6));
        System.out.println(frogJumps2(7));
    }

    //============================================

    // ===== O(n) - linear complexity. Because the amount of factorial calculations
    // equals to n
//    static BigInteger factorial(BigInteger n){
//        if(BigInteger.ONE.equals(n)){return BigInteger.ONE;}
//        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
//    }

//    static void timerFactorial(long n){
//        long start = System.currentTimeMillis();
//        System.out.println(factorial(BigInteger.valueOf(n)));
//        System.out.println("Time for n = " + n + ": " + (System.currentTimeMillis() - start));
//    }

    // ===== O(n) - exponential complexity
//    static int fibonacci(int n) {
//        if(n == 0){return 0;}
//        if(n == 1){return 1;}
//        return fibonacci(n-1) + fibonacci(n-2);
//    }

    // ===== O(log n) - logarithmic complexity
    // Binary search is also an example of logarithmic complexity
    static void logComlexityExample() {
        int n = 100_000_000;
        int sum = 0;
        for (int i = 1; i < n; i *= 2) {
            sum += i;
        }
        System.out.println(sum);
    }

    // Problem. Given n stones (n >= 2). Frog is on the first stone. It can jump either
    // on first next stone or the second next stone.
    // Calculate the amount of combinations the frog can reach the last stone
    static int frogJumps1(int n){ // Recursive programming
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        return frogJumps1(n-1) + frogJumps1(n-2);
    }

    static int frogJumps2(int n){ // Dynamic programming
        int[] counts = new int[n + 1];
        counts[2] = 1;
        counts[3] = 2;
        for (int i = 4; i <= n; i++) {
            counts[i] = counts[i - 1] + counts[i - 2];
        }
        return counts[n];
    }

    // Combinations for 6 stones
    // 0 1 2 3 4 5
    // 0 1 2 3 . 5
    // 0 1 2 . 4 5
    // 0 1 . 3 4 5
    // 0 1 . 3 . 5
    // 0 . 2 3 4 5
    // 0 . 2 . 4 5
    // 0 . 2 3 . 4

    // Combinations for 7 stones
    // 0 1 2 3 4 5 6
    // 0 1 2 3 4 . 6
    // 0 1 2 3 . 5 6
    // 0 1 2 . 4 5 6
    // 0 1 2 . 4 . 6
    // 0 1 . 3 4 5 6
    // 0 1 . 3 . 5 6
    // 0 1 . 3 4 . 6
    // 0 . 2 3 4 5 6
    // 0 . 2 . 4 5 6
    // 0 . 2 . 4 . 6
    // 0 . 2 3 4 . 6
    // 0 . 2 3 . 5 6



}