package com.alice.main;


public class Test005 {

    public static void main(String[] args) {
        ResThread resThread01 = new ResThread();
        resThread01.start();
        ResThread resThread02 = new ResThread();
        resThread02.start();

    }

}

class ResThread extends Thread {

    public boolean threadFlag = true;

    public int i = 10;

    @Override
    public void run() {
        while (threadFlag) {
            try {
                for (int j = 0; j < 20; ++j) {
                    System.out.println(getName() + "---- 线程 run   " + j);
                    if (j >= i) {
                        stopThread();
                        return;
                    }
                }
            } catch (Exception e) {
                stopThread();
                e.printStackTrace();
            }
        }
    }


    public void stopThread() {
        threadFlag = false;
        System.out.println(getName() + "--- 线程 stop");
    }


}
