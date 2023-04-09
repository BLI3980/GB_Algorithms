package Homeworks.Homework04;

public class Main {
    public static void main(String[] args) {
        // New instance of tree
        Tree tree = new Tree();
        // Fill the tree
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(6);
        tree.add(1);
        tree.add(2);
        tree.add(8);
        tree.add(0);
        tree.add(4);

        System.out.println(tree.dfs());
        System.out.println(tree.bfs());
        // 1. Find max element in the tree
        System.out.println(tree.maxElement());

        // 2. Count the amount of leaf nodes in the tree
        System.out.println(tree.countLeafs());

    }
}
