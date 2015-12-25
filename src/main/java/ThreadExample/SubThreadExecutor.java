package main.java.ThreadExample;

/**
 * User: sridhar.anumandla
 * Date: 9/18/14
 * Time: 2:48 PM
 */
public class SubThreadExecutor extends ThreadExecutor {

    @Override
    public void run() {
        System.out.println(name);
    }
}
