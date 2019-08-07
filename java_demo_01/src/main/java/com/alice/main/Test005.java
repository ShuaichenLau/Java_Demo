package com.alice.main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Test005 {

    private static final HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

    public static void main(String[] args) {
        ResThread resThread01 = new ResThread();
        resThread01.start();
        ResThread resThread02 = new ResThread();
        resThread02.start();

        for (int i = 0; i < 100000; i++) {
            objectObjectHashMap.put(UUID.randomUUID(),UUID.randomUUID());
        }

        System.out.println(objectObjectHashMap.size());


        ArrayList<Object> objects = new ArrayList<>();




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


    /**
     * 停止线程
     */
    public void stopThread() {
        threadFlag = false;
        System.out.println(getName() + "--- 线程 stop");
    }


}
