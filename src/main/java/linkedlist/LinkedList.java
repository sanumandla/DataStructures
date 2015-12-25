package main.java.linkedlist;

/**
 * User: sridhar.anumandla
 * Date: 8/16/14
 * Time: 5:54 PM
 */
public class LinkedList<K> {

    private static class Node<K> {

        private K value;
        private Node<K> next;

        public Node() {
        }

        public void setValue(K value) {
            this.value = value;
        }

        public K getValue() {
            return value;
        }

        public void setNext(Node<K> next) {
            this.next = next;
        }

        public Node<K> getNext() {
            return next;
        }

    }

    public Node<K> start;
    public Node<K> node;

    public LinkedList() {
    }

    public void addFirst(K value) {
        Node<K> newNode = new Node<K>();
        newNode.value = value;
        newNode.next = start;

        start = newNode;
    }

    public void addLast(K value) {
        Node<K> node = start;
        while (node != null) {
            if (node.next == null) {
                Node<K> newNode = new Node<K>();
                newNode.value = value;

                node.next = newNode;
                break;
            }

            node = node.next;
        }
    }

    public void insertAfter(K key, K value) {
        Node<K> node = start;
        while (node != null) {
            if (node.value.equals(key)) {
                Node<K> tmp = node.next;

                Node<K> newNode = new Node<K>();
                newNode.value = value;
                newNode.next = tmp;

                node.next = newNode;
                break;
            }

            node = node.next;
        }
    }

    public void remove(K value) {
        Node<K> node = start;
        while (node != null) {
            if (node.next != null && node.value.equals(value)) {
                start = node.next;
                node = null;

                System.out.println("Delete value " + node.value);

                break;
            } else {
                node = node.next;
            }
        }
    }

    public void display() {
        while(start != null) {
            System.out.print(start.value);
            if (start.next != null) {
                System.out.print(" --> ");
            }

            start = start.next;
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addFirst(10);
        linkedList.insertAfter(10, 20);
        linkedList.insertAfter(20, 40);
        linkedList.insertAfter(20, 30);
        linkedList.insertAfter(10, 15);
        linkedList.addLast(50);
        linkedList.display();
    }

}
