package com.alice;

public class OrderService implements Runnable {

    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    private Extlock extLock = new ZookeeperDistrbuteLock();

    @Override
    public void run() {
        getNumber();
    }

    private void getNumber() {

        try {
            extLock.lock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + " -- 生成订单ID  -- " + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            extLock.unlock();
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            OrderService orderService = new OrderService();
            new Thread(orderService).start();
        }
    }
}
