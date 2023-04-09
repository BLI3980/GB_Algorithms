package Seminars.Seminar04;

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

    public boolean contains(int value) {
        return findNode(root, value) != null;
    }

    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value > value) {
            return findNode(current.left, value);
        } else if(current.value < value) {
            return findNode(current.right, value);
        }
        return current;
    }

    public void remove(int value) {
        root = removeNode(root, value);
    }

    private Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (current.value > value) {
            current.left = removeNode(current.left, value);
            return current;
        } else if (current.value < value) {
            current.right = removeNode(current.right, value);
            return current;
        }
        // remove current node.
        // case 1. no child nodes
        if (current.left == null && current.right == null) {
            return null;
        }
        // case2. only one child done
        if (current.left == null) { // && current.right != null) {
            return current.right;
        }
        if (current.right == null) { // && current.left != null) {
            return current.left;
        }
        // case 3. both child nodes exist
        // Need to find the smallest element from the right subtree of the node which is being deleted and
        Node smallestNodeOnTheRight = findFirst(current.right);
        // replace the node being deleted with found the smallest node from the right subtree. Then
        current.value = smallestNodeOnTheRight.value;
        // delete the found smallest element.
        current.right = removeNode(current.right, smallestNodeOnTheRight.value);
        // This way we know that new node is larger than any nodes from its left subtree and at the same
        // time it is less than any nodes from its right subtree.
        return current;
    }

    // Aux method to find the first smallest node from the right subtree
    public int findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findFirst(root).value;
    }

    private Node findFirst(Node current) {
        if (current.left != null) {
            return findFirst(current.left);
        }
        return current;
    }

    public List<Integer> dfs() {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node current, List<Integer> result) {
        if (current != null) {
            dfs(current.left, result);
            result.add(current.value);
            dfs(current.right, result);
        }
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

    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();
        bfs(result);
        return result;
    }

    private void bfs(List<Integer> result) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void bfsConsumer(Consumer<Integer> valueConsumer) {
        bfsConsumerInternal(valueConsumer);
    }

    private void bfsConsumerInternal(Consumer<Integer> valueConsumer) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            valueConsumer.accept(node.value);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }






}
