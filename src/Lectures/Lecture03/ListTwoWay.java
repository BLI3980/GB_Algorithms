package Lectures.Lecture03;

public class List {
    Node head;
    Node tail;


    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if(next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public class Node {
        int value;
        Node next;

        Node previous;
    }
}
