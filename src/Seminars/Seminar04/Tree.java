package Seminars.Seminar04;

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

    public void insert(int value) {
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


}
