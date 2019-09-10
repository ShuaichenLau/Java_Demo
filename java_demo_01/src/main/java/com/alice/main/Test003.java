package com.alice.main;

import java.util.Date;

public class Test003 {

    public static void main(String[] args) {
        String str = "test";
        String test = new String("test");
        System.out.println(test == str);


        Date date = new Date();
        System.out.println(date.getTime());


    }

}
