package Lectures.Lecture01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture01 {

    public static void main(String[] args) {
//        List<Integer> availableDivider =  findAvailableDivider(25);
//        for (Integer item: availableDivider) {
//            System.out.println(item);
//        }
//        List<Integer> simpleNumbers =  findSimpleNumbers2(7);
//        for (Integer item: simpleNumbers) {
//            System.out.println(item);
//        }

//        System.out.println(diceNumberChance(3));

        AtomicInteger counter = new AtomicInteger(0);
        int fib = fibonacci(10, counter);
        System.out.println("Fibonacci number: " + fib);
        System.out.println("Counter: " + counter.get());

    }
    /*
    Algorithm for finding all available dividers for an input number.
    Time complexity is O(n) - Linear time. I.e. the amount of actions linearly
    depends on amount of input value/data.
    */
    public static List<Integer> findAvailableDivider (int input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    /*
    Algorithm for finding all simple numbers in the range from 1 to an input number.
    Time complexity is O(n^2) - Quadratic time. I.e. the amount of actions is in power to two times the
    on amount of input value/data.
    */

    // Option 1. Simple code
    public static List<Integer> findSimpleNumbers1 (int input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= input; i++) {
            Boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isSimple = false;
                    break;
                }
            }
            if(isSimple) {
                result.add(i);
            }
        }
        return result;
    }

    // Option 2. Re-use of availableDividers method
    public static List<Integer> findSimpleNumbers2 (int input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= input; i++) {
            if(findAvailableDivider(i).size()< 3){
                result.add(i);
            }
        }
        return result;
    }

    /*
    Algorithm for finding a chance of getting a desired number when throwing three dice.
    Time complexity is O(2^2) - Exponential time. I.e. the amount of actions grows exponentially with respect to
    growth of amount of input value/data.
    */
    public static double diceNumberChance (int desiredSum) {
        int count = 0;
        int success = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                for (int k = 1; k < 6; k++) {
                    if (i + j + k == desiredSum) {
                        success++;
                    }
                    count++;
                }
            }
        }
        return (double) success / (double) count;
    }

    // Fibonacci sequence
    public static int fibonacci (int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 0) {
            return 0;
        }
        if (position == 1 || position == 2) {
            return 1;
        }else {
            return fibonacci(position - 1, counter) + fibonacci(position - 2, counter);

        }
    }



}
