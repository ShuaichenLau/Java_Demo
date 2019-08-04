package com.alice.main;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadDemo extends Thread {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(10);

    @Override
    public void run() {
        while (true) {
            System.out.println("ThreadName: " + Thread.currentThread().getName() + " || ATOMIC_INTEGER==> " + ATOMIC_INTEGER.getAndIncrement());
        }
    }
}

public class Test002 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new ThreadDemo().start();
        }

    }
}
