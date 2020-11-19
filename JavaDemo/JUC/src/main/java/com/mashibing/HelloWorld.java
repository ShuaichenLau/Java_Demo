package com.mashibing;

public class HelloWorld {

    public static void main(String[] args) {

        int i = 10;
        synchronized (HelloWorld.class){
            add(i);
            System.out.println(i);

        }

    }


    public static int add(int i){
        return i++;
    }

}
