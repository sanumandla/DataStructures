package main.java.linkedlist;

/**
 * Created by sridhar.anumandla on 2/5/15.
 */
public class PartitionLinkedList {

    public static class Node {
        Node next;
        int value;
    }

    private void display(Node node) {
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    private Node partition(Node node, int partitionKey) {
        Node head = node;
        Node tail = node;

        while(node != null) {
            Node next = node.next;
            if (node.value < partitionKey) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 9, 7, 3, 8, 6};
        int partitionKey = 5;

        Node start = null;
        Node end = null;
        for (int anArray : array) {
            if (end == null) {
                Node node = new Node();
                node.value = anArray;
                node.next = null;
                end = node;
                start = node;
            } else {
                end.next = new Node();
                end.next.value = anArray;
                end.next.next = null;
                end = end.next;
            }
        }

        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();

        System.out.println("Input");
        partitionLinkedList.display(start);

        Node output = partitionLinkedList.partition(start, partitionKey);

        System.out.println("\nOutput");
        partitionLinkedList.display(output);
    }

}
