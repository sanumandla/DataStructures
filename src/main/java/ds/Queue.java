package main.java.ds;

/**
 * User: sridhar.anumandla
 * Date: 8/16/14
 * Time: 3:43 PM
 */
public class Queue<K> {

    private int LIMIT = 10;

    private int index = -1;
    private int top = 0;
    private Object[] items = null;

    public Queue() {
        items = new Object[LIMIT];
    }

    public void insert(K item) {
        items[++index] = item;
    }

    public void delete() {
        System.out.println("Item deleted from the queue is " + items[0]);

        // Move items one level up
        for (int i = 0; i < index; i++) {
            items[i] = items[i+1];
        }

        // Nullify the tail elements
        for (int j = index; j < LIMIT; j++) {
            items[j] = null;
        }

        index--;
    }

    public boolean isEmpty() {
        if (index == -1) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (index == LIMIT - 1) {
            return true;
        }

        return false;
    }

    public void display() {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    public void clear() {
        items = null;
    }

    public static void main(String args[]) {
        Queue<String> queue = new Queue<String>();

        System.out.println("Is collection empty: " + queue.isEmpty());

        System.out.println("========= STRING ==========");

        queue.insert("Item1");
        queue.insert("Item2");
        queue.insert("Item3");
        queue.insert("Item4");
        queue.insert("Item5");
        queue.insert("Item6");
        queue.insert("Item7");
        queue.insert("Item8");
        queue.insert("Item9");
        queue.insert("Item10");

        System.out.println("Is collection full: " + queue.isFull());

        queue.display();

        queue.delete();
        queue.delete();
        queue.delete();

        System.out.println("Is collection empty: " + queue.isEmpty());
        System.out.println("Is collection full: " + queue.isFull());

        queue.display();

        System.out.println("========= INTEGER ==========");

        Queue<Integer> queue1 = new Queue<Integer>();

        System.out.println("Is collection empty: " + queue1.isEmpty());

        queue1.insert(1);
        queue1.insert(2);
        queue1.insert(3);
        queue1.insert(4);
        queue1.insert(5);
        queue1.insert(6);
        queue1.insert(7);
        queue1.insert(8);
        queue1.insert(9);
        queue1.insert(10);

        System.out.println("Is collection full: " + queue1.isFull());

        queue1.display();

        queue1.delete();
        queue1.delete();
        queue1.delete();
        queue1.delete();
        queue1.delete();
        queue1.delete();

        System.out.println("Is collection empty: " + queue1.isEmpty());
        System.out.println("Is collection full: " + queue1.isFull());

        queue1.display();
    }

}
