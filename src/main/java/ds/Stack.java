package main.java.ds;

/**
 * User: sridhar.anumandla
 * Date: 8/16/14
 * Time: 2:57 PM
 */
public class Stack<K> {

    private int LIMIT = 10;

    private int index = -1;
    private Object[] items = null;

    public Stack() {
        items = new Object[LIMIT];
    }

    public void push(K item) {
        items[++index] = item;
    }

    public void pop() {
        items[index--] = null;
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
        Stack<String> stack = new Stack<String>();

        System.out.println("Is collection empty: " + stack.isEmpty());

        System.out.println("========= STRING ==========");

        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        stack.push("Item4");
        stack.push("Item5");
        stack.push("Item6");
        stack.push("Item7");
        stack.push("Item8");
        stack.push("Item9");
        stack.push("Item10");

        System.out.println("Is collection full: " + stack.isFull());

        stack.display();

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Is collection empty: " + stack.isEmpty());
        System.out.println("Is collection full: " + stack.isFull());

        stack.display();

        System.out.println("========= INTEGER ==========");

        Stack<Integer> stack1 = new Stack<Integer>();

        System.out.println("Is collection empty: " + stack1.isEmpty());

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        stack1.push(10);

        System.out.println("Is collection full: " + stack1.isFull());

        stack1.display();

        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();

        System.out.println("Is collection empty: " + stack1.isEmpty());
        System.out.println("Is collection full: " + stack1.isFull());

        stack1.display();
    }

}
