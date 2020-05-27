package com.alice.main;

import java.util.concurrent.ConcurrentHashMap;

public class TestHelloWorld {

    public static void main(String[] args) {
        System.out.println(1 << 4);
        System.out.println(1 << 30);

        new ConcurrentHashMap<String, String>();


        int i = 1;
        int j = i++;
        if ((j > ++j) && (i++ == j)) {
            j += i;
        }
        System.out.println(j);
    }
}
