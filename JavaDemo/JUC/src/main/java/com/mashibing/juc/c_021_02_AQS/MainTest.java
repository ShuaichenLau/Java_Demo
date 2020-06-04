package com.mashibing.juc.c_021_02_AQS;

public class MainTest {

    private static int m = 0;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            m++;
        }

        System.out.println(m);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
