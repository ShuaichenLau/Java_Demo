package com.alice01.classTest;

import java.util.concurrent.atomic.AtomicInteger;

public class ClassDemo {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("java.util.concurrent.atomic.AtomicInteger");
            Object instance = aClass.newInstance();
            if (instance instanceof AtomicInteger) {
                System.out.println("java.util.concurrent.atomic.AtomicInteger");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
