package com.alice.main;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = null;

        ListTest listTest = new ListTest();
        listTest.test(list);
        list.add("3");
        list.add("4");
        System.out.println(list.size());
    }

    public void test(List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add("1");
        list.add("2");
    }
}
