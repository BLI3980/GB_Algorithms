package Lectures.Lecture04;

import java.util.List;

public class Tree {

    Node root;

    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    // In-Depth search
    private Node find(Node node, int value) {
        if(node.value == value) {
            return node;
        } else {
            for (Node child: node.children) {
                Node result = find(child, value);
                if (result  != null) {
                    return result;
                }
            }
        }
        return null;
    }

    // In-Width search
//    private Node find(int value) {
//        List<Node> currentLevel = new ArrayList<>();
//        currentLevel.add(root);
//        while (currentLevel.size() > 0) {
//            List<Node> nextLevel = new ArrayList<>();
//            for (Node node: currentLevel) {
//                if(node.value == value) {
//                    return node;
//                }
//            }
//            currentLevel = nextLevel;
//        }
//        return null;
//    }

    public class Node {
        int value;
        List<Node> children;
    }
}
