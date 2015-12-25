package main.java.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sridhar.anumandla on 4/6/15.
 */
public class Palindrome {

    static class NodeWith2Elements<T> {
        Node<T> node;
        boolean value;
    }

    private NodeWith2Elements<Integer> result = new NodeWith2Elements<Integer>();

    private Stack<Integer> stack = new Stack<Integer>();

    private Node<Integer> startNode;

    public NodeWith2Elements<Integer> checkIfPalindromeUsingRecursion(Node<Integer> head, int length) {
        if (length == 0) {
            result.node = null;
            result.value = true;
            return result;
        } else if (length == 1) {
            result.node = head.getNext();
            result.value = true;
            return result;
        } else if (length == 2) {
            result.node = head.getNext().getNext();
            result.value = (head.getValue().equals(head.getNext().getValue()));
            return result;
        }

        NodeWith2Elements<Integer> returnNode = checkIfPalindromeUsingRecursion(head.getNext(), length - 2);
        if (!returnNode.value || returnNode.node == null ) {
            return returnNode;
        } else {
            returnNode.value = returnNode.node.getValue().equals(head.getValue());
            returnNode.node = returnNode.node.getNext();

            return returnNode;
        }
    }

    public boolean checkIfPalindromeUsingStack(Node<Integer> head) {
        if (head == null) {
            return false;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast != null && fast.getNext() != null) {
            stack.push(slow.getValue());

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if(!slow.getValue().equals(stack.pop())) {
                return false;
            }

            slow = slow.getNext();
        }

        return true;
    }

    public Node<Integer> reverseList(Node<Integer> head) {
        if (head == null) {
            return null;
        } else {
            Node<Integer> node = reverseList(head.getNext());

            Node<Integer> newNode = new Node<Integer>();
            newNode.setValue(head.getValue());
            newNode.setNext(null);

            if (node == null) {
                startNode = head;
                return head;
            } else {
                node.setNext(newNode);
                node = node.getNext();

                return node;
            }
        }
    }

    public boolean checkPalindrome(Node<Integer> original, Node<Integer> reversed) {
        if (original == null || reversed == null) {
            return false;
        }

        while(original != null && reversed != null) {
            if (!original.getValue().equals(reversed.getValue())) {
                return false;
            }

            original = original.getNext();
            reversed = reversed.getNext();
        }

        return true;
    }

    public static void main(String[] args) {
        int firstArr[] = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};

        Node<Integer> first = LinkedListUtils.createList(firstArr);
        LinkedListUtils.displayList(first);

        Palindrome palindrom = new Palindrome();
//        palindrom.reverseList(first);
//
//        LinkedListUtils.displayList(palindrom.startNode);
//
//        boolean value = palindrom.checkPalindrome(first, palindrom.startNode);
//        if (value) {
//            System.out.println("List is a Palindrome");
//        } else {
//            System.out.println("List is not a Palindrome");
//        }

//        boolean value = palindrom.checkIfPalindromeUsingStack(first);
//        if (value) {
//            System.out.println("List is a Palindrome");
//        } else {
//            System.out.println("List is not a Palindrome");
//        }
//
//        int secondArr[] = {1, 2, 3, 3, 2, 1};
//
//        Node<Integer> second = LinkedListUtils.createList(secondArr);
//        LinkedListUtils.displayList(second);
//
//        value = palindrom.checkIfPalindromeUsingStack(second);
//        if (value) {
//            System.out.println("List is a Palindrome");
//        } else {
//            System.out.println("List is not a Palindrome");
//        }

        NodeWith2Elements<Integer> node = palindrom.checkIfPalindromeUsingRecursion(first, 11);
        if (node.value) {
            System.out.println("List is a Palindrome");
        } else {
            System.out.println("List is not a Palindrome");
        }

        int secondArr[] = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};

        Node<Integer> second = LinkedListUtils.createList(secondArr);
        LinkedListUtils.displayList(second);

        NodeWith2Elements<Integer> node1 = palindrom.checkIfPalindromeUsingRecursion(second, 10);
        if (node1.value) {
            System.out.println("List is a Palindrome");
        } else {
            System.out.println("List is not a Palindrome");
        }

    }

}
