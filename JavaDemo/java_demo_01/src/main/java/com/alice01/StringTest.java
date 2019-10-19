package com.alice01;

public class StringTest {

    public static void main(String[] args) {

        String a1 = new String("a");
        String a2 = "a";

        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

        String a3 = "a" + "b";
        String a4 = "ab";
        System.out.println(a3 == a4);
        String a5 = new String("ab");
        System.out.println(a3 == a5);
        System.out.println(a3.equals(a5));

        int x1 = 6;
        int x2 = 6;
        System.out.println(x1 == x2);

    }
}
