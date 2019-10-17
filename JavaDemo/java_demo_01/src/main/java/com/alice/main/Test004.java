package com.alice.main;

public class Test004 {


    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = new String("abc");
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));


        SingleInstance singleInstance = SingleInstance.getInstance();

        SingleInstance singleInstance1 = SingleInstance.getInstance();


        System.out.println(singleInstance);
        System.out.println(singleInstance1);
        System.out.println(singleInstance == singleInstance1);
    }
}
