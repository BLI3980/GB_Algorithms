package Seminars.Seminar04;

import java.util.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        // ==========================================================
//        tree.add(5);
//        tree.add(2);
//        tree.add(10);
//
//        System.out.println(tree.contains(5)); // true
//        System.out.println(tree.contains(2)); // true
//        System.out.println(tree.contains(10)); // true
//        System.out.println(tree.contains(-1)); // false
//        System.out.println(tree.contains(4)); // false
//
//        System.out.println(tree.findFist()); // 2
//        tree.remove(2);
//        System.out.println(tree.findFist()); // 5
//        tree.remove(5);
//        System.out.println(tree.findFist()); // 10
//        tree.remove(10);
//        System.out.println(tree.findFist()); // Exception

        // ==========================================================
        tree.add(7);
        tree.add(3);
        tree.add(9);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        // DFS depth-first-search - поиск в глубину
        // BFS breadth-first-search - поиск в ширину
        System.out.println(tree.dfs());
        System.out.println(tree.bfs());

        // ==========================================================
        List<Integer> dfsConsumerOrderItems = new ArrayList<>();
        final int[] sum = {0};
//        tree.dfsConsumer(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                dfsConsumerOrderItems.add(integer);
//            }
//        });

        // ==== The above Consumer can also be wrapped into method reference
        // ==== Meaning - each item of dfsConsumer method is added to dfsConsumerOrderItems list
        tree.dfsConsumer(dfsConsumerOrderItems::add);
        System.out.println(dfsConsumerOrderItems);

        // ==== The Consumer can also be wrapped into Lambda
        tree.dfsConsumer(integer -> sum[0] += integer);
        System.out.println(Arrays.toString(sum));

        // ==========================================================
        List<Integer> bfsConsumerItems = new ArrayList<>();
        tree.bfsConsumer(bfsConsumerItems::add);
        System.out.println(bfsConsumerItems);

        final int[] counter = {0};
        tree.bfsConsumer(integer -> counter[0]++);
        // tree -> tree; bfsConsumer -> method of tree traversal with Consumer method;
        // in brackets -> each element of tree is processed by lambda
        System.out.println(Arrays.toString(counter));

    }

    // ==========================================================
    // HASH TABLE
    // [null, null, null, null, null, null, null, null] = size 8
    // element1: hash(element1) = 18 - example
    // 18 % 8 = 2 - index for element1 in hash-table
    // [null, null, [element1] - linked list, null, null, null, null, null]
    // element2: hash(element2) = 23 - example
    // 24 % 8 = 7 - index for element2 in hash-table
    // [null, null, [element1] - linked list, null, null, null, null, [element2]]
    // element(n): hash(element(n)) = also 18 - in rare occasion
    // [null, null, [element1, element(n)], null, null, null, null, [element2]]


}
