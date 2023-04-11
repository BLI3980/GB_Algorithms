package Homeworks.Homework04;

import java.util.*;
import java.util.function.Consumer;

public class Tree {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        root = appendNode(root, value);
    }

    private Node appendNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (current.value < value) {
            current.right = appendNode(current.right, value);
        } else if (current.value > value) {
            current.left = appendNode(current.left, value);
        }
        return current;
    }

    public void dfsConsumer(Consumer<Integer> valueConsumer) {
        List<Integer> result = new ArrayList<>();
        dfsConsumer(root, valueConsumer);
    }

    private void dfsConsumer(Node current, Consumer<Integer> valueConsumer) {
        if (current != null) {
            dfsConsumer(current.left, valueConsumer);
            valueConsumer.accept(current.value);
            dfsConsumer(current.right, valueConsumer);
        }
    }

    // HOMEWORK ======================================================================
    public int maxElement() {
        final int[] max = {root.value};
        dfsConsumer(integer -> max[0] = integer < max[0] ? max[0] : integer);
        return max[0];
    }

    public int countLeafs() {
        int[] count = {0};
        if (root == null) {
            return 0;
        }
        countLeafs(root, count);
        return count[0];
    }
    private void countLeafs(Node current, int[] count) {
        if (current.left != null) { // && current.right == null) {
            countLeafs(current.left, count);
        }
        if (current.right != null) { // && current.left == null) {
            countLeafs(current.right, count);
        }
        if (current.left == null && current.right == null) {
            count[0]++;
        }
    }

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }
        return isBalanced(root);
    }
    public boolean isBalanced(Node node) {
        boolean result = true;
        if (node == null) {
            result = true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return result;
    }

    private int getHeight(Node current) {
        if (current == null) {
            return 0;
        }
        int leftHeight = getHeight(current.left);
        int rightHeight = getHeight(current.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
