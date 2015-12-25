package main.java.linkedlist;

/**
 * Created by sridhar.anumandla on 1/28/15.
 */
public class LinkedListFindKthElementFromLast {

    public static class NodeCounter {
        int count;
    }

    public static class Node<T> {
        Node<T> next;
        T data;
    }

    private Node<Integer> findElement(Node<Integer> node, int position, NodeCounter nodeCounter) {
        if (node == null) {
            return null;
        }

        Node<Integer> returnNode = findElement(node.next, position, nodeCounter);
        if (nodeCounter.count++ == position) {
            return node;
        }

        return returnNode;
    }

    public static void main(String[] args) {
        int element = 4;
        int numOfElements = 10;

        NodeCounter count = new NodeCounter();
        Node<Integer> start = new Node<Integer>();

        // Add nodes
        Node<Integer> node = start;
        for (int i = 0; i < numOfElements; i++) {
            node.next = new Node<Integer>();
            node = node.next;
        }

        // Add data to nodes
        node = start;
        for (int i = 0; i < numOfElements; i++) {
            node.data = (i + 1) * 10;
            node = node.next;
        }

        // Display
        node = start;
        for (int i = 0; i < numOfElements; i++) {
            if (node == null) {
                continue;
            }

//            System.out.println(node.data);
            node = node.next;
        }

        Node<Integer> foundNode = new LinkedListFindKthElementFromLast().findElement(start, element, count);
        System.out.println(foundNode.data);
    }

}
