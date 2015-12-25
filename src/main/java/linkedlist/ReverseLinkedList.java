package main.java.linkedlist;

/**
 * Created by sridhar.anumandla on 4/6/15.
 */
public class ReverseLinkedList {

    // My version
    public Node<Integer> reverseListRecursively(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        Node<Integer> next = head.getNext();
        head.setNext(null);

        Node<Integer> node = reverseListRecursively(next);
        if (node == null) {
            return head;
        } else {
            next.setNext(head);
            return node;
        }
    }

    // Slightly changed version from the internet
    public Node<Integer> reverseListRecursivelyVersion2(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        Node<Integer> next = head.getNext();
        head.setNext(null);

        Node<Integer> node = reverseListRecursively(next);
        next.setNext(head);
        return node;
    }

    public Node<Integer> reverseListIteratively(Node<Integer> current) {
        if (current == null || current.getNext() == null) {
            return current;
        }

        Node<Integer> previous = current;
        while (current.getNext() != null) {
            Node<Integer> next = current.getNext();
            current.setNext(next.getNext());
            next.setNext(previous);
            previous = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        int firstArr[] = {1, 2, 3, 4, 5, 6};

        System.out.println("Original list");
        Node<Integer> head = LinkedListUtils.createList(firstArr);
        LinkedListUtils.displayList(head);

        System.out.println("Reversed list");
//        Node<Integer> reverse = new ReverseLinkedList().reverseListIteratively(head);
//        LinkedListUtils.displayList(reverse);

        Node<Integer> reverse = new ReverseLinkedList().reverseListRecursively(head);
        LinkedListUtils.displayList(reverse);

    }

}
