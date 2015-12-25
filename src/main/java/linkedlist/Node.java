package main.java.linkedlist;

/**
 * Created by sridhar.anumandla on 4/2/15.
 */
public class Node<K> {

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