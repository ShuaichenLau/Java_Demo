package com.alice.main;

import java.math.BigDecimal;

public class Test008 {


    public static void main(String[] args) {
        BigDecimal bigDecimal01 = new BigDecimal(0);
        BigDecimal bigDecimal02 = new BigDecimal(0.0);

        System.out.println(bigDecimal01);

        System.out.println(bigDecimal01.equals(null));

        System.out.println(bigDecimal01.compareTo(bigDecimal02));


        System.out.println(true && true && false);

        String str = null;

        String str1 = "alice";

        String str2;
        if (str == null) {
            str2 = str;
            str = str1;
        }

        System.out.println(str.equals(str1));


    }

}
