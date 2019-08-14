package com.alice.main;

import java.util.LinkedList;

public class Test006 {

    public static void main(String[] args) {
        LinkedList<String> strList = new LinkedList<String>();

        for (int i = 0; i < 10; i++) {
            strList.add("String" + i);
        }

        for (String str : strList) {
            System.out.println(str);
        }


        //位移 /2
        System.out.println(strList.size() >> 1);

        /**
         * 时间复杂度
         * 空间复杂度
         */

    }
}
