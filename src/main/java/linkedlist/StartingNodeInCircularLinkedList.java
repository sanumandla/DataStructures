package main.java.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Cracking the coding interview - 2.6
 *
 * Find starting node in circular linkedlist
 *
 * Created by sridhar.anumandla on 4/6/15.
 */
public class StartingNodeInCircularLinkedList {

    public boolean isALoop(Node<Integer> head) {
        if (head == null) {
            return false;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public Node<Integer> findStartingNodeDoublePointer(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.getNext() == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return fast;
    }

    public Node<Integer> findStartingNodeUsingMap(Node<Integer> head) {
        Set<Object> set = new HashSet<Object>();

        while(head != null) {
            if(set.contains(head)) {
                return head;
            } else {
                set.add(head);

                head = head.getNext();
            }
        }

        return null;
    }

    public Node<Integer> findStartingNode(Node<Integer> head) {
        while(head != null) {
            if (head.getNext() == null) {
                return head;
            } else {
                Node<Integer> tmp = head.getNext();
                head.setNext(null);
                head = tmp;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int firstArr[] = {1, 5, 3, 4, 7, 8, 10, 12, 7};

        Node<Integer> node = LinkedListUtils.createCircularList(firstArr);

        // Display items in the list
        for(int i=0; i<firstArr.length; i++) {
            System.out.print(" " + node.getValue());
            node = node.getNext();
        }

        StartingNodeInCircularLinkedList object = new StartingNodeInCircularLinkedList();
//        Node startingNode = object.findStartingNode(node);
//        Node startingNode = object.findStartingNodeUsingMap(node);
        Node startingNode = object.findStartingNodeDoublePointer(node);
        if (startingNode == null) {
            System.out.println("Node not found");
        } else {
            System.out.println("\nFound starting of node which is " + startingNode.getValue());
        }

        boolean retVal = object.isALoop(node);
        if (retVal) {
            System.out.println("Is a loop");
        } else {
            System.out.println("Is not a loop");
        }
    }

}
