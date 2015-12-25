package main.java.linkedlist;

import sun.jvm.hotspot.debugger.linux.LinuxDebugger;

/**
 * Cracking the coding interview - 2.5 Follow up
 * <p/>
 * Created by sridhar.anumandla on 4/2/15.
 */
public class AddNumbersFromLists {

    public Node<Integer> sum(Node<Integer> first, Node<Integer> second, Node<Integer> carry) {

        // If lists are of unequal size then pad the shorter one with zeros

        if (first == null && second == null) {
            return null;
        } else {
            Node<Integer> node = sum(first == null ? null : first.getNext(), second == null ? null : second.getNext(), carry);

            int sum = carry.getValue();

            if (first != null) {
                sum += first.getValue();
            }

            if (second != null) {
                sum += second.getValue();
            }

            // make sure to carry or reset the 'carry' value
            if (sum >= 10) {
                carry.setValue(1);
            } else {
                carry.setValue(0);
            }

            Node<Integer> newNode = new Node<Integer>();
            newNode.setValue(sum % 10);
            if (node == null) {
                newNode.setNext(null);
            } else {
                newNode.setNext(node);
            }

            return newNode;
        }

    }

    public static void main(String[] args) {
        int firstArr[] = {5, 5, 3};
        int secondArr[] = {6, 7, 2};

        Node<Integer> first = LinkedListUtils.createList(firstArr);
        LinkedListUtils.displayList(first);

        Node<Integer> second = LinkedListUtils.createList(secondArr);
        LinkedListUtils.displayList(second);

        Node<Integer> carry = new Node<Integer>();
        carry.setValue(0);

        AddNumbersFromLists addNumbersFromLists = new AddNumbersFromLists();
        Node<Integer> head = addNumbersFromLists.sum(first, second, carry);

        if (carry.getValue() == 1) {
            Node<Integer> newNode = new Node<Integer>();
            newNode.setValue(carry.getValue());
            newNode.setNext(head);
            head = newNode;
        }

        LinkedListUtils.displayList(head);
    }

}
