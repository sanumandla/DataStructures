package main.java.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sridhar.anumandla on 4/5/15.
 */
public final class LinkedListUtils {

    // Create list and add items to it
    public static Node<Integer> createList(int[] array) {
        if (array == null) {
            return null;
        }

        int numOfElements = array.length;

        Node<Integer> head = null;
        Node<Integer> start = null;
        for (int i = 0; i < numOfElements; i++) {
            if (start == null) {
                start = new Node<Integer>();
                start.setValue(array[i]);
                start.setNext(null);
                head = start;
            } else {
                Node<Integer> node = new Node<Integer>();
                node.setValue(array[i]);
                node.setNext(null);

                start.setNext(node);
                start = node;
            }
        }

        return head;
    }


    // Create a circular linked list and add items to it
    public static Node<Integer> createCircularList(int[] array) {
        if (array == null) {
            return null;
        }

        Map<Integer, Object> map = new HashMap<Integer, Object>();

        int numOfElements = array.length;

        Node<Integer> head = null;
        Node<Integer> start = null;
        for (int i = 0; i < numOfElements; i++) {
            if (start == null) {
                start = new Node<Integer>();
                start.setValue(array[i]);
                start.setNext(null);
                head = start;
            } else {
                Node<Integer> node = new Node<Integer>();
                node.setValue(array[i]);
                node.setNext((Node <Integer>) map.get(array[i]));

                start.setNext(node);
                start = node;
            }

            map.put(array[i], start);
        }

        return head;
    }


    // Display the list
    public static void displayList(Node<Integer> head) {
        if (head == null) {
            System.out.println("No items to display");
            return;
        }

        while (head != null) {
            System.out.print(" " + head.getValue());
            head = head.getNext();
        }

        System.out.println();
    }

}
