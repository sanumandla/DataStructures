package main.java.ThreadExample;

/**
 * User: sridhar.anumandla
 * Date: 9/18/14
 * Time: 2:47 PM
 */
public abstract class ThreadExecutor implements Runnable {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

}
