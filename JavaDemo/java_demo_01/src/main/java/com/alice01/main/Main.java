package com.alice01.main;

public class Main {
    public static void main(String[] args)  {

        try {
            ThreadDemo threadDemo = new ThreadDemo();
            Thread thread = new Thread(threadDemo);
            thread.start();
            synchronized (Thread.class){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            thread.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            Thread.sleep(3000);
//            thread.notifyAll();
            System.out.println("111111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("aaaaaaaaaaa");
    }
}
