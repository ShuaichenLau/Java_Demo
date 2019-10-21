package com.alice01.ticket;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 火车票
 */
public class TicketMain {

    private static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {

        TicketThread ticketThread1 = new TicketThread(atomicInteger);
        TicketThread ticketThread2 = new TicketThread(atomicInteger);
        TicketThread ticketThread3 = new TicketThread(atomicInteger);
        TicketThread ticketThread4 = new TicketThread(atomicInteger);

        Thread thread1 = new Thread(ticketThread1);
        Thread thread2 = new Thread(ticketThread2);
        Thread thread3 = new Thread(ticketThread3);
        Thread thread4 = new Thread(ticketThread4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}


class TicketThread implements Runnable {

    private AtomicInteger atomicInteger;

    public TicketThread(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        while (atomicInteger.get() > 0) {
            System.out.println("售出" + atomicInteger.decrementAndGet() + "张票");
        }
    }
}