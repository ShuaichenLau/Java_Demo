package com.alice01.classTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        Collections.synchronizedList(list2);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list.toString());
            }).start();
        }

        Thread.sleep(2000);

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString());
                System.out.println(list2.toString());
            }).start();

        }
    }
}
