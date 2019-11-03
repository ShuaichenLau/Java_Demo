package com.alice.main;

public class Test {

    public static void main(String[] args) {
        String a = "a" + "b";
        String b = "a" + new String("b");
        System.out.println(a == b);

        int x = 1;
        Integer y = new Integer(1);
        System.out.println(x == y);

    }
}
