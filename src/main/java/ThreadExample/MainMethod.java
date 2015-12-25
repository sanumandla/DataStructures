package main.java.ThreadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: sridhar.anumandla
 * Date: 9/18/14
 * Time: 2:51 PM
 */
public class MainMethod {

    public static void main(String args[]) {
        SubThreadExecutor executor = new SubThreadExecutor();
        MainMethod mainMethod = new MainMethod();
        mainMethod.executeMethod(executor);
    }

    public void executeMethod(ThreadExecutor threadExecutor) {
        threadExecutor.setName("Sridhar");
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(threadExecutor);
    }

}
