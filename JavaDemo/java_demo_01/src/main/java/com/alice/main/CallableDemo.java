package com.alice.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            Callable callable = new MyCallable(i + "");
            Future submit = executorService.submit(callable);
            futures.add(submit);
        }
        executorService.shutdown();

        for (Future future : futures) {
            System.out.println(Thread.currentThread().getName() + future.get().toString());
        }

    }
}
